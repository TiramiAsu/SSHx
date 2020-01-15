/*
 * 
 * 
 * 
 * 
 * 
 * &copy;TiramiAsu
 * 
 */
package com.sshx.c01_login;

/**
 * <pre>
 * [定義 UserDAO] 2020-01-16 02:14
 * </pre>
 * 
 * @author TiramiAsu (Email)
 */
public interface UserDAO {
	boolean find(String username, String password);
}
