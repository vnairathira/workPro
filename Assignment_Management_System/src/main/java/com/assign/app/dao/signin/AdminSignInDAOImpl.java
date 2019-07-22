package com.assign.app.dao.signin;

import java.util.Date;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.assign.app.dto.signin.ChangePwdDTO;
import com.assign.app.dto.signin.SignInDTO;
import com.assign.app.dto.signup.AdminDTO;
import com.assign.app.exception.DAOException;
@Repository
public class AdminSignInDAOImpl implements AdminSignInDAO{
	private final static Logger log=LoggerFactory.getLogger(AdminSignInDAOImpl.class);
	@Autowired
	private SessionFactory sessionFactory;
	
	public AdminSignInDAOImpl() {
		log.info("Created\t"+this.getClass().getSimpleName());
	}

	public AdminDTO adminSignInDAOImpl(SignInDTO signInDTO) throws DAOException {
		AdminDTO dtoFrmDB=null;
		Session session=null;
		String hql="from AdminDTO where email=:em";
		try {
		 session=sessionFactory.openSession();
		Query query=session.createQuery(hql);
		query.setParameter("em",signInDTO.getEmail());
		 dtoFrmDB=(AdminDTO) query.uniqueResult();
		}
		catch (HibernateException e) {
			throw new DAOException(e.getMessage());

		} catch (Exception e) {
			throw new DAOException(e.getMessage());

		} finally {
			session.close();
		}
		return dtoFrmDB;
	}
		
	
	public void updateLastLoginAndFailCountDAO(String email,Date lastLogin,int failCount,boolean newUser) throws DAOException {
		String hql="update AdminDTO set lastLogin=:ll,failCount=:fc,newUser=:nu where email=:em";
		Session session=null;
		Transaction transaction=null;
		try {
		 session=sessionFactory.openSession();
		 transaction=session.beginTransaction();
		Query query=session.createQuery(hql);
		query.setParameter("ll",lastLogin);
		query.setParameter("fc",failCount);
		query.setParameter("nu",newUser);
		query.setParameter("em",email);
		query.executeUpdate();
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
	public void updateNewUserDAO(String email,boolean newUser) throws DAOException {
		Session session=null;
		Transaction transaction=null;
		String hql="update AdminDTO set newUser=:nu where email=:em";
		try {
		 session=sessionFactory.openSession();
		 transaction=session.beginTransaction();
		Query query=session.createQuery(hql);
		query.setParameter("nu",newUser);
		query.setParameter("em",email);
		query.executeUpdate();
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
	public AdminDTO getAdminDTOByEmail(ChangePwdDTO pwdDTO) throws DAOException {
		Session session=null;
		AdminDTO dtoFrmDB=null;
		String hql="from AdminDTO where email=:em";
		try {
		 session=sessionFactory.openSession();
		Query query=session.createQuery(hql);
		query.setParameter("em",pwdDTO.getEmail());
		 dtoFrmDB=(AdminDTO) query.uniqueResult();
		}catch (HibernateException e) {
			throw new DAOException(e.getMessage());

		} catch (Exception e) {
			throw new DAOException(e.getMessage());

		} finally {
			session.close();
		}
		return dtoFrmDB;

	}
	
	public void failedLoginDAO(AdminDTO dtoFrmDb) throws DAOException {
		Session session=null;
		Transaction transaction=null;
		try{
		session=sessionFactory.openSession();
		transaction=session.beginTransaction();
		session.saveOrUpdate(dtoFrmDb);
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
	
	public void changePwdDAO(String email,String password) throws DAOException {
		Session session=null;
		Transaction transaction=null;
		String hql="update AdminDTO set password=:pwd where email=:em";
		try {
		session=sessionFactory.openSession();
		transaction=session.beginTransaction();
		Query query=session.createQuery(hql);
		query.setParameter("pwd",password);
		query.setParameter("em",email);
		query.executeUpdate();
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
