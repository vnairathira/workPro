package com.assign.app.service.upload;

import java.io.File;

import com.assign.app.dto.upload.UploadDTO;
import com.assign.app.exception.ServiceException;

public interface UploadService {
	public void uploadService(UploadDTO uploadDTO, File serverFile) throws ServiceException;
}
