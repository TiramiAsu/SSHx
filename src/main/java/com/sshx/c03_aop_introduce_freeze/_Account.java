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

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * <pre>
 * [帳務凍結範例: 使用 introduce] 2020-01-16 17:23
 * </pre>
 * 
 * @author TiramiAsu (Email)
 */
public class _Account {

	@SuppressWarnings({ "resource", "unchecked" })
	public static void main(String[] args) {

		ApplicationContext application = new ClassPathXmlApplicationContext("aop_introduce_freeze.xml");
		Passbook passbook = application.getBean("passbook", Passbook.class);

		/** 帳戶狀態: 正常 */
		System.out.println("開戶, 存款餘額: " + passbook.getCash());

		// 存款
		passbook.deposit(30_000);
		passbook.deposit(5_000_000);
		System.out.println("存入 3萬, 5百萬 後, 帳戶餘額: " + passbook.getCash());

		// 提款
		passbook.withdrawal(2_000);
		System.out.println("提出 2千 後, 帳戶餘額: " + passbook.getCash());

		// 帳戶狀態: 凍結
		try {
			Thread.sleep(2000);
			System.err.println(">>> 查到疑似有不法贓款, 凍結該帳戶 <<<");
			((AccountFreeze<Passbook>)passbook).freeze();

			// 被查到了, 趕快提款
			System.out.println("帳戶餘額: " + passbook.getCash()); // 可執行
			passbook.withdrawal(4_000_000); // 拋出例外

			// 來看看有沒有提款成功
			System.out.println("帳戶餘額: " + passbook.getCash()); // 因拋出例外, 此行不執行

		} catch (Exception e) {
			System.err.println(e.getMessage());
			try {
				System.err.println(">>> 5百萬 確認為不法贓款 <<<");
				((AccountFreeze<Passbook>)passbook).unfreeze(); // 先解除凍結, 才可以沒收
				passbook.withdrawal(5_000_000); // 沒收
				
				Thread.sleep(2000);
				System.err.println(">>> 已沒收 5百萬 不法贓款 <<<");
				
				// 帳戶餘額為 29_000
				System.out.println("帳戶餘額: " + passbook.getCash());
			} catch (Exception ex) {
				System.err.println(ex.getMessage());
			}
		}
	}
}
