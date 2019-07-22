package com.assign.app.service.assign;

import com.assign.app.dto.createAssignment.CreateAssignmentDTO;
import com.assign.app.dto.signup.AdminDTO;
import com.assign.app.exception.ServiceException;

public interface AssignService {
	public CreateAssignmentDTO getAssignmentByPinService(Integer pin) throws ServiceException;
	public void assignService(String emails,CreateAssignmentDTO assignmentDTO,AdminDTO adminDTO);
}
