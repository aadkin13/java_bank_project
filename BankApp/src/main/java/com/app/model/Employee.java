package com.app.model;

public class Employee {
	
	private String emplUsername;
	private String password;
	private String phoneNumber;
	private String email;
	
	public Employee() {
		
	}
	
	public Employee(String emplUsername, String password, String phoneNumber, String email) {
		super();
		this.emplUsername = emplUsername;
		this.password = password;
		this.phoneNumber = phoneNumber;
		this.email = email;
	}
	
	//Setters
	public void setEmplUsername(String emplUsername) {
		this.emplUsername = emplUsername;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void setEmplPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	//Getters
	public String getEmplUsername() {
		return emplUsername;
	}
	public String getPassword() {
		return password;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public String getEmail() {
		return email;
	}
	
	public String toString() {
		return "Employee: [employee username: " + emplUsername + " password: " + password + " phone number: " + phoneNumber + " email: " + email;
	}
}
