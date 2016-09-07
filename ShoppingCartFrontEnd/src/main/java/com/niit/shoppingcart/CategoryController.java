package com.niit.shoppingcart;

import org.hibernate.annotations.common.util.impl.LoggerFactory;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.niit.Yourcart.Dao.CategoryDao;
import com.niit.Yourcart.model.Category;

@Controller
public class CategoryController {
	
		private static Logger Log = LoggerFactory.getLogger(CategoryController);
		
		
		@Autowired
		private CategoryDao categoryDao;
		
		@Autowired
		private Category category;
		
		@RequestMapping(value = "/categories", method = RequestMethod.GET)
		public String listCategories(Model model) {
			Log.debug("Starting of the method listCategories");
			model.addAttribute("category", category);
			model.addAttribute("categoryList",this.categoryDao.list());;
			Log.debug("End of the method listCategories");
			return "category";
		}
		
		@RequestMapping(value = "/category/add", method = RequestMethod.'POST')
		public String addCategory(@ModelAttribute("category") Category <category>
			Log.debug("Starting of the method addCategory");
			
			categoryDao.saveOrUpdate(category);
			Log.debug("Ending of the method addCategory");
			return "category";
}

		@RequestMapping("category/eemove/{id}")
		public ModelAndView deleteCategory(@PathVariable("id")String id) throws Exception {
		
			
			boolean flag= categoryDao.delete(id);
			ModelAndView mv = new ModelAndView ("category");
			String msg = "Successfully done the operation";
			if(flag!=true)
		{
				msg= "The operation could not success";
		}
			mv.addobject("msg",msg);
			
			return mv;
}
