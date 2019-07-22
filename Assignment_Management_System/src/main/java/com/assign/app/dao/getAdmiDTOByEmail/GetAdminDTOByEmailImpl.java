package com.assign.app.dao.getAdmiDTOByEmail;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.assign.app.dto.signup.AdminDTO;

@Repository
public class GetAdminDTOByEmailImpl implements GetAdminDTOByEmail{

	private final static Logger log=LoggerFactory.getLogger(GetAdminDTOByEmailImpl.class);
	@Autowired
	private SessionFactory sessionFactory;
	
	public GetAdminDTOByEmailImpl() {
		log.info("Created\t"+this.getClass().getSimpleName());
	}
	
	public AdminDTO getAdminDTOByEmail(String email) {
		String hql="from AdminDTO where email=:em";
		Session session=sessionFactory.openSession();
		Query query=session.createQuery(hql);
		query.setParameter("em",email);
		AdminDTO dtoFrmDB=(AdminDTO) query.uniqueResult();
		if(dtoFrmDB!=null) {
		return dtoFrmDB;}
		return null;
	}
}
