package com.ordering.models;


public class Cart {

	private long id;
	private Customer customer;
	private Product product;
	private int qty;
	
	
	public Cart() {

	}
	public Cart(Customer customer,Product product, int qty) {
		this.customer = customer;
		this.product = product;
		this.qty = qty;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

}
