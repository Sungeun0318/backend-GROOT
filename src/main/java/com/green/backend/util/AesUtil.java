package com.green.backend.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;

@Component
public class AesUtil {

    private static final String ALGORiTHM = "AES/CBC/PKCS5Padding"; // 암호화 방식
     // AES : 대칭키 암호화 알고리즘
     // CBC : 데이터를 블록 단위로 쪼개서 암호화할 때, 이전 블록의 결과값을 다음 블록에 영향을 주게 하여 보안성을 높인 방식
     // PKCS5Padding :데이터 크기가 딱 맞지 않을 때 빈 공간을 어떻게 채울지 정하는 규칙


    @Value("${aes.secret.key}") // 32자 키(AES-256)
    private String secretKey;

    @Value("${aes.secret.iv}") // 16자 IV
    private String iv; // CBC 모드에서 첫 번째 블록을 암호화할 때 사용하는 '무작위 값'

    // [1] 데이터 암호화 : 평문(byte[]) -> 암호문(byte[]) 변환
    public byte[] encrypt(byte[] data){
        // 1. 열쇠 객체 생성 : 비밀키 문자열을 AES용 열쇠(SecretKeySpec)로 변환
        SecretKeySpec keySpec = new SecretKeySpec(secretKey.getBytes(StandardCharsets.UTF_8),"AES");
        // 2. IV 객체 생성 : 첫 블록 암호화 시 섞어줄 무작위 값 세팅
        IvParameterSpec ivSpec = new IvParameterSpec(iv.getBytes(StandardCharsets.UTF_8));
        try{
            // 3. 정해진 알고리즘 방식의 인스턴스 호출
            Cipher cipher = Cipher.getInstance(ALGORiTHM);
            // 4. 암호화 모드(ENCRYPT_MODE)' 설정 및 열쇠/iv 장착
            cipher.init(Cipher.ENCRYPT_MODE , keySpec , ivSpec);
            // 5. 실제 암호화 실행
            return cipher.doFinal(data);
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    // 복호화
    public byte[] decrypt(byte[] data){
        SecretKeySpec keySpec = new SecretKeySpec(secretKey.getBytes(StandardCharsets.UTF_8),"AES");
        IvParameterSpec ivSpec = new IvParameterSpec(iv.getBytes(StandardCharsets.UTF_8));
        try{
            Cipher cipher = Cipher.getInstance(ALGORiTHM);
            cipher.init(Cipher.DECRYPT_MODE , keySpec , ivSpec); // 복호화모드
            return cipher.doFinal(data);
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }


}


