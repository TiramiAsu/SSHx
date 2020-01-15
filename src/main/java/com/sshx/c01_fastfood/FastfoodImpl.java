/*
 * 
 * 
 * 
 * 
 * 
 * &copy;TiramiAsu
 * 
 */
package com.sshx.c01_fastfood;

import java.util.Set;

/**
 * <pre>
 * [實作 Fastfood] 2020-01-16 02:03
 * </pre>
 * 
 * @author TiramiAsu (Email)
 */
@SuppressWarnings("rawtypes")
public class FastfoodImpl implements Fastfood {

	private Set foodSet;
	
	public FastfoodImpl() {}
	
	public FastfoodImpl(Set foodSet) {
		this.foodSet = foodSet;
	}

	@Override
	public void print() {
		System.out.println(foodSet);
	}

}
