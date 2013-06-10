package com.ordering.dao;

import java.util.List;

import com.ordering.models.Product;

public interface ProductDAO {

	public List<Product> getAllProducts();
	
	public Product getProductById(long productId);
	
	public void editProduct(Product product);
	
}
