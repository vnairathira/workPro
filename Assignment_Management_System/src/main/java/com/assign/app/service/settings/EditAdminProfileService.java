package com.assign.app.service.settings;

import com.assign.app.dto.settings.EditAdminProfileDTO;
import com.assign.app.dto.signup.AdminDTO;
import com.assign.app.exception.ServiceException;

public interface EditAdminProfileService {
	public Boolean  editAdminProfileServicebyEmail(EditAdminProfileDTO editDTO,String idAddress,AdminDTO adminDTO) throws ServiceException;
	//public AdminDTO getALlDataFrmAdmin(String email);
}
