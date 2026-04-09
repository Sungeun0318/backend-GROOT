package com.green.backend.member.controller;


import com.green.backend.member.dto.*;
import com.green.backend.util.JwtUtil;
import com.green.backend.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/member")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:5173", exposedHeaders = "Authorization" )
public class MemberController {


    private final MemberService memberService;
    private final JwtUtil jwtUtil;


    // 회원 가입
    @PostMapping("/signup")
    public ResponseEntity<?> signup(MemberDTO memberDTO) {
        System.out.println("memberDTO = " + memberDTO);
        boolean result = memberService.signup(memberDTO);
        return ResponseEntity.ok(result);
    }

    // 로그인
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginDTO loginDTO) {
        LoginTokenDTO id_admin = memberService.login(loginDTO);
        if (id_admin != null) {
            String token = jwtUtil.generateToken(id_admin.getMid(),id_admin.getIsAdmin());
            return ResponseEntity.ok().header("Authorization", "Bearer " + token) // HTTP 통신의 부가정보 담는 구역 ( 주로 인증정보 포함 )
                    // 클라이언트에게 헤더에 발급받은 jwt토큰 반환한다. Bearer token (띄어쓰기 주의)
                    .body(true); // 성공의미
        }
        return ResponseEntity.ok(false);
    }

    // 로그아웃 프론트에서 토큰 버리면됨

    // 탈퇴
    @DeleteMapping("/delete")
    public ResponseEntity<?> withdraw(@RequestHeader String token) {
        // mid 추출
        Long mid = getMidFromToken(token);

        boolean result = memberService.withdraw(mid);

        return ResponseEntity.ok(result);
    }

    // 회원 정보 수정
    @PutMapping("/update")
    public ResponseEntity<?> mupdate(@RequestHeader String token, MemberUpdateDTO memberUpdateDTO) {

        // mid 추출
        Long mid = getMidFromToken(token);

        boolean result = memberService.mupdate(mid, memberUpdateDTO);
        return ResponseEntity.ok(result);

    }

    // 마이페이지
    @GetMapping("/myinfo")
    public ResponseEntity<?> mPrint(@RequestHeader String token) {

        // mid 추출
        Long mid = getMidFromToken(token);

        MemberResponseDTO member = memberService.mPrint(mid);
        return ResponseEntity.ok(member);

    }

    // 전체 회원 목록
    @GetMapping("/list")
    public ResponseEntity<?> memberList() {
        return ResponseEntity.ok(memberService.memberList());
    }

    // 기업별 회원 목록
    @GetMapping("/list/{companyId}")
    public ResponseEntity<?> memberListByCompany(@PathVariable Long companyId) {
        return ResponseEntity.ok(memberService.memberListByCompany(companyId));
    }



    // mid 추춣 함수
    private Long getMidFromToken(String token) {
        if (token == null || !token.startsWith("Bearer")) {
            return null;
        }
        token = token.replace("Bearer ", "");
        LoginTokenDTO dto = jwtUtil.validateToken(token);
        return dto.getMid();
    }


}
