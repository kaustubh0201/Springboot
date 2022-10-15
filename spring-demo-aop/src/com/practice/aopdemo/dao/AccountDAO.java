package com.practice.aopdemo.dao;

import org.springframework.stereotype.Component;

import com.practice.aopdemo.Account;

@Component
public class AccountDAO {

	public void addAccount(Account theAccount, boolean vipFlag) {
			
		System.out.println(getClass() + ": DOINT MY DB WORK: ADDING AN ACCOUNT");
		
	}
	
	public boolean doWork() {
		
		System.out.println(getClass() + ": DO WORK");
		
		return false;
	}
	
}
