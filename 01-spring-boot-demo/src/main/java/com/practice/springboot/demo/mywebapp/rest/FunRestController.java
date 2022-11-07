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

}
