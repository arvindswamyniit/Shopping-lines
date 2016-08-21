package com.niit.Yourcart;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.Yourcart.Dao.ProductDao;
import com.niit.Yourcart.model.Product;

public class TestCaseProduct {
	@Autowired
	ProductDao productDao;
	@Autowired
	Product product;
	AnnotationConfigApplicationContext context;
	@Before
	public void init(){
		context=new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
	productDao=(ProductDao) context.getBean("productDao");
	product= (Product) context.getBean("product");
	}
	@Test
	public void deleteProductTestCase(){
		product.setId("MOB_001");
		boolean flag =productDao.delete(product);
		assertEquals("deleteProductTestCase",flag,true);
		
	}
	@Test
	public void addProductTestCase()
	
	{
		product.setId("MOB_002");
		product.setName("i-phone6");
		product.setDescription("this is new iphone");
		
		assertEquals("addProductTestCase",productDao.save(product),true);
		
	}
	@Test
	public void listProductTestCase(){
		assertEquals("listProductTestCase",productDao.list().size(),1);
		
	}
	@Test
	public void updateProductTestCase(){
		product.setId("MOB_002");
		product.setName("i-phone6+");
		product.setDescription("this new iphone");
		assertEquals("updateProductTestCase",productDao.update(product),true);
		
	}
	@Test
	public void getProductTestCase()
	
	{
		product=productDao.get("MOB_002");
		assertEquals("getProductTestCase",product.getId(),"MOB_002");
}}


