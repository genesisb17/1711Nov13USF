package com.ex.aoptest;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AspectDemo {

	@Before("execution (* com.ex.aoptest.*.*d* (..))")
	public void testIfHasLetter(JoinPoint jp) {
		System.out.println(jp.getSignature().getName() + " has the letter d");
	}
	
	@Around("execution (* com.ex.aoptest.*.*d* (..))")
	public void aroundTest(ProceedingJoinPoint pjp) throws Throwable {
		System.out.println("before around");
		pjp.proceed();
		System.out.println("after around");
	}
	
	@After("execution (* com.ex.aoptest.*.*d* (..))")
	public void afterTest(JoinPoint jp) {
		System.out.println("after test");
	}
}
