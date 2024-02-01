package com.khit.library.dto;

import java.sql.Timestamp;

import com.khit.library.entity.FreeBoard;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class FreeBoardDTO {
	private Long id;  //자유게시판 번호
	private String title;  //자유게시판 제목
	private String content; //자유게시판 내용
	private Integer hit;  //조회수
	
	private Timestamp createdDate;
	private Timestamp updatedDate;
	
	public static FreeBoardDTO toSaveDTO(FreeBoard fboard) {
		FreeBoardDTO fbDTO = FreeBoardDTO.builder()
				.id(fboard.getId())
				.title(fboard.getTitle())
				.content(fboard.getContent())
				.hit(fboard.getHit())
				.createdDate(fboard.getCreatedDate())
				.updatedDate(fboard.getUpdatedDate())
				.build();
		
		return fbDTO;
	}
	
}
