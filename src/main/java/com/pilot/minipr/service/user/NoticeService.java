package com.pilot.minipr.service.user;

import org.springframework.transaction.annotation.Transactional;

import com.pilot.minipr.model.notice.Notice;
import com.pilot.minipr.repository.notice.NoticeRepository;
import com.pilot.minipr.repository.user.UserRepository;

public class NoticeService {
	private final NoticeRepository noticeRepository;
	
	private final UserRepository userRepository;
	
	public NoticeService(UserRepository userRepository,NoticeRepository noticeRepository) {
		this.userRepository = userRepository;
		this.noticeRepository = noticeRepository;
	}	
	
	//게시판 등록
	//   - textchange(MIT license) 모듈(js)을 사용하여 사용자의 입력에 이벤트를 걸어 글자수를 제한
	//   - 게시글 제한수 (1000자) 댓글 제한 (140자)
	 @Transactional
	 public Notice write(Notice notice) {
		return noticeRepository.save(notice);
	 }
	 
	 //게시판 수정 : 내가 쓴 글에 대해서만 수정
	 @Transactional
	 public Notice modify(Notice notice) {
		 noticeRepository.update(notice);
		 return notice;
	 }
	 
	 //게시판 삭제
}
