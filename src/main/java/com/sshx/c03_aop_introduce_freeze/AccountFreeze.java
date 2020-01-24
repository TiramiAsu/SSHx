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
 * [帳戶凍結] 2020-01-16 17:20
 * </pre>
 * 
 * @author TiramiAsu (Email)
 */
public interface AccountFreeze<T> {
	void freeze();
	void unfreeze();
	boolean isFreeze();
	void confiscateCash(T t, int confiscateCash);
}
