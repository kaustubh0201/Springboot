package com.practice.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.practice.hibernate.demo.entity.Course;
import com.practice.hibernate.demo.entity.Instructor;
import com.practice.hibernate.demo.entity.InstructorDetail;

public class CreateInstructorDemo {

	public static void main(String[] args) {
		
		// create session factory
		
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(InstructorDetail.class)
								.addAnnotatedClass(Instructor.class)
								.addAnnotatedClass(Course.class)
								.buildSessionFactory();
		
		// create session
		Session session = factory.getCurrentSession();
		
		try {			
			
			// create the objects
			Instructor tempInstructor = new Instructor("Susan", "Public", "susan@gmail.com");
			
			InstructorDetail tempInstructorDetail = new InstructorDetail("http://www.code.com/youtube", "video games");
			
//			Instructor tempInstructor = new Instructor("Madhu", "Patel", "madhu@gmail.com");
//			
//			InstructorDetail tempInstructorDetail = new InstructorDetail("http://www.codeyou.com/youtube", "guitar");
			
			// associate the objects
			tempInstructor.setInstructorDetail(tempInstructorDetail);
			
			// start a transaction
			session.beginTransaction();
			
			// save the instructor
			// Note: this will ALSO save the details object
			// because of CascadeType.ALL
			System.out.println("Saving instructor: " + tempInstructor);
			session.save(tempInstructor);
			
			// commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done!!!");
			
		} catch (Exception e){
			e.printStackTrace();
		}
		finally {
			// add clean up code
			
			session.close();
			
			factory.close();
		}

	}

}
