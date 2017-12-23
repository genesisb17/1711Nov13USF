package com.boot.aop;

import org.aspectj.lang.JoinPoint;
<<<<<<< HEAD
=======
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
>>>>>>> master
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class TestAspect {
<<<<<<< HEAD
	@Before("execution(* com.boot.controller.*.add* (..))")
	public void testBefore(JoinPoint jp) {
		System.out.println("PRINT BEFORE " + jp.getSignature().getName());
	}
=======
	
	@Before	("execution(* com.boot.controller.*.* (..))&&args(str,..)")
	public void testBefore(JoinPoint jp, String str) {
		System.out.println("PRINT BEFORE " + jp.getSignature() + str);
	}
	
	@AfterThrowing("execution(* com.boot.controller.*.* (..))&&args(str,..)")
	public void testAround(ProceedingJoinPoint pjp) {
		System.out.println("1, 4, 5, 00");
		try {
			pjp.proceed();
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("after");
		
	}
	

	

>>>>>>> master
}
