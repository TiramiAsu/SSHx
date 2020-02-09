/*
 * 
 * 
 * 
 * 
 * 
 * &copy;TiramiAsu
 * 
 */
package com.sshx.dao;

import com.sshx.entity.Stock;

/**
 * <pre>
 * [定義 StockDAO] 2020-02-02 21:35
 * </pre>
 * 
 * @author TiramiAsu (Email)
 */
public interface StockDAO extends GenericDAO<Stock> {
	Stock find(String code);
}
