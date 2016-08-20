package com.niit.Yourcart;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.Yourcart.Dao.ProductDao;
import com.niit.Yourcart.model.Product;

public class ProductTest {
public static void main(String[] args) {
	AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
	context.scan("com.niit");
	context.refresh();
	ProductDao ProductDao=(ProductDao) context.getBean("productDao");
	Product Product=(Product) context.getBean("product");
	Product.setId("CG001");
	Product.setName("CGName001");
	Product.setDescription("CG001 descri");
	if (ProductDao.save(Product)==true) 
	{
		System.out.println("Product created successfully");
		
	} else {
		System.out.println("cannot create product");

	}
}
}