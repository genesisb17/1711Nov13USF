package com.springboot.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
/*
 * Aspect oriented Programming
 * 
 * Aspects are our classes. The Methods are our Advices.
 * Before
 * After
 * Around
 * After Throwing
 * After Returning
 */
@Aspect
@Component
public class TestAspect {
	
	@Before ("execution(* com.boot.controller.*.* (..))")
	public void testBefore(JoinPoint jp) {
	System.out.println("BEFORE: "+ jp.getSignature().getName());
	}
	
	@Around ("execution(* com.boot.controller.*.* (..))")
	public void testAround(ProceedingJoinPoint pjp) {
		System.out.println("1,2,3,4");
		long tStart = System.currentTimeMillis();
		try{
			pjp.proceed();
			long delta = System.currentTimeMillis() - tStart;
			System.out.println("TimePassed :" + delta);
		}
		catch(Throwable e) {
			e.printStackTrace();
		}
			
	}
}
