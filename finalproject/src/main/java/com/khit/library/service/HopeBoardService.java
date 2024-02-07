package com.khit.library.service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.khit.library.dto.HopeBoardDTO;
import com.khit.library.entity.HopeBoard;
import com.khit.library.repository.HopeBoardRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class HopeBoardService {
	private final HopeBoardRepository hopeBoardRepository;

	public void save(HopeBoard hopeBoard, MultipartFile hopeBoardFile) throws Exception, IOException {

		if(!hopeBoardFile.isEmpty()) { 
		//String hopeFilepath = "C:\\Final_project\\final-project\\finalproject\\src\\main\\resources\\static\\upload\\";
		//String hopeFilepath = "C:\\final-project\\finalproject\\src\\main\\resources\\static\\upload";
			UUID uuid = UUID.randomUUID();
			String hopeFilename = uuid + "_" + hopeBoardFile.getOriginalFilename();
			String hopeFilepath = "C:/springfiles/" + hopeFilename;
			
			File savedHopeFile = new File(hopeFilepath);  // 실제 저장되는 파일
			hopeBoardFile.transferTo(savedHopeFile);
			
			hopeBoard.setHopeFilename(hopeFilename);
			hopeBoard.setHopeFilepath(hopeFilepath);
		}
		hopeBoardRepository.save(hopeBoard);
	}

	public List<HopeBoardDTO> findAll() {
		List<HopeBoard> hopeBoardList = hopeBoardRepository.findAll(Sort.by(Sort.Direction.DESC, "hbid"));
		List<HopeBoardDTO> hopeBoardDTOList = new ArrayList<>();
		
		for(HopeBoard hopeBoard : hopeBoardList) {
			HopeBoardDTO hopeBoardDTO = HopeBoardDTO.toSaveDTO(hopeBoard);
			hopeBoardDTOList.add(hopeBoardDTO);
		}
		
		return hopeBoardDTOList;
	}

	public HopeBoardDTO findById(Long hbid) {
		Optional<HopeBoard> findHopeBoard = hopeBoardRepository.findById(hbid);
		HopeBoardDTO hopeBoardDTO = HopeBoardDTO.toSaveDTO(findHopeBoard.get());
		return hopeBoardDTO;
	}

	public void deleteById(Long hbid) {
		hopeBoardRepository.deleteById(hbid);
	}

	public HopeBoardDTO update(HopeBoardDTO hopeBoardDTO, MultipartFile hopeBoardFile) throws Exception, IOException {
		if(!hopeBoardFile.isEmpty()) {
			UUID uuid = UUID.randomUUID();
			String hopeFilename = uuid + "_" + hopeBoardFile.getOriginalFilename();
			String hopeFilepath = "C:/springfiles/" + hopeFilename;
			
			File savedHopeFile = new File(hopeFilepath);
			hopeBoardFile.transferTo(savedHopeFile);
			
			hopeBoardDTO.setHopeFilename(hopeFilename);
			hopeBoardDTO.setHopeFilepath(hopeFilepath);
		}else {
			hopeBoardDTO.setHopeFilename(findById(hopeBoardDTO.getHbid()).getHopeFilename());
			hopeBoardDTO.setHopeFilepath(findById(hopeBoardDTO.getHbid()).getHopeFilepath());
		}
		HopeBoard hopeBoard = HopeBoard.toUpdateEntity(hopeBoardDTO);
		hopeBoardRepository.save(hopeBoard);
		return findById(hopeBoardDTO.getHbid());
	}
	
	@Transactional
	public void updateHits(Long hbid) {
		hopeBoardRepository.updateHits(hbid);
	}
}
