package com.practice.springdemo;

public class TrackCoach implements Coach, DisposableBean {
	
	private FortuneService fortuneService;
	
	public TrackCoach() {
		
	}
	
	public TrackCoach(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}
	@Override
	public String getDailyWorkout() {
		// TODO Auto-generated method stub
		return "Run a hard 5k";
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
