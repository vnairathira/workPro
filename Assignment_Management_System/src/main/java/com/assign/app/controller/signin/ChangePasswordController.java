package com.assign.app.controller.signin;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.assign.app.constants.Constants;
import com.assign.app.constants.EnumPage;
import com.assign.app.dto.signin.ChangePwdDTO;
import com.assign.app.dto.signup.AdminDTO;
import com.assign.app.exception.ControllerException;
import com.assign.app.exception.ServiceException;
import com.assign.app.service.signin.AdminSignInService;
@Controller
@RequestMapping("/")
public class ChangePasswordController {
	private static final Logger log=LoggerFactory.getLogger(ChangePasswordController.class);
	@Autowired
	AdminSignInService adminSignInService;
	
	@RequestMapping(value="/changePwd")
	public ModelAndView ChangePassword(ChangePwdDTO changePwdDTO) throws ControllerException {
		AdminDTO adminDTO=null;
		try {
		adminDTO=adminSignInService.getDataByEmail(changePwdDTO);		
		adminSignInService.changePasswordService(changePwdDTO);
		adminSignInService.updateNewUserService(adminDTO);
		}catch (ServiceException e) {
			log.error(e.getMessage());
			throw new ControllerException(e.getMessage());
		} catch (Exception e) {
			throw new ControllerException(e.getMessage());
		}
	
		
		//adminSignInService.updateLastLoginAndFailCountDAO(dtoFrmDB);
		return new ModelAndView(EnumPage.Home.toString(),Constants.MSG, "login successfull").addObject(Constants.USER, adminDTO);
	}
	
}

