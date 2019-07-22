package com.assign.app.dto.createAssignment;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Entity
@Table(name="createAssignment")
public class CreateAssignmentDTO implements Serializable{
	private final static Logger log = LoggerFactory.getLogger(CreateAssignmentDTO.class);
	
	public CreateAssignmentDTO() {
	log.info("created\t"+this.getClass().getSimpleName());
	}

	/*
	 * @Id 
	 * @GenericGenerator(name="auto",strategy="increment")
	 * @GeneratedValue(generator="auto")
	 */
	//private int id;
	private String course;
	private String topic;
	private String description;
	private String deadLine;
	private String uploadType;
	@Id
	private Integer generatedPin;

	public String getCourse() {
		return course;
	}
	public void setCourse(String course) {
		this.course = course;
	}
	public String getTopic() {
		return topic;
	}
	public void setTopic(String topic) {
		this.topic = topic;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getDeadLine() {
		return deadLine;
	}
	public void setDeadLine(String deadLine) {
		this.deadLine = deadLine;
	}
	public String getUploadType() {
		return uploadType;
	}
	public void setUploadType(String uploadType) {
		this.uploadType = uploadType;
	}
	public Integer getGeneratedPin() {
		return generatedPin;
	}
	public void setGeneratedPin(Integer generatedPin2) {
		this.generatedPin = generatedPin2;
	}
	@Override
	public String toString() {
		return "CreateAssignmentDTO [course=" + course + ", topic=" + topic + ", description=" + description
				+ ", deadLine=" + deadLine + ", uploadType=" + uploadType + ", generatedPin=" + generatedPin + "]";
	}
	
}
