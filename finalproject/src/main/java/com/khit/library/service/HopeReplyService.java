package com.khit.library.service;

import org.springframework.stereotype.Service;

import com.khit.library.repository.HopeReplyRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class HopeReplyService {
	private final HopeReplyRepository hopeReplyRepository;
}
