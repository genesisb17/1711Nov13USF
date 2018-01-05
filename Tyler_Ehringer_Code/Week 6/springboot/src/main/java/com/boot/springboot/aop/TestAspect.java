package com.boot.springboot.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class TestAspect {

	@Before("execution(* com.boot.springboot.controller.*.* (..))")
	public void testBefore(JoinPoint jp) {
		System.out.println("PRINT BEFORE " + jp.getSignature().getName());
	}

	
//	@Around("execution(* com.boot.springboot.controller.*.* (..))")
//	public void timeTaken(ProceedingJoinPoint pjp)throws Throwable {
//		long start = System.nanoTime();
//		pjp.proceed();
//		System.out.println("Method took " + (System.nanoTime() - start) + " nanoseconds");
//	}

}
