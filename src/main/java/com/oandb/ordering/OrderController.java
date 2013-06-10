package com.oandb.ordering;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.ordering.exceptions.InsuffiecientStockException;
import com.ordering.models.Cart;
import com.ordering.models.Customer;
import com.ordering.models.Product;
import com.ordering.services.OrderService;
import com.ordering.services.ProductService;
import com.ordering.services.impl.OrderServiceImpl;
import com.ordering.services.impl.ProductServiceImpl;

@Controller
public class OrderController {

	@RequestMapping(value = "/menu", method = RequestMethod.GET)
	public ModelAndView menuPage(HttpSession session) {

		ModelAndView model = new ModelAndView("order/menu");
		ProductService productService = new ProductServiceImpl();
		List<Product> allProduct = productService.getAllProduct();
		model.addObject("foods", allProduct);
		Customer customer = (Customer) session.getAttribute("account");
		OrderService orderService = new OrderServiceImpl();
		List<Cart> cartItems = orderService.getCartItems(customer);
		model.addObject("cartItems", cartItems);
		return model;
	}

	@RequestMapping(value = "/addToCart", method = RequestMethod.POST)
	public ModelAndView addToCart(HttpServletRequest request,
			HttpSession session) {

		OrderService orderService = new OrderServiceImpl();
		ProductService productService = new ProductServiceImpl();
		ModelAndView model = new ModelAndView("redirect:/menu");
		long productId = Long.parseLong(request.getParameter("productId"));
		Product product = productService.getProductById(productId);
		Customer customer = (Customer) session.getAttribute("account");
		int qty = Integer.parseInt(request.getParameter("qtyOrdered"));
		Cart cart = new Cart(customer, product, qty);
		try {

			orderService.addToCart(cart);
		} catch (InsuffiecientStockException e) {
			model.addObject("errorMessage", e.getMessage());
		}

		return model;
	}

	@RequestMapping(value = "/removeToCart", method = RequestMethod.POST)
	public ModelAndView removeToCart(HttpServletRequest request,
			HttpSession session) {

		OrderService orderService = new OrderServiceImpl();
		ModelAndView model = new ModelAndView("redirect:/menu");
		long cartId = Long.parseLong(request.getParameter("orderLineId"));
		orderService.removeToCart(cartId);

		return model;
	}
	
	@RequestMapping(value = "/checkOut", method = RequestMethod.POST)
	public ModelAndView checkOut(HttpServletRequest request,
			HttpSession session) {

		OrderService orderService = new OrderServiceImpl();
		ModelAndView model = new ModelAndView("redirect:/menu");
		long cartId = Long.parseLong(request.getParameter("orderLineId"));
		orderService.removeToCart(cartId);

		return model;
	}

}
