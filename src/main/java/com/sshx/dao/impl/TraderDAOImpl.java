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

import com.sshx.dao.TraderDAO;
import com.sshx.entity.Trader;

/**
 * <pre>
 * [實作 TraderDAO] 2020-03-10 01:54
 * </pre>
 * 
 * @author TiramiAsu (Email)
 */
@Repository
public class TraderDAOImpl extends GenericDAOImpl<Trader> implements TraderDAO {

	@Override
	@Transactional
	public Trader find(String name) {
		String hql = "FROM trader WHERE name = :name";
		Query<Trader> query = getSessionFactory().getCurrentSession().createQuery(hql, Trader.class);
		query.setParameter("name", name).setMaxResults(1);
		List<Trader> list = query.list();
		return list.size() > 0 ? list.get(0) : null;
	}
}
