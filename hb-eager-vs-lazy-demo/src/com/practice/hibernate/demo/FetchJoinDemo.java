package com.practice.hibernate.demo;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.practice.hibernate.demo.entity.Course;
import com.practice.hibernate.demo.entity.Instructor;
import com.practice.hibernate.demo.entity.InstructorDetail;

@SuppressWarnings("deprecation")
public class FetchJoinDemo {

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
			
			// start a transaction
			session.beginTransaction();
			
			// option 2: Hibernate query with HQL
			
			// get the instructor from db
			int theId = 1;
			
			Query<Instructor> query = session.createQuery("select i from Instructor i JOIN FETCH i.courses where i.id =: theInstructorId", Instructor.class);
			
			// set parameter on query
			query.setParameter("theInstructorId", theId);
			
			//execute query and get instructor
			Instructor tempInstructor = query.getSingleResult();
			
			System.out.println("Me: Instructor: " + tempInstructor);

			
			// commit transaction
			session.getTransaction().commit();
			
			// close the session
			session.close();
			
			System.out.println("Me: The session is now closed!\n");			
			
			// get course for the instructor
			System.out.println("Me: Courses: " + tempInstructor.getCourses());
			
			System.out.println("Me: Done!!!");
			
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
