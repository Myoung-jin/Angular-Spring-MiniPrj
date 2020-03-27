package com.pilot.minipr.repository.notice;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;

import com.pilot.minipr.model.notice.Notice;
//@Repository
public class JdbcNoticeRepository implements NoticeRepository {

	@Override
	public List<Notice> noticeList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(com.pilot.minipr.model.notice.Notice notice) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Notice save(Notice notice) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
