package com.wangdh.learner.aop;

import java.lang.reflect.Method;
import java.math.BigDecimal;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.aop.AfterReturningAdvice;
import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.aop.ThrowsAdvice;

/**
 * 记录方法执行时间
 * 
 * @author wangdh 2017年3月8日下午8:05:05
 */
public class ExecutionTimeLoggingSpringAop implements MethodBeforeAdvice, AfterReturningAdvice,ThrowsAdvice{
	long startTime = 0;

	@Override
	public void afterReturning(Object returnValue, Method method, Object[] arg2, Object target) throws Throwable {
		long elapsedTime = System.nanoTime() - startTime;
		String className = target.getClass().getCanonicalName();
		String methodName = method.getName();
		System.out.println("Execution of " + className + "." + methodName + " ended in "
				+ new BigDecimal(elapsedTime).divide(new BigDecimal(1000000)) + " milliseconds");
	}

	@Override
	public void before(Method method, Object[] arg1, Object target) throws Throwable {
		startTime = System.nanoTime();
	}
	
	public void afterThrowing(Method method,Object[] args,Object target,Exception ex){
		String className = target.getClass().getCanonicalName();
		String methodName = method.getName();
		System.out.println("Execution of " + className + "." + methodName + " 抛出异常!");
	}
	
	public void doAfter(JoinPoint joinPoint){
	
	}
	
	public void doAround(ProceedingJoinPoint joinPoint){
		
	}
}