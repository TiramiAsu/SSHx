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

import com.sshx.entity.Investor;

/**
 * <pre>
 * [定義 InvestorDAO] 2020-03-11 12:36
 * </pre>
 * 
 * @author TiramiAsu (Email)
 */
public interface InvestorDAO extends GenericDAO<Investor> {
	Investor find(String name);
}
