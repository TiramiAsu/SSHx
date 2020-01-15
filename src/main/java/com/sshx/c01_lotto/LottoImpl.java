/*
 * 
 * 
 * 
 * 
 * 
 * &copy;TiramiAsu
 * 
 */
package com.sshx.c01_lotto;

import java.util.LinkedHashSet;
import java.util.Random;
import java.util.Set;

/**
 * <pre>
 * [實作 Lotto] 2020-01-16 00:30
 * </pre>
 * 
 * @author TiramiAsu (Email)
 */
public class LottoImpl implements Lotto {
	
	private int count;
	
	public LottoImpl() {}
	
	public LottoImpl(int count) {
		this.count = count;
	}
	
	public LottoImpl(int a, int b) {
		this.count = (int) Math.pow(a, b);
	}
	
	@Override
	public void print() {
		Set<Integer> nums = new LinkedHashSet<>();
		while (nums.size() < this.count) {
			nums.add(new Random().nextInt(100));
		}
		System.out.println(nums);
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

}
