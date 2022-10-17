package com.practice.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect {

	// this is where we add all of our related advices for logging
	
	// let's start with an @Before advice
	
	//@Before("execution(public void add*())")
	
	//@Before("execution(* add*(..))")
	
	@Before("com.practice.aopdemo.aspect.AopExpressions.forDaoPackageNoGetterSetter()")
	private void beforeAddAccountAdvice() {		
		System.out.println("\n======>>> Executing  @Before advice on method");		
	}
		
}
