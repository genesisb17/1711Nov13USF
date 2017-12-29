package com.ex.aoptest;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AspectDemo {

	@Before("execution(* com.ex.aoptest.*.*D* (..))")
	public void testIfHasLetter(JoinPoint jp) {
		System.out.println(jp.getSignature().getName() + "has the letter d");
	}
}