package com.assign.app.dto.signin;

import java.io.Serializable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SignInDTO implements Serializable{
	private final static Logger log=LoggerFactory.getLogger(SignInDTO.class);
	private String email;
	private String password;
	public SignInDTO() {
		log.info("created\t"+this.getClass().getSimpleName());
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
	@Override
	public String toString() {
		return "SignInDTO [email=" + email + ", password=" + password + "]";
	}
	
	
}
