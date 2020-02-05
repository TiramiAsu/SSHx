/*
 * 
 * 
 * 
 * 
 * 
 * &copy;TiramiAsu
 * 
 */
package com.sshx.c04_jdbc;

import java.util.Date;
import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * <pre>
 * [CRUD] 2020-02-01 17:43
 * ">" : require
 * "o" : choose one
 * 
 * [Implement Flow]
 * - 1 Bean:
 * -	> Book(Long id, String title, String author, Integer price, Date time_publish)
 * - 2 DAO: CRUD
 * -	> public void create(String title, String author, Integer price, Date time_publish);
 * -	> public List<Map<String, Object>> query();
 * -	> public Map<String, Object> find(Long id);
 * -	> public void update(Long id, String title, String author, Integer price, Date time_publish);
 * -	> public void delete(Long id);
 * - 3 DAOImpl: 使用 JdbcTemplate 實作
 * -	o 繼承 JdbcDaoSupport, 取得 JdbcTemplate 使用
 * -	o 不繼承 JdbcDaoSupport, 於 xml 配置 JdbcTemplate
 * - 4 Setting proj-datasource.xml
 * -	> set dataSource
 * -	> set connection pool
 * -	> set bean(DAO, DAOImpl)
 * </pre>
 * 
 * @author TiramiAsu (Email)
 */
public class _CRUD {
	
	private static BookDAO bookDAO;
	
	static {
		@SuppressWarnings("resource")
		ApplicationContext ctx = new ClassPathXmlApplicationContext("jdbc_datasource.cfg.xml");
		bookDAO = ctx.getBean(BookDAO.class);
	}

	public static void main(String[] args) {
//		create("Java of Spring", "springframework", 999, new Date());
		query();
//		System.out.println(find(5L));
//		update(5L, "Spring", "springframework", 999, new Date());
//		delete(5L);
	}
	
	public static void create(String title, String author, Integer price, Date time_publish) {
		bookDAO.create(title, author, price, time_publish);
		query();
	}
	
	public static void query() {
		bookDAO.query().stream().forEach(System.out::println);
	}
	
	public static Map<String, Object> find(Long id) {
		return bookDAO.find(id);
	}
	
	public static void update(Long id, String title, String author, Integer price, Date time_publish) {
		bookDAO.update(id, title, author, price, time_publish);
		query();
	}
	
	public static void delete(Long id) {
		bookDAO.delete(id);
		query();
	}
	
}
