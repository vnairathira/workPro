package com.assign.app.dao.signin;

import java.util.Date;

import com.assign.app.dto.signin.ChangePwdDTO;
import com.assign.app.dto.signin.SignInDTO;
import com.assign.app.dto.signup.AdminDTO;
import com.assign.app.exception.DAOException;

public interface AdminSignInDAO {
	public AdminDTO adminSignInDAOImpl(SignInDTO signInDTO) throws DAOException ;
	public void updateLastLoginAndFailCountDAO(String email,Date lastLogin,int failCount,boolean newUser) throws DAOException;
	public void failedLoginDAO(AdminDTO dtoFrmDb) throws DAOException;
	public void changePwdDAO(String email,String password) throws DAOException;
	public void updateNewUserDAO(String email,boolean newUser)throws DAOException;
	public AdminDTO getAdminDTOByEmail(ChangePwdDTO pwdDTO)throws DAOException;
}
