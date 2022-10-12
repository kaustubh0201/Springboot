package com.practice.springdemo;

import javax.annotation.PostConstruct;
//import javax.annotation.PreDestroy;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class TennisCoach implements Coach, DisposableBean{
	
	@Value("${foo.email}")
	private String email;
	
	@Value("${foo.team}")
	private String team;

	@Autowired
	@Qualifier("fileFortuneService")
	private FortuneService fortuneService;
	
	// define a default Constructor
	public TennisCoach() {
		
		System.out.println(">> TennisCoach: Inside Default Constructor");
	}
	
	// in the case for the setter injection
	// we can use either of the two methods of putting @Qualifier annotation in the method
	// either with the argument or just above the method
	
	// defining a constructor with @Autowired and @Qualifier
//	@Autowired
//	public TennisCoach(@Qualifier("randomFortuneService")FortuneService fortuneService) {
//		System.out.println(">> TennisCoach: inside constructor using @Autowired and @Qualifier");
//		
//		this.fortuneService = fortuneService;
//	}
	
	// define a setter method
//	@Autowired
//	public void setFortuneService(FortuneService theFortuneService) {
//		System.out.println(">> TennisCoach: Inside setFortuneService");
//		fortuneService = theFortuneService;
//	}
	
//	@Autowired
//	public void doSomeCrazyStuff(FortuneService theFortuneService) {
//		System.out.println(">> TennisCoach: Inside doSomeCrazyStuffMethod");
//		fortuneService = theFortuneService;
//	}
	
	/*
	@Autowired
	public TennisCoach(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}
	*/
	
	// define my in-it method
	@PostConstruct	
	public void doMyStartupStuff() {
		System.out.println(">> TennisCoach: inside of doMyStartupStuff");
	}

	
	// define my destroy method
//	@PreDestroy
//	public void doMyCleanupStuff() {
//		System.out.println(">> TennisCoach: inside of doMyCleanupStuff");
//	}
	
	@Override
	public String getDailyWorkout() {
		
		return "Practice your backhand volley";
	}

	@Override
	public String getDailyFortune() {
		
		//System.out.println(email + " "  + team);
		
		return fortuneService.getFortune();
	}

	@Override
	public void destroy() throws Exception {
		
		System.out.println(">> TennisCoach: inside destroy()");
		
	}

}
