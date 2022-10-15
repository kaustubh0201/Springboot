package com.practice.springdemo.dao;

import java.util.List;

import com.practice.springdemo.entity.Customer;

public interface CustomerDAO {

	public List<Customer> getCustomer();

	public void saveCustomer(Customer theCustomer);

	public Customer getCustomer(int theId);
	
}
