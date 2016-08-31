package com.niit.shoppingcart;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.niit.Yourcart.Dao.CategoryDao;
import com.niit.Yourcart.model.Category;

@Controller
public class HomeController {

	@Autowired
	CategoryDao categoryDao;
	@RequestMapping("/")
	@Autowired
	public ModelAndView home()
	{
		ModelAndView mv=new ModelAndView("home");
		mv.addObject("message","thank you for visiting");
		List<Category> categoryList = categoryDao.list();
		mv.addObject("categoryList",categoryList);
		System.out.println("size:"+categoryList.size());
		return mv;
	}
	@RequestMapping("/register")
	public ModelAndView register()
	{

		ModelAndView mv=new ModelAndView("register");
		mv.addObject("user clicked register here","true");
		return mv;
	}
	@RequestMapping("/login")
	public ModelAndView login()
	{

		ModelAndView mv=new ModelAndView("login");
		mv.addObject("user clicked register here","true");
		return mv;
	}
	
	

}
