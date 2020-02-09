/*
 * 
 * 
 * 
 * 
 * 
 * &copy;TiramiAsu
 * 
 */
package com.sshx.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * <pre>
 * [股票] 2020-02-02 21:02
 * </pre>
 * 
 * @author TiramiAsu (Email)
 */
public class Stock {

	private Long id;
	private String code;
	private String name;
	private Set<Fund> funds = new HashSet<>();
	
	public Stock() {}

	public Stock(String code, String name) {
		this.code = code;
		this.name = name;
	}
	
	public Stock(String code, String name, Set<Fund> funds) {
		this.code = code;
		this.name = name;
		this.funds = funds;
	}

	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getCode() {
		return code;
	}
	
	public void setCode(String code) {
		this.code = code;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public Set<Fund> getFunds() {
		return funds;
	}

	public void setFunds(Set<Fund> funds) {
		this.funds = funds;
	}

	@Override
	public String toString() {
		String fundsNames = "";
		for (Fund fund : funds) {
			fundsNames = fundsNames + fund.getName() + ", ";
		}
		return "Stock [id=" + id +
				", code=" + code +
				", name=" + name +
				", funds=" + fundsNames +
				"]";
	}
	
}
