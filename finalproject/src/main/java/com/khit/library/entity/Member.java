package com.khit.library.entity;

import com.khit.library.dto.MemberDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@Table(name = "member")
@NoArgsConstructor
@AllArgsConstructor
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
    @Builder.Default
    private Integer rentalCount = 0;

    @Column
    @Builder.Default
    private Boolean rentalAble = true;

    @Enumerated(EnumType.STRING)
    private Role role;

    public static Member toSaveEntity(MemberDTO memberDTO){
        Member member = Member.builder()
                .mid(memberDTO.getMid())
                .password(memberDTO.getPassword())
                .email(memberDTO.getEmail())
                .name(memberDTO.getName())
                .role(memberDTO.getRole())
                .build();
        return member;
    }

    public static Member toUpdateEntity(MemberDTO memberDTO){
        Member member = Member.builder()
                .memberId(memberDTO.getMemberId())
                .mid(memberDTO.getMid())
                .password(memberDTO.getPassword())
                .email(memberDTO.getEmail())
                .name(memberDTO.getName())
                .rentalCount(memberDTO.getRentalCount())
                .rentalAble(memberDTO.getRentalAble())
                .role(memberDTO.getRole())
                .build();
        return member;
    }
}

