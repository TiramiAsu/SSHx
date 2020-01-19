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

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sshx.c02_aop_execution.subpkg.PackageAOP;

/**
 * <pre>
 * [AOP: execution 表達式] 2020-01-16 16:37
 * 
 * [execution 表達式]
 * execution(modifiers-pattern? ret-type-pattern declaring-type-pattern name-pattern(param-pattern) throws-pattern?)
 * execution(<修飾子模式>? <返回類型模式> <方法名模式>(<參數模式>) <異常模式>?)
 * - ? 表示選擇性設置
 * </pre>
 * 
 * @author TiramiAsu (Email)
 */
public class _Execution {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("aop_execution.xml");
		ClassAOP classAOP = (ClassAOP) context.getBean("classAOP");

		/* 修飾子模式
		execution(public * com.sshx.c02_aop_execution.ClassAOP.* (..))
		execution(protected * com.sshx.c02_aop_execution.ClassAOP.* (..))
		execution(* com.sshx.c02_aop_execution.ClassAOP.* (..))
		 */
		classAOP.modifiers_public();
		classAOP.modifiers_protected();
		
		/* 返回類型模式
		execution(boolean com.sshx.c02_aop_execution.ClassAOP.*(..))
		execution(java.util.List com.sshx.c02_aop_execution.ClassAOP.*(..))
		 */
		classAOP.return_boolean();
		classAOP.return_List();
		
		/* 方法名模式
		execution(* com.sshx.c02_aop_execution.ClassAOP.method* (..))
		execution(* com.sshx.c02_aop_execution.ClassAOP.*aop (..))
		execution(* com.sshx.c02_aop_execution.ClassAOP.*aop* (..))
		 */
		classAOP.method_aop();
		classAOP.method_aop_test();
		
		/* 參數模式
		execution(* com.sshx.c02_aop_execution.ClassAOP.*(..))
		execution(* com.sshx.c02_aop_execution.ClassAOP.*(*))
		execution(* com.sshx.c02_aop_execution.ClassAOP.*(*, Integer))
		execution(* com.sshx.c02_aop_execution.ClassAOP.*(*, String))
		 */
		classAOP.args_one("Hello");
		classAOP.args_two("World", 999);
		classAOP.args_two("SSH", "JAVA");
		
		/* 異常模式 - 未完成
		 */
		try {
			classAOP.throws_io();
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			classAOP.throw_sql();
		} catch (Exception e) {
			e.printStackTrace();
		}

		/** 進階 - package
		execution(* com.sshx.c02_aop_execution.ClassAOP.*(..))
		execution(* com.sshx.c02_aop_execution.*AOP.*(..))
		execution(* com.sshx.c02_aop_execution..*AOP.*(..))
		 */
		// OtherAOP
		OtherAOP otherAOP = context.getBean(OtherAOP.class);
		otherAOP.otherAOP();
		
		// PackageAOP
		PackageAOP packageAOP = context.getBean(PackageAOP.class);
		packageAOP.packageAOP();
		
	}
}
