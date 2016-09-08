package com.niit.shoppingcart;

import javax.servlet.http.HttpServletRequest;
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
	public ModelAndView login(@RequestParam(value="name")String id,
			@RequestParam(value = "password") String password, HttpSession session)
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
			 Session.SetAttribute("welcomeMsg", userDetails.getName());
			 Session.SetAttribute("userID",userDetails.getId());
			 
			 
			 session.setAttribute("userDetails",userDetails);  //
			 
			 if(userDetails.getAdmin() == 1){
				 mv.addObject("isAdmin","true");
				 
			 }else{
				 mv.addObject("isAdmin","false");
				 cart = cartDao.get(userID);
				 mv.addObject("cart",cart);
				 //Fetch the cart list based on user ID
				 List<cart> cartlist = cartDao.list(userID);
				 mv.addObject("cartList", cartlist);
				 mv.addObject("cartSize", cartlist.size());
				 
			 }
			 
		}else{
			
			mv.addObject("invalidcredentials","true");
			mv.addObject("errorMessage","Invalid credentials");
			
		}
		log.debug("Ending of the method login");
		return mv;
			 
		}
		
		@Requestmapping("/logout")
		public ModelAndView logout(HttpServletRequest request,HttpSession session){
			ModelAndView mv = new ModelAndView("/home");
			session.invalidate();
			session = request.getSession(true);
			session.setAttribute("category",category);
			session.setAttribute("categoryList",categoryDao.list());
			
			mv.addObject("logoutMessage","You are successfully logged out");
			
		}
	
		 
	
		return mv;
		}

	
}
	
	
	




	
	
	

