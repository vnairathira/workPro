package com.assign.app.service.createAssignment;

import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

import com.assign.app.dao.createAssignment.CreateAssignmentDAO;
import com.assign.app.dto.createAssignment.CreateAssignmentDTO;
import com.assign.app.dto.signup.AdminDTO;
import com.assign.app.exception.DAOException;
import com.assign.app.exception.ServiceException;

@Service
public class CreateAssignmentServiceImpl implements CreateAssignmentService{
	
	private final static Logger log=LoggerFactory.getLogger(CreateAssignmentServiceImpl.class);
	
	@Autowired
	private CreateAssignmentDAO createAssignmentDAO;
	
	@Autowired
	private MailSender sender;
	
	public CreateAssignmentServiceImpl() {
		log.info("created\t"+this.getClass().getSimpleName());
	}

	public Integer createAssignmentServiceImpl(CreateAssignmentDTO assignmentDTO,AdminDTO adminDTO ) throws ServiceException {
		
		Integer generatedPin=generateRandomPin();
		log.info("generated pin is:\t"+generatedPin);
		assignmentDTO.setGeneratedPin(generatedPin);
		Integer result=0;
		try {
		 result=createAssignmentDAO.createAssignmentDAO(assignmentDTO);
		}catch (DAOException e) {
			log.error(e.getMessage());
			throw new ServiceException(e.getMessage());
		} catch (Exception e) {
			log.error(e.getMessage());
			throw new ServiceException(e.getMessage());
		}
		//email sending logic
		String to=adminDTO.getEmail();
		String subject="Auto genereated pin";
		String text="pin is generated\n"+"to assign assignment use this pin:\t"+generatedPin;
		String emailResult=sendEmail(to, subject, text, generatedPin);
		log.info(emailResult);
		return result;
	}
	public  Integer generateRandomPin() {
		
		Random random =new Random();
		Integer randomNum=random.nextInt(900000+100000);
		return randomNum;
						
	}
	
	public String sendEmail(String to, String subject, String text, Integer generatedPin) {
		SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
		simpleMailMessage.setTo(to);
		simpleMailMessage.setSubject(subject);
		simpleMailMessage.setText(text);
		sender.send(simpleMailMessage);

		return "mail send to" + to;
		
	}
}
