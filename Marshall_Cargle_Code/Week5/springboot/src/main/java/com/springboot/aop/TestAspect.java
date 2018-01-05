package com.springboot.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class TestAspect {
	
	@Before("execution(* com.boot.controller.*.*(..))&&args(str,..)")
	public void testBefore(JoinPoint jp, String str) {
		System.out.println("PRINT BEFORE "+ jp.getSignature()+str);
	}
	
	@Around("execution(* com.boot.controller.*.*(..))&&args(str,..)")
	public void testAround(ProceedingJoinPoint pjp) {
		System.out.println("1,4,5,00");
		try {
			pjp.proceed();
		} catch (Throwable e) {
			e.printStackTrace();
		}
		System.out.println("after");
	}

}
