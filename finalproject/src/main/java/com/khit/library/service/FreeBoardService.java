package com.khit.library.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.khit.library.dto.FreeBoardDTO;
import com.khit.library.dto.NoticeBoardDTO;
import com.khit.library.entity.FreeBoard;
import com.khit.library.entity.NoticeBoard;
import com.khit.library.repository.FreeBoardRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class FreeBoardService {
	private final FreeBoardRepository freeBoardRepository;

	public void save(FreeBoard freeBoard) {
		freeBoardRepository.save(freeBoard);
	}

	public List<FreeBoardDTO> findAll() {
		List<FreeBoard> freeBoardList = freeBoardRepository.findAll(Sort.by(Sort.Direction.DESC, "fbid"));
		List<FreeBoardDTO> freeBoardDTOList = new ArrayList<>();

		for (FreeBoard freeBoard : freeBoardList) {
			FreeBoardDTO freeBoardDTO = FreeBoardDTO.toSaveDTO(freeBoard);
			freeBoardDTOList.add(freeBoardDTO);
		}

		return freeBoardDTOList;
	}

	public FreeBoardDTO findById(Long fbid) {
		Optional<FreeBoard> findFreeBoard = freeBoardRepository.findById(fbid);
		FreeBoardDTO freeBoardDTO = FreeBoardDTO.toSaveDTO(findFreeBoard.get());
		return freeBoardDTO;
	}

	public void deleteById(Long fbid) {
		freeBoardRepository.deleteById(fbid);
	}

	public void update(FreeBoardDTO freeBoardDTO) {
		FreeBoard freeBoard = FreeBoard.toUpdateEntity(freeBoardDTO);
		freeBoardRepository.save(freeBoard);
	}
	
	public Page<FreeBoardDTO> searchByTitle(String keyword, Pageable pageable) {
	    return freeBoardRepository.findByFbtitleContaining(keyword, pageable)
	            .map(freeBoard -> FreeBoardDTO.toSaveDTO(freeBoard));
	}

	public Page<FreeBoardDTO> searchByContent(String keyword, Pageable pageable) {
	    return freeBoardRepository.findByFbcontentContaining(keyword, pageable)
	            .map(freeBoard -> FreeBoardDTO.toSaveDTO(freeBoard));
	}

	
	
	
	@Transactional
	public void updateHits(Long fbid) {
		freeBoardRepository.updateHits(fbid);
	}

	//페이징
	public Page<FreeBoardDTO> paging(Pageable pageable) {
        Page<FreeBoard> freeBoardPage = freeBoardRepository.findAll(pageable);
        return freeBoardPage.map(freeBoard -> FreeBoardDTO.toSaveDTO(freeBoard));
    }
}

