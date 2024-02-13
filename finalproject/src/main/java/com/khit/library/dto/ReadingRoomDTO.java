package com.khit.library.dto;

import com.khit.library.entity.ReadingRoom;
import jakarta.persistence.Column;
import lombok.Builder;
import lombok.Data;

import java.sql.Timestamp;

@Data
@Builder
public class ReadingRoomDTO {
    private Long readingId;
    private Timestamp enter; //입실
    private Timestamp checkOut; //퇴실
    private int seat; //좌석
    private boolean seatAble; //좌석유무

    public static ReadingRoomDTO toSaveDTO(ReadingRoom readingRoom){
        ReadingRoomDTO readingRoomDTO = ReadingRoomDTO.builder()
                .readingId(readingRoom.getReadingId())
                .enter(readingRoom.getEnter())
                .checkOut(readingRoom.getCheckOut())
                .seat(readingRoom.getSeat())
                .seatAble(readingRoom.isSeatAble())
                .build();
        return readingRoomDTO;
    }
}
