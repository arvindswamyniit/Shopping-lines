package com.niit.shoppingcart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.niit.Yourcart.Dao.SupplierDao;
import com.niit.Yourcart.model.Supplier;

public class SupplierController {
	
	@Autowired(required=true)
	@Qualifier(value="supplierDao")
	private SupplierDao supplierDao;
	@Autowired(required=true)
	private Supplier supplier;
	
	public void setSupplierDao(SupplierDao ps){
		this.supplierDao=ps;
	}
@RequestMapping(value="/suppliers",method=RequestMethod.GET)
public String listSuppliers(Model model){
		model.addAttribute("supplier", new Supplier());
		model.addAttribute("supplierList", this.supplierDao.list());
			return "supplier";
}
@RequestMapping(value="/supplier/add",method=RequestMethod.POST)
public String addSupplier(@ModelAttribute("supplier")Supplier supplier){
	supplierDao.save(supplier);
	return "redirect:/suppliers";
}
@RequestMapping("supplier/remove/{id}")
public String removeSupplier(@PathVariable("id")String id,ModelMap model) throws Exception{
	
	try{
		supplierDao.delete(supplier);
		model.addAttribute("message", "successful");	
	}
	catch(Exception e){
		model.addAttribute("message", e.getMessage());
	}
	
	
	return "supplier";
	
}
}
