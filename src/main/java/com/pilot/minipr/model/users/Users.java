package com.pilot.minipr.model.users;

import static com.google.common.base.Preconditions.checkNotNull;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.hibernate.annotations.CreationTimestamp;

import static java.time.LocalDateTime.now;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import static org.apache.commons.lang3.ObjectUtils.defaultIfNull;
@Getter
@Setter
@Entity
@Table(name = "users")
public class Users {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String userId;
	@NotEmpty @Column(length=50, nullable=false)
	private String userNm;
	
	@Column(length=50, nullable=false)
	@NotEmpty @JsonIgnore 
	private String passwd;
	@NotEmpty @Column(length=50, nullable=false)
	private String email;
	@NotEmpty @Column(length=50)
	private String address;
	@NotEmpty @Column(length=50)
	private String tel;
	@Column
	private Long seq;
	@CreationTimestamp
	@Column(name="regDate", nullable=false, updatable = false)
	private LocalDateTime regDate;
	
	@Column(name="modDate", nullable=false)
	private LocalDateTime modDate;
	
	// 필수 인자 생성자
	public Users(String userId, String userNm, String passwd) {
		this(userId,userNm, passwd,null,null,null, null,null);
	}
	// 모든 변수를 받는 생성자
	public Users(String userId, String userNm
			  , String passwd, String email, String address
			  , String tel, LocalDateTime regDate, LocalDateTime modDate) {
		checkNotNull(userId, "User ID must be provided.");
		checkNotNull(userNm, "User Namm must be provided.");
		checkNotNull(email, "Email must be provided.");
		this.userId = userId;
		this.userNm = userNm;
		this.passwd = passwd;
		this.email = email;
		this.address = address;
		this.tel = tel;
		this.regDate = (LocalDateTime) defaultIfNull(regDate, now());;
		this.modDate = (LocalDateTime) defaultIfNull(modDate, now());;
	}

	@Override
	public String toString() {
		  return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE)
				  	.append("userId",userId)
				  	.append("userNm",userNm)
				  	.append("email",email)
				  	.append("address",address)
				  	.append("tel",tel)
				  	.append("regDate",regDate)
				  	.append("modDate",modDate)
				  	.toString();
				  	
	}
	
	
	static public class Builder {
		private String userId;
		private String userNm;
		private String passwd;
		private String email;
		private String address;
		private String tel;
		private Long seq;
		private LocalDateTime regDate;
		private LocalDateTime modDate;
	        
	    public Builder() {}
	    public Builder(Users user) {
	    	this.userId = user.userId;
	    	this.userNm =user.userNm;
	    	this.passwd = user.passwd;
	    	this.email = user.email;
	    	this.address = user.address;
	    	this.tel = user.tel;
	    	this.regDate = user.regDate;
	    	this.seq = user.seq;
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
	    public Builder seq(long seq) {
	        this.seq = seq;
	        return this;
	    }
	    public Builder modDate(LocalDateTime modDate) {
	        this.modDate = modDate;
	        return this;
	    }
	    public Builder regDate(LocalDateTime regDate) {
	        this.regDate = regDate;
	        return this;
	    }
	    public Users build() {
	        return new Users(userId, userNm, passwd, email, address, tel, regDate, modDate);
	    }

	
	}
}
