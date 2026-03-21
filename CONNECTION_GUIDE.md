# Frontend-Backend 연결 가이드 (React + Spring Boot)

> 이 문서는 프론트엔드(Vite + React)와 백엔드(Spring Boot) 간의 데이터 통신 및 연결 설정 방법을 설명합니다.

---

## 1. 통신 기본 원리
- **프론트엔드 (Port 5173)**: 사용자 화면에서 데이터를 수집하여 백엔드에 요청(Request)을 보냅니다.
- **백엔드 (Port 8080)**: 요청을 받아 DB 처리 등을 수행하고 결과를 응답(Response)합니다.
- **데이터 형식**: 주로 **JSON** 형식을 사용합니다.

---

## 2. 백엔드 설정 (Spring Boot)

### ✅ CORS 허용 설정 (필수)
브라우저의 보안 정책상 포트가 다르면 통신이 차단됩니다. 백엔드에서 이를 허용해줘야 합니다.
`backend/src/main/java/com/green/backend/config/CorsConfig.java` 파일을 아래와 같이 작성하세요.

```java
package com.green.backend.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**") // 모든 경로에 대해
                .allowedOrigins("http://localhost:5173") // 리액트 주소 허용
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
                .allowedHeaders("*")
                .allowCredentials(true);
    }
}
```

---

## 3. 프론트엔드 설정 (Vite + React)

### ✅ Axios 설치 및 기본 호출
HTTP 통신을 위해 `axios` 라이브러리를 사용합니다.
```bash
npm install axios
```

**사용 예시 (Login.tsx):**
```tsx
import axios from 'axios';

const handleLogin = async (credentials) => {
  try {
    // 백엔드 API 호출 (POST 방식)
    const response = await axios.post('http://localhost:8080/api/auth/login', credentials);
    
    // 성공 시 처리 (결과 데이터는 response.data에 들어있음)
    console.log("서버 응답:", response.data);
    alert("로그인 성공!");
  } catch (error) {
    // 실패 시 처리
    console.error("로그인 실패:", error);
  }
};
```

### ✅ Vite Proxy 설정 (권장)
매번 전체 주소(`http://localhost:8080`)를 쓰지 않도록 `vite.config.ts`를 수정합니다.

```typescript
// vite.config.ts
export default defineConfig({
  server: {
    proxy: {
      '/api': {
        target: 'http://localhost:8080',
        changeOrigin: true,
        secure: false,
      }
    }
  }
});
```
설정 후에는 `axios.post('/api/auth/login', ...)` 처럼 상대 경로로 호출이 가능합니다.

---

## 4. 데이터 주고받기 규칙 (DTO)
- **Request**: 프론트에서 보내는 데이터 구조와 백엔드 Java의 **DTO 클래스** 필드명이 일치해야 합니다.
- **Response**: 백엔드에서 반환하는 객체는 자동으로 JSON으로 변환되어 프론트의 `response.data`에 담깁니다.

---

## 🛠 연결 확인 체크리스트
1. 백엔드 서버(Spring Boot)가 실행 중인가? (8080 포트)
2. 프론트엔드 서버(Vite)가 실행 중인가? (5173 포트)
3. 백엔드에 `CorsConfig` 설정이 되어 있는가?
4. 프론트엔드에서 `axios` 주소가 백엔드 컨트롤러의 `@RequestMapping` 주소와 일치하는가?
