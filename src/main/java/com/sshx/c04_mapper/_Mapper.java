/*
 * 
 * 
 * 
 * 
 * 
 * &copy;TiramiAsu
 * 
 */
package com.sshx.c04_mapper;

/**
 * <pre>
 * [Mapper used for CRUD] 2020-02-05 02:29
 * ">" : require
 * "o" : choose one
 * 
 * [Implement Flow]
 * - 1 Bean:
 * -	> Stock(Long id, String code, String name)
 * - 2 DAO: CRUD
 * -	> public void create(Stock stock);
 * -	> public List<Stock> query();
 * -	> public Stock find(Long id);
 * -	> public void update(Long id, Stock stock);
 * -	> public void delete(Long id);
 * - 3 DAOImpl: 使用 JdbcTemplate 實作
 * -	o 繼承 JdbcDaoSupport, 取得 JdbcTemplate 使用
 * -	o 不繼承 JdbcDaoSupport, 於 xml 配置 JdbcTemplate
 * -	> RowMapper<T> 實作, 完成映射
 * - 4 Setting proj-datasource.xml
 * -	> set dataSource
 * -	> set connection pool
 * -	> set bean(DAO, DAOImpl)
 * </pre>
 * 
 * @author TiramiAsu (Email)
 */
public class _Mapper {

	/*
	CREATE TABLE public.stock (
		id bigserial NOT NULL,
		code character varying(127) NOT NULL UNIQUE,
		name character varying(127) NOT NULL,
		PRIMARY KEY (id)
	) WITH ( OIDS = FALSE );
	ALTER TABLE public.stock OWNER to postgres;
	 */
	
	private static StockDAO stockDAO;
	
	static {
		stockDAO = SpringUtils.getBean(StockDAO.class);
	}

	public static void main(String[] args) {
//		create(new Stock("2330", "台雞電"));
//		create(new Stock("3008", "大立光"));
//		create(new Stock("2303", "聯電"));
		query();
//		System.out.println(find(1L));
//		update(1L, new Stock("2330", "台積電"));
//		delete(1L);
	}
	
	public static void create(Stock stock) {
		stockDAO.create(stock);
		query();
	}
	
	public static void query() {
		stockDAO.query().stream().forEach(System.out::println);
	}
	
	public static Stock find(Long id) {
		return stockDAO.find(id);
	}
	
	public static void update(Long id, Stock stock) {
		stockDAO.update(id, stock);
		query();
	}
	
	public static void delete(Long id) {
		stockDAO.delete(id);
		query();
	}
}
