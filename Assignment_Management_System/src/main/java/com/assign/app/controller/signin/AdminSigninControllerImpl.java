package com.assign.app.controller.signin;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.assign.app.constants.Constants;
import com.assign.app.constants.EnumPage;
import com.assign.app.dto.signin.ChangePwdDTO;
import com.assign.app.dto.signin.SignInDTO;
import com.assign.app.dto.signup.AdminDTO;
import com.assign.app.exception.ControllerException;
import com.assign.app.exception.ServiceException;
import com.assign.app.service.signin.AdminSignInService;
import com.assign.app.util.AES;
@Controller
@RequestMapping("/")
public class AdminSigninControllerImpl {
	@Autowired
	AdminSignInService adminSignInService;
	private final static Logger log=LoggerFactory.getLogger(AdminSigninControllerImpl.class);
	public AdminSigninControllerImpl() {
		log.info(Constants.CREATED+this.getClass().getSimpleName());
	}
	@RequestMapping(value="/adminSignIn",method=RequestMethod.POST)
	public ModelAndView adminSigninControllerImpl(SignInDTO signInDTO,HttpServletRequest request) throws ControllerException {
		
		log.info(signInDTO.toString());
		AdminDTO dtoFrmDB=null;
		try {
		dtoFrmDB=adminSignInService.adminSignInServiceImpl(signInDTO);
		}catch (ServiceException e) {
			log.error(e.getMessage());
			throw new ControllerException(e.getMessage());
		} catch (Exception e) {
			throw new ControllerException(e.getMessage());
		}
		if(dtoFrmDB!=null)
		{
			 final String secretKey = "ssshhhhhhhhhhh!!!!";
			 String passFrmDb=dtoFrmDB.getPassword();
			 System.out.println("pass from db\t"+passFrmDb);
			String decryptedPassword = AES.decrypt(passFrmDb, secretKey) ;
			log.info("decrypted password is:\t"+decryptedPassword);
			if(signInDTO.getPassword().equals(decryptedPassword)) {
				if(dtoFrmDB.isNewUser()) {
					return new ModelAndView(EnumPage.AdmnCPwd.toString(), "msg",decryptedPassword )
							.addObject(Constants.USER, dtoFrmDB);
					
				}else {
				log.info("login successfull");
				HttpSession session=request.getSession(true);
				session.setMaxInactiveInterval(2000);
				session.setAttribute("adminData", dtoFrmDB);
				try {
				adminSignInService.updateLastLoginAndFailCountDAO(dtoFrmDB);
				}catch (ServiceException e) {
					log.error(e.getMessage());
					throw new ControllerException(e.getMessage());
				} catch (Exception e) {
					throw new ControllerException(e.getMessage());
				}
				return new ModelAndView(EnumPage.Home.toString(),Constants.MSG,Constants.LOGIN_SUCC)
						.addObject(Constants.USER, dtoFrmDB);}
				
			}else {
				log.info("Incorrect password");
				int failCount=dtoFrmDB.getFailCount();
				dtoFrmDB.setFailCount(failCount+1);
				System.out.println("decrypted password"+this.getClass().getSimpleName()+decryptedPassword);
				try {
				adminSignInService.failedLoginService(dtoFrmDB);
				}catch (ServiceException e) {
					log.error(e.getMessage());
					throw new ControllerException(e.getMessage());
				} catch (Exception e) {
					throw new ControllerException(e.getMessage());
				}
				return new ModelAndView(EnumPage.AdminSignIn.toString(),Constants.MSG,Constants.WRONG_PASS).addObject(Constants.USER, dtoFrmDB);
			}	
		}else {
			log.info("wrong email id");
			return new ModelAndView(EnumPage.AdminSignIn.toString(),Constants.MSG,Constants.WRONG_EMAIL).addObject(Constants.USER, dtoFrmDB);
		}
		
	}
	
}
