package com.ordering.services;

import com.ordering.exceptions.LoginFailedException;
import com.ordering.exceptions.UsernameAlreadyExistException;
import com.ordering.models.Customer;

public interface CustomerService {

	public void validateAccount(String username, String password)throws LoginFailedException;
	public void addNewCustomer(Customer customer) throws UsernameAlreadyExistException;
	public Customer getCustomerByUsernameAndPassword(String username,String password)throws LoginFailedException;
}
