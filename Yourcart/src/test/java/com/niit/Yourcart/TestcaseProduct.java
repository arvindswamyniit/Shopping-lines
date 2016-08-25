package com.niit.Yourcart;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.Yourcart.Dao.ProductDao;
import com.niit.Yourcart.model.Product;

public class TestcaseProduct {


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
public void deleteProductTest(){
	product.setId("PRO_001");
	boolean flag =productDao.delete(product);
	assertEquals("deleteProductTest",flag,true);
	
}
@Test
public void addProductTest()

{
	product.setId("PRO_003");
	product.setName("ELECTRONIC");
	product.setDescription("this is new iphone");
	
	assertEquals("addProductTest",productDao.save(product),true);
	
}
@Test
public void listProductTest(){
	assertEquals("listProductTest",productDao.list().size(),1);
}
@Test
public void updateProductTestCase(){
	product.setId("PRO_003");
	product.setName("GAD");
	product.setDescription("this is new iphone");
	assertEquals("updateProductTestCase",productDao.update(product),true);
	
}
@Test
public void getProductTestCase(){

product=productDao.get("PRO_003");
assertEquals("getProductTestCase",product.getName(),"GAD");
}
}
