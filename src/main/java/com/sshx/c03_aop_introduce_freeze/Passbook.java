/*
 * 
 * 
 * 
 * 
 * 
 * &copy;TiramiAsu
 * 
 */
package com.sshx.c03_aop_introduce_freeze;

/**
 * <pre>
 * [定義 存摺] 2020-01-16 17:21
 * </pre>
 * 
 * @author TiramiAsu (Email)
 */
public interface Passbook {
	int getCash();
	void deposit(int cash); // 存款
	void withdrawal(int cash); // 提款
}
