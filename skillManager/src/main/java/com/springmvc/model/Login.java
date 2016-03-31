package com.springmvc.model;

import org.hibernate.validator.constraints.NotEmpty;

public class Login {

	@NotEmpty(message="{login.login.notBlank}")
	private String login;
	@NotEmpty(message="{login.password.notBlank}")
	private String password;
	
	public Login() {
		login = "";
		password = "";
	}
	
	public Login(String login, String password) {
		this.login = login;
		this.password = password;
	}
	
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String toString() {
		return "["+login+"/"+password+"]";
	}
		
}
