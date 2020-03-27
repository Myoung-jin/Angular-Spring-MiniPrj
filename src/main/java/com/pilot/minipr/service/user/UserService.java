package com.pilot.minipr.service.user;

import static com.google.common.base.Preconditions.checkNotNull;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.pilot.minipr.model.users.Email;
import com.pilot.minipr.model.users.Users;
import com.pilot.minipr.repository.user.UserRepository;

import javassist.NotFoundException;

@Service
public class UserService {
	private final UserRepository userRepository;

	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Transactional
	public Users join(Users user) {
		return userRepository.save(user);
	}
	
	public List<Users> userList(){
		return userRepository.userList();
	}
	
	@Transactional
	public Optional<Users> findByEmail(String email, String userId) {
		Email chkEmail = new Email(email);
        checkNotNull(chkEmail, "email must be provided.");
        return userRepository.findByEmail(email,userId);
    }
	
	@Transactional
	public Optional<Users> findById(String userId) {
		  checkNotNull(userId, "userId must be provided.");
        return userRepository.findById(userId);
    }
	
	
	
	public Optional<Users> login(String userId, String passwd) throws NotFoundException {
		checkNotNull(passwd,"passwd id must be provided");
		
		// 사용자 확인
		Users user = findById(userId)
				.orElseThrow(() -> new NotFoundException(userId));
		//TODO: 암호화, 시큐맅티
		return null;
		
	}
	

}
