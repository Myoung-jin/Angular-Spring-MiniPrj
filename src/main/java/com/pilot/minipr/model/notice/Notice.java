package com.pilot.minipr.model.notice;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@Table(name="notice")
//@NoArgsConstructor(access = AccessLevel.PROTECTED) // 파라미터가 없는 생성자 생성.
public class Notice {
	@Id
	@Column(name="seq")
	private String seq;
	@Column
	private String title;
	@Column
	private String contents;
	@Column
	private String regUser;
	@Column
	private LocalDateTime regDate;
	@Column
	private LocalDateTime modDate;
	@Builder 
	public Notice(String title, String contents, String regUser
			, LocalDateTime regDate, LocalDateTime modDate) {
		this.title = title;
		this.contents = contents;
		this.regUser = regUser;
		this.regDate = regDate;
		this.modDate = modDate;
	}
	@Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE)
                .append("title", title)
                .append("contents", contents)
                .append("regUser", regUser)
                .append("regDate", regDate)
                .append("modDate", modDate)
                .toString();
    }
}
