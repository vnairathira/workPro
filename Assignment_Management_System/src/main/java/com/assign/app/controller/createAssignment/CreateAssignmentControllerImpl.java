package com.assign.app.controller.createAssignment;

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
import com.assign.app.dto.createAssignment.CreateAssignmentDTO;
import com.assign.app.dto.signup.AdminDTO;
import com.assign.app.exception.ControllerException;
import com.assign.app.exception.ServiceException;
import com.assign.app.service.createAssignment.CreateAssignmentService;

@Controller
@RequestMapping("/")
public class CreateAssignmentControllerImpl {
	private final static Logger log=LoggerFactory.getLogger(CreateAssignmentControllerImpl.class);
	AdminDTO adminDTO=null;
	@Autowired
	private CreateAssignmentService createAssignmentService;
	
	@RequestMapping(value="/createAssignment",method=RequestMethod.POST)
	public ModelAndView createAssignmentService(CreateAssignmentDTO assignmentDTO,HttpServletRequest request) throws ControllerException {
		
		HttpSession session1=request.getSession(true);
		session1.setAttribute("createAssignment", assignmentDTO);
		
		HttpSession session=request.getSession(false);
		if(session!=null) {		
		 adminDTO=(AdminDTO)session.getAttribute("adminData");	
		}
		Integer result=0;
		Integer pinIS=0;
		if(session.getAttribute("adminData")!=null) {
		try { 
		 result=createAssignmentService.createAssignmentServiceImpl(assignmentDTO,adminDTO);
		  pinIS=assignmentDTO.getGeneratedPin();
		 System.err.println("pinIS\t"+pinIS);
		}catch (ServiceException e) {
			log.error(e.getMessage());
			throw new ControllerException(e.getMessage());
		} catch (Exception e) {
			throw new ControllerException(e.getMessage());
		}
		return new ModelAndView(EnumPage.Home.toString(),Constants.GENERATED_PIN,Constants.GENERATED_PIN+pinIS).addObject(Constants.USER, adminDTO);	
	}else {
		return new ModelAndView(EnumPage.AdminSignIn.toString(),Constants.MSG,Constants.SESSION_TIME_OUT);
	}
		}
}
