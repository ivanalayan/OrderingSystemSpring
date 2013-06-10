package com.ordering.services.impl;

import com.ordering.dao.CustomerDAO;
import com.ordering.dao.impl.CustomerDAOImpl;
import com.ordering.exceptions.LoginFailedException;
import com.ordering.exceptions.UsernameAlreadyExistException;
import com.ordering.models.Customer;
import com.ordering.services.CustomerService;

public class CustomerServiceImpl implements CustomerService {

	@Override
	public void validateAccount(String username, String password)
			throws LoginFailedException {

		CustomerDAO customerDAO = new CustomerDAOImpl();
		Customer retrieveCustomer = customerDAO
				.getCustomerByUsernameAndPassword(username, password);
		if (retrieveCustomer == null)
			throw new LoginFailedException("Login failed for username "
					+ username);

	}

	@Override
	public void addNewCustomer(Customer customer)
			throws UsernameAlreadyExistException {

		CustomerDAO customerDAO = new CustomerDAOImpl();

		if (customerDAO.isUsernameExists(customer.getUsername()))
			throw new UsernameAlreadyExistException(customer.getUsername()
					+ " is already exist");
		customerDAO.addCustomer(customer);
	}

	@Override
	public Customer getCustomerByUsernameAndPassword(String username,
			String password) throws LoginFailedException {
		CustomerDAO customerDAO = new CustomerDAOImpl();

		Customer retrievedCustomer = customerDAO
				.getCustomerByUsernameAndPassword(username, password);
		if (retrievedCustomer == null)
			throw new LoginFailedException("Login failed for username "
					+ username);
		return retrievedCustomer;
	}

}
