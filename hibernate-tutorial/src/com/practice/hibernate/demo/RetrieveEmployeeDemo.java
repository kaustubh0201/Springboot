package com.practice.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.practice.hibernate.demo.entity.Employee;

public class RetrieveEmployeeDemo {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		
		// create session factory
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Employee.class)
				.buildSessionFactory();
		
		// create session
		Session session = factory.getCurrentSession();
		
		try {			
			// start a transaction
			session.beginTransaction();
			
			// query employee: with id = 2
			List<Employee> theEmployees = session.createQuery("from Employee e where e.id = 2").getResultList();
						
			// display the results
			System.out.println("Displying the results with Employees starting with id 2");
			displayEmployees(theEmployees);
			
			// query employee: with a given company
			theEmployees = session.createQuery("from Employee e where e.company = 'Amazon'").getResultList();
			
			// display the results
			System.out.println("Displaying the results with Employees working in Amazon");
			displayEmployees(theEmployees);
			
			// commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done!!");
			
		} finally {
			factory.close();
		}

	}
	
	private static void displayEmployees(List<Employee> theEmployees) {
		for(Employee tempEmployee: theEmployees) {
			System.out.println(tempEmployee);
		}
	}

}
