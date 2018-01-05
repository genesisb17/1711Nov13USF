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

//	@Before("execution(* com.ex.aoptest.*.*(..))")
//	public void testIfHasLetter(JoinPoint jp) {
//		System.out.println(jp.getSignature().getName()+"has the letter d");
//	}
	
	@Before("execution(* * (..))")
	public void testIfHasLetter(JoinPoint jp) {
		System.out.println(jp.getSignature().getName()+"");
	}
	
	@After("execution(* com.ex.aoptest.*.* (..))")
	public void afterTest(JoinPoint jp) {
		System.out.println(jp.getSignature()+"after");
	}
	
	@Around("execution(* com.ex.aoptest.*.* (..))")
	public void aroundTest(ProceedingJoinPoint pjp) throws Throwable {
		System.out.println("before around");
		pjp.proceed();
		System.out.println("after around");
	}
	
	@AfterThrowing(throwing="e", pointcut=("execution(* com.ex.aoptest.*.* (..))"))
	public void afterThrowing(Exception e) {
		System.out.println("in after throwing");
		e.printStackTrace();
	}
}
