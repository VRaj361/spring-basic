package com.bean;

import javax.validation.constraints.NotBlank;

public class RoleBean {
	int roleid;
	@NotBlank(message = "Please Provide Valid Name")
	String rolename;
	public int getRoleid() {
		return roleid;
	}
	public void setRoleid(int roleid) {
		this.roleid = roleid;
	}
	public String getRolename() {
		return rolename;
	}
	public void setRolename(String rolename) {
		this.rolename = rolename;
	}
	
	
}
