# GreenZone 프로젝트 팀원별 개발 로드맵

> 4인 팀 프로젝트 분담 및 기능 명세 (한승, 도경, 태형, 성은)
> 도메인별 패키지 구조 적용

---

## 📁 전체 백엔드 파일 구조 (도메인별)

```
src/main/java/com/green/backend/
├── BackendApplication.java
├── config/
│   ├── CorsConfig.java
│   └── RestTemplateConfig.java
├── member/
│   ├── entity/      Company.java, Member.java
│   ├── controller/  MemberController.java
│   ├── service/     MemberService.java
│   ├── repository/  CompanyRepository.java, MemberRepository.java
│   └── dto/         MemberDTO.java, LoginDTO.java
├── application/
│   ├── entity/      Application.java
│   ├── controller/  ApplicationController.java, AdminController.java
│   ├── service/     ApplicationService.java
│   ├── repository/  ApplicationRepository.java
│   └── dto/         ApplicationDTO.java
├── expert/
│   ├── entity/      Expert.java
│   ├── repository/  ExpertRepository.java
│   └── dto/         ExpertDTO.java
├── expertreport/
│   ├── entity/      ExpertReport.java
│   ├── controller/  ExpertReportController.java
│   ├── service/     ExpertReportService.java
│   ├── repository/  ExpertReportRepository.java
│   └── dto/         ExpertReportDTO.java
├── certification/
│   ├── entity/      Certification.java
│   ├── controller/  CertificationController.java
│   ├── service/     CertificationService.java
│   ├── repository/  CertificationRepository.java
│   └── dto/         CertificationDTO.java
├── carbon/
│   ├── controller/  CarbonController.java
│   ├── service/     CarbonService.java, KosisApiService.java, GirDataService.java, WeatherApiService.java
│   ├── entity/      RegionCode.java, RegionalEmission.java, CompanyEmission.java
│   ├── repository/  RegionCodeRepository.java, RegionalEmissionRepository.java, CompanyEmissionRepository.java
│   └── dto/         CarbonStatsDTO.java, TotalCarbonStatsDTO.java,
│                    CompanyLocationDTO.java, CompanyDetailDTO.java, TreeRecordDTO.java, WeatherDTO.java
├── tree/
│   ├── entity/      Tree.java
│   ├── controller/  TreeController.java
│   ├── service/     TreeService.java
│   └── repository/  TreeRepository.java
└── report/
    ├── entity/      Report.java, QrShare.java
    ├── controller/  ReportController.java
    ├── service/     ReportService.java, QrService.java
    ├── repository/  ReportRepository.java, QrShareRepository.java
    ├── dto/         ReportDTO.java
    └── util/        QrCodeUtil.java
```

---

## 1차 MVP

### 👤 [한승] 기업 인증 및 계정 관리
**목표:** 신뢰할 수 있는 기업 정보 기반의 회원 체계 구축

#### 주요 기능
- **기업 조회 API 연동 회원가입**: 공공데이터 API 등을 활용해 실제 등록된 기업인지 확인 후 가입 진행
- **기업 계정 로그인**: 가입된 정보를 바탕으로 세션/JWT 기반 로그인 구현

#### 담당 파일
- **Backend** (`member/` 패키지):
    - `member/entity/Company.java`: 기업 정보 (기업번호, 회사명, 사업자등록번호)
    - `member/entity/Member.java`: 회원 정보 (회원번호, 기업FK, 아이디, 비밀번호, 담당자, 전화번호, 이메일, 주소)
    - `member/controller/MemberController.java`: `/member/signup`, `/member/login`, `/member/logout`, `/api/company/verify`
    - `member/service/MemberService.java`: 가입/로그인 비즈니스 로직 및 외부 API 연동
    - `member/repository/CompanyRepository.java`, `member/repository/MemberRepository.java`
    - `member/dto/MemberDTO.java`, `member/dto/LoginDTO.java`
- **Frontend (React)**:
    - `SignUp.tsx`: 기업 조회 및 정보 입력 폼
    - `Login.tsx`: 로그인 인터페이스

