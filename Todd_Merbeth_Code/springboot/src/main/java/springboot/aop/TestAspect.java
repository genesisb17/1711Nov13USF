package springboot.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class TestAspect {
	
	@Before ("execution(* com.springboot.controller.*.* (..))") // Star means any return type .*.* means any class, any name (..) is any return type
	public void testBefore(JoinPoint jp) {						// execution(* com.springboot.controller.*add* (..))") would be before any add class
		System.out.println("PRINT BEFORE " + jp.getSignature().getName());
	}

	@Around ("execution(* com.springboot.controller.*.* (..))")
	public void testAround(ProceedingJoinPoint pjp) {
		System.out.println("1, 4, 5, 00");
		try {
			pjp.proceed();
		} catch (Throwable e) {
			e.printStackTrace();
		}
		System.out.println("after");
	}
	
}
