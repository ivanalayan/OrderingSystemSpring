package com.ordering.dao.impl;

import java.util.List;

import org.hibernate.Session;

import com.ordering.dao.ProductDAO;
import com.ordering.models.Product;
import com.ordering.utils.HibernateUtil;

public class ProductDAOImpl implements  ProductDAO{

	@SuppressWarnings("unchecked")
	@Override
	public List<Product> getAllProducts(){
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		List<Product> products =(List<Product>) session.createCriteria(Product.class).list();
		return products;
	}

	@Override
	public Product getProductById(long productId) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		return (Product) session.get(Product.class,productId);
	}

	@Override
	public void editProduct(Product product) {
		Session session = HibernateUtil.getSessionFactory().openSession();
				session.beginTransaction();
				session.merge(product);
				session.getTransaction().commit();
	}

}
