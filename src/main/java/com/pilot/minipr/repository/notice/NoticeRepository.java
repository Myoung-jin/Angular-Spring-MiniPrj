package com.pilot.minipr.repository.notice;

import java.util.List;

import com.pilot.minipr.model.notice.Notice;

public interface NoticeRepository{
	//게시판 리스트
	List<Notice> noticeList();

	void update(com.pilot.minipr.model.notice.Notice notice);

	Notice save(Notice notice);
	
	//게시판 등록
	//   - textchange(MIT license) 모듈(js)을 사용하여 사용자의 입력에 이벤트를 걸어 글자수를 제한
	//   - 게시글 제한수 (1000자) 댓글 제한 (140자)
	
	
	//게시판 수정 : 내가 쓴 글에 대해서만 수정, 삭제 가능
	
	//게시판 삭제
	
	
}
