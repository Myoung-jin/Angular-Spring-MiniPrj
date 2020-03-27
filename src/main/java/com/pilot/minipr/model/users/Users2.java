package com.pilot.minipr.model.users;

import static com.google.common.base.Preconditions.checkNotNull;

import java.time.LocalDateTime;
import static java.time.LocalDateTime.now;
import com.fasterxml.jackson.annotation.JsonIgnore;
import static org.apache.commons.lang3.ObjectUtils.defaultIfNull;
public class Users2 {
	private String userId;
	private String userNm;
	@JsonIgnore
	private String passwd;
	private String email;
	private String address;
	private String tel;
	private String regDate;
	private String modDate;
	
	public Users2() {}
	
	// 필수 인자 생성자
	public Users2(String userId, String userNm, String passwd) {
		this(userId,userNm, passwd,null,null,null, null,null);
	}
	// 모든 변수를 받는 생성자
	public Users2(String userId, String userNm
			  , String passwd, String email, String address
			  , String tel, String regDate, String modDate) {
		checkNotNull(userId, "User ID must be provided.");
		checkNotNull(userNm, "User Namm must be provided.");
		checkNotNull(email, "Email must be provided.");
		this.userId = userId;
		this.userNm = userNm;
		this.passwd = passwd;
		this.email = email;
		this.address = address;
		this.tel = tel;
		this.regDate = (String) defaultIfNull(regDate, now());;
		this.modDate = (String) defaultIfNull(modDate, now());;
		
	}
	
	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserNm() {
		return userNm;
	}

	public void setUserNm(String userNm) {
		this.userNm = userNm;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getRegDate() {
		return regDate;
	}

	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}

	public String getModDate() {
		return modDate;
	}

	public void setModDate(String modDate) {
		this.modDate = modDate;
	}

	static public class Builder {
		private String userId;
		private String userNm;
		private String passwd;
		private String email;
		private String address;
		private String tel;
		private String regDate;
		private String modDate;
	        
	    public Builder() {}
	    public Builder(Users2 user) {
	    	this.userId = user.userId;
	    	this.userNm =user.userNm;
	    	this.passwd = user.passwd;
	    	this.email = user.email;
	    	this.address = user.address;
	    	this.tel = user.tel;
	    	this.regDate = user.regDate;
	    	this.modDate = user.modDate;
	    }
	    public Builder userId(String userId) {
	        this.userId = userId;
	        return this;
	    }
	    public Builder userNm(String userNm) {
	        this.userNm = userNm;
	        return this;
	    }
	    public Builder passwd(String passwd) {
	        this.passwd = passwd;
	        return this;
	    }
	    public Builder email(String email) {
	        this.email = email;
	        return this;
	    }
	    public Builder address(String address) {
	        this.address = address;
	        return this;
	    }
	    public Builder tel(String tel) {
	        this.tel = tel;
	        return this;
	    }
	    public Builder modDate(String modDate) {
	        this.modDate = modDate;
	        return this;
	    }
	    public Builder regDate(String regDate) {
	        this.regDate = regDate;
	        return this;
	    }
	    public Users2 build() {
	        return new Users2(userId, userNm, passwd, email, address, tel, regDate, modDate);
	    }

	
	}
	
}
