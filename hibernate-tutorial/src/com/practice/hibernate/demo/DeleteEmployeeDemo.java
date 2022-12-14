package com.practice.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.practice.hibernate.demo.entity.Employee;

public class DeleteEmployeeDemo {

	public static void main(String[] args) {
		
		// create session factory
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Employee.class)
				.buildSessionFactory();
		
		// create session
		Session session = factory.getCurrentSession();
		
		try {	
			
			int employeeId = 3;
			
			// start a transaction
			session.beginTransaction();
			
			// query: deleting employee with the given employee id
			session.createQuery("delete from Employee e where e.id = " + employeeId).executeUpdate();	
			
			// commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done!!");
			
		} finally {
			factory.close();
		}
	}
}
