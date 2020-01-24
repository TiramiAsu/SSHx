/*
 * 
 * 
 * 
 * 
 * 
 * &copy;TiramiAsu
 * 
 */
package com.sshx.c03_connectionpool;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;

import com.mchange.v2.c3p0.ComboPooledDataSource;

/**
 * <pre>
 * [JDBC] 2020-01-23 14:22
 * - 連線資料庫
 * </pre>
 * 
 * @author TiramiAsu (Email)
 */
public class _JDBC {

	public static void main(String[] args) throws Exception {
		
		// 1：資料來源設定
		ComboPooledDataSource dataSource = new ComboPooledDataSource();
		dataSource.setDriverClass("org.postgresql.Driver");
		dataSource.setJdbcUrl("jdbc:postgresql://localhost:5432/sshx");
		dataSource.setUser("postgres");
		dataSource.setPassword("postgres");
		dataSource.setMaxPoolSize(10);
		System.out.println(dataSource.getJdbcUrl());

		// 2：建立 JdbcTemplate
		JdbcTemplate jt = new JdbcTemplate(dataSource);

		// 3.1：新增 SQL
		/*
		CREATE TABLE public.book (
			id bigserial NOT NULL,
			title character varying(255) NOT NULL,
			author character varying(255) NOT NULL,
			price integer NOT NULL,
			time_publish timestamp without time zone NOT NULL,
			PRIMARY KEY (id)
		) WITH ( OIDS = FALSE );
		ALTER TABLE public.book OWNER to postgres;
		 */
		String sql_insert = "INSERT INTO book(id, title, author, price, time_publish) VALUES (default, ?, ?, ?, ?);";

		// 3.2：設置 SQL 參數
		Object[] data = { "Java", "oracle", 500, new Timestamp(System.currentTimeMillis()) };

		// 4：執行 sql 語句: 新增/更新資料
		jt.update(sql_insert, data);

		Thread.sleep(1000);

		// 5：查詢資料
		String sql_select = "SELECT id, title, author, price, time_publish FROM book;";
		List<Map<String, Object>> list = jt.queryForList(sql_select);
		System.out.println(list);

		// 取得時間
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd a hh:mm:ss E");
		list.stream().forEach(e -> {
			System.out.println(sdf.format(e.get("time_publish")));
		});

		// 5: 查詢 ID 為 1 的 author
		String sql_select_author = "SELECT author FROM book WHERE id = ?;";
		String author = jt.queryForObject(sql_select_author, new Object[] { 1 }, String.class);
		System.out.println(author);
		
		// 6: 修改 ID 為 1 的資料
		String sql_update = "UPDATE book SET title=?, author=? WHERE id=?;";
		Object[] data_update = {"JavaSSH", "Asu", 1};
		jt.update(sql_update, data_update);
		List<Map<String, Object>> listAll = jt.queryForList(sql_select);
		listAll.stream().forEach(System.out::println);
		
	}

}
