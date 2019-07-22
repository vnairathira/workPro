package com.assign.app.service.signup;

import com.assign.app.dto.signup.AdminDTO;
import com.assign.app.exception.ServiceException;

public interface SignUpService {
	public String signUpService(AdminDTO adminDTO) throws ServiceException;
}
