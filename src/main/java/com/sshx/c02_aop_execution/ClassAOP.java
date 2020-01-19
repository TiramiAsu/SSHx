/*
 * 
 * 
 * 
 * 
 * 
 * &copy;TiramiAsu
 * 
 */
package com.sshx.c02_aop_execution;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

/**
 * <pre>
 * [測試 AOP] 2020-01-16 16:39
 * </pre>
 * 
 * @author TiramiAsu (Email)
 */
public class ClassAOP {

	public void modifiers_public() {
		System.out.println("modifiers_public");
	}
	
	protected void modifiers_protected() {
		System.out.println("modifiers_protected");
	}
	
	public boolean return_boolean() {
		System.out.println("return_boolean");
		return true;
	}
	
	public List<String> return_List() {
		System.out.println("return_List");
		return Arrays.asList(new String[]{"apple", "banana"});
	}
	
	public void method_aop() {
		System.out.println("method_aop");
	}
	
	public void method_aop_test() {
		System.out.println("method_aop_test");
	}
	
	public void args_one(String s) {
		System.out.println("args_one: " + s);
	}
	
	public void args_two(String s, Integer num) {
		System.out.println("args_two(String, Integer): " + s + ":" + num);
	}
	
	public void args_two(String s, String ss) {
		System.out.println("args_two(String, String): " + s + ":" + ss);
	}
	
	public void throws_io() throws IOException {
		System.out.println("throws_io");
	}
	
	public void throw_sql() throws SQLException {
		System.out.println("throws_sql");
	}

}
