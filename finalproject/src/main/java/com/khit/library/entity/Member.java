package com.khit.library.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "member")
public class Member extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long memberId;

    @Column(unique = true)
    private String mid;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String name;

    @Column
    private int rentalCount;

    @Column
    private Boolean rentalAble;

    @Enumerated(EnumType.STRING)
    private Role role;
}

