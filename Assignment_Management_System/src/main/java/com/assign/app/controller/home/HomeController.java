package com.assign.app.controller.home;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.assign.app.constants.Constants;
import com.assign.app.constants.EnumPage;
import com.assign.app.dto.signup.AdminDTO;

@Controller
@RequestMapping("/")
public class HomeController {
	
	@RequestMapping(value="/Setting",method=RequestMethod.GET)
	public ModelAndView onSetting(HttpServletRequest request) {
		AdminDTO adminDTO=null;
		HttpSession session = request.getSession(false);
		if (session != null) {
			adminDTO = (AdminDTO) session.getAttribute("adminData");
		}
		return new ModelAndView(EnumPage.Setting.toString(), "Editedmessage", "dataUpdated").addObject(Constants.USER, adminDTO);
	}
	
}
