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

/**
 * <pre>
 * [Bean: Book] 2020-02-05 18:55
 * </pre>
 * 
 * @author TiramiAsu (Email)
 */
public class Book {

	private Long id;
	private String title;
	private String author;
	private Integer price;
	private Date time_publish;

	public Book() {}

	public Book(String title, String author, Integer price, Date time_publish) {
		this.title = title;
		this.author = author;
		this.price = price;
		this.time_publish = time_publish;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public Date getTime_publish() {
		return time_publish;
	}

	public void setTime_publish(Date time_publish) {
		this.time_publish = time_publish;
	}
	
	@Override
	public String toString() {
		return "Book [id=" + id +
				", title=" + title +
				", author=" + author +
				", price=" + price +
				", time_publish=" + time_publish +
				"]";
	}

}
