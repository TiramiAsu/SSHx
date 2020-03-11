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
 * [基金] 2020-02-09 09:44
 * </pre>
 * 
 * @author TiramiAsu (Email)
 */
public class Fund {

	private Long id;
	private String name;
	private String desc;
	private FundNet fundNet;
	private Set<Stock> stocks = new HashSet<>();
	private Set<Trader> traders = new HashSet<>();
	private Set<Investor> investors = new HashSet<>();
	
	public Fund() {}
	
	public Fund(String name, String desc) {
		this.name = name;
		this.desc = desc;
	}

	public Fund(String name, String desc, Set<Stock> stocks) {
		this.name = name;
		this.desc = desc;
		this.stocks = stocks;
	}

	public Fund(String name, String desc, FundNet fundNet, Set<Stock> stocks) {
		this.name = name;
		this.desc = desc;
		this.fundNet = fundNet;
		this.stocks = stocks;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public FundNet getFundNet() {
		return fundNet;
	}

	public void setFundNet(FundNet fundNet) {
		this.fundNet = fundNet;
	}

	public Set<Stock> getStocks() {
		return stocks;
	}

	public void setStocks(Set<Stock> stocks) {
		this.stocks = stocks;
	}

	public Set<Trader> getTraders() {
		return traders;
	}

	public void setTraders(Set<Trader> traders) {
		this.traders = traders;
	}

	public Set<Investor> getInvestors() {
		return investors;
	}

	public void setInvestors(Set<Investor> investors) {
		this.investors = investors;
	}

	@Override
	public String toString() {
		String stocksNames = "";
		for (Stock stock : stocks) {
			stocksNames += stock.getName() + ", ";
		}
		return "Fund [id=" + id +
				", name=" + name +
				", desc=" + desc +
				", fundNet=" + fundNet +
				", traders=" + traders +
				", stocks=" + stocksNames +
				", investors=" + investors.size() +
				"]";
	}
}
