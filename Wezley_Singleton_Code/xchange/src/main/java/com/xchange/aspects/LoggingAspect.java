package com.xchange.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

	@Pointcut("execution(* com.xchange.controllers.*.* (..))")
	public void controllerPointcut() {}
	
	@Around("controllerPointcut()")
    public void elapsedExecutionTime(ProceedingJoinPoint pjp) throws Throwable {
            long start = System.currentTimeMillis();
            System.out.println("[LOG] - Before " + pjp.getSignature().getName() + " method call");
            pjp.proceed();
            System.out.println("[LOG] - After " + pjp.getSignature().getName() + " method call");
            long elapsedTime = System.currentTimeMillis() - start;
            System.out.println("[LOG] - Total elapsed execution time for " + pjp.getSignature().getName() + ": " + elapsedTime + " milliseconds.");
    }
}
