package com.ex.aoptest;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AspectDemo {
//	
//	@Before("execution(* * (..))")
//	public void testIfHasLetter(JoinPoint jp) {
//		System.out.println(jp.getSignature() + "testing for everything");
//	}
	
	
	@Before("execution(* com.ex.aoptest.*.* (..))")
	public void beforeTest(JoinPoint jp) {
		System.out.println(jp.getSignature() + "before");
	}
	

	@After("execution(* com.ex.aoptest.Methods.* (..))")
	public void afterTest(JoinPoint jp) {
		System.out.println(jp.getSignature() + "after");
	}
	
	@Around("execution(* com.ex.aoptest.*.* (..))")
	public void aroundTest(ProceedingJoinPoint pjp) throws Throwable {
		System.out.println("before around");
		long start = System.currentTimeMillis();
		pjp.proceed();
		long end = System.currentTimeMillis();
		System.out.println("after around, took: " + (end-start));
	}
	
//	@AfterThrowing(throwing= "e")
//	public void afterThrowing ( Exception e) throws Throwable{
//		System.out.println("in after throwing");
//		e.printStackTrace();
//	}
	
}
