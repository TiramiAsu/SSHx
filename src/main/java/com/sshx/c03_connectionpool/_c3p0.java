/*
 * 
 * 
 * 
 * 
 * 
 * &copy;TiramiAsu
 * 
 */
package com.sshx.c03_connectionpool;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.mchange.v2.c3p0.ComboPooledDataSource;

/**
 * <pre>
 * [使用 properties 配置 c3p0] 2020-01-23 14:17
 * </pre>
 * 
 * @author TiramiAsu (Email)
 */
public class _c3p0 {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("connectionpool.cfg.xml");
		ComboPooledDataSource datasource = context.getBean("dataSource", ComboPooledDataSource.class);
		System.out.println(datasource.getDriverClass());
		System.out.println(datasource.getJdbcUrl());
		System.out.println(datasource.getUser());
		System.out.println(datasource.getPassword());
		System.out.println(datasource.getMaxPoolSize());
		
	}
	
}
