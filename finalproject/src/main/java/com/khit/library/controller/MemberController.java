package com.khit.library.controller;

import com.khit.library.entity.Member;
import com.khit.library.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class MemberController {
    private final MemberService memberService;

    //회원가입 폼
    @GetMapping("/member/join")
    public String joinForm(){
        return "/member/join";
    }
    //회원가입 처리
    @PostMapping("/member/join")
    public String join(@ModelAttribute Member member){
        memberService.join(member);
        return "redirect:/";
    }
}
