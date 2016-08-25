package com.niit.Yourcart;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.Yourcart.Dao.UserDetailsDao;
import com.niit.Yourcart.model.UserDetails;

public class UserDetailsTest {
public static void main(String[] args) {
	@SuppressWarnings("resource")
	AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
	context.scan("com.niit");
	context.refresh();
	UserDetailsDao UserDetailsDao=(UserDetailsDao) context.getBean("userDetailsDao");
	UserDetails UserDetails=(UserDetails) context.getBean("userDetails");
	UserDetails.setId("USD002");
	UserDetails.setName("USDName002");
	UserDetails.setDescription("USD001 descri");
	if (UserDetailsDao.save(UserDetails)==true) 
	{
		System.out.println("UserDetails created successfully");
		
	} else {
		System.out.println("cannot create userDetails");

	}
}
}
