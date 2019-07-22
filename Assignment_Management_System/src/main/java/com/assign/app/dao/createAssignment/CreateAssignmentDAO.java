package com.assign.app.dao.createAssignment;

import com.assign.app.dto.createAssignment.CreateAssignmentDTO;
import com.assign.app.exception.DAOException;

public interface CreateAssignmentDAO {

	public Integer createAssignmentDAO(CreateAssignmentDTO assignmentDTO) throws DAOException;
}
