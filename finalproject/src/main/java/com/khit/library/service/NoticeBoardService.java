package com.khit.library.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.khit.library.dto.NoticeBoardDTO;
import com.khit.library.entity.NoticeBoard;
import com.khit.library.repository.NoticeBoardRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class NoticeBoardService {

	private final NoticeBoardRepository noticeBoardRepository;

	public void save(NoticeBoard noticeBoard) {
		noticeBoardRepository.save(noticeBoard);
	}

	public NoticeBoardDTO findById(Long nbid) {
		Optional<NoticeBoard> findNoticeBoard = noticeBoardRepository.findById(nbid);
		NoticeBoardDTO noticeBoardDTO = NoticeBoardDTO.toSaveDTO(findNoticeBoard.get());
		return noticeBoardDTO;
	}

	public void update(NoticeBoardDTO noticeBoardDTO) {
		NoticeBoard noticeBoard = NoticeBoard.toUpdateEntity(noticeBoardDTO);
		noticeBoardRepository.save(noticeBoard);
		
	}
}
