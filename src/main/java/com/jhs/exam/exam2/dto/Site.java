package com.jhs.exam.exam2.dto;

public class Site {

	public String getRegDate() {
		return regDate;
	}
	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}
	public String getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(String updateDate) {
		this.updateDate = updateDate;
	}
	public int getMemberId() {
		return memberId;
	}
	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}
	public String getShortCode() {
		return shortCode;
	}
	public void setShortCode(String shortCode) {
		this.shortCode = shortCode;
	}
	public String getOriginUri() {
		return originUri;
	}
	public void setOriginUri(String originUri) {
		this.originUri = originUri;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getBlanklessText() {
		return blanklessText;
	}
	public void setBlanklessText(String blanklessText) {
		this.blanklessText = blanklessText;
	}
	public int getAccessCount() {
		return accessCount;
	}
	public void setAccessCount(int accessCount) {
		this.accessCount = accessCount;
	}
	private int id;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	private String regDate;
	private String updateDate;
	private int memberId;
	private String shortCode;
	private String originUri;
	private String text;
	private String blanklessText;
	private int accessCount;
	
}
