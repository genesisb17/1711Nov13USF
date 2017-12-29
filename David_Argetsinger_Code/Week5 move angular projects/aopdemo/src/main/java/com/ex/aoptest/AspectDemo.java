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
	//                 return type method name params 
	@Before("execution(* com.ex.aoptest.*.a* (..))") // runs if 
	public void testIfHasLetter(JoinPoint jp){
		System.out.println(jp.getSignature().getName() + " has the letter  a");
		
	}
	@After("execution(* com.ex.aoptest.*.* (..))") // runs if 
	public void afterTest(JoinPoint jp){
		System.out.println(jp.getSignature() + " after");
		
	}
	@Around("execution(* com.ex.aoptest.*.* (..))") // runs if 
	public void aroundTest(ProceedingJoinPoint pjp) throws Throwable{
		System.out.println("before around ");
		long start = System.currentTimeMillis();
		pjp.proceed();
		long end = System.currentTimeMillis();
		System.out.println("after around, took  " + (end-start));
	}
//	@AfterThrowing(throwing = "e" pointcut="execution(* com.ex.aoptest.*.* (..))") // runs if 
//	public void afterThrowing(Exception e)throws Exception{
//		System.out.println(jp.getSignature() + " after");
//		
//	}
	
}
