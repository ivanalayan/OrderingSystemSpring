package com.ordering.dao;

import java.util.List;

import com.ordering.models.Cart;
import com.ordering.models.Customer;

public interface OrderDAO {

	public void addItemsToCart(Cart cart);

	public List<Cart> getCartByCustomer(Customer customer);

	public void removeItemsToCart(long id);
	
	public Cart getItemsByCartId(long id);
}
