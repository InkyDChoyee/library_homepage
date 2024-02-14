package com.khit.library.service;

import com.khit.library.dto.ReadingRoomDTO;
import com.khit.library.entity.ReadingRoom;
import com.khit.library.repository.ReadingRoomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class ReadingRoomService {
    private final ReadingRoomRepository readingRoomRepository;

    //좌석
    public List<ReadingRoomDTO> findAll() {
        List<ReadingRoom> readingRoomList = readingRoomRepository.findAll();
        List<ReadingRoomDTO> readingRoomDTOList = new ArrayList<>();

        for(ReadingRoom readingRoom : readingRoomList){
            ReadingRoomDTO readingRoomDTO = ReadingRoomDTO.toSaveDTO(readingRoom);
            readingRoomDTOList.add(readingRoomDTO);
        }
        return readingRoomDTOList;
    }

    public void save(ReadingRoomDTO readingRoomDTO) {

    }

    public ReadingRoomDTO findById(Long readingId) {
        return null;
    }
}
