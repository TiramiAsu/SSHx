/*
 * 
 * 
 * 
 * 
 * 
 * &copy;TiramiAsu
 * 
 */
package com.sshx.c01_fastfood;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * <pre>
 * [建構 class 時注入集合] 2020-01-16 01:59
 * </pre>
 * 
 * @author TiramiAsu (Email)
 */
public class _Fastfood {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

		Fastfood ff_set = (Fastfood) context.getBean("fastfood_set");
		ff_set.print();
		
		System.out.println();
		
		Fastfood ff_list = (Fastfood) context.getBean("fastfood_list");
		ff_list.print();
		
	}
	
}
