package com.khit.library.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.khit.library.config.SecurityUser;
import com.khit.library.entity.HopeReply;
import com.khit.library.service.HopeReplyService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class HopeRelpyController {
	private final HopeReplyService hopeReplyService;

	@PostMapping("/hopeReply/{hopeBoardHbid}")
	@ResponseBody
	public String insertReply(@PathVariable Long hopeBoardHbid,
							  @RequestBody HopeReply hopeReply,
							  @AuthenticationPrincipal SecurityUser principal
							  ) {
		hopeReply.setMember(principal.getMember());
	}



}