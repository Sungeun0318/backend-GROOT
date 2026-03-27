package com.green.backend.expert.repository;

import com.green.backend.application.entity.Application;
import com.green.backend.expert.entity.Expert;
import com.green.backend.member.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExpertRepository extends JpaRepository<Expert, Long> {
}
