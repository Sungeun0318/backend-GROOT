package com.green.backend.expertreport.service;


import com.green.backend.FileService;
import com.green.backend.application.dto.ApplicationDTO;
import com.green.backend.application.entity.Application;
import com.green.backend.application.repository.ApplicationRepository;
import com.green.backend.carbon.service.CarbonCalculator;
import com.green.backend.expertreport.dto.ExpertReportDTO;
import com.green.backend.expertreport.dto.TreeDto;
import com.green.backend.expertreport.dto.basicReportDto;
import com.green.backend.expertreport.entity.ExpertReport;
import com.green.backend.expertreport.repository.ExpertReportRepository;
import com.green.backend.member.entity.Member;
import com.green.backend.member.repository.MemberRepository;
import com.green.backend.util.FileUtil;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ExpertReportService {

    private final ExpertReportRepository expertReportRepository;
    private final ApplicationRepository applicationRepository;
    private final MemberRepository memberRepository;
    private final CarbonCalculator carbonCalculator;
    private final FileUtil fileUtil;


    // 답사 정보 등록
    @Transactional
    public boolean saveSurvey(List<ExpertReportDTO> dtoList, List<MultipartFile> files, MultipartFile site) {

        if (dtoList == null || dtoList.isEmpty()) {
            System.out.println("데이터 없음");
            return false;
        }

        if (site == null || site.isEmpty()) {
            System.out.println("대표 사진(site) 없음");
            return false;
        }

        // 현재는 선택 가능하게 처리
        if (files != null && !files.isEmpty() && dtoList.size() != files.size()) {
            System.out.println("데이터 수와 추가 사진 수 불일치");
            return false;
        }

        // detailId 확인
        Long detailId = dtoList.get(0).getDetailId();
        Application application = applicationRepository.findById(detailId)
                .orElseThrow(() -> new IllegalArgumentException("detail_id 없음"));


        // 답사 상태가 "진행중"인지 확인
        if (!"답사진행중".equals(application.getSurveyStatus())) {
            throw new IllegalStateException("해당 답사는 진행중이 아닙니다.");
        }

        application.setOpinion(dtoList.get(0).getOpinion());
        String siteFileName = fileUtil.fileUpload(site,false);
        application.setSitePicture(siteFileName);   // 현장사진
        // 보고서 제출 시 답사상태가 "완료"로 변경
        application.setSurveyStatus("답사완료");


        List<ExpertReport> entityList = new ArrayList<>();
        for (int i = 0; i < dtoList.size(); i++) {

            ExpertReportDTO dto = dtoList.get(i);
            ExpertReport entity = dto.toEntity();

            entity.setApplication(application);

            // 추가 사진이 있으면 저장
            if (files != null && !files.isEmpty()) {
                MultipartFile file = files.get(i);

                if (file != null && !file.isEmpty()) {
                    String fileName = fileUtil.fileUpload(file, false);
                    entity.setPicture(fileName);
                }
            }

            entityList.add(entity);
        }

        applicationRepository.save(application);
        expertReportRepository.saveAll(entityList);
        return true;
    }


    // 전문가 - 답사 정보 조회
    // 답사신청테이블에서 조회
    public List<ApplicationDTO> getSurvey(Long detailId) {

        // 현재 답사신청번호로 답사신청 정보 조회
        Application application = applicationRepository.findById(detailId)
                .orElseThrow(() -> new IllegalArgumentException("detail_id 없음"));


        // 조회한 답사신청 정보에서 회원번호 확인
        Long mid = application.getMemberId().getMid();

        // 같은 회원번호, 답사상태가 완료인 답사 목록 조회
        List<Application> applicationList =
                applicationRepository.findByMemberId_MidAndSurveyStatusOrderByTimesAsc(mid, "답사완료");

        // DTO 변환
        List<ApplicationDTO> dtoList = new ArrayList<>();

        for (Application app : applicationList) {
            ApplicationDTO dto = new ApplicationDTO();

            dto.setDetailId(app.getDetailId());
            dto.setTimes(app.getTimes());
            dto.setSurveyStatus(app.getSurveyStatus());

            dtoList.add(dto);
        }

        return dtoList;
    }

    // 상세 조회
    public List<ExpertReportDTO> getSurveyDetail(Long detailId) {

        // detailId 존재 여부
        if (!applicationRepository.existsById(detailId)) {
            throw new IllegalArgumentException("detailId 없음");
        }

        // 나무 정보 조회
        List<ExpertReport> expertReportList =
                expertReportRepository.findByApplication_DetailId(detailId);

        if (expertReportList.isEmpty()) {
            throw new IllegalArgumentException("리스트 없음");
        }
        List<ExpertReportDTO> dtoList = new ArrayList<>();
        for (ExpertReport expertReport : expertReportList) {
            ExpertReportDTO dto = expertReport.toDto();

            if (expertReport.getPicture() != null) {
                dto.setPicture(expertReport.getPicture());
            }

            dtoList.add(dto);
        }
        return dtoList;
    }


    // 답사 링크 유효 조회
    public boolean getLink(Long detailId) {

        Application application = applicationRepository.findById(detailId)
                .orElseThrow(() -> new IllegalArgumentException("detail_id 없음"));

        LocalDate now = LocalDate.now(); // 현재 시간
        LocalDate start = application.getDueStartDate(); // 시작일
        LocalDate end = application.getDueEndDate();     // 종료일
        String status = application.getSurveyStatus();   // 상태

        // 조건 검사
        // 시작일, 종료일 검사
        if (start == null || end == null) {
            return false;
        }

        if (now.isBefore(start) || now.isAfter(end) || !"답사진행중".equals(status)) {
            return false;
        }
        return true;

    }

    // 보고서 기본 정보 조회
    public basicReportDto getBasicReportByDetailId(Long detailId) {

        basicReportDto dto = expertReportRepository.findBasicReportByDetailId(detailId);
        if (dto == null) {
            throw new IllegalArgumentException("해당 기본 보고서 정보가 없습니다. / " + detailId);
        }
        return dto;
    }


    // 기업 - 내가 속한 기업이 가진 모든(최신) 나무 정보 확인
    public List<TreeDto> treeList(Long memberId) {
        if (memberId == null) {
            throw new IllegalArgumentException("유효하지 않은 토큰입니다.");
        }

        Member loginMember = memberRepository.findById(memberId)
                .orElseThrow(() -> new IllegalArgumentException("회원 정보가 없습니다."));

        if (loginMember.getCompany() == null) {
            throw new IllegalArgumentException("소속 회사 정보가 없습니다.");
        }

        Long companyId = loginMember.getCompany().getCompanyId();


        List<ExpertReport> reports =
                expertReportRepository.findLatestTreeEntitiesByCompanyId(companyId);
        

        for (ExpertReport er : reports) {
            System.out.println(
                    "treeId=" + er.getTreeId()
                            + ", detailId=" + er.getApplication().getDetailId()
                            + ", appMemberId=" + er.getApplication().getMemberId().getMid()
                            + ", times=" + er.getApplication().getTimes()
                            + ", status=" + er.getApplication().getSurveyStatus()
            );
        }

        List<TreeDto> result = new ArrayList<>();

        for (ExpertReport er : reports) {

            double carbon = carbonCalculator.calculateAnnualAbsorption(er);

            result.add(TreeDto.builder()
                    .treeId(er.getTreeId())
                    .treeType(er.getTreeType())
                    .treeStatus(er.getTreeStatus())
                    .kind(er.getKind())
                    .createDate(er.getCreateDate().toLocalDate())
                    .address(er.getApplication().getMemberId().getAddress())
                    .carbonAbsorption(carbon)
                    .build());
        }

        return result;
    }

}


