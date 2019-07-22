package com.assign.app.service.settings;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assign.app.dao.getAdmiDTOByEmail.GetAdminDTOByEmail;
import com.assign.app.dao.getAdmiDTOByEmail.GetAdminDTOByEmailImpl;
import com.assign.app.dao.settings.EditAdminProfileDAO;
import com.assign.app.dao.signin.AdminSignInDAO;
import com.assign.app.dto.settings.AuditTableDTO;
import com.assign.app.dto.settings.EditAdminProfileDTO;
import com.assign.app.dto.signup.AdminDTO;
import com.assign.app.exception.DAOException;
import com.assign.app.exception.ServiceException;

@Service
public class EditAdminProfileServiceImpl implements EditAdminProfileService{
	private static final Logger log=LoggerFactory.getLogger(EditAdminProfileServiceImpl.class);
	@Autowired
	EditAdminProfileDAO adminProfileDAO;

	public Boolean  editAdminProfileServicebyEmail(EditAdminProfileDTO editDTO,String ipAddress,AdminDTO adminDTO) throws ServiceException {
	//	AdminDTO data=GetAdminDTOByEmailImpl.getAdminDTOByEmail(editDTO.getEmail());
		boolean update =false;
		try {
		String fName=editDTO.getfName();
		String lName=editDTO.getlName();
		String phone=editDTO.getPhone();
	//AdminDTO adminDTO=	getAdminDTOByEmail.getAdminDTOByEmail(editDTO.getEmail());
	System.err.println("this is from service using session adminDTO"+adminDTO.toString());
		
	if(fName!=null && fName!="" && !fName.equalsIgnoreCase(adminDTO.getfName())) {
		log.info("inside fName");
		AuditTableDTO auditTableDTO=new AuditTableDTO();
		auditTableDTO.setEntityId(adminDTO.getEmail());
		auditTableDTO.setEntity(adminDTO.getClass().getSimpleName());
		auditTableDTO.setProperty("First Name");
		auditTableDTO.setOldvalue(adminDTO.getfName());
		auditTableDTO.setNewValue(editDTO.getfName());
		auditTableDTO.setDate(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date())+"");
		auditTableDTO.setSystemIp(ipAddress);
		adminProfileDAO.updateAuditTable(auditTableDTO);
		log.info(auditTableDTO.toString());
		adminDTO.setfName(fName);
		update=true;
	}
	
	if(lName!=null && lName!="" && !lName.equalsIgnoreCase(adminDTO.getlName())) {
		System.err.println("inside lName");
		AuditTableDTO auditTableDTO=new AuditTableDTO();
		auditTableDTO.setEntityId(adminDTO.getEmail());
		auditTableDTO.setEntity(adminDTO.getClass().getSimpleName());
		auditTableDTO.setProperty("Last Name");
		auditTableDTO.setOldvalue(adminDTO.getlName());
		auditTableDTO.setNewValue(editDTO.getlName());
		auditTableDTO.setDate(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date())+"");
		auditTableDTO.setSystemIp(ipAddress);
		adminProfileDAO.updateAuditTable(auditTableDTO);
		log.info(auditTableDTO.toString());
		adminDTO.setlName(lName);
		update=true;		
	}
	if(phone!=null  && !phone.equals(adminDTO.getPhone())) {
		System.err.println("inside phone");
		AuditTableDTO auditTableDTO=new AuditTableDTO();
		auditTableDTO.setEntityId(adminDTO.getEmail());
		auditTableDTO.setEntity(adminDTO.getClass().getSimpleName());
		auditTableDTO.setProperty("Phone Number");
		auditTableDTO.setOldvalue(adminDTO.getPhone());
		auditTableDTO.setNewValue(editDTO.getPhone());
		auditTableDTO.setDate(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date())+"");
		auditTableDTO.setSystemIp(ipAddress);
		adminProfileDAO.updateAuditTable(auditTableDTO);
		log.info(auditTableDTO.toString());
		adminDTO.setPhone(phone);
		update=true;		
	}	
		  if(update) {	  
		  adminProfileDAO.updateAdmin(adminDTO); }
		}catch (DAOException e) {
			log.error(e.getMessage());
			throw new ServiceException(e.getMessage());
		} catch (Exception e) {
			log.error(e.getMessage());
			throw new ServiceException(e.getMessage());
		}
	return update;
	}	
}
