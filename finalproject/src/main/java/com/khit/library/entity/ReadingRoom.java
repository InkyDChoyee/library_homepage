package com.khit.library.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.khit.library.dto.ReadingRoomDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Data
@Table(name= "readingroom")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class ReadingRoom {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long readingId;

    @Column
    private Timestamp enter; //입실

    @Column
    private Timestamp checkOut; //퇴실

    @Column(nullable = false)
    private int seat; //좌석

    @Column
    @Builder.Default
    private boolean seatAble = true; //좌석유무

    public static ReadingRoom toSaveEntity(ReadingRoomDTO readingRoomDTO){
        ReadingRoom readingRoom = ReadingRoom.builder()
                .enter(readingRoomDTO.getEnter())
                .checkOut(readingRoomDTO.getCheckOut())
                .seat(readingRoomDTO.getSeat())
                .seatAble(readingRoomDTO.isSeatAble())
                .build();
        return readingRoom;
    }

    public static ReadingRoom toUpdateEntity(ReadingRoomDTO readingRoomDTO){
        ReadingRoom readingRoom = ReadingRoom.builder()
                .readingId(readingRoomDTO.getReadingId())
                .enter(readingRoomDTO.getEnter())
                .checkOut(readingRoomDTO.getCheckOut())
                .seat(readingRoomDTO.getSeat())
                .seatAble(readingRoomDTO.isSeatAble())
                .build();
        return readingRoom;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JsonIgnore
    @JoinColumn
    private Member member;
}
