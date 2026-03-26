package com.green.backend.application.repository;

import com.green.backend.application.entity.Application;
import com.green.backend.member.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ApplicationRepository extends JpaRepository<Application, Long> {
    List<Application> findAllByMemberId(Member member); // Member 엔티티를 기준으로 해당 회원이 신청한 모든 답사 내역을 조회하는 메서드

    // 답사 정보 조회할때 사용 (이태형)
    List<Application> findByMemberId_MidAndSurveyStatusOrderByTimesAsc(
            Long mid,
            String surveyStatus
    );

    // 답사 정보 상세 조회
    Optional<Application> findByMemberId_MidAndTimes(Long mid, int times);
}
