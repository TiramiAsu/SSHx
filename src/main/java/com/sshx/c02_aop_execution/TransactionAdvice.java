/*
 * 
 * 
 * 
 * 
 * 
 * &copy;TiramiAsu
 * 
 */
package com.sshx.c02_aop_execution;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

/**
 * <pre>
 * [AOP 處理動作] 2020-01-19 01:28
 * </pre>
 * 
 * @author TiramiAsu (Email)
 */
public class TransactionAdvice {

	public void before(JoinPoint joinPoint) {
		if (joinPoint.getArgs() != null && joinPoint.getArgs().length > 0) {
			System.out.println("\n前置通知被執行:" + joinPoint.getArgs()[0]);
		} else {
			System.out.println("\n前置通知被執行");
		}
	}

	public void after(JoinPoint joinPoint) {
		System.out.println("後置通知被執行(不論有無錯誤發生)");
	}

	public void afterReturning(JoinPoint joinPoint) {
		System.out.println("後置通知被執行(\"無\"錯誤發生)\n");
	}

	public void afterThrowing(JoinPoint joinPoint) {
		System.out.println("後置通知被執行(\"有\"錯誤發生)\n");
	}

	public Object around(ProceedingJoinPoint point) throws Throwable{
		System.out.println("環繞通知 Begin");
		Object[] objs = point.getArgs();
		Object proceed = point.proceed(objs); // update(), save() etc...
		System.out.println("環繞通知 End");
		return proceed;
	}
	
}
