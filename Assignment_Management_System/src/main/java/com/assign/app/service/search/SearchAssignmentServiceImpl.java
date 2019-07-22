package com.assign.app.service.search;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assign.app.dao.search.SearchAssignmentDAO;
import com.assign.app.dto.createAssignment.CreateAssignmentDTO;
import com.assign.app.exception.DAOException;
import com.assign.app.exception.ServiceException;

@Service
public class SearchAssignmentServiceImpl implements SearchAssignmentService {
	private static final Logger log=LoggerFactory.getLogger(SearchAssignmentServiceImpl.class);
	@Autowired
	SearchAssignmentDAO searchAssignmentDAO;
	
	public SearchAssignmentServiceImpl() {
		log.info("created\t"+this.getClass().getSimpleName());
	}
	
	public List<CreateAssignmentDTO> searchAssignmentServiceByPin(String course,String topic) throws ServiceException {
		List<CreateAssignmentDTO> entityFrmDb=null;
		try {
		entityFrmDb=searchAssignmentDAO.searchAssignmentDAOImplByPin(course,topic);
		}catch (DAOException e) {
			log.error(e.getMessage());
			throw new ServiceException(e.getMessage());
		} catch (Exception e) {
			log.error(e.getMessage());
			throw new ServiceException(e.getMessage());
		}
		return entityFrmDb;
		
	}
}
