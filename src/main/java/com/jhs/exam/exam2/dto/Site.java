package com.jhs.exam.exam2.dto;

import lombok.Data;

@Data
public class Site {
	private int id;
	private String regDate;
	private String updateDate;
	private int memberId;
	private String shortCode;
	private String originUri;
	private String text;
	private String blanklessText;
	private int accessCount;
	private int extra__cnt;
}
