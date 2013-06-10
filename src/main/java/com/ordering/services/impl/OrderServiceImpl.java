package com.ordering.services.impl;

import java.util.List;

import com.ordering.dao.OrderDAO;
import com.ordering.dao.ProductDAO;
import com.ordering.dao.impl.OrderDAOImpl;
import com.ordering.dao.impl.ProductDAOImpl;
import com.ordering.exceptions.InsuffiecientStockException;
import com.ordering.models.Cart;
import com.ordering.models.Customer;
import com.ordering.models.Product;
import com.ordering.services.OrderService;

public class OrderServiceImpl implements OrderService {

	@Override
	public void addToCart(Cart cart) throws InsuffiecientStockException {

		OrderDAO orderDAO = new OrderDAOImpl();

		ProductDAO productDAO = new ProductDAOImpl();
		Product product = productDAO.getProductById(cart.getProduct().getId());
		int currentQty = product.getQty();
		int newQty = (currentQty - cart.getQty());
		if (newQty < 0)
			throw new InsuffiecientStockException("Insufiecient stock for "
					+ product + " Current stock: " + currentQty);

		product.setQty(newQty);
		productDAO.editProduct(product);
		orderDAO.addItemsToCart(cart);
	}

	@Override
	public void removeToCart(long id) {

		OrderDAO orderDAO = new OrderDAOImpl();
		ProductDAO productDAO = new ProductDAOImpl();
		Cart cart = orderDAO.getItemsByCartId(id);
		Product product = productDAO.getProductById(cart.getProduct().getId());
		int currentQty = product.getQty();
		int newQty = (currentQty + cart.getQty());
		product.setQty(newQty);
		productDAO.editProduct(product);
		orderDAO.removeItemsToCart(id);
	}

	@Override
	public void checkOut() {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Cart> getCartItems(Customer customer) {
		OrderDAO orderDAO = new OrderDAOImpl();
		return orderDAO.getCartByCustomer(customer);
	}

}
