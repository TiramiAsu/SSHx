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

import com.sshx.dao.InvestorDAO;
import com.sshx.entity.Investor;

/**
 * <pre>
 * [實作 InvestorDAO] 2020-03-11 12:38
 * </pre>
 * 
 * @author TiramiAsu (Email)
 */
@Repository
public class InvestorDAOImpl extends GenericDAOImpl<Investor> implements InvestorDAO {

	@Override
	@Transactional
	public Investor find(String name) {
		String hql = "FROM Investor WHERE name = :name";
		Query<Investor> query = getSessionFactory().getCurrentSession().createQuery(hql, Investor.class);
		query.setParameter("name", name).setMaxResults(1);
		List<Investor> list = query.list();
		return list.size() > 0 ? list.get(0) : null;
	}
}
