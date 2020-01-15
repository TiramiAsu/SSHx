/*
 * 
 * 
 * 
 * 
 * 
 * &copy;TiramiAsu
 * 
 */
package com.sshx.c01_hello;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * <pre>
 * [使用 spring 注入 class] 2020-01-16 00:07
 * </pre>
 * 
 * @author TiramiAsu (Email)
 */
public class _HelloSpring {

	@SuppressWarnings("resource")
	public static void main(String[] args) {

		// new
		Hello helloNew = new HelloImpl();
		helloNew.print();

		// spring
//		ApplicationContext context = new FileSystemXmlApplicationContext("C://temp/applicationContext.xml");
//		ApplicationContext context = new FileSystemXmlApplicationContext("./src/main/java/resources/applicationContext.xml");
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		Hello helloSpring = (Hello) context.getBean("helloSpring");
		helloSpring.print();

	}

}
