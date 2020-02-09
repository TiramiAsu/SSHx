/*
 * 
 * 
 * 
 * 
 * 
 * &copy;TiramiAsu
 * 
 */
package com.sshx.dao.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import com.sshx.dao.StockDAO;
import com.sshx.entity.Stock;

/**
 * <pre>
 * [實作 StockDAO] 2020-02-02 21:37
 * </pre>
 * 
 * @author TiramiAsu (Email)
 */
@Repository
public class StockDAOImpl extends GenericDAOImpl<Stock> implements StockDAO {

	@Override
	@Transactional
	public Stock find(String code) {
		String hql = "FROM Stock WHERE code = :code"; // Stock 為 className
		Query<Stock> query = getSessionFactory().getCurrentSession().createQuery(hql, Stock.class);
		query.setParameter("code", code).setMaxResults(1); // 僅回傳一筆資料回來
		List<Stock> list = query.list();
		return list.size() > 0 ? list.get(0) : null;
	}

}
