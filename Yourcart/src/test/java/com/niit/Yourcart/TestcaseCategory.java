package com.niit.Yourcart;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.Yourcart.Dao.CategoryDao;
import com.niit.Yourcart.model.Category;

public class TestcaseCategory {


@Autowired
CategoryDao categoryDao;
	@Autowired
	Category category;
	AnnotationConfigApplicationContext context;
	@Before
	public void init(){
		context=new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
	categoryDao=(CategoryDao) context.getBean("categoryDao");
	category= (Category) context.getBean("category");
	}
@Test
public void deleteCategoryTest(){
	category.setId("CAT_001");
	boolean flag =categoryDao.delete(category);
	assertEquals("deleteCategoryTest",flag,true);
	
}
@Test
public void addCategoryTest()

{
	category.setId("CAT_003");
	category.setName("ELECTRONIC");
	category.setDescription("this is new iphone");
	
	assertEquals("addCategoryTest",categoryDao.save(category),true);
	
}
@Test
public void listCategoryTest(){
	assertEquals("listCategoryTest",categoryDao.list().size(),2);
}
@Test
public void updateCategoryTestCase(){
	category.setId("CAT_003");
	category.setName("GAD");
	category.setDescription("this is new iphone");
	assertEquals("updateCategoryTestCase",categoryDao.update(category),true);
	
}
@Test
public void getCategoryTestCase(){

category=categoryDao.get("CAT_003");
assertEquals("updateCategoryTestCase",category.getId(),"CAT_003");
}
}
