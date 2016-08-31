package com.niit.shoppingcart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {

	
	@Autowired
	userDetailsDao userDetailsDao;
	
	
	
	@RequestMapping("/login")
	public ModelAndView login(@RequestParam(value="id") String id,
				@RequestParam(value="password") String password)
	{
		
		ModelAndView mv = new ModelAndView("home");
		
		if(userDetailsDao)
			
			return mv;
	}
	
	
	
}
