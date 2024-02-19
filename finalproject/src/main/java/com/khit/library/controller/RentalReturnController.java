package com.khit.library.controller;

import com.khit.library.config.SecurityUser;
import com.khit.library.dto.MemberDTO;
import com.khit.library.dto.RentalReturnDTO;
import com.khit.library.entity.Member;
import com.khit.library.service.MemberService;
import com.khit.library.service.RentalReturnService;
import lombok.RequiredArgsConstructor;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/rentalReturn")
public class RentalReturnController {
    private final RentalReturnService rentalReturnService;
    private final MemberService memberService;

    //대출리스트, 페이징
    @GetMapping("/list")
    public String getList(
    		 @RequestParam(value = "page", defaultValue = "0") int page,
             @RequestParam(value = "size", defaultValue = "10") int size,
             @AuthenticationPrincipal SecurityUser principal,
             Model model) {
    	Pageable pageable = PageRequest.of(page, size);
    	Page<RentalReturnDTO> rentalReturnPage = rentalReturnService.paging(pageable);
        model.addAttribute("rentalReturnPage", rentalReturnPage);
    	
        //List<RentalReturnDTO> rentalReturnDTOList = rentalReturnService.findAll();
        //model.addAttribute("rentalList", rentalReturnDTOList);
        //model.addAttribute("rentalCount", rentalReturnService.count(memberId));
        
        model.addAttribute("able", rentalReturnService.rentalAble());
        
        List<MemberDTO> memberDTOList = memberService.findAll();
        model.addAttribute("memberList", memberDTOList);
        if(principal == null){
        	return "rental/list";
        }else{
            MemberDTO memberDTO = memberService.findByMid(principal);
            model.addAttribute("member", memberDTO);
            return "rental/list";
        }
    }

    //도서대출
    @PostMapping("/rental")
    public @ResponseBody RentalReturnDTO rental(@RequestBody RentalReturnDTO rentalReturnDTO, @AuthenticationPrincipal SecurityUser user){
        System.out.println(rentalReturnDTO);
        rentalReturnDTO.setMember(Member.builder().memberId(user.getMember().getMemberId()).build());
        rentalReturnDTO.setReturnDate(null);
        rentalReturnService.save(rentalReturnDTO);

        return rentalReturnDTO;
    }

    //도서 반납
    @PutMapping("/return")
    public @ResponseBody RentalReturnDTO bookReturn(@RequestBody RentalReturnDTO rentalReturnDTO){
        RentalReturnDTO findRentalId = rentalReturnService.findByRentalId(rentalReturnDTO.getRentalId());
        findRentalId.setReturnDate(rentalReturnDTO.getReturnDate());
        rentalReturnService.update(findRentalId);
        return findRentalId;
    }
}
