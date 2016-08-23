package com.niit.Yourcart.Dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.niit.Yourcart.model.UserDetails;


@EnableTransactionManagement
@Repository(value="userDetailsDao")
public class UserDetailsDaoImpl implements UserDetailsDao {
		@Autowired
	private SessionFactory sessionFactory;
		
	public UserDetailsDaoImpl(SessionFactory sessionFactory){
		this.sessionFactory=sessionFactory;
		
	}
	@Transactional
	public boolean save(UserDetails userDetails){
		
		try{
			sessionFactory.getCurrentSession().save(userDetails);
			return true;
		
		} catch (Exception e) {
			e.printStackTrace();
		return false;
		
		}
		
		
		
	}
	@Transactional
	public boolean update(UserDetails userDetails){
			try {
				sessionFactory.getCurrentSession().update(userDetails);
				return true;
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return false;
	}
			
	}
	@Transactional
	public boolean delete(UserDetails userDetails){
		try {
			sessionFactory.getCurrentSession().delete(userDetails);
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
			
		}
	}
	@Transactional
	public UserDetails get(String id){
		//select*from userDetails where id=+
		
		String hql="from userDetails where id="+"'"+id+"'";
				Query query=sessionFactory.getCurrentSession().createQuery(hql);
				List<UserDetails> list = query.list();
				
				if(list == null){
					return null;
				}else{
					return list.get(0);
				}
			
				
				
	}
	@Transactional
	public List<UserDetails> list(){
		
	
		String hql="from userDetails";
		
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		return query.list();
	
	}}
	