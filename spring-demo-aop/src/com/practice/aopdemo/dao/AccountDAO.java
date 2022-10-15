package com.practice.aopdemo.dao;

import org.springframework.stereotype.Component;

@Component
public class AccountDAO {

	public void addAccount() {
			
		System.out.println(getClass() + ": DOINT MY DB WORK: ADDING AN ACCOUNT");
		
	}
	
}
