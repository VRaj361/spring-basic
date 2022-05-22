package com.bean;


public class UserBean {
	private int userId;
	@javax.validation.constraints.NotBlank(message = "Please enter firstname")
	private String firstname;
	@javax.validation.constraints.NotBlank(message = "Please enter email")
	private String email;
	@javax.validation.constraints.NotBlank(message = "Please enter password")
	private String password;
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
