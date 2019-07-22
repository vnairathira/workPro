package com.assign.app.dto.signup;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
@Entity
@Table(name="Admin")
public class AdminDTO implements Serializable {
	private final static Logger log=LoggerFactory.getLogger(AdminDTO.class);
	private String fName;
	private String lName;
	@Id
	private String email;
	private String country;
	private String code;
	private String phone;
	private boolean newUser;
	private String password;
	private Date lastLogin;
	private int failCount;
	
	public AdminDTO() {
		log.info("created\t"+this.getClass().getSimpleName());
	}

	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	public String getlName() {
		return lName;
	}

	public void setlName(String lName) {
		this.lName = lName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public boolean isNewUser() {
		return newUser;
	}

	public void setNewUser(boolean newUser) {
		this.newUser = newUser;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getLastLogin() {
		return lastLogin;
	}

	public void setLastLogin(Date lastLogin) {
		this.lastLogin = lastLogin;
	}

	public int getFailCount() {
		return failCount;
	}

	public void setFailCount(int failCount) {
		this.failCount = failCount;
	}

	@Override
	public String toString() {
		return "AdminDTO [fName=" + fName + ", lName=" + lName + ", email=" + email + ", country=" + country + ", code="
				+ code + ", phone=" + phone + ", newUser=" + newUser + ", password=" + password + ", lastLogin="
				+ lastLogin + ", failCount=" + failCount + "]";
	}

	
	

}