---

### 👤 [도경] 답사 신청 및 통합 관리 (기업/관리자)
**목표:** 기업의 답사 요청부터 관리자의 전문가 배정까지의 프로세스 구현

#### 주요 기능
- **[기업] 답사 신청 및 CRUD**: 답사 신청 등록, 내역 조회, 수정, 취소
- **[기업] 일정 및 전문가 확인**: 확정된 답사 일정 및 배정된 전문가 정보 조회
- **[관리자] 통합 관리**: 전체 신청 내역 관리 및 전문가 배정 기능

#### 담당 파일
- **Backend** (`application/`, `expert/` 패키지):
    - `application/entity/Application.java`: 답사 신청 (답사번호, 회원FK, 전문가FK, 위도, 경도, 정기차수, 상태, 답사일, 신청내용)
    - `expert/entity/Expert.java`: 전문가 정보 (전문가번호, 이름, 연락처, 이메일, 등록일, 상태)
    - `application/controller/ApplicationController.java`: `/api/applications/**` (CRUD API)
    - `application/controller/AdminController.java`: `/api/admin/**` (전문가 배정, 신청 승인/반려)
    - `application/service/ApplicationService.java`: 답사 신청 비즈니스 로직
    - `application/repository/ApplicationRepository.java`, `expert/repository/ExpertRepository.java`
    - `application/dto/ApplicationDTO.java`, `expert/dto/ExpertDTO.java`
- **Frontend (React)**:
    - `ApplicationStatus.tsx`: 기업용 신청 목록 및 상세 페이지
    - `AdminPage.tsx`: 관리자용 전체 목록 및 배정 모달

---

### 👤 [태형] 답사 결과 기록 및 인증 등급 부여
**목표:** 현장 데이터 수집 및 이를 기반으로 한 최종 ESG 등급 결정

#### 주요 기능
- **[전문가] 답사 결과 입력**: 수종, DBH(흉고직경), 수고, 상태 등 현장 데이터 기록
- **[전문가] 정기 답사 조회**: 이전 답사 데이터를 불러와 연속성 있는 기록 지원
- **[관리자] 등급 부여**: 답사 정보를 검토하여 기업별 최종 인증 등급 결정

#### 담당 파일
- **Backend** (`expertreport/`, `certification/` 패키지):
    - `expertreport/entity/ExpertReport.java`: 나무기록 (나무기록번호, 답사FK, 수종, 흉고직경, 상태, 사진, 수고, 수관폭, 종합의견)
    - `certification/entity/Certification.java`: 기업별 등급 및 인증 이력
    - `expertreport/controller/ExpertReportController.java`: `/api/expert-reports/**`
    - `certification/controller/CertificationController.java`: `/api/certifications/**`
    - `expertreport/service/ExpertReportService.java`: 나무기록 CRUD 로직
    - `certification/service/CertificationService.java`: 등급 부여 로직 및 결과 처리
    - `expertreport/repository/ExpertReportRepository.java`, `certification/repository/CertificationRepository.java`
    - `expertreport/dto/ExpertReportDTO.java`, `certification/dto/CertificationDTO.java`
- **Frontend (React)**:
    - `ExpertReport.tsx`: 전문가용 데이터 입력 폼
    - `Certification.tsx`: 관리자용 등급 검토 및 부여 화면

---

### 👤 [성은] 시각화 및 데이터 제공 API + 외부 API 연동
**목표:** 대외적인 활동 현황 시각화 및 내/외부 연동용 데이터 제공, 외부 공공데이터 수집

#### 주요 기능
- **[전체] 메인페이지 지도 시각화**: 전체 참여 기업의 위치를 마커로 표시하여 활동 현황 공개
- **기업별 탄소현황 API**: 누적 탄소 흡수량 및 현황 데이터를 JSON 형태로 제공
- **서비스 연계**: 대시보드, 리포트, 지도 등에서 사용할 공통 데이터 제공
- **외부 API 연동**: KOSIS 지역별 배출량(DB 저장), GIR 엑셀 적재(DB 저장), 기상청 실시간 날씨(호출만)

