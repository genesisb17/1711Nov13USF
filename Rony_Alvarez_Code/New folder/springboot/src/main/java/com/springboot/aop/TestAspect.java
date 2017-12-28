package com.springboot.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class TestAspect {

	@Before("execution(* com.springboot.controller.*.*(..))&&args(str,..)")
	public void testBefore(JoinPoint jp, String str) {
		System.out.println("SPRING BEFORE " + jp.getSignature() + str);
	}
	
	
	
	

}
