package com.green.backend.util;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;

@Component
public class JwtUtil {

    private final String SECRET_KEY = "greencarbonplatformgreencarbonplatform"; // 32자 이상
    //.setExpiration( new Date( System.currentTimeMillis() + 1000 * 20 ) ) // 토큰 유지/유효 시간
    private final long EXPIRATION = 1000 * 60 * 60 * 24; // 24시간

    // * 내가 만든 임의의 값(비밀번호) 해시값(SHA)으로 변환
    //    private final Key 비밀키 = Keys.hmacShaKeyFor( 비밀번호.getBytes() );
    private Key getSigningKey(){
        return Keys.hmacShaKeyFor( SECRET_KEY.getBytes() );
    }

    // 토큰 생성
    public String generateToken(Long mid){
        String token = Jwts.builder()
                .claim("mid", mid) // 토큰에 저장할 자료
                .setIssuedAt(new Date()) // 토큰 발급날짜/시간대입
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION)) // 토큰 만료 시간
                .signWith(getSigningKey(), SignatureAlgorithm.HS256)//  최종 토큰 암호화는 HS256 알고리즘 적용
                .compact(); // 토큰 최종 문자열로 반환
        return token;
    }

    // 토큰의 클레임(내용물) 추출
    public Long validateToken(String token){
        try{
            Claims claims = Jwts.parserBuilder() // 파싱
                    .setSigningKey(getSigningKey()) // 서명 검증에 필요한 비밀키 대입
                    .build() // 파서 완성
                    .parseClaimsJws(token)
                    .getBody();
            Object object = claims.get("mid");
            return Long.parseLong(  String.valueOf(object) );
        }catch (JwtException e){
            return null;
        }
    }



}
