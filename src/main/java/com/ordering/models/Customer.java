package com.ordering.models;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Customer {
	
	private long customerId;
	private String firstName;
	private String lastName;
	private String username;
	private String password;
	private Date birthday;
	private Date dateRegistered;
	private Date lastOrderDate;
	private String address;
	private Set<Cart> cartItems = new HashSet<Cart>();
	
	public Customer(){
		
	}

	public Customer(long customerId, String firstName, String lastName,
			String username, String password, Date birthday,
			Date dateRegistered, Date lastOrderDate, String address) {

		this.customerId = customerId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.username = username;
		this.password = password;
		this.birthday = birthday;
		this.dateRegistered = dateRegistered;
		this.lastOrderDate = lastOrderDate;
		this.address = address;
	}

	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", firstName="
				+ firstName + ", lastName=" + lastName + ", username="
				+ username + ", password=" + password + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (customerId ^ (customerId >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Customer other = (Customer) obj;
		if (customerId != other.customerId)
			return false;
		return true;
	}
	
	public String printAccount(){
			return "Username: "+username+" - Password: "+password;
	}

	public long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(long customerId) {
		this.customerId = customerId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public Date getDateRegistered() {
		return dateRegistered;
	}

	public void setDateRegistered(Date dateRegistered) {
		this.dateRegistered = dateRegistered;
	}

	public Date getLastOrderDate() {
		return lastOrderDate;
	}

	public void setLastOrderDate(Date lastOrderDate) {
		this.lastOrderDate = lastOrderDate;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Set<Cart> getCartItems() {
		return cartItems;
	}

	public void setCartItems(Set<Cart> cartItems) {
		this.cartItems = cartItems;
	}
}
