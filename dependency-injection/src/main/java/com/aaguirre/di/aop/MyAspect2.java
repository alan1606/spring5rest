package com.aaguirre.di.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Order(0)
public class MyAspect2 {

	private static final Logger log = LoggerFactory.getLogger(MyAspect.class);

	@Before("PointCutExample.targetObjectMethod()")	
	public void before(JoinPoint joinPoint) {
		log.info("1 Method name {}", joinPoint.getSignature().getName());
		log.info("1 Object type {}", joinPoint.getSignature().getDeclaringType());
		log.info("1 Modifiers {}", joinPoint.getSignature().getModifiers());
		log.info("1 Args {}", joinPoint.getArgs());


		log.info("1 Before advice");
	}
	
}
