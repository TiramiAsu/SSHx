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

/**
 * <pre>
 * [實作我的汽車] 2020-01-19 12:15
 * </pre>
 * 
 * @author TiramiAsu (Email)
 */
public class MyCar implements Auto {

	@Override
	public void driving() {
		System.out.println("開車中");
	}
	
	// 使用 Introduce, 在不變更 MyCar 的情況下, 增加 selfDriving()
//	public void selfDriving() {
//	System.out.println("切換為自動駕駛...");
//}

}
