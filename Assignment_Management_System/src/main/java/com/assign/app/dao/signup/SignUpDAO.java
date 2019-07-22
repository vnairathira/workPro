package com.assign.app.dao.signup;

import com.assign.app.dto.signup.AdminDTO;
import com.assign.app.exception.DAOException;

public interface SignUpDAO {
	public String signUpDAO(AdminDTO adminDTO) throws DAOException;
}
