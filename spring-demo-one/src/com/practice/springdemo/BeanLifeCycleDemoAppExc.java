package com.practice.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanLifeCycleDemoAppExc {

	public static void main(String[] args) {
		
		// load the spring configuration file
		ClassPathXmlApplicationContext context = 
				new ClassPathXmlApplicationContext("beanLifeCycle-applicationContextExc.xml");
		
		// retrieve bean from spring container
		Coach theCoach = context.getBean("myCoach", Coach.class);
		Coach theCoachDup = context.getBean("myCoach", Coach.class);
		
		Coach theSecondCoach = context.getBean("mySecondCoach", Coach.class);
		Coach theSecondCoachDup = context.getBean("mySecondCoach", Coach.class);
		
		
		System.out.println("\nFor the prototype scope: ");
		System.out.println(theCoach == theCoachDup);
		System.out.println(theCoach);
		System.out.println(theCoachDup);
		
		System.out.println("\nFor the singleton scope: ");
		System.out.println(theSecondCoach == theSecondCoachDup);
		System.out.println(theSecondCoach);
		System.out.println(theSecondCoachDup);
		
		// System.out.println(theCoach.getDailyWorkout());
		
		// close the context
		context.close();
		

	}

}
