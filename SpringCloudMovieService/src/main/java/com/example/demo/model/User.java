package com.example.demo.model;

public class User {

	private int userId;
	private String userName;
	private String email;
	private String port;
	public User(int userId, String userName, String email,String port) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.email = email;
		this.port = port;
	}
	public int getUserId() {
		return userId;
	}
	
	public String getPort() {
		return port;
	}
	public void setPort(String port) {
		this.port = port;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", email=" + email + "]";
	}
	
}
