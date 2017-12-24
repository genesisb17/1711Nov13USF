package com.ex.aoptest;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AspectDemo {
	
	@Before("execution (* com.ex.aoptest.*.*d* (..))")
	public void testIfHasLetter(JoinPoint jp) {
		System.out.println(jp.getSignature().getName()+"has the letter d");
	}
	
	@Before("execution(* com.* (..))")
	public void beforeTest(JoinPoint jp) {
		System.out.println(jp.getSignature()+"before");
	}
	
	@After("execution(* com.ex.aoptest.*.* (..))")
	public void afterTest(JoinPoint jp) {
		System.out.println(jp.getSignature()+"after");
	}
	
	//
	@Around("execution(* com.ex.aoptest.*.* (..))")
	//public 
}
