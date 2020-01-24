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

import org.aopalliance.intercept.MethodInvocation;
import org.springframework.aop.framework.AopConfigException;
import org.springframework.aop.support.DelegatingIntroductionInterceptor;

/**
 * <pre>
 * [凍結帳戶] 2020-01-23 13:54
 * - 當帳戶被鎖定, 則無法提款或存款
 * </pre>
 * 
 * @author TiramiAsu (Email)
 */
@SuppressWarnings("serial")
public class AccountFreezeImpl extends DelegatingIntroductionInterceptor implements AccountFreeze<Passbook> {

	private boolean freeze;
	
	@Override
	public void freeze() {
		this.freeze = true;
	}

	@Override
	public void unfreeze() {
		this.freeze = false;
	}

	@Override
	public boolean isFreeze() {
		return this.freeze;
	}

	@Override
	public void confiscateCash(Passbook passbook, int confiscateCash) {
		int residual = passbook.getCash() - confiscateCash;
		if (residual >= 0) {
			// 有剩餘, 直接沒收贓款
			passbook.withdrawal(confiscateCash);
		} else {
			// 無剩餘, 直接沒收剩下的金額
			passbook.withdrawal(passbook.getCash());
		}
	}
	
	@Override
	public Object invoke(MethodInvocation mi) throws Throwable {
		// 凍結帳戶, 限制調用方法
		if ((isFreeze() && mi.getMethod().getName().indexOf("deposit") == 0) ||
			(isFreeze() && mi.getMethod().getName().indexOf("withdrawal") == 0)) {
//			System.out.println(mi.getMethod().getName().indexOf("deposit") + " <<<");
//			System.out.println(mi.getMethod().getName().indexOf("withdrawal") + " <<<");
			throw new AopConfigException("此帳戶已被凍結");
		}
		return super.invoke(mi);
	}

}
