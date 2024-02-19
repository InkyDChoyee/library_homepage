package com.khit.library.repository;

import com.khit.library.entity.ReadingRoom;

import jakarta.transaction.Transactional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.sql.Timestamp;

public interface ReadingRoomRepository extends JpaRepository<ReadingRoom, Long> {

    @Transactional
    @Modifying
    @Query("update ReadingRoom set member.memberId = :memberId, enter = now(), checkOut = :checkOut, seatAvailable = false where seat = :seat")
    public void select(Long memberId, Timestamp checkOut, Integer seat);

    @Transactional
    @Modifying
    @Query("update ReadingRoom set member.memberId = null , enter = null , checkOut = null, seatAvailable = true where seat = :seat")
    public void checkout(Integer seat);
    
	//페이징 처리를 위한 메서드
//	Page<ReadingRoom> findAll(Pageable pageable);
}
