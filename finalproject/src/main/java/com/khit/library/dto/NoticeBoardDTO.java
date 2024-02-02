package com.khit.library.dto;

import java.security.Timestamp;

import com.khit.library.entity.Member;
import com.khit.library.entity.NoticeBoard;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
public class NoticeBoardDTO {
	
	private Long nbid;	//공지사항 글 번호
	
	private String nbtitle; //공지사항 제목
	
	@NotBlank(message = "공지사항 내용은 비워둘 수 없습니다.")
	private String nbcontent;	//공지사항 내용
	
	private Timestamp createdDate;	//작성일
	private Timestamp updatedDate;	//수정일
	
	private Integer nbhit;	//조회수
	
	private Member member;	//작성자 - 외래

	//entity -> dto
	public static NoticeBoardDTO toSaveDTO(NoticeBoard noticeBoard) {
		NoticeBoardDTO noticeBoardDTO = NoticeBoardDTO.builder().nbid(noticeBoard.getNbid())
																.member(noticeBoard.getMember())
																.nbtitle(noticeBoard.getNbtitle())
																.nbcontent(noticeBoard.getNbcontent())
																.nbhit(noticeBoard.getNbhit())
																.build();
		return noticeBoardDTO;
	}
}
