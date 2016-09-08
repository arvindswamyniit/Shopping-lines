package com.niit.shoppingcart;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.niit.Yourcart.Dao.CategoryDao;
import com.niit.Yourcart.model.Category;

public class CategoryController {

	private static Logger log=LoggerFactory.getLogger(CategoryController.class);
	
	@Autowired
	private CategoryDao categoryDao;
	@Autowired
	private Category category;
	
	@RequestMapping(value="/categories", method=RequestMethod.GET)
	public String listCategories(Model model)
	{
		log.debug("starting of method listCategories");
		model.addAttribute("category", category);
		model.addAttribute("categoryList", this.categoryDao.list());
		log.debug("ending of method listCategories");
		return "category";
	}
	@RequestMapping(value="/category/add",method=RequestMethod.POST)
	public String addCategory(@ModelAttribute("category") Category category)
	{
	log.debug("starting of method addcategory");
categoryDao.save(category);
log.debug("ending of method addCategory");
return "category";
}
	@RequestMapping("category/remove/{id}")
	public ModelAndView deleteCategory(@PathVariable("id") Category id) throws Exception
	{
		boolean flag = categoryDao.delete(id);
		
		ModelAndView mv=new ModelAndView("category");
		String msg= "successfully done the operation";
		if(flag!=true)
		{
     msg = " operation could not success";
		}
	mv.addObject("msg", msg);
	return mv;
	}
	@RequestMapping("category/edit/{id}")
	public String editCategory(@ModelAttribute("category") Category category)
	{
		log.debug("starting of method editcategory");
		categoryDao.save(category);
		log.debug("ending of method editcategory");
		return "category";
	}
	}
