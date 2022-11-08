package com.practice.springboot.demo.mywebapp.rest;

import java.time.LocalDateTime;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {
	
	// expose '/' that return "Hello World"
	
	@GetMapping("/")
	public String sayHello() {
		return "Time on server is " + LocalDateTime.now();
	}
	
	// expose a new endpoint for "workout"
	
	@GetMapping("/workout")
	public String getDailyWorkout() {
		return "Run for 5 km!";
	}
	
	// expose a new endpoint for "fortune"
	@GetMapping("/fortune")
	public String getDailyFortune() {
		return "Today is your lucky day!";
	}

}
