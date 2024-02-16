package com.khit.library.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.khit.library.config.SecurityUser;
import com.khit.library.dto.FreeBoardDTO;
import com.khit.library.dto.MemberDTO;
import com.khit.library.dto.NoticeBoardDTO;
import com.khit.library.entity.FreeBoard;
import com.khit.library.service.FreeBoardService;
import com.khit.library.service.MemberService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class FreeBoardController {
	private final FreeBoardService freeBoardService;
	private final MemberService memberService;

	// write page 글쓰기
	@GetMapping("/freeboard/write")
	public String writeForm(@AuthenticationPrincipal SecurityUser principal, Model model) {
        if(principal == null){
        	return "freeboard/write";
        }else{
            MemberDTO memberDTO = memberService.findByMid(principal);
            model.addAttribute("member", memberDTO);
            return "freeboard/write";
        }
	}

	// 글쓰기 처리
	@PostMapping("/freeboard/write")
	public String write(@ModelAttribute FreeBoard freeBoard, @AuthenticationPrincipal SecurityUser principal, MultipartFile freeBoardFile) 
			 throws IOException, Exception {
    	freeBoard.setMember(principal.getMember());
		freeBoard.setFbhit(0);
		freeBoardService.save(freeBoard, freeBoardFile);
		return "redirect:/freeboard/pagelist";
	}

	// update page 글 수정
	@GetMapping("/freeboard/update/{fbid}")
	public String updateForm(@PathVariable Long fbid, @AuthenticationPrincipal SecurityUser principal, Model model) {
		FreeBoardDTO freeBoardDTO = freeBoardService.findById(fbid);
		model.addAttribute("freeBoard", freeBoardDTO);
        if(principal == null){
        	return "freeboard/update";
        }else{
            MemberDTO memberDTO = memberService.findByMid(principal);
            model.addAttribute("member", memberDTO);
            return "freeboard/update";
        }
	}

	// 글 수정 처리
	@PostMapping("/freeboard/update/{fbid}")
	public String update(@ModelAttribute FreeBoardDTO freeBoardDTO, MultipartFile freeBoardFile,
            @AuthenticationPrincipal SecurityUser principal,
            Model model) throws IOException, Exception {
		freeBoardDTO.setMember(principal.getMember());
		FreeBoardDTO upFreeBoardDTO = freeBoardService.update(freeBoardDTO, freeBoardFile);
		model.addAttribute("freeBoard", upFreeBoardDTO);
		return "redirect:/freeboard/" + upFreeBoardDTO.getFbid();
	}

	// 글 전체 목록
//	@GetMapping("/pagelist")
//	public String getAllList(Model model, @AuthenticationPrincipal SecurityUser principal) {
//		List<FreeBoardDTO> freeBoardDTOList = freeBoardService.findAll();
//		model.addAttribute("freeBoardList", freeBoardDTOList);
//        if(principal == null){
//            return "freeboard/pagelist";
//        }else{
//            MemberDTO memberDTO = memberService.findByMid(principal);
//            model.addAttribute("member", memberDTO);
//            return "freeboard/pagelist";
//        }
//	}
	
	//페이징, 글 목록
    @GetMapping("/freeboard/pagelist")
    public String pagelist(
            @RequestParam(value = "page", defaultValue = "0") int page,
            @RequestParam(value = "size", defaultValue = "10") int size,
            @AuthenticationPrincipal SecurityUser principal,
            Model model) {
        Pageable pageable = PageRequest.of(page, size);
        Page<FreeBoardDTO> freeBoardPage = freeBoardService.paging(pageable);
        List<FreeBoardDTO> freeBoardDTOList = freeBoardService.findAll();
        model.addAttribute("freeBoardPage", freeBoardPage);
        model.addAttribute("freeBoardList", freeBoardDTOList);
        if(principal == null){
            return "freeboard/pagelist";
        }else{
            MemberDTO memberDTO = memberService.findByMid(principal);
            model.addAttribute("member", memberDTO);
            return "freeboard/pagelist";
        }
    }

	// 글 하나 상세보기
	@GetMapping("/freeboard/{fbid}")
	public String getDetail(@AuthenticationPrincipal SecurityUser principal, @PathVariable Long fbid, Model model) {
		FreeBoardDTO freeBoardDTO = freeBoardService.findById(fbid);
		model.addAttribute("freeBoard", freeBoardDTO);
		if(principal == null){
			return "freeboard/detail";
		}else{
			MemberDTO memberDTO = memberService.findByMid(principal);
			model.addAttribute("member", memberDTO);
			return "freeboard/detail";
		}
	}

	// 글 삭제
	@GetMapping("/freeboard/delete/{fbid}")
	public String deleteFreeBoard(@PathVariable Long fbid) {
		freeBoardService.deleteById(fbid);
		return "redirect:/freeboard/pagelist";
	}

	@GetMapping("/freeboard/search")
	public String search(@RequestParam(required = false) String searchOption,
	                     @RequestParam(required = false) String keyword,
	                     Pageable pageable,
	                     Model model) {
	    Page<FreeBoardDTO> searchResults;
	    if (searchOption != null && keyword != null) {
	        if ("title".equals(searchOption)) {
	            searchResults = freeBoardService.searchByTitle(keyword, pageable);
	        } else if ("author".equals(searchOption)) {
	            searchResults = freeBoardService.searchByAuthor(keyword, pageable);
	        } else {
	            // 다른 경우에 대한 처리 (예: 기본적으로는 제목으로 검색)
	            searchResults = freeBoardService.search(keyword, pageable);
	        }
	    } else {
	        // searchOption 또는 keyword가 누락된 경우에 대한 처리
	        // 예: 기본적으로는 제목으로 검색하거나 다른 적절한 기본 동작을 설정
	        searchResults = freeBoardService.search(keyword, pageable);
	    }

	    model.addAttribute("freeBoardList", searchResults);
	    return "freeboard/pagelist";
	}
}
