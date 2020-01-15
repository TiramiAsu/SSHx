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
 * [實作 Login] 2020-01-16 02:17
 * </pre>
 * 
 * @author TiramiAsu (Email)
 */
public class LoginImpl implements Login {
	
	private UserDAO userDAO;

	// xml 設定使用 ref, 必須提供 set 方法
	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}
	
	@Override
	public boolean verify(String username, String password) {
		return userDAO.find(username, password);
	}

}
