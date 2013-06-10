package com.ordering.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.ordering.dao.OrderDAO;
import com.ordering.models.Cart;
import com.ordering.models.Customer;
import com.ordering.utils.HibernateUtil;

public class OrderDAOImpl implements OrderDAO {

	@Override
	public void addItemsToCart(Cart cart) {

		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		session.save(cart);
		session.getTransaction().commit();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Cart> getCartByCustomer(Customer customer) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		List<Cart> cartItems = session.createCriteria(Cart.class)
				.add(Restrictions.eq("customer", customer))
				.list();

		return cartItems;
	}

	@Override
	public void removeItemsToCart(long id) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Cart cart = (Cart) session.get(Cart.class, id);
		session.beginTransaction();
		session.delete(cart);
		session.getTransaction().commit();
	}

	@Override
	public Cart getItemsByCartId(long id) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Cart cart =  (Cart) session.get(Cart.class, id);
		return cart;
	}

}
