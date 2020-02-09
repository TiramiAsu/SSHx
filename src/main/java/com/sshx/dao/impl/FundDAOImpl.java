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

import com.sshx.dao.FundDAO;
import com.sshx.entity.Fund;

/**
 * <pre>
 * [實作 FundDAO] 2020-02-09 12:53
 * </pre>
 * 
 * @author TiramiAsu (Email)
 */
@Repository
public class FundDAOImpl extends GenericDAOImpl<Fund> implements FundDAO {

	@Override
	@Transactional
	public Fund find(String name) {
		String hql = "FROM Fund WHERE name = :name"; // Fund 為 className
		Query<Fund> query = getSessionFactory().getCurrentSession().createQuery(hql, Fund.class);
		query.setParameter("name", name).setMaxResults(1);
		List<Fund> list = query.list();
		return list.size() > 0 ? list.get(0) : null;
	}

}
