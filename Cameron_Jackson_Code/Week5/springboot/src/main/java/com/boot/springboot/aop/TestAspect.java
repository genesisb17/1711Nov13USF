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
//	public void testAround(ProceedingJoinPoint pjp) {
//		System.out.println("1,4,5,00");
//		try {
//			pjp.proceed();
//		} catch (Throwable e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		System.out.println("after");
//	}
	
	@Around("execution(* com.boot.springboot.controller.*.* (..))")
	public void timerFunction(ProceedingJoinPoint pjp) {
		long start = System.currentTimeMillis();
		try {
			pjp.proceed();
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		long duration = System.currentTimeMillis() - start;
		System.out.println("Duration of run: " + duration);
	}
}
