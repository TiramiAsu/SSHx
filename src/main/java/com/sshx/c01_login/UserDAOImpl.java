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
 * [實作 UserDAO] 2020-01-16 02:15
 * </pre>
 * 
 * @author TiramiAsu (Email)
 */
public class UserDAOImpl implements UserDAO {

	@Override
	public boolean find(String username, String password) {
		if (username.equals("admin") && password.equals("1234")) {
			return true;
		}
		return false;
	}

}
