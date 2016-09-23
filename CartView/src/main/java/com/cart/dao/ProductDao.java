package com.cart.dao;

import java.util.List;

import com.cart.model.Product;

public interface ProductDao {
	void addProduct(Product product);
	List<Product> viewProducts();
	void deleteProductById(int id);
	
}
