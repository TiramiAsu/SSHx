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
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.support.JdbcDaoSupport;

/**
 * <pre>
 * [實作 BookDAO] 2020-02-05 19:05
 * </pre>
 * 
 * @author TiramiAsu (Email)
 */
public class BookDAOImpl extends JdbcDaoSupport implements BookDAO {

	@Override
	public void create(String title, String author, Integer price, Date time_publish) {
		String sql = "INSERT INTO book(id, title, author, price, time_publish) VALUES (default, ?, ?, ?, ?);";
		Object[] data = { title, author, price, time_publish };
		getJdbcTemplate().update(sql, data);
	}

	@Override
	public List<Map<String, Object>> query() {
		String sql = "SELECT * FROM book;";
		return getJdbcTemplate().queryForList(sql);
	}

	@Override
	public Map<String, Object> find(Long id) {
		String sql = "SELECT * FROM book WHERE id=?;";
		Object[] data = { id };
		return getJdbcTemplate().queryForMap(sql, data);
	}

	@Override
	public void update(Long id, String title, String author, Integer price, Date time_publish) {
		String sql = "UPDATE book SET title=?, author=?, price=?, time_publish=? WHERE id=?;";
		Object[] data = { title, author, price, time_publish, id };
		getJdbcTemplate().update(sql, data);
	}

	@Override
	public void delete(Long id) {
		String sql = "DELETE FROM book WHERE id=" + id;
		getJdbcTemplate().execute(sql);
	}

}
