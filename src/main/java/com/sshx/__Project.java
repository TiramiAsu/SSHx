/*
 * 
 * 
 * 
 * 
 * 
 * &copy;TiramiAsu
 * 
 */
package com.sshx;

/**
 * <pre>
 * [Spring 專案範例] 2020-02-09 14:29
 * - Spring 配置 (+Hibernate)
 * - JPA 配置
 * - PostgreSQL 連線配置於 datasource.xml
 * - Table 級聯關係配置於 bean 中
 * - DAOImpl 註冊於 applicationContext.xml
 * 
 * </pre>
 * 
 * @author TiramiAsu (Email)
 */
public interface __Project {
	/*
	 * [Implement Flow]
	 * ">" : require
	 * "o" : choose one
	 */
	/**- 1 Bean:
	 * -	> Stock(Long id, String title, String author, Integer price, Date time_publish, Set<Fund> funds)
	 * -	> Fund(Long id, String name, String desc, FundNet fundNet, Set<Stock> stocks)
	 * -	> FundNet(Long id, Integer value, Fund fund)
	 * -	> Trader(Long id, String name, Fund fund)
	 * - 2 GenericDAO: CRUD
	 * -	> public void create(T bean);
	 * -	> public List<T> query();
	 * -	> public T find(Long id);
	 * -	> public void update(Long id, T bean);
	 * -	> public void delete(Long id); */
	/* - 3 DAOImpl: 使用 JdbcTemplate 實作
	 * -	o 繼承 JdbcDaoSupport, 取得 JdbcTemplate 使用
	 * -	o 不繼承 JdbcDaoSupport, 於 xml 配置 JdbcTemplate
	 * -	> RowMapper<T> 實作, 完成映射
	 * - 4 Setting proj-datasource.xml
	 * -	> set dataSource
	 * -	> set connection pool */
	/**-	> set sessionFactory
	 * -	  > org.springframework.orm.hibernate5.LocalSessionFactoryBean:
	 * -	    > dataSource -> ref
	 * -	    > packagesToScan -> list -> value -> path
	 * -	    > hibernateProperties -> props -> ...
	 * -	> set transactionManager
	 * -	  > org.springframework.orm.hibernate5.HibernateTransactionManager:
	 * -	    > sessionFactory -> ref
	 * -	> set tx:annotation-driven
	 * - 5 Setting JPA: setting Entity
	 * - 6 Setting proj-spring.cfg.xml
	 * -	> import proj-datasource.xml */
	/* -	> set bean(DAO, DAOImpl) */
	/**- 7 Show Data
	 * -	o console <--> DAO <--> DB
	 * -	o JSP <--> Servlet <--> DAO <--> DB
	 */
}
