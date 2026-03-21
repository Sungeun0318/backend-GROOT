# GreenZone Backend 프로젝트 구조 (Spring Boot + MySQL)

> Java 17+ / Spring Boot 3.x / JPA (Hibernate) / MySQL / AWS(EC2, RDS) 기반 ESG/탄소 관리 서버

---

## 디렉토리 구조 및 역할 (`src/main/java/com/green/backend/`)

### 1. Controller (`/controller`)
프론트엔드의 요청을 받아 서비스 계층으로 전달하는 API 엔드포인트입니다.
- `MemberController.java`: 로그인, 회원가입 (`Login.tsx`, `SignUp.tsx`)
- `ReportController.java`: ESG 리포트 생성, QR 공유 (`ESGReport.tsx`)
- `ExpertReportController.java`: 전문가 현장 측정 데이터 처리 (`ExpertReport.tsx`)
- `TreeController.java`: 수목 목록 조회 및 추천 알고리즘 (`TreeList.tsx`, `TreeRecommendation.tsx`)
- `ApplicationController.java`: 수목 신청 현황 관리 (`ApplicationStatus.tsx`)
- `CarbonController.java`: 탄소 배출량 통계 및 시각화 데이터 (`CarbonVisualization.tsx`)
- `CertificationController.java`: 인증서 발급 및 등급 관리 (`Certification.tsx`)
- `AdminController.java`: 관리자 전용 승인 및 기업 관리 (`AdminPage.tsx`)

### 2. Service (`/service`)
핵심 비즈니스 로직과 알고리즘이 구현되는 곳입니다.
- `MemberService.java`: 사용자 인증 및 권한 로직
- `ReportService.java`: 리포트 생성 및 데이터 집계
- `CarbonService.java`: 탄소 계산 공식 (Expert Report 입력값 기반 계산)
- `TreeService.java`: 수목 추천 가중치 알고리즘
- `QrService.java`: 24시간 만료 QR 코드 생성 및 유효성 검사

### 3. Entity (`/entity`)
MySQL 데이터베이스 테이블과 1:1로 매핑되는 객체입니다.
- `Member.java`: 사용자 및 기업 정보
- `Report.java`: 리포트 기본 정보
- `ExpertReport.java`: 수목 측정 데이터 (DBH, 수고, 수관폭 등)
- `Tree.java`: 수목 마스터 데이터
- `Application.java`: 신청 내역 및 상태
- `Certification.java`: 인증 등급 및 이력
- `QrShare.java`: QR 공유 메타데이터

### 4. Repository (`/repository`)
Spring Data JPA를 사용하여 DB에 접근하는 인터페이스입니다.
- `MemberRepository.java`, `ReportRepository.java` 등 Entity와 1:1 매칭

### 5. DTO (`/dto`)
프론트엔드와 통신할 때 사용하는 데이터 전송 객체입니다. (Entity 직접 노출 방지)
- `LoginRequestDTO.java`, `SignUpResponseDTO.java`
- `CarbonStatsDTO.java` 등

### 6. Config (`/config`)
- `SecurityConfig.java`: Spring Security 및 JWT 설정 (AWS 배포 시 필수)
- `CorsConfig.java`: 프론트엔드(Vite)와의 통신 허용 설정
- `AwsS3Config.java`: 사진 업로드(S3) 설정 (추후 필요 시)

---

## 설정 파일 (`src/main/resources/`)
- `application.yml`: DB 연결 정보 (MySQL), AWS 설정, 서버 포트(8080)
- `sql/`: 초기 데이터(수목 정보 등)를 위한 SQL 스크립트


