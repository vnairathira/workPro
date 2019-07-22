package com.assign.app.dto.settings;


import org.slf4j.*;


public class EditAdminProfileDTO {
	
	private static final Logger log=LoggerFactory.getLogger(EditAdminProfileDTO.class);
	
	private String fName;
	private String lName;
	private String email;
	private String phone;
	
	public EditAdminProfileDTO() {
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

	public void setLName(String lName) {
		this.lName = lName;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "EditAdminProfileDTO [fName=" + fName + ", LName=" + lName + ", email=" + email + ", phone=" + phone
				+ "]";
	}

}
