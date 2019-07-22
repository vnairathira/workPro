package com.assign.app.dao.signup;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.assign.app.dto.signup.AdminDTO;
import com.assign.app.exception.DAOException;

@Repository
public class SignUpDAOImpl implements SignUpDAO{
	private final static Logger log=LoggerFactory.getLogger(SignUpDAOImpl.class);
	@Autowired
	private SessionFactory sessionFactory;

	public SignUpDAOImpl() {
		log.info("created" + this.getClass().getSimpleName());
	}

	public String signUpDAO(AdminDTO adminDTO) throws DAOException{
		Session session=null;
		Transaction transaction = null;
		log.info("SignUpDAO stared");
		String hql = "from AdminDTO where email=:em";
		try {
			 session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			Query query = session.createQuery(hql);
			query.setParameter("em", adminDTO.getEmail());
			AdminDTO dtoFromDB = (AdminDTO) query.uniqueResult();

			if (dtoFromDB != null) {
				log.info("email id is already present!");
				return "email id is already present!";
			} else {
				session.save(adminDTO);
				transaction.commit();
				return "Admin created succesfully";
			}
		} catch (HibernateException e) {
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
