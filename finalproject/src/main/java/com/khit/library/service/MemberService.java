package com.khit.library.service;

import com.khit.library.config.SecurityUser;
import com.khit.library.dto.MemberDTO;
import com.khit.library.entity.Member;
import com.khit.library.entity.Role;
import com.khit.library.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;
    private final PasswordEncoder pwEncoder;

    //회원가입
    public void save(MemberDTO memberDTO) {
        String encPw = pwEncoder.encode(memberDTO.getPassword()); //비밀번호 암호화
        memberDTO.setPassword(encPw);
        memberDTO.setRole(Role.Member); //권한설정
        Member member = Member.toSaveEntity(memberDTO);
        memberRepository.save(member);
    }
    public MemberDTO findByMid(SecurityUser principal){
        Optional<Member> member = memberRepository.findByMid(principal.getUsername());
        MemberDTO memberDTO = MemberDTO.toSaveDTO(member.get());
        return memberDTO;
    }
}
