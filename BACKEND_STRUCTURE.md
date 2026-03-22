# GreenZone Backend 프로젝트 구조 (Spring Boot + MySQL)

> Java 17+ / Spring Boot 4.x / JPA / MySQL / AWS(EC2, RDS) 기반 ESG/탄소 관리 서버

---

## 디렉토리 구조 및 역할 (`src/main/java/com/green/backend/`)

### 1. Controller (`/controller`)
프론트엔드의 요청을 받아 서비스 계층으로 전달하는 API 엔드포인트입니다.
- `MemberController.java`: 로그인, 회원가입, 사업자번호 인증 (`Login.tsx`, `SignUp.tsx`)
- `ApplicationController.java`: 답사 신청 CRUD (`ApplicationStatus.tsx`)
- `AdminController.java`: 관리자 전용 승인, 전문가 배정, 기업 관리 (`AdminPage.tsx`)
- `ExpertReportController.java`: 전문가 현장 측정 데이터 처리 (`ExpertReport.tsx`)
- `CertificationController.java`: 인증서 발급 및 등급 관리 (`Certification.tsx`)
- `CarbonController.java`: 탄소 통계, 지도 위치, 기업 상세 데이터 (`CarbonVisualization.tsx`, `Dashboard.tsx`, `KakaoMapCompanies.tsx`)
- `ReportController.java`: ESG 리포트 생성, QR 공유 (`ESGReport.tsx`)
- `TreeController.java`: 수목 목록 조회 및 추천 알고리즘 (`TreeList.tsx`, `TreeRecommendation.tsx`)

### 2. Service (`/service`)
핵심 비즈니스 로직과 알고리즘이 구현되는 곳입니다.
- `MemberService.java`: 사용자 인증 및 권한 로직
- `ApplicationService.java`: 답사 신청 CRUD 비즈니스 로직
- `ExpertReportService.java`: 나무기록 CRUD 비즈니스 로직
- `CertificationService.java`: 등급 산정 및 인증 발급 로직
- `CarbonService.java`: 탄소 계산 공식 (ExpertReport 입력값 기반 계산)
- `ReportService.java`: 리포트 생성 및 데이터 집계
- `TreeService.java`: 수목 추천 가중치 알고리즘
- `QrService.java`: 24시간 만료 QR 코드 생성 및 유효성 검사

### 3. Entity (`/entity`)
MySQL 데이터베이스 테이블과 1:1로 매핑되는 객체입니다.
- `Company.java`: 기업 정보 (기업번호, 회사명, 사업자등록번호)
- `Member.java`: 회원 정보 (회원번호, 기업FK, 아이디, 비밀번호, 담당자, 전화번호, 이메일, 주소)
- `Expert.java`: 전문가 정보 (전문가번호, 이름, 연락처, 이메일, 등록일, 상태)
- `Application.java`: 답사 신청 내역 (답사번호, 회원FK, 전문가FK, 위도, 경도, 정기차수, 상태, 답사일, 신청내용)
- `ExpertReport.java`: 나무 기록 (나무기록번호, 답사FK, 수종, 흉고직경, 상태, 사진, 수고, 수관폭, 종합의견)
- `Certification.java`: 인증 등급 및 이력
- `Report.java`: ESG 리포트 기본 정보
- `Tree.java`: 수목 마스터 데이터 (추천 알고리즘용)
- `QrShare.java`: QR 공유 메타데이터

### 4. Repository (`/repository`)
Spring Data JPA를 사용하여 DB에 접근하는 인터페이스입니다.
- `CompanyRepository.java`
- `MemberRepository.java`
- `ExpertRepository.java`
- `ApplicationRepository.java`
- `ExpertReportRepository.java`
- `CertificationRepository.java`
- `ReportRepository.java`
- `TreeRepository.java`
- `QrShareRepository.java`

### 5. DTO (`/dto`)
프론트엔드와 통신할 때 사용하는 데이터 전송 객체입니다. (Entity 직접 노출 방지)
- `MemberDTO.java`: 회원가입 요청/응답
- `LoginDTO.java`: 로그인 요청
- `ExpertDTO.java`: 전문가 정보
- `ApplicationDTO.java`: 답사 신청 요청/응답
- `ExpertReportDTO.java`: 나무기록 요청/응답
- `CertificationDTO.java`: 인증 정보
- `CarbonStatsDTO.java`: 기업별 탄소 현황
- `TotalCarbonStatsDTO.java`: 전체 탄소 통계
- `CompanyLocationDTO.java`: 지도 마커용 위치 데이터
- `CompanyDetailDTO.java`: 기업 상세 정보
- `TreeRecordDTO.java`: 수목 기록 데이터
- `ReportDTO.java`: ESG 리포트 정보

### 6. Config (`/config`)
- `CorsConfig.java`: 프론트엔드(Vite, localhost:5173)와의 통신 허용 설정

### 7. Util (`/util`)
- `QrCodeUtil.java`: QR 코드 이미지 생성 유틸리티

---

## 설정 파일 (`src/main/resources/`)
- `application.properties`: DB 연결 정보 (MySQL greendb), 서버 포트(8080), JPA 설정
- `sql/`: 초기 데이터(수목 정보 등)를 위한 SQL 스크립트
