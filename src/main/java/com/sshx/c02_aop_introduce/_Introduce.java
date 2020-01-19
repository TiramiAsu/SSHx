/*
 * 
 * 
 * 
 * 
 * 
 * &copy;TiramiAsu
 * 
 */
package com.sshx.c02_aop_introduce;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * <pre>
 * [AOP: Introduce] 2020-01-16 16:41
 * - 對於一個現存的物件, Introduction 可以為其增加行為，而不用修改該類別的程式
 * - 在某個已撰寫、編譯完成的物件，在執行時期動態加入一些方法或行為，而不用修改或新增任何一行程式碼
 * 
 * [實作]
 * - 介紹類實作要繼承 DelegatingIntroductionInterceptor
 * </pre>
 * 
 * @author TiramiAsu (Email)
 */
public class _Introduce {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("aop_introduce.xml");
		
		Auto car = (Auto) context.getBean("myCar");
		car.driving();
		// car.selfDriving();
		
		System.out.println();
		
		Auto selfCar = (Auto) context.getBean("intelligentCar");
		selfCar.driving();
		((Intelligent)selfCar).selfDriving();
		
	}
	
}
