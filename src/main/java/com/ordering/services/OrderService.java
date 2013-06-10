package com.ordering.services;

import java.util.List;

import com.ordering.exceptions.InsuffiecientStockException;
import com.ordering.models.Cart;
import com.ordering.models.Customer;

public interface OrderService {

	public void addToCart(Cart cart)throws InsuffiecientStockException;
	public void removeToCart(long id);
	public List<Cart> getCartItems(Customer customer);
	public void checkOut();
}
