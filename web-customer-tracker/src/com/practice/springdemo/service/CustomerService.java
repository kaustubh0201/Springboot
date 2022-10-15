package com.practice.springdemo.service;

import java.util.List;

import com.practice.springdemo.entity.Customer;

public interface CustomerService {
	
	public List<Customer> getCustomers();
	
	public void saveCustomer(Customer theCustomer);

	public Customer getCustomers(int theId);
	
}
