package com.khit.library.service;

import org.springframework.stereotype.Service;

import com.khit.library.entity.HopeBoard;
import com.khit.library.repository.HopeBoardRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class HopeBoardService {
	private final HopeBoardRepository hopeBoardRepository;

	public void save(HopeBoard hopeBoard) {
		hopeBoardRepository.save(hopeBoard);
	}
	
}
