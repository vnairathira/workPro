package com.assign.app.service.upload;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.assign.app.dao.upload.UploadDAO;
import com.assign.app.dto.upload.UploadDTO;
import com.assign.app.exception.DAOException;
import com.assign.app.exception.ServiceException;

@Service
public class UploadServiceImpl implements UploadService {
	private static final Logger log = LoggerFactory.getLogger(UploadServiceImpl.class);
	@Autowired
	UploadDAO uploadDAO;

	public void uploadService(UploadDTO uploadDTO, File serverFile) throws ServiceException {
		MultipartFile file = uploadDTO.getFile();
		uploadDTO.setFilePath(serverFile.toString());
		log.info(serverFile.toString());

		if (!file.isEmpty()) {
			try {
				byte[] bytes = file.getBytes();
				BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(serverFile));
				stream.write(bytes);
				uploadDAO.uploadDAO(uploadDTO);
				stream.close();
			} catch (DAOException e){
				log.error(e.getMessage());
				throw new ServiceException(e.getMessage());
			}catch (Exception e){
				log.error(e.getMessage());
				throw new ServiceException(e.getMessage());
			}
		}
	}
}
