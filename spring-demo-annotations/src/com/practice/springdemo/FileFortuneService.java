package com.practice.springdemo;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

@Component
public class FileFortuneService implements FortuneService {
	
	private ArrayList<String> fortunes = new ArrayList<String>();
	private Random random = new Random();
	
	@PostConstruct
	public void doBeforeConstruction() throws FileNotFoundException {
		
		System.out.println(">> FileFortuneService: in the doBeforeConstruction()");
		
		File file = new File("/home/kaustubh0201/eclipse-workspace/spring-demo-annotations/bin/com/practice/springdemo/fortuneText");
		
		Scanner sc = new Scanner(file);
		
		while(sc.hasNextLine())
			fortunes.add(sc.nextLine());
		
		sc.close();
	}
	
//	public FileFortuneService() throws FileNotFoundException {
//		File file = new File("/home/kaustubh0201/eclipse-workspace/spring-demo-annotations/bin/com/practice/springdemo/fortuneText");
//		
//		Scanner sc = new Scanner(file);
//		
//		while(sc.hasNextLine())
//			fortunes.add(sc.nextLine());
//		
//		sc.close();
//	}
	
	@Override
	public String getFortune() {
		
		return fortunes.get(random.nextInt(fortunes.size() * 1000) % fortunes.size());
		
	}

}
