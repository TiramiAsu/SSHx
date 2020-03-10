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

import com.sshx.entity.Trader;

/**
 * <pre>
 * [定義 TraderDAO] 2020-03-10 01:53
 * </pre>
 * 
 * @author TiramiAsu (Email)
 */
public interface TraderDAO extends GenericDAO<Trader> {
	Trader find(String name);
}
