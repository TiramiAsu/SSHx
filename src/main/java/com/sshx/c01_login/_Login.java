/*
 * 
 * 
 * 
 * 
 * 
 * &copy;TiramiAsu
 * 
 */
package com.sshx.c01_login;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * <pre>
 * [注入自定義 Class] 2020-01-16 02:18
 * </pre>
 * 
 * @author TiramiAsu (Email)
 */
public class _Login {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		Login login_ref = (Login) context.getBean("login_ref");
		System.out.println(login_ref.verify("admin", "1234"));
		
		Login login_byType = context.getBean("login_byType", Login.class);
		System.out.println(login_byType.verify("admin", "1234"));
		
		Login login_byName = context.getBean("login_byType", Login.class);
		System.out.println(login_byName.verify("admin", "1234"));
		
	}
	
}
