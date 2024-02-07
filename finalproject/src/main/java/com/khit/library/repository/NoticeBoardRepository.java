package com.khit.library.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.khit.library.entity.NoticeBoard;

public interface NoticeBoardRepository extends JpaRepository<NoticeBoard, Long>{

	Page<NoticeBoard> findAll(Pageable pageable); // 페이징 처리를 위한 메서드
}