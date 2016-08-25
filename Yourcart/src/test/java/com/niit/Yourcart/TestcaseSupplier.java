package com.niit.Yourcart;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.Yourcart.Dao.SupplierDao;
import com.niit.Yourcart.model.Supplier;

public class TestcaseSupplier {


@Autowired
SupplierDao supplierDao;
	@Autowired
	Supplier supplier;
	AnnotationConfigApplicationContext context;
	@Before
	public void init(){
		context=new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
	supplierDao=(SupplierDao) context.getBean("supplierDao");
	supplier= (Supplier) context.getBean("supplier");
	}
@Test
public void deleteSupplierTest(){
	supplier.setId("SUP_001");
	boolean flag =supplierDao.delete(supplier);
	assertEquals("deleteSupplierTest",flag,true);
	
}
@Test
public void addSupplierTest()

{
	supplier.setId("SUP_004");
	supplier.setName("clothes");
	supplier.setDescription("about clothes");
	
	assertEquals("addSupplierTest",supplierDao.save(supplier),true);
	
}
@Test
public void listSupplierTest(){
	assertEquals("listSupplierTest",supplierDao.list().size(),4);
}
@Test
public void updateSupplierTestCase(){
	supplier.setId("SUP_002");
	supplier.setName("GAD");
	supplier.setDescription("this is new iphone");
	assertEquals("updateSupplierTestCase",supplierDao.update(supplier),true);
	
}
@Test
public void getSupplierTestCase(){

supplier=supplierDao.get("SUP_002");
assertEquals("updateSupplierTestCase",supplier.getId(),"SUP_002");
}
}
