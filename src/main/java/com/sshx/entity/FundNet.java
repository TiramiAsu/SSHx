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
 * [基金淨額] 2020-03-06 19:00
 * </pre>
 * 
 * @author TiramiAsu (Email)
 */
public class FundNet implements Serializable {

	private static final long serialVersionUID = -665829266659590369L;

	private Long id;
	private Integer value;
	private Fund fund;

	public FundNet() {}

	public FundNet(Integer value, Fund fund) {
		this.value = value;
		this.fund = fund;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getValue() {
		return value;
	}

	public void setValue(Integer value) {
		this.value = value;
	}

	public Fund getFund() {
		return fund;
	}

	public void setFund(Fund fund) {
		this.fund = fund;
	}

	@Override
	public String toString() {
		return "FundNet [id=" + id +
				", value=" + value +
				", fund=" + fund.getName() +
				"]";
	}

}
