package com.green.backend.member.entity;

import com.green.backend.BaseTime;
import jakarta.persistence.*;
import lombok.*;

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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "company_id")
    private Company company;


}
