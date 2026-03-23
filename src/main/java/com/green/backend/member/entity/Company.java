package com.green.backend.member.entity;

import com.green.backend.member.dto.MemberDTO;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder@Table(name = "company")
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int company_id;

    @Column(nullable = false,length = 30)
    private String company_name;

    @Column(nullable = false, length = 30,unique = true)
    private String business_number;

    @OneToMany(mappedBy = "company")
    @Builder.Default
    @ToString.Exclude
    private List<Member> members = new ArrayList<>();

}
