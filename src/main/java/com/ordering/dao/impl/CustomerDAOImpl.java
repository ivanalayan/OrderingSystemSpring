package com.ordering.dao.impl;

import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.ordering.dao.CustomerDAO;
import com.ordering.models.Customer;
import com.ordering.utils.HibernateUtil;

public class CustomerDAOImpl implements CustomerDAO {

	@Override
	public void addCustomer(Customer customer) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		customer.setDateRegistered(new Date());
		session.save(customer);
		session.getTransaction().commit();
	}

	@Override
	public void editCustomer(Customer customer) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteCustomer(long id) {
		// TODO Auto-generated method stub

	}

	@Override
	public Customer getCustomerById(long id) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();

		return (Customer) session.get(Customer.class, id);
	}

	@Override
	public List<Customer> getAllCustomer() {
		// TODO Auto-generated method stub
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Customer getCustomerByUsernameAndPassword(String username,
			String password) {

		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		List<Customer> customer = session.createCriteria(Customer.class)
				.add(Restrictions.eq("username", username))
				.add(Restrictions.eq("password", password)).list();
		return (customer.size() == 0 ? null : customer.get(0));
	}

	@SuppressWarnings("unchecked")
	public boolean isUsernameExists(String username) {

		Session session = HibernateUtil.getSessionFactory().openSession();
		List<Customer> customer = session.createCriteria(Customer.class)
				.add(Restrictions.eq("username", username)).list();
		return (customer.size() == 0 ? false : true);
	}
}
