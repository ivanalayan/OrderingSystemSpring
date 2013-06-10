package com.ordering.dao;

import java.util.List;

import com.ordering.models.Customer;

public interface CustomerDAO {

	public void addCustomer(Customer customer);

	public void editCustomer(Customer customer);

	public void deleteCustomer(long id);

	public Customer getCustomerById(long id);

	public Customer getCustomerByUsernameAndPassword(String username,
			String password);

	public List<Customer> getAllCustomer();
	
	public boolean isUsernameExists(String username);
}
