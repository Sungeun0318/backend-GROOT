package com.green.backend.member.repository;


import com.green.backend.member.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long> {

    // 로그인용 - member_name으로 회원 조회
    Optional<Member> findByMname(String mname);
    // 회원가입용 - member_name 중복 체크
    boolean existsByMname(String mname);
    // 회원가입용 - email 중복 체크
    boolean existsByEmail(String email);

    // 회원 목록 기업별
    List<Member> findByCompany_CompanyId(Long companyId);


}
