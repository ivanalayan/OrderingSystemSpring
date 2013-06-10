package com.ordering.services.impl;

import java.util.List;

import com.ordering.dao.ProductDAO;
import com.ordering.dao.impl.ProductDAOImpl;
import com.ordering.models.Product;
import com.ordering.services.ProductService;

public class ProductServiceImpl implements ProductService{

	@Override
	public List<Product> getAllProduct() {
		ProductDAO productDAO = new ProductDAOImpl();
		return productDAO.getAllProducts();
	}

	@Override
	public Product getProductById(long id) {
		ProductDAO productDAO = new ProductDAOImpl();
	
		return productDAO.getProductById(id);
	}

}
