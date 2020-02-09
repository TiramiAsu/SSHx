/*
 * 
 * 
 * 
 * 
 * 
 * &copy;TiramiAsu
 * 
 */
package com.sshx.utils;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import com.sshx.entity.Stock;
import com.sshx.dao.StockDAO;

/**
 * <pre>
 * [Spring 工具類] 2020-02-05 12:50
 * </pre>
 * 
 * @author TiramiAsu (Email)
 */
@Component
public class SpringUtils {

	public static ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

	public static Object getBean(String id) {
		return context.getBean(id, Object.class);
	}

	public static <T>T getBean(Class<T> clazz) {
		return context.getBean(clazz);
	}
	
	public static <T>T getBean(String id, Class<T> clazz) {
		return context.getBean(id, clazz);
	}
	
	// test
	public static void main(String[] args) {
		StockDAO stockDAO = context.getBean(StockDAO.class);
		stockDAO.query(Stock.class).stream().forEach(System.out::println);
	}
}
