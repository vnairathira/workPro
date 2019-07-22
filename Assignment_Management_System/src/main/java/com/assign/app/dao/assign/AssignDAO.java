package com.assign.app.dao.assign;

import com.assign.app.dto.createAssignment.CreateAssignmentDTO;
import com.assign.app.exception.DAOException;

public interface AssignDAO {
	public CreateAssignmentDTO getAssignmentByPinDao(Integer pin) throws DAOException;
}
