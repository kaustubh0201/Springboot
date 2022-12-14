package com.practice.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.practice.hibernate.demo.entity.Instructor;
import com.practice.hibernate.demo.entity.InstructorDetail;

public class DeleteDemo {

	public static void main(String[] args) {
		
		// create session factory
		
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(InstructorDetail.class)
								.addAnnotatedClass(Instructor.class)
								.buildSessionFactory();
		
		// create session
		Session session = factory.getCurrentSession();
		
		try {			
					
			// start a transaction
			session.beginTransaction();
			
			// get instructor by primary key / id
			int theId = 1;
			Instructor tempInstructor = session.get(Instructor.class, theId);
			
			System.out.println("Found instructor: " + tempInstructor);
			
			// delete the instructors
			if (tempInstructor != null) {
				System.out.println("Deleting: " + tempInstructor);
				
				// Note: will ALSO delete associated "details" object
				// beacuse of CascadeType.ALL
				//
				session.delete(tempInstructor);
				
			}
			
			// commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done!!!");
			
		} catch (Exception e){
			e.printStackTrace();
		}
		finally {
			factory.close();
		}

	}

}
