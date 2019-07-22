package com.assign.app.service.signin;

import com.assign.app.dto.signin.ChangePwdDTO;
import com.assign.app.dto.signin.SignInDTO;
import com.assign.app.dto.signup.AdminDTO;
import com.assign.app.exception.ServiceException;

public interface AdminSignInService {
	public AdminDTO adminSignInServiceImpl(SignInDTO signInDTO) throws ServiceException ;
	public void updateLastLoginAndFailCountDAO(AdminDTO dtoFrmDb) throws ServiceException;
	public void failedLoginService(AdminDTO dtoFrmDb) throws ServiceException;
	public void changePasswordService(ChangePwdDTO dtoFrmDb) throws ServiceException;
	public void updateNewUserService(AdminDTO dtoFrmDb) throws ServiceException ;
	public AdminDTO getDataByEmail(ChangePwdDTO pwdDTO) throws ServiceException;
	
}
