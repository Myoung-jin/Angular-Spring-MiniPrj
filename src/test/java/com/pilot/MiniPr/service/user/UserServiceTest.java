package com.pilot.MiniPr.service.user;

import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

import java.time.LocalDateTime;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestMethodOrder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import com.pilot.minipr.model.users.Email;
import com.pilot.minipr.model.users.Users;
import com.pilot.minipr.service.user.UserService;

@SpringBootTest
@ActiveProfiles("test")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class UserServiceTest {
	private Logger log = LoggerFactory.getLogger(getClass());

    @Autowired 
    private UserService userService;
    
    private String id;
    private String name;
    private String password;
    private Email email;
    private String address;
    private String tel;
    
    @BeforeAll
    void setUp() {
    	id = "GD_Hong";
        email = new Email("test@gmail.com");
        password = "1234";
        name = "홍길동";
        address="서울시 성북구 삼성동 삼선1가 120";
        tel="01045678941";
    }
    
// 주석 풀면 테스트 됨.
    @Test
    @Order(1)
    void 사용자를_추가한다() {
    	/*Users.builder().userId("GG")
    		 .userNm("GG")
    		 .passwd("1234")
    		 .build();*/
    	Users user_temp  = new Users(
    			id, name
    			, password, email.getAddress() , address
    			, tel, LocalDateTime.now(), null);
        Users user = userService.join(user_temp);
        assertThat(user, is(notNullValue()));
        assertThat(user.getEmail(), is(notNullValue()));
        assertThat(user.getAddress(), is(email));
        assertThat(user.getUserNm(), is(notNullValue()));
        log.trace("Inserted user: {}", user);
        System.out.printf("Inserted user: {}",user);
    }

    @Test
    @Order(2)
    void 사용자를_이메일로_조회한다() {
    	System.out.println(email.getAddress());
    	Users user = userService.findByEmail("test@dd.com",id).orElse(null);
    	assertThat(user, is(notNullValue()));
        assertThat(user.getEmail(), is(email));
        log.trace("Found by {}: {}", email, user);
        System.out.println("Found by "+email+"/"+user);
    }
    
    @Test
    @Order(3)
    void 사용자_리스트를_조회한다() {
    	List<Users> userList = userService.userList();
    	for (Users user : userList) {
    		log.trace(user.toString());
    		 System.out.println(user.toString());
		}
    }

//    @Test
//    @Order(4)
//    void 사용자가_로그인을한다() {
//    	String userId="GG";
//    	String passwd="PWD";
//    	
//    	Users user = userService.login(userId, passwd);
//    	System.out.printf("First login: {}", user);
//    }
}
