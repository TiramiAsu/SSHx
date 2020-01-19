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

import org.springframework.aop.support.DelegatingIntroductionInterceptor;

/**
 * <pre>
 * [實作智能汽車] 2020-01-19 12:18
 * </pre>
 * 
 * @author TiramiAsu (Email)
 */
@SuppressWarnings("serial")
public class IntelligentCar extends DelegatingIntroductionInterceptor implements Intelligent {

	@Override
	public void selfDriving() {
		System.out.println("切換為自動駕駛...");
	}

}
