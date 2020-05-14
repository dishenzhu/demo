package com.fdm.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class FormUser {

	@NotBlank(message = "username cannot be left empty")
	@Size(min = 8, max = 14)
	private String username;
	@NotBlank(message = "password cannot be left empty")
	private String password;

	public FormUser() {
		super();
	}

	public FormUser(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
