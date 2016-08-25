package com.niit.Yourcart;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.Yourcart.Dao.UserDetailsDao;
import com.niit.Yourcart.model.UserDetails;

public class TestcaseUserDetails {


@Autowired
UserDetailsDao userDetailsDao;
	@Autowired
	UserDetails userDetails;
	AnnotationConfigApplicationContext context;
	@Before
	public void init(){
		context=new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
	userDetailsDao=(UserDetailsDao) context.getBean("userDetailsDao");
	userDetails= (UserDetails) context.getBean("userDetails");
	}
@Test
public void deleteUserDetailsTest(){
	userDetails.setId("USD_001");
	boolean flag =userDetailsDao.delete(userDetails);
	assertEquals("deleteUserDetailsTest",flag,true);
	
}
@Test
public void addUserDetailsTest()

{
	userDetails.setId("USD_003");
	userDetails.setName("ELECTRONIC");
	userDetails.setDescription("this is new iphone");
	
	assertEquals("addUserDetailsTest",userDetailsDao.save(userDetails),true);
	
}
@Test
public void listUserDetailsTest(){
	assertEquals("listUserDetailsTest",userDetailsDao.list().size(),2);
}
@Test
public void updateUserDetailsTestCase(){
	userDetails.setId("USD_003");
	userDetails.setName("GAD");
	userDetails.setDescription("this is new iphone");
	assertEquals("updateUserDetailsTestCase",userDetailsDao.update(userDetails),true);
	
}
@Test
public void getUserDetailsTestCase(){

userDetails=userDetailsDao.get("USD_003");
assertEquals("updateUserDetailsTestCase",userDetails.getName(),"GAD");
}
}
