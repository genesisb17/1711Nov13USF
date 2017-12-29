package com.boot.aop;

import java.time.Clock;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class TestAspect {
	
	static Clock clock;
	
	@Before ("execution(* com.boot.controller.*.* (..))")
	public void testBefore(JoinPoint jp) {
		System.out.println("PRINT BEFORE " + jp.getSignature().getName());
	}
	
	@After ("execution(* com.boot.controller.*.* (..))")
	public void testAfter(JoinPoint jp) {
		System.out.println("PRINT AFTER " + jp.getSignature().getName());
	}
}
