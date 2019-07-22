package com.assign.app.controller.settings;

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
import com.assign.app.dto.settings.EditAdminProfileDTO;
import com.assign.app.dto.signup.AdminDTO;
import com.assign.app.exception.ControllerException;
import com.assign.app.exception.ServiceException;
import com.assign.app.service.settings.EditAdminProfileService;

@Controller
@RequestMapping("/")
public class EditAdminProfileControllerImpl {

	private static final Logger log = LoggerFactory.getLogger(EditAdminProfileControllerImpl.class);
	@Autowired
	EditAdminProfileService editAdminProfileService;
	
AdminDTO adminDTO=null;
	public EditAdminProfileControllerImpl() {
		log.info(Constants.CREATED+ this.getClass().getSimpleName());
	}
	@RequestMapping(value = "/setting", method = RequestMethod.POST)
	public ModelAndView editAdminProfileControllerByEmail(EditAdminProfileDTO editDTO, HttpServletRequest request) throws ControllerException {
		
		HttpSession newSession=request.getSession(true);
		newSession.setAttribute("editAdmin", editDTO);

		HttpSession session = request.getSession(false);
		if (session != null) {
			adminDTO = (AdminDTO) session.getAttribute("adminData");
		}
		
		String ipAddress = request.getRemoteAddr();
		if(session.getAttribute("adminData")!=null) {
		try {
		editAdminProfileService.editAdminProfileServicebyEmail(editDTO,ipAddress,adminDTO);
		}catch (ServiceException e) {
			log.error(e.getMessage());
			throw new ControllerException(e.getMessage());
		} catch (Exception e) {
			throw new ControllerException(e.getMessage());
		}
		return new ModelAndView(EnumPage.Home.toString(),Constants.MSG,Constants.SETTING_SUCC).addObject("editedData", editDTO);
	}else{
		return new ModelAndView(EnumPage.AdminSignIn.toString(),Constants.MSG,Constants.SESSION_TIME_OUT);
		}
	}

}
