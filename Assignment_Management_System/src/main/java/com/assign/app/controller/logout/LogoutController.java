package com.assign.app.controller.logout;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.assign.app.constants.Constants;
import com.assign.app.constants.EnumPage;

@Controller
@RequestMapping("/")
public class LogoutController {
	private static final Logger log=LoggerFactory.getLogger(LogoutController.class);
	public LogoutController() {
		log.info(Constants.CREATED+this.getClass().getSimpleName());
	}

	@RequestMapping(value="/Logout",method=RequestMethod.GET)
	public ModelAndView logout(HttpServletRequest request) {
		
		HttpSession session = request.getSession(false);
		if (session != null) {
			session.invalidate();
			session = null;
			return new ModelAndView(EnumPage.AdminSignIn.toString());
		}
		return new ModelAndView(EnumPage.AdminSignIn.toString(),Constants.MSG, "logout successfull");
	}	
}
