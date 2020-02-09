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

import com.sshx.entity.Fund;

/**
 * <pre>
 * [定義 FundDAO] 2020-02-09 12:51
 * </pre>
 * 
 * @author TiramiAsu (Email)
 */
public interface FundDAO extends GenericDAO<Fund> {
	Fund find(String name);
}
