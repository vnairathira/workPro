package com.assign.app.dto.settings;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Entity
@Table(name="auditTable")
public class AuditTableDTO implements Serializable{
	
	private static final Logger log=LoggerFactory.getLogger(AuditTableDTO.class);
	@Id
	@GenericGenerator(name="auto",strategy="increment")
	@GeneratedValue(generator="auto")
	private int auditId;
	private String entity;
	private String entityId;
	private String property;
	private String oldvalue;
	private String newValue;
	private String date;
	private String systemIp;
	
	public AuditTableDTO() {
		System.out.println("created"+this.getClass().getSimpleName());
	}
	
	public int getAuditId() {
		return auditId;
	}
	public void setAuditId(int auditId) {
		this.auditId = auditId;
	}
	public String getEntity() {
		return entity;
	}
	public void setEntity(String entity) {
		this.entity = entity;
	}
	public String getEntityId() {
		return entityId;
	}
	public void setEntityId(String entityId) {
		this.entityId = entityId;
	}
	public String getProperty() {
		return property;
	}
	public void setProperty(String property) {
		this.property = property;
	}
	public String getOldvalue() {
		return oldvalue;
	}
	public void setOldvalue(String oldvalue) {
		this.oldvalue = oldvalue;
	}
	public String getNewValue() {
		return newValue;
	}
	public void setNewValue(String newValue) {
		this.newValue = newValue;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getSystemIp() {
		return systemIp;
	}
	public void setSystemIp(String systemIp) {
		this.systemIp = systemIp;
	}
	@Override
	public String toString() {
		return "AuditTableDTO [auditId=" + auditId + ", entity=" + entity + ", entityId=" + entityId + ", property="
				+ property + ", oldvalue=" + oldvalue + ", newValue=" + newValue + ", date=" + date + ", systemIp="
				+ systemIp + "]";
	}	
	
}
