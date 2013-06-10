package com.ordering.services;

import java.util.List;

import com.ordering.models.Product;

public interface ProductService {

	public List<Product> getAllProduct();
	public Product getProductById(long id);
}
