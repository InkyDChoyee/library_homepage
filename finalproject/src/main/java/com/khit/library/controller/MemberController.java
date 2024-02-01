package com.khit.library.controller;

import com.khit.library.config.SecurityUser;
import com.khit.library.dto.MemberDTO;
import com.khit.library.service.MemberService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class MemberController {
    private final MemberService memberService;

    //회원가입 폼
    @GetMapping("/member/join")
    public String joinForm(MemberDTO memberDTO){
        return "member/join";
    }
    //회원가입 처리
    @PostMapping("/member/join")
    public String join(@Valid MemberDTO memberDTO){
        memberService.save(memberDTO);
        return "redirect:/";
    }
    //로그인 폼
    @GetMapping("/login")
    public String loginForm(){
        return "login";
    }
    //로그아웃
    @GetMapping("/logout")
    public String logout(){
        return "redirect:/";
    }
    //회원목록
    @GetMapping("/member/list")
    public String getList(Model model){
        List<MemberDTO> memberDTOList = memberService.findAll();
        model.addAttribute("memberList", memberDTOList);
        return "member/list";
    }
    //회원 상세보기
    @GetMapping("/member/{memberId}")
    public String getMember(@PathVariable Long memberId, Model model){
        MemberDTO memberDTO = memberService.findById(memberId);
        model.addAttribute("member", memberDTO);
        return "member/detail";
    }
    //회원삭제
    @GetMapping("/member/delete/{memberId}")
    public String delete(@PathVariable Long memberId){
        memberService.deleteById(memberId);
        return "redirect:/member/list";
    }
    //회원수정 폼
    @GetMapping("/member/update")
    public String updateForm(@AuthenticationPrincipal SecurityUser principal, Model model){
        MemberDTO memberDTO = memberService.findByMid(principal);
        model.addAttribute("member", memberDTO);
        return "member/update";
    }
    //회원수정 처리
    @PostMapping("/member/update")
    public String update(@ModelAttribute MemberDTO memberDTO){
        memberService.update(memberDTO);
        return "redirect:/member/" + memberDTO.getMemberId();
    }
}