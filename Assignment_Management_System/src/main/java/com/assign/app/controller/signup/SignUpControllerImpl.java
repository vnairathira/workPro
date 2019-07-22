package com.assign.app.controller.signup;

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
import com.assign.app.dto.signup.AdminDTO;
import com.assign.app.exception.ControllerException;
import com.assign.app.exception.ServiceException;
import com.assign.app.service.signup.SignUpService;
import com.assign.app.service.signup.SignUpServiceImpl;
@Controller
@RequestMapping("/")
public class SignUpControllerImpl{
	private final static Logger log=LoggerFactory.getLogger(SignUpControllerImpl.class);
	@Autowired
	private SignUpService signUpService;
	public SignUpControllerImpl() {
		log.info("created\t"+this.getClass().getSimpleName());
	}
	@RequestMapping(value="/signUp",method=RequestMethod.POST)
	public ModelAndView signUpController(AdminDTO adminDTO,HttpServletRequest request) throws ControllerException {
		
		HttpSession session=request.getSession(true);
		session.setAttribute("firstData",adminDTO);

		String result=null;
		log.info(adminDTO.toString());
		try {
		 result=signUpService.signUpService(adminDTO);
		}catch (ServiceException e) {
			log.error("ServiceException in service " + e.getMessage());
			throw new ControllerException(e.getMessage());
		}catch (Exception e) {
			log.error(" Exception in controller " + e.getMessage());
		}
		return new ModelAndView(EnumPage.Index.toString(),Constants.MSG,Constants.SIGNUP_SUCC).addObject(Constants.USER, adminDTO);
	}
	
}
