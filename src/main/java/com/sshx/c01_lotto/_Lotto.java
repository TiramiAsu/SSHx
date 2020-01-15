/*
 * 
 * 
 * 
 * 
 * 
 * &copy;TiramiAsu
 * 
 */
package com.sshx.c01_lotto;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * <pre>
 * [建構 class 時注入參數] 2020-01-16 00:36
 * </pre>
 * 
 * @author TiramiAsu (Email)
 */
public class _Lotto {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		Lotto lottoName = (Lotto) context.getBean("lotto_name");
		lottoName.print();
		
	}
	
}
