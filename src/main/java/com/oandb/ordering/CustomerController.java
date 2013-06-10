package com.oandb.ordering;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.ordering.exceptions.LoginFailedException;
import com.ordering.exceptions.UsernameAlreadyExistException;
import com.ordering.models.Customer;
import com.ordering.services.CustomerService;
import com.ordering.services.impl.CustomerServiceImpl;

/**
 * Handles requests for the application home page.
 */
@Controller
public class CustomerController {


	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView loginPage() {
		ModelAndView model = new ModelAndView("customer/login");
		Customer customer = new Customer();
		model.addObject("customer", customer);
		return model;
	}
	
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public ModelAndView logout(HttpSession session,HttpServletResponse response) {

		ModelAndView model = new ModelAndView("redirect:/");
		session.removeAttribute("account");
		return model;
	}
	@RequestMapping(value = "/welcome", method = RequestMethod.POST)
	public ModelAndView validateLogin(@ModelAttribute Customer customer,HttpSession session,HttpServletResponse response) {

		ModelAndView model = null;
	
		CustomerService customerService = new CustomerServiceImpl();
		try {
	
			customerService.validateAccount(customer.getUsername(),
					customer.getPassword());
			Customer account = customerService.getCustomerByUsernameAndPassword(customer.getUsername(),
					customer.getPassword());
			session.setAttribute("account", account);
			model = new ModelAndView("redirect:/menu");
			
		} catch (LoginFailedException e) {
			model = new ModelAndView("customer/login");
			model.addObject("errorMessage", e.getMessage());
		}
		
		return model;
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public ModelAndView registerPage() {
		ModelAndView model = new ModelAndView("customer/register");
		model.addObject("customer", new Customer());
		return model;
	}
	
	@RequestMapping(value = "/registration", method = RequestMethod.POST)
	public ModelAndView registerCustomer(@ModelAttribute Customer customer) {
		
		
		ModelAndView model = null;
		
		CustomerService customerService = new CustomerServiceImpl();
		try {
			customerService.addNewCustomer(customer);
			model = new ModelAndView("customer/register");
			model.addObject("message", "Registration successfull!");
		} catch (UsernameAlreadyExistException e) {
			model = new ModelAndView("customer/register");
			model.addObject("message", e.getMessage());
		}
		
		return model;
	}
}