#### 외부 데이터 소스
| 소스 | 방식 | DB 저장 | 데이터 |
|------|------|---------|--------|
| KOSIS 국가통계포털 | API (인증키) | O → `regional_emission` | 17개 시도 x 2019~2023 지역별 온실가스 직접배출량 |
| GIR 명세서 | 엑셀 파일 → DB | O → `company_emission` | 1167개 기업 배출량/에너지사용량 (2024) |
| 기상청 단기예보 | API (인증키) | X | 실시간 기온, 강수, 풍속, 풍향, 습도 |

#### 담당 파일
- **Backend** (`carbon/` 패키지):
    - `carbon/controller/CarbonController.java`: `/api/carbon/**`
    - `carbon/service/CarbonService.java`: 기업별 탄소 데이터 집계 로직
    - `carbon/service/KosisApiService.java`: KOSIS API 호출 → `regional_emission` DB 저장
    - `carbon/service/GirDataService.java`: GIR 엑셀 파일 읽기 → `company_emission` DB 저장
    - `carbon/service/WeatherApiService.java`: 기상청 API 실시간 호출 (DB 저장 X)
    - `carbon/entity/RegionCode.java`: 17개 시도 마스터 (기상청 격자좌표 포함)
    - `carbon/entity/RegionalEmission.java`: 지역별 온실가스 배출량
    - `carbon/entity/CompanyEmission.java`: 기업별 온실가스 배출량
    - `carbon/repository/RegionCodeRepository.java`, `RegionalEmissionRepository.java`, `CompanyEmissionRepository.java`
    - `carbon/dto/WeatherDTO.java`, `CompanyLocationDTO.java`, `CarbonStatsDTO.java`, `TotalCarbonStatsDTO.java`, `TreeRecordDTO.java`, `CompanyDetailDTO.java`
- **Frontend (React)**:
    - `Landing.tsx`: 카카오맵 API 연동 및 마커 표시
    - `KakaoMapCompanies.tsx`: 지도 컴포넌트
    - `Dashboard.tsx`: 기업별 요약 통계 시각화
    - `CarbonVisualization.tsx`: 탄소 현황 차트

---

## 2차 고도화

### 수목 추천 알고리즘 (조건별 최적 식재 제안)
- `tree/` 패키지
- `tree/entity/Tree.java`: 수목 마스터 데이터
- `tree/controller/TreeController.java`: `/api/trees/**`
- `tree/service/TreeService.java`: 수목 추천 가중치 알고리즘
- `tree/repository/TreeRepository.java`
- **Frontend**: `TreeList.tsx`, `TreeRecommendation.tsx`

### ESG 리포트 PDF 생성 및 QR 코드 공유
- `report/` 패키지
- `report/entity/Report.java`: ESG 리포트 정보
- `report/entity/QrShare.java`: QR 공유 메타데이터
- `report/controller/ReportController.java`: `/api/reports/**`
- `report/service/ReportService.java`: 리포트 생성 및 데이터 집계
- `report/service/QrService.java`: 24시간 만료 QR 코드 생성 및 유효성 검사
- `report/util/QrCodeUtil.java`: QR 코드 이미지 생성 유틸리티
- `report/repository/ReportRepository.java`, `report/repository/QrShareRepository.java`
- `report/dto/ReportDTO.java`
- **Frontend**: `ESGReport.tsx`

### 실시간 알림 시스템 (전문가 배정 등 알림)
- 추후 파일 추가 예정

---

## 공통 파일
- `BackendApplication.java`: Spring Boot 메인 클래스
- `config/CorsConfig.java`: 프론트엔드(localhost:5173) CORS 허용 설정
- `config/RestTemplateConfig.java`: 외부 API 호출용 RestTemplate Bean
- `resources/data/gir_emission.xls`: GIR 온실가스 명세서 엑셀 (1167개 기업)
- `resources/sql/data.sql`: 초기 데이터 (region_code 17개 시도 포함)
