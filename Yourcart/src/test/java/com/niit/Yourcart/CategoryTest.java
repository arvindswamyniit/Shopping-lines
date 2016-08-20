package com.niit.Yourcart;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.Yourcart.Dao.CategoryDao;
import com.niit.Yourcart.model.Category;

public class CategoryTest {
public static void main(String[] args) {
	AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
	context.scan("com.niit");
	context.refresh();
	CategoryDao CategoryDao=(CategoryDao) context.getBean("categoryDao");
	Category Category=(Category) context.getBean("category");
	Category.setId("CG001");
	Category.setName("CGName001");
	Category.setDescription("CG001 descri");
	if (CategoryDao.save(Category)==true) 
	{
		System.out.println("Category created successfully");
		
	} else {
		System.out.println("cannot create category");

	}
}
}
