package com.cart.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cart.model.Product;
@Repository
public class ProductDaoImpl implements ProductDao {
	@Autowired
	SessionFactory sessionFactory;

	public void addProduct(Product product) {
		Session session=sessionFactory.getCurrentSession();
		Transaction tx=session.beginTransaction();
		session.save(product);
		tx.commit();
		System.out.println("done");
		
	}
	public List<Product> viewProducts(){
		Session session=sessionFactory.getCurrentSession();
		Transaction tx=session.beginTransaction();
		List<Product> products=session.createCriteria(Product.class).list();
		tx.commit();
		return products;
	}
	public void deleteProductById(int id) {
		
		Session session=sessionFactory.getCurrentSession();
		Transaction tx=session.beginTransaction();
		Product prod=session.get(Product.class,new Integer(id));
		session.delete(prod);
		tx.commit();
		
		
	}
}
