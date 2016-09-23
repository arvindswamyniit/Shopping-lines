package com.cart.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
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
	public ModelAndView addTheProduct(@RequestParam("file") MultipartFile file,@ModelAttribute("pro") Product product) throws IllegalStateException, IOException
	{
		System.out.println("in addTheproduct");
		productDao.addProduct(product);
		MultipartFile f= file;
		System.out.println("file:"+f);
		Path path=Paths.get("C://Users//admin//workspace//CartView//src//main//webapp//resources//images//"+product.getProductId()+".jpg");
		if(f !=null)
		{
			f.transferTo(new File(path.toString()));
			System.out.println("Image stored");
		}
		return new ModelAndView("viewProducts");
	}
	@RequestMapping("/viewproduct")
	public ModelAndView viewproduct() throws JsonGenerationException, JsonMappingException, IOException
	 
	{
			List<Product> list=productDao.viewProducts();
		ObjectMapper objectMapper=new ObjectMapper();
		String jsondata=objectMapper.writeValueAsString(list);
		System.out.println("list of products are:"+jsondata);
			return new ModelAndView("viewproduct","json",jsondata);
	}
	@RequestMapping("/deleteProduct")
	public String deleteProduct(@RequestParam("id") int id)
	{
		System.out.println("id:"+id);
		productDao.deleteProductById(id);
		return "redirect:/viewproduct";
	}
}
