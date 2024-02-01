package com.khit.library.service;

import org.springframework.stereotype.Service;

import com.khit.library.dto.FreeBoardDTO;
import com.khit.library.entity.FreeBoard;
import com.khit.library.repository.FreeBoardRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class FreeBoardService {
	private final FreeBoardRepository fboardRepository;

	public void insert(FreeBoard fboard) {
		fboardRepository.save(fboard);
	}
}
