package com.assign.app.controller.search;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.assign.app.constants.Constants;
import com.assign.app.constants.EnumPage;
import com.assign.app.dto.createAssignment.CreateAssignmentDTO;
import com.assign.app.exception.ControllerException;
import com.assign.app.exception.ServiceException;
import com.assign.app.service.search.SearchAssignmentService;

@Controller
@RequestMapping("/")

//@RestController
public class SearchAssignmentControllerImpl {
	private static final Logger log = LoggerFactory.getLogger(SearchAssignmentControllerImpl.class);

	@Autowired
	SearchAssignmentService searchAssignmentService;

	public SearchAssignmentControllerImpl() {
		log.info(Constants.CREATED + this.getClass().getSimpleName());
	}
	  @RequestMapping(value="/search",method=RequestMethod.POST) public
	  ModelAndView searchAssignmentControllerByPin(@RequestParam String course,@RequestParam String topic,HttpServletRequest request) throws ControllerException {
	  List<CreateAssignmentDTO> entityFrmDb=null;
	  HttpSession session=request.getSession(false);
	  if(session.getAttribute("adminData")!=null) {
	  try {
	  entityFrmDb=searchAssignmentService.searchAssignmentServiceByPin(course,topic);
	  }catch (ServiceException e) {
			log.error(e.getMessage());
			throw new ControllerException(e.getMessage());
		} catch (Exception e) {
			throw new ControllerException(e.getMessage());
		}
	  log.info(entityFrmDb.toString()); 
	  return new ModelAndView(EnumPage.Search.toString(),Constants.MSG,"display is working").addObject(Constants.USER, entityFrmDb); 
	  }else {
		  return new ModelAndView(EnumPage.AdminSignIn.toString(),Constants.MSG,Constants.SESSION_TIME_OUT); 
		  }
	  }
	}
