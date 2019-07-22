package com.assign.app.dao.assign;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.assign.app.dto.createAssignment.CreateAssignmentDTO;
import com.assign.app.exception.DAOException;
@Repository
public class AssignDAOImpl implements AssignDAO{
	@Autowired
	private SessionFactory sessionFactory;

	private static final Logger log = LoggerFactory.getLogger(AssignDAOImpl.class);   
	
	public AssignDAOImpl() {
		log.info("created\t"+this.getClass().getSimpleName());
	}
	public CreateAssignmentDTO getAssignmentByPinDao(Integer pin) throws DAOException {
		Session session=null;
		try {
		session=sessionFactory.openSession();
		CreateAssignmentDTO createAssignmentDTO=session.get(CreateAssignmentDTO.class, pin);
		return createAssignmentDTO;
		
		}catch (HibernateException e) {
			throw new DAOException(e.getMessage());
		}catch(Exception e) {
			throw new DAOException(e.getMessage());
		}
	}
}
