package com.khit.library.controller;

import com.khit.library.dto.MemberDTO;
import com.khit.library.service.MemberService;
import jakarta.validation.Valid;
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
    public String joinForm(MemberDTO memberDTO){
        return "/member/join";
    }
    //회원가입 처리
    @PostMapping("/member/join")
    public String join(@Valid MemberDTO memberDTO){
        memberService.save(memberDTO);
        return "redirect:/";
    }
    //로그인 폼
    @GetMapping("/member/login")
    public String loginForm(){
        return "/member/login";
    }
    //로그아웃
    @GetMapping("/member/logout")
    public String logout(){
        return "redirect:/";
    }
}
