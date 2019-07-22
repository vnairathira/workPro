package com.assign.app.controller.Assign;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.assign.app.constants.Constants;
import com.assign.app.constants.EnumPage;
import com.assign.app.dto.createAssignment.CreateAssignmentDTO;
import com.assign.app.dto.signup.AdminDTO;
import com.assign.app.exception.ServiceException;
import com.assign.app.service.assign.AssignService;

@Controller
@RequestMapping("/")
public class AssignController {
	private static final Logger log = LoggerFactory.getLogger(AssignController.class);
	@Autowired
	AssignService assignService;

	public AssignController() {
		log.info(Constants.CREATED + this.getClass().getSimpleName());
	}
	@RequestMapping(value="/assign")
	public ModelAndView assignController(@RequestParam Integer pin,@RequestParam String emails,HttpServletRequest request) {
		AdminDTO adminDTO=null;
		HttpSession session=request.getSession(false);
		if(session!=null) {		
		 adminDTO=(AdminDTO)session.getAttribute("adminData");	
		}
		if(session.getAttribute("adminData")!=null) {
		try {
		CreateAssignmentDTO assignmentDTO=assignService.getAssignmentByPinService(pin);
		assignService.assignService(emails, assignmentDTO,adminDTO);
			
		} catch (ServiceException e) {
			log.error(e.getMessage());
		}catch (Exception e) {
			log.error(e.getMessage());
		}
		return new ModelAndView(EnumPage.Home.toString(),Constants.MSG,Constants.TASK_ASSIGN).addObject(Constants.USER, adminDTO);
		}else {
			return new ModelAndView(EnumPage.AdminSignIn.toString(),Constants.MSG,Constants.SESSION_TIME_OUT);
		}
	}
	
}
