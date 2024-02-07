package com.khit.library.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.khit.library.dto.HopeBoardDTO;
import com.khit.library.dto.NoticeBoardDTO;
import com.khit.library.entity.HopeBoard;
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

	public void deleteById(Long nbid) {
		noticeBoardRepository.deleteById(nbid);
		
	}
	
//	public List<NoticeBoardDTO> findAll(Pageable pageable) {
//	    Page<NoticeBoard> page = noticeBoardRepository.findAll(pageable);
//	    List<NoticeBoardDTO> noticeBoardDTOList = new ArrayList<>();
//	    for (NoticeBoard noticeBoard : page.getContent()) {
//	        NoticeBoardDTO noticeBoardDTO = NoticeBoardDTO.toSaveDTO(noticeBoard);
//	        noticeBoardDTOList.add(noticeBoardDTO);
//	    }
//	    return noticeBoardDTOList;
//	}
	
	public Page<NoticeBoardDTO> findAll(Pageable pageable) {
	    Page<NoticeBoard> noticeBoards = noticeBoardRepository.findAll(pageable);
	    return noticeBoards.map(noticeBoard -> NoticeBoardDTO.toSaveDTO(noticeBoard));
	}
}
