package com.practice.springboot.cruddemo.dao;

import java.util.List;

import com.practice.springboot.cruddemo.entity.Employee;

public interface EmployeeDAO {
	
	public List<Employee> findAll();

}
