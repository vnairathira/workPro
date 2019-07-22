package com.assign.app.dao.search;

import java.util.List;

import com.assign.app.dto.createAssignment.CreateAssignmentDTO;
import com.assign.app.exception.DAOException;

public interface SearchAssignmentDAO {
	public List<CreateAssignmentDTO> searchAssignmentDAOImplByPin(String course,String topic) throws DAOException;
}
