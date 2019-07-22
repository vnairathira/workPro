package com.assign.app.dao.search;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.assign.app.dto.createAssignment.CreateAssignmentDTO;
import com.assign.app.dto.signup.AdminDTO;
import com.assign.app.exception.DAOException;

@Repository
public class SearchAssignmentDAOImpl implements SearchAssignmentDAO {
	private static final Logger log = LoggerFactory.getLogger(SearchAssignmentDAOImpl.class);
	@Autowired
	SessionFactory sessionFactory;

	public SearchAssignmentDAOImpl() {
		log.info("created\t" + this.getClass().getSimpleName());
	}

	public List<CreateAssignmentDTO> searchAssignmentDAOImplByPin(String course,String topic) throws DAOException {
		String hql="from CreateAssignmentDTO where course=:co and topic=:tp";
		List<CreateAssignmentDTO> entityFrmDB=null;
		Session session=null;
		try {
		 session = sessionFactory.openSession();
		 Query query = session.createQuery(hql);
			query.setParameter("co",course);
			query.setParameter("tp",topic);
			
			entityFrmDB = query.list();
		}catch (HibernateException e) {
			throw new DAOException(e.getMessage());

		} catch (Exception e) {
			throw new DAOException(e.getMessage());

		} finally {
			session.close();
		}
		return entityFrmDB;
	}

}
