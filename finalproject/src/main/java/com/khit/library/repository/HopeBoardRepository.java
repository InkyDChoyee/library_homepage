package com.khit.library.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.khit.library.entity.HopeBoard;
import com.khit.library.entity.NoticeBoard;

public interface HopeBoardRepository extends JpaRepository<HopeBoard, Long>{

	Page<HopeBoard> findAll(Pageable pageable); // 페이징 처리를 위한 메서드
}
