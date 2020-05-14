package com.fdm.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class FormUser {

	@NotBlank(message = "username cannot be left empty")
	@Size(min = 1, max = 14)
	private String username;
	@NotBlank(message = "password cannot be left empty")
	private String password;
	@NotBlank(message = "email cannot be left empty")
	private String email;

	public FormUser() {
		super();
	}

	public FormUser(String username, String password, String email) {
		super();
		this.username = username;
		this.password = password;
		this.email = email;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
