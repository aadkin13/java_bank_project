package com.app.model;

public class Users {
	
	private int userId;
	private String username;
	private String password;
	private String phoneNumber;
	private String email;
	
	public Users() {
		
	}
	
	public Users(String username, String password, String phoneNumber, String email) {
		super(); 
		this.username = username;
		this.password = password;
		this.phoneNumber = phoneNumber;
		this.email = email;
	}
	
	//Setters
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void setUserPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	//Getters
	public int getUserId() {
		return userId;
	}
	public String getUsername() {
		return username;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public String getEmail() {
		return email;
	}
	
	public String getPassword() {
		return password;
	}
	
	public StringBuilder getHiddenPassword() {
		StringBuilder hiddenPassword = new StringBuilder();
		for(int i = 0; i < password.length(); i++) {
			hiddenPassword.append("*");
		}
		return hiddenPassword;
	}
	
	@Override
	public String toString() {
		return "User: [username: " + username + " password: " + getHiddenPassword() + " phone: " + phoneNumber + " email: " + email + "]";
	}

}
