package com.khit.library.service;

import com.khit.library.entity.Member;
import com.khit.library.entity.Role;
import com.khit.library.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;

    public void join(Member member) {
        member.setRole(Role.Admin);
        memberRepository.save(member);
    }
}
