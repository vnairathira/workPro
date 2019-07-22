package com.assign.app.dao.settings;

import com.assign.app.dto.settings.AuditTableDTO;
import com.assign.app.dto.signup.AdminDTO;
import com.assign.app.exception.DAOException;

public interface EditAdminProfileDAO {
	public void updateAuditTable(AuditTableDTO auditTableDTO) throws DAOException;
	public void updateAdmin(AdminDTO adminDTO) throws DAOException;
}
