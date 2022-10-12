package com.practice.springdemo;

public class BasketballCoach implements Coach, DisposableBean {
	
	private FortuneService fortuneService;
	
	public BasketballCoach() {
		
	}
	
	public BasketballCoach(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}
	@Override
	public String getDailyWorkout() {
		// TODO Auto-generated method stub
		return "Do 100 3 pointers straight!!";
	}

	@Override
	public String getDailyFortune() {
		return "Just Do It: " + fortuneService.getFortune();
	}
	
	// add an in-it method
	public void doMyStartupStuff() {
		System.out.println("TrackCoach: inside method doMyStartupStuff");
	}
	
	// add a destroy method
//	public void doMyCleanupStuff() {
//		System.out.println("TrackCoach: inside method doMyCleanupStuff");
//	}

	@Override
	public void destroy() throws Exception {
		System.out.println("TrackCoach: inside method doMyCleanupStuffYoYo");
		
	}

}
