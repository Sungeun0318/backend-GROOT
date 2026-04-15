# 🌳 GreenZone

> **기업 ESG 실천을 위한 탄소중립 수목 관리 플랫폼**

지역 기후와 토양 데이터를 기반으로 최적 수종을 추천하고,
기업의 탄소흡수량을 과학적으로 측정·예측하여 **친환경 인증마크**를 발급하는 서비스입니다.

---

## 📖 1. 프로젝트 소개

### 프로젝트 이름
**GreenZone** — 기업 ESG 탄소중립 플랫폼

### 한 줄 설명
**"기업의 탄소 상쇄 활동을 데이터 기반으로 추천·측정·인증하는 플랫폼"**

### 개발 목적 / 배경

- 🌍 2050 **탄소중립** 목표와 ESG 경영 확산에 따라, 기업의 실질적인 탄소 상쇄 활동 수요가 급증
- 🌱 기업이 직접 식재할 수목 선정 시 **지역 기후·토양·면적**을 고려한 과학적 근거 부족
- 📊 기존 탄소흡수량 산정은 단순 추정에 의존 → **산림과학원 논문 기반** 상대생장식으로 신뢰성 확보
- ✅ 답사 → 식재 → 측정 → 인증 전 과정을 **하나의 플랫폼**에서 관리

---

## 👥 2. 팀원 / 역할

| 팀원 | 담당 영역 | 주요 역할 |
|:---:|:---|:---|
| **한승** | 🔐 **회원 · 인프라** | • 회원 및 기업 관리<br>• JWT 기반 로그인/인증<br>• AWS 클라우드 배포 |
| **도경** | 📋 **답사 · 배정** | • 답사 신청 및 전문가 관리<br>• 관리자 승인/반려 로직<br>• 전문가 자동 배정 트리거 |
| **태형** | 📐 **현장 · 측정** | • 현장 보고서 및 나무 측정<br>• 탄소흡수량 계산 로직<br>• 좌표 기반 위치 매핑 |
| **성은** | 🌳 **추천 · 인증** | • 수목 추천 알고리즘<br>• 탄소흡수량 계산 및 예측<br>• 인증마크 시스템<br>• 외부 API 연동 |

---

## 🛠 3. 기술 스택

