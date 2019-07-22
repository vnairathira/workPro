package com.assign.app.dao.upload;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.assign.app.dto.upload.UploadDTO;
import com.assign.app.exception.DAOException;

@Repository
public class UploadDAOImpl implements UploadDAO{
	@Autowired
	SessionFactory sessionFactory;
	public void uploadDAO(UploadDTO uploadDTO) throws DAOException {
		Session session=null;
		Transaction transaction =null;
		try {
		session=sessionFactory.openSession();
		transaction =session.beginTransaction();
		session.save(uploadDTO);
		transaction.commit();
		}catch (HibernateException e) {
			transaction.rollback();
			throw new DAOException(e.getMessage());

		} catch (Exception e) {
			transaction.rollback();
			throw new DAOException(e.getMessage());

		} finally {
			session.close();
		}		
		
	}
}
