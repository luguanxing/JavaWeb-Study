package aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

//增强类上增加注解
@Aspect
public class UserExt {
	
	@Before(value = "execution(* aop.User.*(..))")
	public void add_before() {
		System.out.println("UserExt->before");
	}
	
	@After(value = "execution(* aop.User.*(..))")
	public void add_after() {
		System.out.println("UserExt->after");
	}
	
	@Around(value = "execution(* aop.User.*(..))")
	public void add_around(ProceedingJoinPoint pjp) throws Throwable {
		System.out.println("UserExt:ProceedingJoinPoint->before");
		pjp.proceed();
		System.out.println("UserExt:ProceedingJoinPoint->after");
	}

}
