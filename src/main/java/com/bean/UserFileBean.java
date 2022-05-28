package com.bean;

public class UserFileBean {
	
	private int userid;
	
	@javax.validation.constraints.NotBlank(message = "Please Enter UserName")
	private String name;
	@javax.validation.constraints.NotBlank(message = "Please Enter Email")
	private String email;
	@javax.validation.constraints.NotBlank(message = "Please Enter Password")
	private String password;

	private String profileurl;
	
	
	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public String getProfileurl() {
		return profileurl;
	}

	public void setProfileurl(String profileurl) {
		this.profileurl = profileurl;
	}
//	
}
