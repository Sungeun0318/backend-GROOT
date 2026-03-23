package com.green.backend.member.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder@Table(name = "member")
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    private Long member_id;

    @Column(name = "login_id", nullable = false, unique = true, length = 30)
    private String login_id;

    @Column(name = "password", nullable = false, length = 30)
    private String password;

    @Column(name = "party_name", length = 30)
    private String party_name;

    @Column(name = "phone_number", nullable = false, length = 20)
    private String phone_number;

    @Column(name = "email", nullable = false, unique = true, length = 30)
    private String email;

    @Column(name = "address", length = 100)
    private String address;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "company_id")

    private Company company;


}
