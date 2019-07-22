package com.assign.app.service.signin;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assign.app.dao.signin.AdminSignInDAO;
import com.assign.app.dto.signin.ChangePwdDTO;
import com.assign.app.dto.signin.SignInDTO;
import com.assign.app.dto.signup.AdminDTO;
import com.assign.app.exception.DAOException;
import com.assign.app.exception.ServiceException;
import com.assign.app.util.AES;

@Service
public class AdminSignInServiceImpl implements AdminSignInService {
	private final static Logger log = LoggerFactory.getLogger(AdminSignInServiceImpl.class);
	@Autowired
	AdminSignInDAO adminSignInDAO;
	ChangePwdDTO changePwdDTO;

	public AdminSignInServiceImpl() {
		log.info("created\t" + this.getClass().getSimpleName());
	}

	public AdminDTO adminSignInServiceImpl(SignInDTO signInDTO) throws ServiceException {
		
		AdminDTO dtoFrmDB=null;

		 try {
			dtoFrmDB = adminSignInDAO.adminSignInDAOImpl(signInDTO);
		}catch (DAOException e) {
			log.error(e.getMessage());
			throw new ServiceException(e.getMessage());
		} catch (Exception e) {
			log.error(e.getMessage());
			throw new ServiceException(e.getMessage());
		}
		return dtoFrmDB;
	}

	public void updateLastLoginAndFailCountDAO(AdminDTO dtoFrmDb) throws ServiceException {
		String email = dtoFrmDb.getEmail();
		Date date = new Date();
		int failCount = 0;
		boolean newUser = false;
		log.info("email->" + email);
		log.info("date->" + date);
		log.info("failCount->" + failCount);
		log.info("newUser->" + newUser);

		try {
			adminSignInDAO.updateLastLoginAndFailCountDAO(email, date, failCount, newUser);
		} catch (DAOException e) {
			log.error(e.getMessage());
			throw new ServiceException(e.getMessage());
		} catch (Exception e) {
			log.error(e.getMessage());
			throw new ServiceException(e.getMessage());
		}	}

	public void updateNewUserService(AdminDTO dtoFrmDb) throws ServiceException {
		String email = dtoFrmDb.getEmail();
		boolean newUser = false;
		try {
		adminSignInDAO.updateNewUserDAO(email, newUser);
	}catch (DAOException e) {
		log.error(e.getMessage());
		throw new ServiceException(e.getMessage());
	} catch (Exception e) {
		log.error(e.getMessage());
		throw new ServiceException(e.getMessage());
	}
		}

	public AdminDTO getDataByEmail(ChangePwdDTO pwdDTO) throws ServiceException {
		AdminDTO dtoFrmDb=null;
		
		
		 try {
			dtoFrmDb = adminSignInDAO.getAdminDTOByEmail(pwdDTO);
		}catch (DAOException e) {
			log.error(e.getMessage());
			throw new ServiceException(e.getMessage());
		} catch (Exception e) {
			log.error(e.getMessage());
			throw new ServiceException(e.getMessage());
		}
			
		return dtoFrmDb;
	}

	public void failedLoginService(AdminDTO dtoFrmDb) throws ServiceException {
		try {
		adminSignInDAO.failedLoginDAO(dtoFrmDb);
		}catch (DAOException e) {
			log.error(e.getMessage());
			throw new ServiceException(e.getMessage());
		} catch (Exception e) {
			log.error(e.getMessage());
			throw new ServiceException(e.getMessage());
		}
	}

	public void changePasswordService(ChangePwdDTO dtoFrmDb) throws ServiceException {
		AdminDTO adminDTO=null;
		try {
		adminDTO = adminSignInDAO.getAdminDTOByEmail(dtoFrmDb);
		}catch (DAOException e) {
			log.error(e.getMessage());
			throw new ServiceException(e.getMessage());
		} catch (Exception e) {
			log.error(e.getMessage());
			throw new ServiceException(e.getMessage());
		}
		
		boolean valid = false;
		String email = dtoFrmDb.getEmail();
		String oldPwd = dtoFrmDb.getOldPwd();
		String newPwd = dtoFrmDb.getNewPwd();
		String cnfrmPwd = dtoFrmDb.getCnfrmPwd();

		final String secretKey = "ssshhhhhhhhhhh!!!!";
		String encryptedpassword = AES.encrypt(cnfrmPwd, secretKey);
		log.info("old password\t"+oldPwd);
		log.info("newPassword\t"+newPwd);
		log.info("cnfrm pass\t"+cnfrmPwd);
		log.info("encrypted pass\t"+encryptedpassword);
		String passFrmDb=adminDTO.getPassword();
		log.info("from database"+passFrmDb);
		String decrPassFrmDb=AES.decrypt(passFrmDb, secretKey);
		log.info("decry pass from db"+decrPassFrmDb);
		log.info("old password\t"+oldPwd);
		
		
		if (dtoFrmDb != null) {
			if (oldPwd.equals(decrPassFrmDb)) {
				log.info("old password is valid");
				if (cnfrmPwd.equals(newPwd)) {
					log.info("new pasword is valid");
					valid = true;
				}else {log.error("new password is not valid..");}
			}else {log.error("old password is wrong! check ur mail..");}
			if (valid) {
				try {
				adminSignInDAO.changePwdDAO(email, encryptedpassword);
				}catch (DAOException e) {
					log.error(e.getMessage());
					throw new ServiceException(e.getMessage());
				} catch (Exception e) {
					log.error(e.getMessage());
					throw new ServiceException(e.getMessage());
				}
			} else {
				log.error("cannot change password");
			}
		}

	}
}
