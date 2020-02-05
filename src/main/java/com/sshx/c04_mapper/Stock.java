/*
 * 
 * 
 * 
 * 
 * 
 * &copy;TiramiAsu
 * 
 */
package com.sshx.c04_mapper;

/**
 * <pre>
 * [Bean: Stock] 2020-02-05 20:25
 * </pre>
 * 
 * @author TiramiAsu (Email)
 */
public class Stock {

	private Long id;
	private String code;
	private String name;

	public Stock() {}

	public Stock(String code, String name) {
		this.code = code;
		this.name = name;
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

	@Override
	public String toString() {
		return "Stock [id=" + id +
				", code=" + code +
				", name=" + name +
				"]";
	}

}
