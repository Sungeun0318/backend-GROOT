package com.green.backend.member.entity;

import com.green.backend.BaseTime;
import com.green.backend.application.entity.Application;
import com.green.backend.member.dto.LoginDTO;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder@Table(name = "member")
public class Member extends BaseTime {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    private Long mid;

    @Column(name = "member_name", nullable = false, unique = true, length = 30)
    private String mname;

    @Column(name = "password", nullable = false, length = 65)
    private String password;

    @Column(name = "party_name", length = 30)
    private String party_name;

    @Column(name = "company_number", nullable = false, length = 20)
    private String company_number;

    @Column(name = "email", nullable = false, unique = true, length = 30)
    private String email;

    @Column(name = "address", length = 100)
    private String address;

    @Column( name = "profile")
    private String mfile;

    @Column(name = "career_file")
    private String careerFile; // 경력증명서 PDF

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "company_id")
    private Company company;

    @OneToMany(mappedBy = "memberId", cascade = CascadeType.ALL, orphanRemoval = true)
    @Builder.Default
    @ToString.Exclude
    private List<Application> applications = new ArrayList<>();



}
