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

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

/**
 * <pre>
 * [實作 StockDAO] 2020-02-05 20:27
 * </pre>
 * 
 * @author TiramiAsu (Email)
 */
@Repository
public class StockDAOImpl implements StockDAO {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public void create(Stock stock) {
		String sql = "INSERT INTO stock(id, code, name) VALUES (default, ?, ?);";
		Object[] data = { stock.getCode(), stock.getName() };
		jdbcTemplate.update(sql, data);
	}

	@Override
	public List<Stock> query() {
		String sql = "SELECT * FROM stock;";
		return jdbcTemplate.query(sql, new StockMapper());
	}

	@Override
	public Stock find(Long id) {
		String sql = "SELECT * FROM stock WHERE id=?;";
		Object[] data = { id };
		return jdbcTemplate.queryForObject(sql, data, new StockMapper());
	}

	@Override
	public void update(Long id, Stock stock) {
		Stock stk = find(id);
		if (!stk.equals(null) && !id.equals(null)) {
			String sql = "UPDATE stock SET code=?, name=? WHERE id=?;";
			Object[] data = {
					stock.getCode().equals("-") ? stk.getCode() : stock.getCode(),
					stock.getName().equals("-") ? stk.getName() : stock.getName(),
					id };
			jdbcTemplate.update(sql, data);
		}
	}

	@Override
	public void delete(Long id) {
		String sql = "DELETE FROM stock WHERE id=" + id;
		jdbcTemplate.execute(sql);
	}
	
	private class StockMapper implements RowMapper<Stock> {

		@Override
		public Stock mapRow(ResultSet rs, int rowNum) throws SQLException {
			Stock stock = new Stock(rs.getString("code"), rs.getString("name"));
			stock.setId(rs.getLong("id"));
			return stock;
		}
		
	}

}
