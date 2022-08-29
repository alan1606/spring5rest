package com.aaguirre.di.aop;

import org.aspectj.lang.annotation.Pointcut;

public class PointCutExample {

	
	/* execution
	 * within
	 * 
	 */
	
	//@Pointcut("execution(* com.aaguirre.di.aop.TargetObject.*(..))")
	//@Pointcut("within(com.aaguirre.di.aop.*)")
	@Pointcut("@annotation(MyAnnotation)")
	public void targetObjectMethod() {
		
	}
	
}
