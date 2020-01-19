/*
 * 
 * 
 * 
 * 
 * 
 * &copy;TiramiAsu
 * 
 */
package com.sshx.c02_aop;

/**
 * <pre>
 * [定義 UserService] 2020-01-16 16:33
 * </pre>
 * 
 * @author TiramiAsu (Email)
 */
public interface UserService {
	void query();
	void find();
	void save(String name) throws Exception; // create, update
	void delete();
}
