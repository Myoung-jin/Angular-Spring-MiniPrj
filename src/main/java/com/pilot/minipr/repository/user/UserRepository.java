package com.pilot.minipr.repository.user;

import java.util.List;
import java.util.Optional;

import com.pilot.minipr.model.users.Users;

public interface UserRepository{
	// 사용자 리스트
	List<Users> userList();
	
	// 사용자 추가
	// 비밀번호 : password(비밀번호 단방향 암호 > BCryptPasswordEncoder(bcrypt 해시알고리즘)를 사용)
	//         , 이름, 주소, 전화번호, email 을 계정정보로 가짐
	Users save(Users user);
	
	// 사용자 수정
	Users update(Users user);
	
	// 사용자 검색 EMAIL
	Optional<Users> findByEmail(String email, String userId);

	// 사용자 검색 ID
	Optional<Users> findById(String userId);
}