### 🖥 Backend
![Spring Boot](https://img.shields.io/badge/Spring_Boot-6DB33F?style=for-the-badge&logo=springboot&logoColor=white)
![AWS](https://img.shields.io/badge/AWS_EC2/S3/RDS-FF9900?style=for-the-badge&logo=amazonaws&logoColor=white)
![MySQL](https://img.shields.io/badge/MySQL-4479A1?style=for-the-badge&logo=mysql&logoColor=white)
![JPA](https://img.shields.io/badge/JPA/Hibernate-59666C?style=for-the-badge&logo=hibernate&logoColor=white)
![JWT](https://img.shields.io/badge/JWT-000000?style=for-the-badge&logo=jsonwebtokens&logoColor=white)
![Gmail](https://img.shields.io/badge/Gmail_SMTP-EA4335?style=for-the-badge&logo=gmail&logoColor=white)

### 💻 Frontend
![React](https://img.shields.io/badge/React-61DAFB?style=for-the-badge&logo=react&logoColor=black)
![TypeScript](https://img.shields.io/badge/TypeScript-3178C6?style=for-the-badge&logo=typescript&logoColor=white)
![Tailwind CSS](https://img.shields.io/badge/Tailwind_CSS-06B6D4?style=for-the-badge&logo=tailwindcss&logoColor=white)

### 🌐 외부 API
| API | 제공처 | 용도 |
|:---|:---|:---|
| **사업자번호 검증 API** | 국세청 | 기업 회원가입 시 사업자 진위 확인 |
| **지역별 온실가스 배출량 API** | KOSIS (통계청) | 지역 탄소 배출 데이터 조회 |
| **토양도 기반 토양특성 상세정보 API** | 농촌진흥청 (국립농업과학원) | 배수등급·토심·토성 등 토양 정보 |
| **기상청 단기예보 조회서비스** | 기상청 | 지역별 실시간 기온·습도 조회 |

---

## ✨ 4. 주요 기능

### 🔐 회원 · 인증
- **사업자번호 검증**을 통한 **기업 회원가입** (국세청 API 연동)
- **JWT 기반 로그인**으로 안전한 인증 흐름
- **경력증명서 PDF 업로드** 후 관리자 승인 절차
- **이메일(SMTP)** 을 활용한 인증마크 발급 알림

### 📋 답사 신청 · 자동 배정
- 기업이 원하는 **날짜·지역**을 선택해 답사 신청
- 관리자의 **승인/반려** 처리 후 전문가 **자동 배정**
    - **1단계**: 기업 주소 기준 동일 시(市) 소속 전문가 우선 매칭
    - **2단계**: Haversine 공식으로 **가장 가까운 거리**의 전문가 배정
    - **일정 충돌 자동 회피** (이미 배정된 전문가 제외)

### 📐 현장 보고서 · 측정
- 현장 답사 후 전문가가 **수목 측정 데이터** 입력
    - 흉고직경(DBH), 수고, 위치 좌표 등
- **산림과학원 논문 기반 상대생장식(W = a × D^b)** 적용
- 실측 데이터 기반 **탄소흡수량(CO₂) 자동 산출**

### 🌳 수목 추천 알고리즘
- 기업이 **지역·면적·희망 수량**을 입력하면 22종 중 **최적 수종 TOP 3 추천**
- **100점 만점 4단계 점수화**:

  | 평가 항목 | 배점 | 평가 기준 |
    |:---|:---:|:---|
  | 🌱 탄소흡수력 | 35점 | 상대생장식 기반 연간 CO₂ 흡수량 |
  | 🪴 토양적합도 | 30점 | 흙토람 API × 수종별 선호 범위 매칭 |
  | 🌤 날씨적합도 | 20점 | 기상청 API × 수종 분류별 최적 범위 |
  | 📏 면적적합도 | 15점 | 식재 간격 기반 적정 밀도 판정 |

- **보정 탄소흡수량** 제공 (토양·날씨 환경 반영)

### 📊 탄소흡수량 예측
- **년도별 탄소흡수량 예측**
- **수종별 성장 곡선** 반영 상대생장식 적용
- 기업별 **누적 탄소 상쇄 실적** 관리

### 🏆 인증마크 시스템
- 누적 탄소흡수량 기준 **등급별 인증마크 자동 발급** (Bronze → Silver → Gold → Platinum)
- **이메일 자동 발송** 및 다운로드 가능
- 기업 홍보/ESG 보고서에 활용 가능

### 👨‍💼 관리자 대시보드
- 회원·기업 승인 관리
- 답사 신청 전체 현황 조회
- 전문가 수동 배정 기능
- **지역별 탄소 배출량 통계** 시각화 (KOSIS 연동)

---

## 🌐 서비스 흐름도

```
 [기업 회원가입]
       ↓
 [수목 추천] ──(지역·면적·수량)──→ [토양 API + 기상청 API + DB 조회]
       ↓                                    ↓
       ↓                           [22종 중 TOP 3 추천]
       ↓
 [답사 신청] ──(관리자 승인)──→ [전문가 자동 배정]
       ↓
 [현장 답사 및 식재]
       ↓
 [수목 측정] ──(DBH·수고 입력)──→ [탄소흡수량 산출]
       ↓
 [누적 탄소 흡수량]
       ↓
 [인증마크 발급] ──(Gmail SMTP)──→ [기업 이메일 수신]
```

---

<div align="center">

**🌏 지속 가능한 미래를 위한 한 그루의 시작, GreenZone 🌏**

</div>
