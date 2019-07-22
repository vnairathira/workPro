package com.assign.app.dto.signin;

import java.io.Serializable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ChangePwdDTO implements Serializable{

	private final static Logger log=LoggerFactory.getLogger(ChangePwdDTO.class);
	private String email;
	private String oldPwd;
	private String newPwd;
	private String cnfrmPwd;
	
	public ChangePwdDTO() {
		
		log.info("created"+this.getClass().getSimpleName());
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getOldPwd() {
		return oldPwd;
	}
	public void setOldPwd(String oldPwd) {
		this.oldPwd = oldPwd;
	}
	public String getNewPwd() {
		return newPwd;
	}
	public void setNewPwd(String newPwd) {
		this.newPwd = newPwd;
	}
	public String getCnfrmPwd() {
		return cnfrmPwd;
	}
	public void setCnfrmPwd(String cnfrmPwd) {
		this.cnfrmPwd = cnfrmPwd;
	}

	@Override
	public String toString() {
		return "ChangePwdDTO [email=" + email + ", oldPwd=" + oldPwd + ", newPwd=" + newPwd + ", cnfrmPwd=" + cnfrmPwd
				+ "]";
	}
	
	
	
}
