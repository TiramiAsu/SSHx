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

import java.io.Serializable;

/**
 * <pre>
 * [基金經理人] 2020-03-05 22:50
 * </pre>
 * 
 * @author TiramiAsu (Email)
 */
public class Trader implements Serializable {

	private static final long serialVersionUID = 6004334750121171764L;

	private Long id;
	private String name;
	private Fund fund;

	public Trader() {}

	public Trader(String name) {
		this.name = name;
	}

	public Trader(String name, Fund fund) {
		this.name = name;
		this.fund = fund;
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

	public Fund getFund() {
		return fund;
	}

	public void setFund(Fund fund) {
		this.fund = fund;
	}

	@Override
	public String toString() {
		return "Trader [id=" + id +
				", name=" + name +
				", fund=" + fund.getName() +
				"]";
	}

}
