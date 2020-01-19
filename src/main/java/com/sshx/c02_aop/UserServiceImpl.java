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
 * [實作 UserService] 2020-01-19 01:29
 * </pre>
 * 
 * @author TiramiAsu (Email)
 */
public class UserServiceImpl implements UserService {

	@Override
	public void query() {
		System.out.println(">>> Query <<<");
	}

	@Override
	public void find() {
		System.out.println(">>> Find <<<");
	}

	@Override
	public void save(String name) throws Exception {
		System.out.println(">>> Save: " + name + " <<<");
//		throw new Exception("!!! ERROR !!!");
	}

	@Override
	public void delete() {
		System.out.println(">>> Delete <<<");
	}

}
