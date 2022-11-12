package com.practice.springboot.thymeleafdemo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.practice.springboot.thymeleafdemo.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
	
	// that's it ... no need to write any other code
	
	// add a method to sort by last name
	public List<Employee> findAllByOrderByLastNameAsc();
	
}
