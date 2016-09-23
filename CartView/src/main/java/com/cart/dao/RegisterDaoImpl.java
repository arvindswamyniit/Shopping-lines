package com.cart.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.servlet.handler.UserRoleAuthorizationInterceptor;

import com.cart.model.Register;
import com.cart.model.UserRole;
@Repository
public class RegisterDaoImpl implements RegisterDao {
	
	@Autowired
	private SessionFactory sessionFactory;
	public void registerUser(Register register){
		Session session=sessionFactory.getCurrentSession();
		Transaction tx=session.beginTransaction();
		register.setEnabled(true);
		System.out.println("chek:"+register.isEnabled());
		session.save(register);
		UserRole userrole=new UserRole();
		userrole.setUid(register.getUserId());
		userrole.setAuthority("ROLE_USER");
		session.save(userrole);
		
		tx.commit();
		System.out.println("DONE");
	}

}
