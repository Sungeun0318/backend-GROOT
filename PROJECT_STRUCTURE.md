# Backend 프로젝트 구조

```
backend/
├── build.gradle                         # Gradle 빌드 설정 (Spring Boot 4.0.3, JPA, MySQL, Lombok, Thymeleaf, ZXing)
├── settings.gradle                      # 프로젝트 이름 설정
├── src/
│   ├── main/
│   │   ├── java/com/green/backend/
│   │   │   ├── BackendApplication.java           # Spring Boot 메인 실행 클래스
│   │   │   ├── entity/
│   │   │   │   ├── Report.java                   # ESG 보고서 엔티티
│   │   │   │   ├── QrShare.java                  # QR 공유 링크 엔티티
│   │   │   │   └── Member.java                   # 회원 엔티티
│   │   │   ├── dto/
│   │   │   │   ├── ReportDTO.java                # 보고서 데이터 전송 객체
│   │   │   │   ├── MemberDTO.java                # 회원가입 데이터 전송 객체
│   │   │   │   └── LoginDTO.java                 # 로그인 데이터 전송 객체
│   │   │   ├── repository/
│   │   │   │   ├── ReportRepository.java         # Report JPA 레포지토리
│   │   │   │   ├── QrShareRepository.java        # QrShare JPA 레포지토리
│   │   │   │   └── MemberRepository.java         # Member JPA 레포지토리
│   │   │   ├── service/
│   │   │   │   ├── ReportService.java            # 보고서 비즈니스 로직
│   │   │   │   └── MemberService.java            # 회원 비즈니스 로직 (TODO)
│   │   │   ├── controller/
│   │   │   │   ├── ReportController.java         # 보고서 REST API
│   │   │   │   └── MemberController.java         # 회원 REST API (TODO)
│   │   │   ├── config/
│   │   │   │   └── CorsConfig.java               # CORS 설정
│   │   │   └── util/
│   │   │       └── QrCodeUtil.java               # QR 코드 생성 유틸
│   │   └── resources/
│   │       ├── application.properties            # DB, JPA, 서버 설정
│   │       └── sql/
│   │           └── data.sql                      # 초기 데이터 SQL
│   └── test/
│       └── java/com/green/backend/
│           └── BackendApplicationTests.java      # 테스트
```

## 파일별 기능

### Entity

| 파일 | 기능 |
|------|------|
| `Report.java` | ESG 보고서 데이터 저장. 기업명, 등록 수목 수, 총 탄소흡수량(kg CO₂), 인증 등급, 월별 탄소 데이터(JSON), 생성일시 |
| `QrShare.java` | QR 공유 링크 관리. UUID 토큰, Report FK, 생성/만료 시간(24시간), 전송 여부. `isExpired()` 메서드로 만료 체크 |
| `Member.java` | 회원 정보. 기업명, 사업자등록번호, 담당자명, 연락처, 이메일(unique), 비밀번호, 가입일시 |

### DTO

| 파일 | 기능 |
|------|------|
| `ReportDTO.java` | 보고서 생성 요청 시 클라이언트에서 받는 데이터 객체 |
| `MemberDTO.java` | 회원가입 시 클라이언트에서 받는 데이터 객체 |
| `LoginDTO.java` | 로그인 시 이메일/비밀번호 전달 객체 |

### Repository

| 파일 | 기능 |
|------|------|
| `ReportRepository.java` | Report CRUD (JpaRepository 상속) |
| `QrShareRepository.java` | QrShare CRUD + `findByShareToken(String)` 토큰으로 조회 |
| `MemberRepository.java` | Member CRUD + `findByEmail(String)`, `existsByEmail(String)` |

### Service

| 파일 | 기능 |
|------|------|
| `ReportService.java` | `createReport()` 보고서 생성, `getReport()` 조회, `generateQrShare()` QR 공유 링크+이미지 생성 (24시간 만료), `getReportByToken()` 토큰으로 보고서 조회 (만료 시 null), `markAsSent()` 전송 완료 처리 |
| `MemberService.java` | `signup()` 회원가입, `login()` 로그인 (TODO: 구현 필요) |

### Controller

| 파일 | API 엔드포인트 |
|------|---------------|
| `ReportController.java` | `POST /api/reports` 보고서 생성 |
| | `GET /api/reports/{id}` 보고서 조회 |
| | `POST /api/reports/{id}/share` QR 공유 링크 생성 (token, shareLink, qrImage 반환) |
| | `GET /api/reports/shared/{token}` 토큰으로 보고서 조회 (만료 시 410 Gone) |
| | `POST /api/reports/shared/{token}/send` 전송 버튼 → DB 영구 저장 |
| `MemberController.java` | `POST /api/members/signup` 회원가입 (TODO) |
| | `POST /api/members/login` 로그인 (TODO) |
| | `POST /api/members/logout` 로그아웃 (TODO) |

### Config / Util

| 파일 | 기능 |
|------|------|
| `CorsConfig.java` | `/api/**` 경로에 localhost:3000 CORS 허용 |
| `QrCodeUtil.java` | ZXing 라이브러리로 QR 코드를 Base64 PNG 문자열로 생성 |
