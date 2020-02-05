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

import java.util.List;

/**
 * <pre>
 * [定義 StockDAO] 2020-02-05 20:26
 * </pre>
 * 
 * @author TiramiAsu (Email)
 */
public interface StockDAO {
	public void create(Stock stock);
	public List<Stock> query();
	public Stock find(Long id);
	public void update(Long id, Stock stock);
	public void delete(Long id);
}
