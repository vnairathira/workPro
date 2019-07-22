package com.assign.app.service.createAssignment;

import com.assign.app.dto.createAssignment.CreateAssignmentDTO;
import com.assign.app.dto.signup.AdminDTO;
import com.assign.app.exception.ServiceException;

public interface CreateAssignmentService {

	public Integer createAssignmentServiceImpl(CreateAssignmentDTO assignmentDTO,AdminDTO adminDTO ) throws ServiceException;
	public String sendEmail(String to, String subject, String text, Integer generatedPin);
	public  Integer generateRandomPin();
}
