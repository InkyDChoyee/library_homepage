package com.khit.library.controller;

import com.khit.library.config.SecurityUser;
import com.khit.library.dto.MemberDTO;
import com.khit.library.dto.ReadingRoomDTO;
import com.khit.library.entity.Member;
import com.khit.library.service.MemberService;
import com.khit.library.service.ReadingRoomService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/readingRoom")
public class ReadingRoomController {

    private final ReadingRoomService readingRoomService;
    private final MemberService memberService;

    //좌석
    @GetMapping("/room")
    public String getList(Model model, @AuthenticationPrincipal SecurityUser principal){
        List<ReadingRoomDTO> readingRoomDTOList = readingRoomService.findAll();
        model.addAttribute("seatList", readingRoomDTOList);
        if(principal == null){
            return "readingroom/room";
        }else{
            MemberDTO memberDTO = memberService.findByMid(principal);
            model.addAttribute("member", memberDTO);
            return "readingroom/room";
        }
    }

    //좌석 선택
    @PostMapping("/select")
    public ReadingRoomDTO select(@RequestParam("readingId") Long readingId, @AuthenticationPrincipal SecurityUser principal){
        ReadingRoomDTO readingRoomDTO = readingRoomService.findById(readingId);

        MemberDTO memberDTO = memberService.findByMid(principal);
        readingRoomDTO.setMember(Member.builder().memberId(memberDTO.getMemberId()).build());

        if(readingRoomDTO.getEnter() == null){
            readingRoomDTO.setEnter(new Timestamp(System.currentTimeMillis()));
        }
        readingRoomDTO.setSeatAvailable(false);
        readingRoomService.save(readingRoomDTO);

        /*readingRoomDTO.setEnter(new Timestamp(System.currentTimeMillis()));*/
        return readingRoomDTO;
    }
}
