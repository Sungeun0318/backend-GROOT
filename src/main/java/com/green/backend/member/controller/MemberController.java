package com.green.backend.member.controller;


import com.green.backend.util.JwtUtil;
import com.green.backend.member.dto.LoginDTO;
import com.green.backend.member.dto.MemberDTO;
import com.green.backend.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/member")
@RequiredArgsConstructor
public class MemberController {


    private final MemberService memberService;
    private final JwtUtil jwtUtil;


    // 회원 가입
    @PostMapping("/signup")
    public ResponseEntity<?>signup(MemberDTO memberDTO){
        System.out.println("memberDTO = " + memberDTO);
        boolean result = memberService.signup(memberDTO);
        return ResponseEntity.ok(result);
    }

    // 로그인
    @PostMapping("/login")
    public ResponseEntity<?>login(@RequestBody LoginDTO loginDTO){
        Long mid = memberService.login(loginDTO);
        if (mid !=null){
            String token = jwtUtil.generateToken(mid);
            return ResponseEntity.ok()
                    .header( "Authorization", "Bearer "+token ) // HTTP 통신의 부가정보 담는 구역 ( 주로 인증정보 포함 )
                    // 클라이언트에게 헤더에 발급받은 jwt토큰 반환한다. Bearer token (띄어쓰기 주의)
                    .body( true ); // 성공의미
        }
        return ResponseEntity.ok( false );
    }

    // 로그아웃 프론트에서 토큰 버리면됨

    // 탈퇴?
    @DeleteMapping("/delete")
    public ResponseEntity<?>withdraw(@RequestHeader String token){
        if(token==null||!token.startsWith("Bearer")){
            return ResponseEntity.ok(false);
        }
        token = token.replace("Bearer " , "");

        Long mid = jwtUtil.validateToken(token);

        if(mid == null){return ResponseEntity.ok(false);}

        boolean result = memberService.withdraw(mid);

        return ResponseEntity.ok(result);
    }

//    // 수정
//    @PutMapping("/update")
//    public ResponseEntity<?>Mupdate(){
//
//    }
//
//
//    // 회원 조회
//    @GetMapping("/print")
//    public ResponseEntity<?>mPrint(){
//
//    }



}
