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

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sshx.dao.GenericDAO;

/**
 * <pre>
 * [實作通用 DAO] 2020-02-09 10:53
 * </pre>
 * 
 * @author TiramiAsu (Email)
 */
@Repository
public class GenericDAOImpl<T> implements GenericDAO<T> {
	
	@Autowired
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	@Override
	@Transactional
	public void create(T bean) {
		sessionFactory.getCurrentSession().save(bean);
	}

	@Override
	@Transactional
	@SuppressWarnings("unchecked")
	public List<T> query(Class<T> clazz) {
		return sessionFactory.getCurrentSession()
				.createQuery("FROM " + clazz.getSimpleName()).list();
	}

	@Override
	@Transactional
	public T find(Long id, Class<T> clazz) {
		return sessionFactory.getCurrentSession()
				.get(clazz, id);
	}

	@Override
	@Transactional
	public void update(Long id, T bean) {
		sessionFactory.getCurrentSession().update(bean);
	}

	@Override
	@Transactional
	public void delete(Long id, T bean) {
		sessionFactory.getCurrentSession().delete(bean);
	}

}
