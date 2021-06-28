package com.jhs.exam.exam2.dto;

import lombok.Data;

@Data
public class Member {
	private int id;
	private String regDate;
	private String updateDate;
	private String loginId;
	private String loginPw;
	private String nickname;
	private String email;

}
	