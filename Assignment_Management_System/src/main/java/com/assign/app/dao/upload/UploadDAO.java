package com.assign.app.dao.upload;

import com.assign.app.dto.upload.UploadDTO;
import com.assign.app.exception.DAOException;

public interface UploadDAO {
	public void uploadDAO(UploadDTO uploadDTO) throws DAOException;
}
