package com.assign.app.dao.settings;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.assign.app.dto.settings.AuditTableDTO;
import com.assign.app.dto.signup.AdminDTO;
import com.assign.app.exception.DAOException;

@Repository
public class EditAdminProfileDAOImpl implements EditAdminProfileDAO {
	private static final Logger log = LoggerFactory.getLogger(EditAdminProfileDAOImpl.class);
	@Autowired
	SessionFactory sessionFactory;
	public EditAdminProfileDAOImpl() {
		log.info("created\t" + this.getClass().getSimpleName());
	}
	
	public void updateAuditTable(AuditTableDTO auditTableDTO) throws DAOException {
		System.err.println("inside updateAuditTable");
		Session session=null;
		try {
		 session=sessionFactory.openSession();
		Transaction transaction=session.beginTransaction();
		session.save(auditTableDTO);
		transaction.commit();
		}catch (HibernateException e) {
			throw new DAOException(e.getMessage());

		} catch (Exception e) {
			throw new DAOException(e.getMessage());

		} finally {
			session.close();
		}

	}
	
	public void updateAdmin(AdminDTO adminDTO) throws DAOException {
		System.err.println("inside updateAdmin");
		Session session=null;
		try {
		 session=sessionFactory.openSession();
		Transaction transaction=session.beginTransaction();
		
		session.saveOrUpdate(adminDTO);
		transaction.commit();
		}catch (HibernateException e) {
			throw new DAOException(e.getMessage());

		} catch (Exception e) {
			throw new DAOException(e.getMessage());

		} finally {
			session.close();
		}

		
	}
	
}
