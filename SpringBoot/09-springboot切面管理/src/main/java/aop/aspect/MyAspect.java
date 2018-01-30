package aop.aspect;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import aop.entity.Student;

@Aspect
@Component
public class MyAspect {

	private Logger logger = Logger.getLogger(MyAspect.class);

	@Pointcut("execution(public * aop.controller.*.*(..))")
	public void log() {
		//注解配置切点(即增强的方法)，给aop.controller所有类的所有方法增强
	}

	//切点执行前
	@Before("log()")
	public void doBefore(JoinPoint joinPoint) {
		logger.info("方法执行前");
		ServletRequestAttributes sra = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
		HttpServletRequest request = sra.getRequest();
		logger.info("url:" + request.getRequestURI());
		logger.info("ip:" + request.getRemoteHost());
		logger.info("method:" + request.getMethod());
		logger.info("class_method:" + joinPoint.getSignature().getDeclaringTypeName() + "."
				+ joinPoint.getSignature().getName());
		logger.info("args:" + joinPoint.getArgs());
		Student student = (Student) joinPoint.getArgs()[0];
		System.out.println(student);
	}

	//切点执行后
	@After("log()")
	public void doAfter(JoinPoint joinPoint) {
		logger.info("方法执行后");
	}

	//切点执行返回值
	@AfterReturning(returning="result", pointcut="log()")
	public void doAfterReturning(Object result){
		logger.info("方法返回值："+result);
	}

}
