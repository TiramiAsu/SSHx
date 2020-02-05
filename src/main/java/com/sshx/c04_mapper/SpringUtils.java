/*
 * 
 * 
 * 
 * 
 * 
 * &copy;TiramiAsu
 * 
 */
package com.sshx.c04_mapper;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * <pre>
 * [Spring utils] 2020-02-05 21:28
 * </pre>
 * 
 * @author TiramiAsu (Email)
 */
public class SpringUtils {

	private static ApplicationContext applicationContext = new ClassPathXmlApplicationContext("jdbc_mapper.xml");

	public static Object getBean(String id) {
		return applicationContext.getBean(id, Object.class);
	}

	public static <T> T getBean(Class<T> clazz) {
		return applicationContext.getBean(clazz);
	}

	public static <T> T getBean(String id, Class<T> clazz) {
		return applicationContext.getBean(id, clazz);
	}

}
