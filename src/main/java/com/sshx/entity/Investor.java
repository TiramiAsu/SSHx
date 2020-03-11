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
 * [投資人] 2020-03-06 19:02
 * </pre>
 * 
 * @author TiramiAsu (Email)
 */
public class Investor implements Serializable {

	private static final long serialVersionUID = 4152977138564186622L;

	private Long id;
	private String name;
	private Double units;
	private Integer netValue;
	private Fund fund;

	public Investor() {}

	public Investor(String name) {
		this.name = name;
	}

	public Investor(String name, Double units, Integer netValue, Fund fund) {
		this.name = name;
		this.units = units;
		this.netValue = netValue;
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

	public Double getUnits() {
		return units;
	}

	public void setUnits(Double units) {
		this.units = units;
	}

	public Integer getNetValue() {
		return netValue;
	}

	public void setNetValue(Integer netValue) {
		this.netValue = netValue;
	}

	public Fund getFund() {
		return fund;
	}

	public void setFund(Fund fund) {
		this.fund = fund;
	}

	@Override
	public String toString() {
		return "Investor [id=" + id +
				", name=" + name +
				", units=" + units +
				", netValue=" + netValue +
				", fund=" + fund +
				"]";
	}

}
