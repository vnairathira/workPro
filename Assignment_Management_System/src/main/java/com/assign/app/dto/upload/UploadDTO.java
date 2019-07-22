package com.assign.app.dto.upload;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import org.hibernate.annotations.GenericGenerator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;
@Entity
@Table(name="fileData")
public class UploadDTO implements Serializable{
	private static final Logger log=LoggerFactory.getLogger(UploadDTO.class);
	
	@Id
	@GenericGenerator(name="auto",strategy="increment")
	@GeneratedValue(generator="auto")
	private Integer uploadId;
	private String email;
	private Integer pin;
	private String url;
	@Transient
	private MultipartFile file;
	@Column(name="filePath")
	private String filePath;
	public UploadDTO() {
		log.info("created\t"+this.getClass().getSimpleName());
	}
	public String getFilePath() {
		return filePath;
	}
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	public Integer getUploadId() {
		return uploadId;
	}
	public void setUploadId(Integer uploadId) {
		this.uploadId = uploadId;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Integer getPin() {
		return pin;
	}
	public void setPin(Integer pin) {
		this.pin = pin;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public MultipartFile getFile() {
		return file;
	}
	public void setFile(MultipartFile file) {
		this.file = file;
	}
	@Override
	public String toString() {
		return "UploadDTO [uploadId=" + uploadId + ", email=" + email + ", pin=" + pin + ", url=" + url + ", filePath="
				+ filePath + "]";
	}
		
}
