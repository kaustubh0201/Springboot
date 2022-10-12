package com.practice.springdemo;

import java.util.Random;

public class RandomFortuneService implements FortuneService {

	private String[] fortunes = {"You will have a good day!", "You will have the best day of your life!", "You will have an ordinary day!"};
		
	@Override
	public String getFortune() {
		
		Random rand = new Random();
			
		return fortunes[rand.nextInt(1000) % 3];
	}

}
