package com.khit.library.controller;

import com.khit.library.entity.HopeBoard;
import com.khit.library.service.HopeBoardService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class HopeBoardController {
    private final HopeBoardService hopeBoardService;

    // write page 글쓰기
    @GetMapping("/hopeboard/write")
    public String writeForm() {
        return "hopeboard/write";
    }
    
    // 글쓰기 처리
    @PostMapping("/hopeboard/write")
    public String write() {
    	return "redirect:/hopeboard/pagelist";
    }

    // update page 글 수정
    @GetMapping("/hopeboard/update")
    public String updateForm() {
    	return "hopeboard/update";
    }
    
    // 글 수정 처리
    @PostMapping("/hopeboard/update")
    public String update() {
    	return "redirect:/hopeboard/"; // hopeboardDTO.getId();
    }
    
    // 글 전체 목록
    @GetMapping("/hopeboard/pagelist")
    public String getAllList() {
    	return "hopeboard/pagelist";
    }
    
    // 글 하나 상세보기
    @GetMapping("/hopeboard/detail")
    public String getDetail() {
    	return "hopeboard/detail";
    }
    
}
