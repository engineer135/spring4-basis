package com.tsmi.vo.sample;

public class BoardVO {
	/* 데이터 */
	private String userId;
	private String userName;
	private String userKb1;
	private String userPw;
	
	/* 검색 */
	private String searchUserId;
	private String searchUserName;
	private String searchUserKb1;
	private String cPage;
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserKb1() {
		return userKb1;
	}
	public void setUserKb1(String userKb1) {
		this.userKb1 = userKb1;
	}
	public String getSearchUserId() {
		return searchUserId;
	}
	public void setSearchUserId(String searchUserId) {
		this.searchUserId = searchUserId;
	}
	public String getSearchUserName() {
		return searchUserName;
	}
	public void setSearchUserName(String searchUserName) {
		this.searchUserName = searchUserName;
	}
	public String getSearchUserKb1() {
		return searchUserKb1;
	}
	public void setSearchUserKb1(String searchUserKb1) {
		this.searchUserKb1 = searchUserKb1;
	}
	public String getcPage() {
		return cPage;
	}
	public void setcPage(String cPage) {
		this.cPage = cPage;
	}
	public String getUserPw() {
		return userPw;
	}
	public void setUserPw(String userPw) {
		this.userPw = userPw;
	}
	
	
}
