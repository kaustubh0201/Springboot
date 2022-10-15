package com.practice.aopdemo.dao;

import org.springframework.stereotype.Component;

@Component
public class MembershipDAO {
	
	public boolean addMember() {
		
		System.out.println(getClass() + ": DOINT STUFF: ADDING A MEMBERSHIP ACCOUNT");
		
		return true;
		
	}

}
