package com.khit.library.service;

import org.springframework.stereotype.Service;

import com.khit.library.entity.FreeBoard;
import com.khit.library.entity.FreeReply;
import com.khit.library.repository.FreeBoardRepository;
import com.khit.library.repository.FreeReplyRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class FreeReplyService {
	private final FreeBoardRepository freeBoardRepository;
	private final FreeReplyRepository freeReplyRepository;
	
	public void insertReply(Long freeBoardHbid, FreeReply freeReply) {
		FreeBoard freeBoard = freeBoardRepository.findById(freeBoardHbid).get();
		freeReply.setFreeboard(freeBoard);
		freeReplyRepository.save(freeReply);
	}

	public void deleteById(Long freeReplyHrid) {
		freeReplyRepository.deleteById(freeReplyHrid);
	}

	public FreeReply findById(Long freeReplyHrid) {
		return freeReplyRepository.findById(freeReplyHrid).orElse(null);
	}

	public void save(FreeReply updatefreeReply) {
		freeReplyRepository.save(updatefreeReply);
	}
	
}
