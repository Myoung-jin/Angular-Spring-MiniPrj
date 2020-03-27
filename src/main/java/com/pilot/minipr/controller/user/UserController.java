package com.pilot.minipr.controller.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pilot.minipr.model.users.Users;
import com.pilot.minipr.model.response.ApiResult;
import com.pilot.minipr.repository.user.JdbcUserRepository;
import com.pilot.minipr.repository.user.UserRepository;
import com.pilot.minipr.service.user.UserService;

import static com.pilot.minipr.model.response.ApiResult.OK;

@RestController
@RequestMapping("api/user")
public class UserController {
	@Autowired
	private UserService userService;
	
	@GetMapping(path = "/list")
	public ApiResult<List<Users>> userList(){
		return OK(userService.userList());
	}
	
	@PostMapping(path = "/join") 
	public ApiResult<Users> join(Users user){
		return OK(userService.join(user));
	}
	
}
