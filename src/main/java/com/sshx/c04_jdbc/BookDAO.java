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

/**
 * <pre>
 * [定義 BookDAO] 2020-02-05 19:02
 * </pre>
 * 
 * @author TiramiAsu (Email)
 */
public interface BookDAO {
	public void create(String title, String author, Integer price, Date time_publish);
	public List<Map<String, Object>> query();
	public Map<String, Object> find(Long id);
	public void update(Long id, String title, String author, Integer price, Date time_publish);
	public void delete(Long id);
}
