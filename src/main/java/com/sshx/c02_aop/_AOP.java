/*
 * 
 * 
 * 
 * 
 * 
 * &copy;TiramiAsu
 * 
 */
package com.sshx.c02_aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * <pre>
 * [AOP: 切面] 2020-01-16 17:21
 * </pre>
 * 
 * @author TiramiAsu (Email)
 */
public class _AOP {
	
	@SuppressWarnings("resource")
	public static void main(String[] args) throws Exception {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("aop_advice.xml");
		UserService userService = context.getBean(UserService.class);

		userService.query();
		userService.save("TiramiAsu");
	}
	
}
