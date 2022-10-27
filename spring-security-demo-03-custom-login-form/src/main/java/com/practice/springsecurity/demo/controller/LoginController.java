package com.practice.springsecurity.demo.controller;

@Controller
public class LoginController {
	
	@GetMapping("/showMyLoginPage")
	public String showMyLoginPage() {
		
		return "plain-login";
	}
	
}
