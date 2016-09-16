package com.cart.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.cart.dao.ProductDao;
import com.cart.model.Product;

@Controller
public class AdminController {
	@Autowired
	ProductDao productDao;
	@RequestMapping("/admin") 
	public ModelAndView admin()
	{
		System.out.println("In admin()");
		return new ModelAndView("admin");
	}
	@RequestMapping("/addProduct") 
	public ModelAndView addProduct()
	{
		Product product=new Product();
		System.out.println("In addProduct()");
		return new ModelAndView("addProduct","pro",product);
	}
	@RequestMapping("/addTheProduct") 
	public ModelAndView addTheProduct(@ModelAttribute("pro") Product product)
	{
		productDao.addProduct(product);
		return new ModelAndView("viewProducts");
	}
}
