package com.cart.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.cart.dao.RegisterDao;
import com.cart.model.Register;

@Controller
public class CartController 
{
	@Autowired
	RegisterDao registerdao;
	
	@RequestMapping("/")
	public String index()
	{ 
		System.out.println("index called");
		return "index";
	}
	 @RequestMapping("/login")
	public String login()
	{
		 System.out.println("login called");
		 return "login";
	}
	 @RequestMapping("/register")
	public ModelAndView register()
	{
		 System.out.println("register called");
		 Register reg=new Register();
		return new ModelAndView("register","reg",reg);
	}
	 @RequestMapping("/registerUser")
		public ModelAndView registerUser(@Valid @ModelAttribute("reg")Register register,BindingResult bindingresult)
		
		{
		 
		 if(bindingresult.hasErrors())
		 {
			 System.out.println("errors there");
			 return new ModelAndView ("register()");
		 }
		 System.out.println("in registerUser()");
		 	registerdao.registerUser(register);
			return new ModelAndView("registerUser","info","successfully registered");
		}
	 

}
