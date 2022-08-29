package com.aaguirre.di.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class MyAspect {

	
	private static final Logger log = LoggerFactory.getLogger(MyAspect.class);

	@Before("execution(* com.aaguirre.di.aop.TargetObject.*(..))")	
	public void before(JoinPoint joinPoint) {
		log.info("Method name {}", joinPoint.getSignature().getName());
		log.info("Object type {}", joinPoint.getSignature().getDeclaringType());
		log.info("Modifiers {}", joinPoint.getSignature().getModifiers());
		log.info("Args {}", joinPoint.getArgs());


		log.info("Before advice");
	}
}
