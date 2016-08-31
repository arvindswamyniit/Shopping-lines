package com.niit.shoppingcart;

import javax.persistence.Access;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.niit.Yourcart.Dao.CategoryDao;
import com.niit.Yourcart.Dao.ProductDao;
import com.niit.Yourcart.Dao.SupplierDao;
import com.niit.Yourcart.model.Category;
import com.niit.Yourcart.model.Product;
import com.niit.Yourcart.model.Supplier;

@Controller
public class AdminController {
	
	@Autowired
	private Product product;
	
	@Autowired
	private Supplier supplier;
	
	@Autowired
	private Category category;
	
	@Autowired
	private SupplierDao supplierDao;
	
	@Autowired
	private CategoryDao categoryDao;
	
	@Autowired
	private ProductDao productDao;
	
	@RequestMapping("/manageCategories")
	public ModelAndView categories(){
		ModelAndView mv = new ModelAndView("/home");
		mv.addObject("category",category);
		mv.addObject("isAdminClickedCategories","true");
		mv.addObject("categoryList",categoryDao.list());
		return mv;
	}
	
	@RequestMapping("/manageProducts")
	public ModelAndView suppliers(){
		ModelAndView mv = new ModelAndView("/home");
		mv.addObject("product",product);
		mv.addObject("isAdminClickedProducts","true");
		mv.addObject("productList",productDao.list());
		return mv;
	
	}
	
	@RequestMapping("/manageSuppliers")
	public ModelAndView products() {
		ModelAndView mv = new ModelAndView("/home");
		mv.addObject("supplier",supplier);
		mv.addObject("isAdminClickedSuppliers","true");
		mv.addObject("supplierList",supplierDao.list());
		return mv;
	
	}




}
