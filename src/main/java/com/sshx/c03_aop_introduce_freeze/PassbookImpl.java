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
 * [實作 存摺] 2020-01-23 13:09
 * </pre>
 * 
 * @author TiramiAsu (Email)
 */
public class PassbookImpl implements Passbook {
	
	// 現金
	private int cash;
	
	// 建構子
	public PassbookImpl(int cash) {
		this.cash = cash;
	}
	
	@Override
	public int getCash() {
		return this.cash;
	}

	@Override
	public void deposit(int cash) {
		// 存款存入 < 0 視為 0
		this.cash += (cash < 0) ? 0 : cash;
	}

	@Override
	public void withdrawal(int cash) {
		// 提款取出必須 >= 0, 且餘額必須 >= 0
		if (cash >= 0 && (this.cash - cash) >= 0) {
			this.cash -= cash;
		}
	}

}
