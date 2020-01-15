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

import java.util.List;
import java.util.Map;
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
	private List drinkList;
	private Map packageMap;
	
	public FastfoodImpl() {}
	
	public FastfoodImpl(Set foodSet) {
		this.foodSet = foodSet;
	}
	
	public FastfoodImpl(List drinkList) {
		this.drinkList = drinkList;
	}
	
	public FastfoodImpl(Map packageMap) {
		this.packageMap = packageMap;
	}

	public FastfoodImpl(Set foodSet, List drinkList, Map packageMap) {
		this.foodSet = foodSet;
		this.drinkList = drinkList;
		this.packageMap = packageMap;
	}

	@Override
	public void print() {
		System.out.println(foodSet);
		System.out.println(drinkList);
		System.out.println(packageMap);
		System.out.println();
	}

}
