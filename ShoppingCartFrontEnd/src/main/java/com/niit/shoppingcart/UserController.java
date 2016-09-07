package com.niit.shoppingcart;

import javax.servlet.http.HttpSession;

import org.h2.engine.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.niit.Yourcart.Dao.UserDetailsDao;
import com.niit.Yourcart.model.UserDetails;

@Controller
public class UserController {
	
	
	@Autowired
	UserDetailsDao userDetailsDao;
	
	@Autowired
	UserDetails userDetails;
	
	
	
	@RequestMapping("/login")
	public ModelAndView login(@RequestParam(value="id")String id,@RequestParam(value = "password") String password, HttpSession session)
	{
		
		ModelAndView mv = new ModelAndView("home");
		String msg;
		userDetails = userDetailsDao.isValiduser(id, password);
		if (userDetails == null)
		{
			msg="Invalid User...please try again";
		
		} 
		else {
		
				if (userDetails.getRole().equals("ROLE_ADMIN"){
					mv = new ModelAndView("adminHome");
			}
		else{
			 Session.setAttribute("welcomeMsg", userDetails.getName());
			 Session.setAttribute("userID",userDetails.getId())	;
			 
		}
			
		}
	
		 
	}
		return mv;
		}
		
	
	
	




	
	
	

