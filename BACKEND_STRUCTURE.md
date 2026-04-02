# GreenZone Backend 프로젝트 구조 (Spring Boot + MySQL)

> Java 17+ / Spring Boot 4.x / JPA / MySQL / AWS(EC2, RDS) 기반 ESG/탄소 관리 서버
> 도메인별 패키지 구조 (Domain-based Package Structure)

---

## 디렉토리 구조 (`src/main/java/com/green/backend/`)

```
com.green.backend/
├── BackendApplication.java
├── config/
│   ├── CorsConfig.java
│   └── RestTemplateConfig.java       외부 API 호출용 RestTemplate Bean
│
├── member/                    ← [한승] 기업 인증 및 계정 관리
│   ├── entity/
│   │   ├── Company.java           기업 정보 (기업번호, 회사명, 사업자등록번호)
│   │   └── Member.java            회원 정보 (회원번호, 기업FK, 아이디, 비밀번호, 담당자, 전화번호, 이메일, 주소)
│   ├── controller/
│   │   └── MemberController.java  로그인, 회원가입, 사업자번호 인증 (Login.tsx, SignUp.tsx)
│   ├── service/
│   │   └── MemberService.java     사용자 인증 및 권한 로직
│   ├── repository/
│   │   ├── CompanyRepository.java
│   │   └── MemberRepository.java
│   └── dto/
│       ├── MemberDTO.java         회원가입 요청/응답
│       └── LoginDTO.java          로그인 요청
│
├── application/               ← [도경] 답사 신청 및 통합 관리
│   ├── entity/
│   │   └── Application.java       답사 신청 (답사번호, 회원FK, 전문가FK, 위도, 경도, 정기차수, 상태, 답사일, 신청내용)
│   │                              * 초기 생성 시 전문가FK(null), 답사일(null), 종합의견(null), 정기차수(0) 자동 세팅
│   ├── controller/                  기업용 답사 신청/조회 API (토큰 기반 인증, 클라이언트로부터 '신청 내용'만 입력받음)
│   │   ├── ApplicationController.java  답사 신청 CRUD (ApplicationStatus.tsx)
│   │   └── AdminController.java        관리자 전용 승인, 전문가 배정, 기업 관리 (AdminPage.tsx)
│   ├── service/
│   │   └── ApplicationService.java     답사 신청 CRUD 비즈니스 로직
│   ├── repository/
│   │   └── ApplicationRepository.java
│   └── dto/
│       └── ApplicationDTO.java    답사 신청 요청/응답
│
├── expert/                    ← [도경] 전문가 관리
│   ├── entity/
│   │   └── Expert.java            전문가 정보 (전문가번호, 이름, 연락처, 이메일, 등록일, 상태)
│   ├── repository/
│   │   └── ExpertRepository.java
│   └── dto/
│       └── ExpertDTO.java         전문가 정보
│
├── expertreport/              ← [태형] 답사 결과 기록
│   ├── entity/
│   │   └── ExpertReport.java      나무기록 (나무기록번호, 답사FK, 수종, 흉고직경, 상태, 사진, 수고, 수관폭, 종합의견)
│   ├── controller/
│   │   └── ExpertReportController.java  전문가 현장 측정 데이터 처리 (ExpertReport.tsx)
│   ├── service/
│   │   └── ExpertReportService.java     나무기록 CRUD 비즈니스 로직
│   ├── repository/
│   │   └── ExpertReportRepository.java
│   └── dto/
│       └── ExpertReportDTO.java   나무기록 요청/응답
│
├── certification/             ← [성은] 인증마크 발급 및 등급 관리
│   ├── entity/
│   │   └── Certification.java     인증 등급 및 이력 (member FK, application FK, grade, totalScore, treeCount, totalCarbonAbsorption, status, issuedDate, expireDate)
│   ├── controller/
│   │   └── CertificationController.java  인증 현황 조회, 등급 기준, PNG/PDF 다운로드 (Certification.tsx)
│   ├── service/
│   │   └── CertificationService.java     탄소흡수량 기반 등급 산정 (씨앗/새싹/숲/산림), 발급/갱신 로직
│   ├── repository/
│   │   └── CertificationRepository.java
│   └── dto/
│       ├── CertificationDTO.java  인증 정보 (entity↔dto 변환)
│       ├── CertStatusDTO.java     인증 현황 응답 (등급, 진행률, 다음등급까지 남은 흡수량)
│       └── GradeInfoDTO.java      등급 기준 정보 (이름, 이모지, 탄소 기준)
│
├── carbon/                    ← [성은] 시각화 및 데이터 제공 API + 외부 API 연동
│   ├── controller/
│   │   └── CarbonController.java  탄소 통계, 지도 위치, 기업 상세 데이터 (CarbonVisualization.tsx, Dashboard.tsx, KakaoMapCompanies.tsx)
│   ├── service/
│   │   ├── CarbonService.java     기업별 탄소 데이터 집계 + 예측 대시보드
│   │   ├── CarbonCalculator.java  탄소흡수량 계산 엔진 (현재저장량, 수령추정, 년별예측 + 날씨1년보정)
│   │   ├── DashboardService.java  대시보드 요약, 수종분포, 최근신청, 일정 조회
│   │   ├── KosisApiService.java   KOSIS API → 지역별 온실가스 배출량 DB 저장
│   │   ├── GirDataService.java    GIR 엑셀 → 기업별 배출량 DB 저장
│   │   └── WeatherApiService.java 기상청 단기예보 실시간 호출 (DB 저장 X)
│   ├── entity/
│   │   ├── RegionCode.java            지역 마스터 (17개 시도, 기상청 격자좌표 포함)
│   │   ├── RegionalEmission.java      지역별 온실가스 배출량 (KOSIS API)
│   │   ├── CompanyEmission.java       기업별 온실가스 배출량 (GIR 명세서)
│   │   └── TreeCoefficient.java       수종별 탄소흡수 계수 (상대생장식, 수령추정, 성장량)
│   ├── repository/
│   │   ├── RegionCodeRepository.java
│   │   ├── RegionalEmissionRepository.java
│   │   ├── CompanyEmissionRepository.java
│   │   └── TreeCoefficientRepository.java
│   └── dto/
│       ├── CarbonStatsDTO.java        기업별 탄소 현황
│       ├── CarbonPredictionDTO.java   대시보드 예측 응답 (현재 + 년별 예측)
│       ├── YearlyPredictionDTO.java   년별 장기 예측 (나무나이 + 날씨1년보정)
│       ├── DashboardSummaryDTO.java   대시보드 요약 (수목수, 총흡수량, 인증상태, 다음일정)
│       ├── MonthlyAbsorptionDTO.java  월별 흡수량 (대시보드 차트용)
│       ├── SpeciesDistributionDTO.java 수종 분포
│       ├── RecentApplicationDTO.java  최근 답사 신청
│       ├── UpcomingScheduleDTO.java   다가오는 일정
│       ├── TotalCarbonStatsDTO.java   전체 탄소 통계
│       ├── CompanyLocationDTO.java    지도 마커용 위치 데이터 [태형 담당]
│       ├── CompanyDetailDTO.java      기업 상세 정보
│       ├── TreeRecordDTO.java         수목 기록 데이터
│       └── WeatherDTO.java            기상청 실시간 날씨 응답
│
├── tree/                      ← [2차] 수목 추천 알고리즘
│   ├── entity/
│   │   └── Tree.java              수목 마스터 데이터 (추천 알고리즘용)
│   ├── controller/
│   │   └── TreeController.java    수목 목록 조회 및 추천 (TreeList.tsx, TreeRecommendation.tsx)
│   ├── service/
│   │   └── TreeService.java       수목 추천 가중치 알고리즘
│   └── repository/
│       └── TreeRepository.java
│
└── report/                    ← [2차] ESG 리포트 및 QR 공유
    ├── entity/
    │   ├── Report.java            ESG 리포트 기본 정보
    │   └── QrShare.java           QR 공유 메타데이터
    ├── controller/
    │   └── ReportController.java  ESG 리포트 생성, QR 공유 (ESGReport.tsx)
    ├── service/
    │   ├── ReportService.java     리포트 생성 및 데이터 집계
    │   └── QrService.java         24시간 만료 QR 코드 생성 및 유효성 검사
    ├── repository/
    │   ├── ReportRepository.java
    │   └── QrShareRepository.java
    ├── dto/
    │   └── ReportDTO.java         ESG 리포트 정보
    └── util/
        └── QrCodeUtil.java        QR 코드 이미지 생성 유틸리티
```

---

## 설정 파일 (`src/main/resources/`)
- `application.properties`: DB 연결 정보 (MySQL greendb), 서버 포트(8080), JPA 설정, 외부 API 키 (KOSIS, 기상청)
- `sql/`: 초기 데이터 SQL 스크립트 (region_code 17개 시도 포함)
- `data/gir_emission.xls`: GIR 온실가스 에너지 목표관리 명세서 (1167개 기업)

## 외부 API 연동
| API | 용도 | DB 저장 |
|-----|------|---------|
| KOSIS 국가통계포털 | 지역별 온실가스 배출량 (2019~2023) | O → regional_emission |
| GIR 명세서 (엑셀) | 기업별 배출량 (1167개, 2024) | O → company_emission |
| 기상청 단기예보 | 실시간 지역별 날씨 (기온, 강수, 풍속 등) | X (실시간 호출만) |



