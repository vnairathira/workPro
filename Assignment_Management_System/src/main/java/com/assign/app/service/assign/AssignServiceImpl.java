package com.assign.app.service.assign;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

import com.assign.app.dao.assign.AssignDAO;
import com.assign.app.dto.createAssignment.CreateAssignmentDTO;
import com.assign.app.dto.signup.AdminDTO;
import com.assign.app.exception.DAOException;
import com.assign.app.exception.ServiceException;
@Service
public class AssignServiceImpl implements AssignService{
	private static final Logger log=LoggerFactory.getLogger(AssignServiceImpl.class);
	@Autowired
	AssignDAO assignDAO;
	
	@Autowired
	private MailSender sender;
	
	public CreateAssignmentDTO getAssignmentByPinService(Integer pin) throws ServiceException {
		CreateAssignmentDTO createAssignmentDTO	=null;
		try {
			createAssignmentDTO	=assignDAO.getAssignmentByPinDao(pin);
		} catch (DAOException e) {
			throw new ServiceException(e.getMessage());
		}catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
		return createAssignmentDTO;
	}
	
	public void assignService(String emails,CreateAssignmentDTO assignmentDTO,AdminDTO adminDTO) {
		String[] to=emails.split(",");
		String content="Assignment details is mentioned below..";
		String assignedBy=adminDTO.getfName()+" "+adminDTO.getlName();
		String text=content+"\npin is\t:"+assignmentDTO.getGeneratedPin()+"Assigned by\t:"+assignedBy
		+"\nCourse name\t:"+assignmentDTO.getCourse()+"\nTopic name\t:"+assignmentDTO.getTopic()
		+"\nDescription\t:"+assignmentDTO.getDescription()+"\nDeadline\t:"+assignmentDTO.getDeadLine()
		+"\nupload type\t:"+assignmentDTO.getUploadType();
		String subject="Assignment description";
		sendEmail(to, subject, text);
		
	}
	
	public String sendEmail(String[] to, String subject, String text) {
		for(String emailList:to) {
		SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
		simpleMailMessage.setTo(emailList);
		simpleMailMessage.setSubject(subject);
		simpleMailMessage.setText(text);
		sender.send(simpleMailMessage);}

		return "mail send to" + to;		
	}
		
}
