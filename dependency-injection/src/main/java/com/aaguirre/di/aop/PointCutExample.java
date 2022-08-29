package com.aaguirre.di.aop;

import org.aspectj.lang.annotation.Pointcut;

public class PointCutExample {

	@Pointcut("execution(* com.aaguirre.di.aop.TargetObject.*(..))")
	public void targetObjectMethod() {
		
	}
	
}
