package com.green.backend.member.entity;


import com.green.backend.BaseTime;
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
public class Company extends BaseTime {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long company_id;

    @Column(nullable = false,length = 30)
    private String companyName;

    @Column(nullable = false, length = 30,unique = true)
    private String business_number;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "company")
    @Builder.Default
    @ToString.Exclude
    private List<Member> members = new ArrayList<>();

}