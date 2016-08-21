package com.niit.Yourcart.Dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.niit.Yourcart.model.Product;


@EnableTransactionManagement
@Repository(value="productDao")
public class ProductDaoImpl implements ProductDao {
		@Autowired
	private SessionFactory sessionFactory;
		
	public ProductDaoImpl(SessionFactory sessionFactory){
		this.sessionFactory=sessionFactory;
		
	}
	@Transactional
	public boolean save(Product product){
		
		try{
			sessionFactory.getCurrentSession().save(product);
			return true;
		
		} catch (Exception e) {
			e.printStackTrace();
		return false;
		
		}
		
		
		
	}
	@Transactional
	public boolean update(Product product){
			try {
				sessionFactory.getCurrentSession().update(product);
				return true;
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return false;
	}
			
	}
	@Transactional
	public boolean delete(Product product){
		try {
			sessionFactory.getCurrentSession().delete(product);
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
			
		}
	}
	@Transactional
	public Product get(String id){
		//select*from product where id=+
		
		String hql="from product where id="+"'"+id+"'";
				Query query=sessionFactory.getCurrentSession().createQuery(hql);
				List<Product> list = query.list();
				
				if(list == null){
					return null;
				}else{
					return list.get(0);
				}
			
				
				
	}@Transactional
	public List<Product> list(){
		
	
		String hql="from product";
		
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		return query.list();
	
	}}
	