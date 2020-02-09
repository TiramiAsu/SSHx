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

import java.util.List;

/**
 * <pre>
 * [定義通用 DAO] 2020-02-02 21:43
 * </pre>
 * 
 * @author TiramiAsu (Email)
 */
public interface GenericDAO<T> {
//	public void create(T bean);
//	public List<T> query();
//	public T find(Long id);
//	public void update(Long id, T bean);
//	public void delete(Long id);
	public void create(T bean);
	public List<T> query(Class<T> clazz);
	public T find(Long id, Class<T> clazz);
	public void update(Long id, T bean);
	public void delete(Long id, T bean);
}
