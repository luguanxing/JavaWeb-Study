package aop;

import org.aspectj.lang.ProceedingJoinPoint;

public class UserExt {
	
	public void add_before() {
		System.out.println("UserExt->before");
	}
	
	public void add_after() {
		System.out.println("UserExt->after");
	}
	
	public void add_around(ProceedingJoinPoint pjp) throws Throwable {
		System.out.println("UserExt:ProceedingJoinPoint->before");
		pjp.proceed();
		System.out.println("UserExt:ProceedingJoinPoint->after");
	}

}
