package com.assign.app.controller.upload;

import java.io.File;
import java.io.FileOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.assign.app.constants.Constants;
import com.assign.app.constants.EnumPage;
import com.assign.app.dto.signup.AdminDTO;
import com.assign.app.dto.upload.UploadDTO;
import com.assign.app.exception.ControllerException;
import com.assign.app.exception.ServiceException;
import com.assign.app.service.upload.UploadService;
@Controller
@RequestMapping("/")
public class UploadController {
	private static final Logger log=LoggerFactory.getLogger(UploadController.class);
	@Autowired
	private UploadService uploadService;
	
	public UploadController() {
		log.info("created\t"+this.getClass().getSimpleName());
	}
	@RequestMapping(value="/upload",method=RequestMethod.POST)
	public ModelAndView onUpload(UploadDTO uploadDTO,HttpServletRequest request) throws ControllerException {
		MultipartFile file=uploadDTO.getFile();
		AdminDTO adminDTO=null;
		HttpSession session=request.getSession(false);
		if(session!=null) {		
		 adminDTO=(AdminDTO)session.getAttribute("adminData");	
		}
		if(session.getAttribute("adminData")!=null) {
		if(!file.isEmpty()) {
				String uploadRootPath = request.getServletContext().getRealPath("upload");
			      log.info("uploadRootPath=" + uploadRootPath);
			      String filename=file.getOriginalFilename(); 
			      log.info("fileName"+filename);
			      File uploadRootDir = new File(uploadRootPath);
			      if (!uploadRootDir.exists()) {
			          uploadRootDir.mkdirs();
			      }
			      File serverFile = new File(uploadRootDir.getAbsolutePath() + File.separator + filename);
			      
			      try {
			      uploadService.uploadService(uploadDTO, serverFile);
			      }catch (ServiceException e) {
					log.error(e.getMessage());
					throw new ControllerException(e.getMessage());
				}
		}
		return new ModelAndView(EnumPage.Home.toString(),Constants.MSG,Constants.UPLOAD_SUCC).addObject(Constants.USER, adminDTO);
		}else {
			return new ModelAndView(EnumPage.AdminSignIn.toString(),Constants.MSG,Constants.SESSION_TIME_OUT);
		}
		}
}
