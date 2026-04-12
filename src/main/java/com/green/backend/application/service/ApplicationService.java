package com.green.backend.application.service;

import com.green.backend.application.dto.ApplicationDTO;
import com.green.backend.application.entity.Application;
import com.green.backend.application.repository.ApplicationRepository;
import com.green.backend.expert.entity.Expert;
import com.green.backend.expert.repository.ExpertRepository;
import com.green.backend.member.dto.LoginTokenDTO;
import com.green.backend.member.entity.Member;
import com.green.backend.member.repository.MemberRepository;
import com.green.backend.region.entity.RegionCoordinate;
import com.green.backend.region.repository.RegionCoordinateRepository;
import com.green.backend.schedule.repository.ScheduleRepository;
import com.green.backend.util.AddressParser;
import com.green.backend.util.JwtUtil;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class ApplicationService {
    private final JwtUtil jwtUtil;
    private final ApplicationRepository applicationRepository; // 답사신청데이터 db에 저장/조회
    private final MemberRepository memberRepository; // 기업 데이터 조회
    private final ExpertRepository expertRepository; // 전문가 데이터 조회
    private final ScheduleRepository scheduleRepository;
    private final RegionCoordinateRepository regionCoordinateRepository;

     // [1] 답사신청 등록 (전문가 자동 배정 포함)
    // 클라이언트로 ApplicationDto 전달받음 -> member/ expert 유효성검사 -> 전문가 자동 배정 -> 답사신청 정보 DB 저장
     public boolean CreateVisitRequest (LoginTokenDTO loginUser, ApplicationDTO applicationDTO){
         Long memberId = loginUser.getMid();

         //  회원 유효성 검사
         Member member = memberRepository.findById(memberId).orElse(null);
         if(member==null){ return false; }

         // 초기 신청 상태, 차수
         applicationDTO.setSurveyStatus("신청"); // 초기 상태 : "신청"
         applicationDTO.setTimes(0); // 초기 차수 : 0

         // 회원 정보 불러오기
         Application saveEntity = applicationDTO.toEntity(); // dto -> Entity 변환
         saveEntity.setMemberId(member); // 회원 fk 연결

         // times 차수 +-1
         int finalLastTime = applicationRepository.findLastTime(memberId); // 해당 회원의 마지막 차수 조회
         saveEntity.setTimes(finalLastTime == 0 ? finalLastTime : finalLastTime +1); // 차수 없으면 0, 있으면 +1

         // === 전문가 자동 배정 ===
         LocalDate startDate = applicationDTO.getDueStartDate();
         LocalDate endDate = applicationDTO.getDueEndDate();
         Expert assignedExpert = autoAssignExpert(member.getAddress(), startDate, endDate);
         if (assignedExpert != null) {
             saveEntity.setExpertId(assignedExpert);
         }

         // 정보 저장 및 확인
         Application savedapplication = applicationRepository.save(saveEntity); // 완성된 Application엔티티를 DB에 저장
         return savedapplication.getDetailId() > 0; // DB 저장 및 검증
     }

    /**
     * 전문가 자동 배정 로직
     * 1) 회원 주소에서 "시" 추출
     * 2) 동일한 시에 있는 가용 전문가 중 일정 충돌 없는 가장 낮은 번호의 전문가 배정
     * 3) 동일 시에 없으면 → 시/군/구 좌표 기반 가장 가까운 전문가 배정
     */
    private Expert autoAssignExpert(String memberAddress, LocalDate startDate, LocalDate endDate) {
        String memberCity = AddressParser.extractCity(memberAddress);
        if (memberCity == null) return null;

        // 가용 상태인 전문가만 대상 (휴직/퇴직/파견 제외)
        List<Expert> allExperts = expertRepository.findByExpertState("가용");
        if (allExperts.isEmpty()) return null;

        // 1단계: 동일 시 매칭 (전문가 번호 낮은 순)
        List<Expert> sameCityExperts = allExperts.stream()
                .filter(e -> memberCity.equals(AddressParser.extractCity(e.getSAddress())))
                .sorted(Comparator.comparing(Expert::getExpertId))
                .toList();

        for (Expert expert : sameCityExperts) {
            if (!scheduleRepository.existsConflict(expert.getExpertId(), startDate, endDate)) {
                return expert;
            }
        }

        // 2단계: 가장 가까운 전문가 (시/군/구 좌표 기반)
        String memberDistrict = AddressParser.extractDistrict(memberAddress);
        double[] memberCoords = getCoordinates(memberCity, memberDistrict);
        if (memberCoords == null) return null;

        Expert nearest = null;
        double minDistance = Double.MAX_VALUE;

        for (Expert expert : allExperts) {
            // 이미 동일 시에서 실패한 전문가 스킵 (일정 충돌)
            if (sameCityExperts.contains(expert)) continue;

            // 일정 충돌 확인
            if (scheduleRepository.existsConflict(expert.getExpertId(), startDate, endDate)) continue;

            String expertCity = AddressParser.extractCity(expert.getSAddress());
            String expertDistrict = AddressParser.extractDistrict(expert.getSAddress());
            double[] expertCoords = getCoordinates(expertCity, expertDistrict);
            if (expertCoords == null) continue;

            double distance = calculateDistance(memberCoords[0], memberCoords[1], expertCoords[0], expertCoords[1]);
            if (distance < minDistance) {
                minDistance = distance;
                nearest = expert;
            }
        }

        return nearest;
    }

    /**
     * 시/군/구 좌표 조회 (region_coordinate 테이블)
     */
    private double[] getCoordinates(String city, String district) {
        if (city == null) return null;

        // 구/군 단위로 먼저 조회
        if (district != null) {
            RegionCoordinate coord = regionCoordinateRepository.findByCityAndDistrict(city, district);
            if (coord != null) return new double[]{coord.getLatitude(), coord.getLongitude()};
        }

        // 구 없으면 시 단위 첫 번째 좌표 사용
        List<RegionCoordinate> coords = regionCoordinateRepository.findByCity(city);
        if (!coords.isEmpty()) return new double[]{coords.get(0).getLatitude(), coords.get(0).getLongitude()};

        return null;
    }

    /**
     * Haversine 공식으로 두 좌표 간 거리(km) 계산
     */
    private double calculateDistance(double lat1, double lon1, double lat2, double lon2) {
        final double R = 6371; // 지구 반지름 (km)
        double dLat = Math.toRadians(lat2 - lat1);
        double dLon = Math.toRadians(lon2 - lon1);
        double a = Math.sin(dLat / 2) * Math.sin(dLat / 2)
                + Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2))
                * Math.sin(dLon / 2) * Math.sin(dLon / 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        return R * c;
    }

     // [2] 답사 신청 조회
    public List<ApplicationDTO> ReadVisitRequest( Long memberId ){
        Optional<Member> memberOptional = memberRepository.findById(memberId); // 회원 정보 조회
        if (memberOptional.isEmpty()) { throw new IllegalArgumentException("존재하지 않는 회원입니다."); // 회원 없으면 예외 처리
        }
        List<Application> applications = applicationRepository.findAllByMemberId(memberOptional.get()); // 회원 기준 신청목록 조회
        // DB에서 찾은 회원정보 Repository에 넘겨주기 -> 이 회원이 쓴 답사 신청서 DB에서 싹 다 긁어와!

        return applications.stream() // 리스트 -> 스트림
                            .map(Application::toDto) // 엔티티 -> DTO
                            .collect(Collectors.toList()); // DTO -> 리스트
    }

    // [1] 관리자) 모든 답사내역 목록 조회
    public List<ApplicationDTO> readAllVisitRequests() {
         List<Application> applications = applicationRepository.findAll(); // DB에서 모든 신청 데이터 조회
        return applications.stream() // 리스트 -> 스트림
                .map(Application::toDto) // 엔티티 -> DTO
                .toList(); // DTO 리스트로 반환
    }

    // [2] 관리자) 전문가 배정
    @Transactional
    public void assignExpert(ApplicationDTO dto ){
         Application application = applicationRepository.findById(dto.getDetailId() ) // 답사번호로 신청 정보 조회
                 .orElseThrow(()->new IllegalArgumentException("답사 없음")); // 없으면 예외 발생

         Expert expert = expertRepository.findById(dto.getExpertId()) // 전문가번호로 전문가 조회
            .orElseThrow(() -> new IllegalArgumentException("전문가 없음")); // 없으면 예외 발생

        // 전문가가 불가능한 일정 제외 // application의 LocalDate -> String 변환
        LocalDate startDate = application.getDueStartDate();
        LocalDate endDate = application.getDueEndDate();
        boolean isConflict = scheduleRepository.existsConflict(
                expert.getExpertId(), startDate, endDate);

        if(isConflict){
            throw new IllegalArgumentException("해당 전문가는 그 날짜에 일정이 있어 배정할 수 없습니다.");
        }

        application.setExpertId(expert); // 답사에 전문가 연결
        application.setSurveyStatus("진행중"); // 상태를 "진행중"으로 변경
    }

    // [3] 관리자) 답사 신청 승인
    @Transactional
    public boolean updateRequestStatus(ApplicationDTO dto){
         Application application = applicationRepository.findById(dto.getDetailId())
                 .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 답사신청입니다."));

         application.setRequestStatus(dto.getRequestStatus());

         if("승인".equals(dto.getRequestStatus())){
             application.setSurveyStatus("승인완료");
         } else if ("반려".equals(dto.getRequestStatus())) {
             application.setSurveyStatus("반려");
             application.setOpinion(dto.getOpinion());
         }
        return true;
    }
}
