# GreenZone 프로젝트 팀원별 개발 로드맵 (1차 MVP)

> 4인 팀 프로젝트 분담 및 기능 명세 (한승, 도경, 태형, 성은)

---

## 👤 [한승] 기업 인증 및 계정 관리
**목표:** 신뢰할 수 있는 기업 정보 기반의 회원 체계 구축

### 주요 기능
- **기업 조회 API 연동 회원가입**: 공공데이터 API 등을 활용해 실제 등록된 기업인지 확인 후 가입 진행
- **기업 계정 로그인**: 가입된 정보를 바탕으로 세션/JWT 기반 로그인 구현

### 담당 파일
- **Backend (Java)**:
    - `Member.java` (Entity): 기업 정보 및 인증 상태 저장
    - `MemberController.java`: `/api/auth/signup`, `/api/auth/login`
    - `MemberService.java`: 가입/로그인 비즈니스 로직 및 외부 API 연동
    - `dto/LoginRequestDTO.java`, `dto/SignUpRequestDTO.java`
- **Frontend (React)**:
    - `SignUp.tsx`: 기업 조회 및 정보 입력 폼
    - `Login.tsx`: 로그인 인터페이스

---

## 👤 [도경] 답사 신청 및 통합 관리 (기업/관리자)
**목표:** 기업의 답사 요청부터 관리자의 전문가 배정까지의 프로세스 구현

### 주요 기능
- **[기업] 답사 신청 및 CRUD**: 답사 신청 등록, 내역 조회, 수정, 취소
- **[기업] 일정 및 전문가 확인**: 확정된 답사 일정 및 배정된 전문가 정보 조회
- **[관리자] 통합 관리**: 전체 신청 내역 관리 및 전문가 배정 기능

### 담당 파일
- **Backend (Java)**:
    - `Application.java` (Entity): 신청 상태(대기/배정/완료), 전문가 정보 필드
    - `ApplicationController.java`: `/api/applications/**` (CRUD API)
    - `AdminController.java`: `/api/admin/assign` (전문가 배정 API)
- **Frontend (React)**:
    - `ApplicationStatus.tsx`: 기업용 신청 목록 및 상세 페이지
    - `AdminPage.tsx`: 관리자용 전체 목록 및 배정 모달

---

## 👤 [태형] 답사 결과 기록 및 인증 등급 부여
**목표:** 현장 데이터 수집 및 이를 기반으로 한 최종 ESG 등급 결정

### 주요 기능
- **[전문가] 답사 결과 입력**: 수종, DBH(흉고직경), 수고, 상태 등 현장 데이터 기록
- **[전문가] 정기 답사 조회**: 이전 답사 데이터를 불러와 연속성 있는 기록 지원
- **[관리자] 등급 부여**: 답사 정보를 검토하여 기업별 최종 인증 등급 결정

### 담당 파일
- **Backend (Java)**:
    - `ExpertReport.java` (Entity): 상세 측정 데이터 저장
    - `ExpertReportController.java`: `/api/expert-reports/**`
    - `Certification.java` (Entity): 기업별 등급 및 인증 이력
    - `CertificationService.java`: 등급 부여 로직 및 결과 처리
- **Frontend (React)**:
    - `ExpertReport.tsx`: 전문가용 데이터 입력 폼
    - `Certification.tsx`: 관리자용 등급 검토 및 부여 화면

---

## 👤 [성은] 시각화 및 데이터 제공 API
**목표:** 대외적인 활동 현황 시각화 및 내/외부 연동용 데이터 제공

### 주요 기능
- **[전체] 메인페이지 지도 시각화**: 전체 참여 기업의 위치를 마커로 표시하여 활동 현황 공개
- **기업별 탄소현황 API**: 누적 탄소 흡수량 및 현황 데이터를 JSON 형태로 제공
- **서비스 연계**: 대시보드, 리포트, 지도 등에서 사용할 공통 데이터 제공

### 담당 파일
- **Backend (Java)**:
    - `CarbonController.java`: `/api/carbon/stats/**`
    - `CarbonService.java`: 기업별 탄소 데이터 집계 로직
    - `MemberController.java`: 지도 마커용 위치 정보 목록 API
- **Frontend (React)**:
    - `Landing.tsx`: 지도 API(Google/Kakao) 연동 및 마커 표시
    - `Dashboard.tsx`: 기업별 요약 통계 시각화

---

## 📅 향후 일정 (2차 고도화)
- 수목 추천 알고리즘 (조건별 최적 식재 제안)
- ESG 리포트 PDF 생성 및 QR 코드 공유
- 실시간 알림 시스템 (전문가 배정 등 알림)
