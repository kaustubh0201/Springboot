package com.practice.hibernate.demo;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.practice.hibernate.demo.entity.Student;

public class CreateStudentDemo {

	public static void main(String[] args) {
		
		// create session factory
		
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Student.class)
								.buildSessionFactory();
		
		// create session
		Session session = factory.getCurrentSession();
		
		try {
			// use the session object to save Java object
			
			// create a student object
			System.out.println("Creating new student object...");
			
			String theDateOfBirthStr = "31/12/1998";
			 
			Date theDateOfBirth = DateUtils.parseDate(theDateOfBirthStr);
			
			Student tempStudent = new Student("Wolf", "Fox", "wolf@gmail.com", theDateOfBirth);
			
			// start a transaction
			session.beginTransaction();
			
			// save the student object
			System.out.println("Saving the student....");
			session.save(tempStudent);
			
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
