package com.practice.springdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.practice.springdemo.dao.CustomerDAO;
import com.practice.springdemo.entity.Customer;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	
	// need to inject the customer dao
	
	@Autowired
	private CustomerDAO customerDAO;
	
	@RequestMapping("/list")
	public String listCustomers(Model theModel) {
		
		// get he customers from the dao
		List<Customer> theCustomers = customerDAO.getCustomer();
		
		// add the customers to the model
		theModel.addAttribute("customers", theCustomers);
		
		return "list-customers";
		
	}
	

}
