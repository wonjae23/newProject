package com.won.project.domain;

import java.sql.Date;

public class MemberVO {
	
	private String userId;
	private String userPw;
	private String userName;
	private Date userRegdate;
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserPw() {
		return userPw;
	}
	public void setUserPw(String userPw) {
		this.userPw = userPw;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public Date getUserRegdate() {
		return userRegdate;
	}
	public void setUserRegdate(Date userRegdate) {
		this.userRegdate = userRegdate;
	}
	@Override
	public String toString() {
		return "MemberVO [userId=" + userId + ", userPw=" + userPw + ", userName=" + userName + ", userRegdate="
				+ userRegdate + "]";
	}
	
	
	
}
