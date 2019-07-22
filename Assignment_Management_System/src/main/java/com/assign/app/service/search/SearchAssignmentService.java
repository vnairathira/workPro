package com.assign.app.service.search;

import java.util.List;

import com.assign.app.dto.createAssignment.CreateAssignmentDTO;
import com.assign.app.exception.ServiceException;

public interface SearchAssignmentService {

	public List<CreateAssignmentDTO> searchAssignmentServiceByPin(String course,String topic) throws ServiceException ;
}
