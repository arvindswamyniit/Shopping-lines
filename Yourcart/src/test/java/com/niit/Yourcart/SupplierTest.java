package com.niit.Yourcart;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.Yourcart.Dao.SupplierDao;
import com.niit.Yourcart.model.Supplier;

public class SupplierTest {
public static void main(String[] args) {
	AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
	context.scan("com.niit");
	context.refresh();
	SupplierDao SupplierDao=(SupplierDao) context.getBean("supplierDao");
	Supplier Supplier=(Supplier) context.getBean("supplier");
	Supplier.setId("CG001");
	Supplier.setName("CGName001");
	Supplier.setDescription("CG001 descri");
	if (SupplierDao.save(Supplier)==true) 
	{
		System.out.println("Supplier created successfully");
		
	} else {
		System.out.println("cannot create supplier");

	}
}
}
