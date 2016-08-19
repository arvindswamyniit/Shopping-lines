package com.niit.Yourcart.Dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.niit.Yourcart.model.Category;

public class CategoryDaoImpl implements CategoryDao {
		@Autowired
	private SessionFactory sessionFactory;
		
	public CategoryDaoImpl(SessionFactory sessionFactory){
		this.sessionFactory=sessionFactory;
		
	}
	public boolean save(Category category){
		return false;
	}
	public boolean update(Category category){
		return false;
	}
	
	
	}