package com.assign.app.dao.createAssignment;



import java.io.Serializable;

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
public class CreateAssignmentDAOImpl implements CreateAssignmentDAO{

	private final static Logger log=LoggerFactory.getLogger(CreateAssignmentDAOImpl.class);
	@Autowired
	private SessionFactory sessionFactory;
	
	public CreateAssignmentDAOImpl() {
		log.info("created\t"+this.getClass().getSimpleName());
	}

	public Integer createAssignmentDAO(CreateAssignmentDTO assignmentDTO) throws DAOException {
				 Session session=null;
				 Transaction transaction=null;
		try {
	 session=sessionFactory.openSession();
		 transaction=session.beginTransaction();
		Serializable id=(Integer)session.save(assignmentDTO);
		transaction.commit();
		return (Integer)id;
		} catch (HibernateException e) {
			throw new DAOException(e.getMessage());

		} catch (Exception e) {
			throw new DAOException(e.getMessage());

		} finally {
			session.close();
		}
	}
	
	
}
