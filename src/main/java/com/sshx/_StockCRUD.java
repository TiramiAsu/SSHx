/*
 * 
 * 
 * 
 * 
 * 
 * &copy;TiramiAsu
 * 
 */
package com.sshx;

import java.util.List;

import com.sshx.utils.SpringUtils;
import com.sshx.dao.StockDAO;
import com.sshx.entity.Stock;

/**
 * <pre>
 * [CRUD] 2020-02-09 11:41
 * </pre>
 * 
 * @author TiramiAsu (Email)
 */
public class _StockCRUD {
	
	private static StockDAO stockDAO;
	
	static {
		stockDAO = SpringUtils.getBean(StockDAO.class);
	}
	
	public static void main(String[] args) {
//		create(new Stock("3008", "大立光"));
//		create(new Stock("2330", "台雞電"));
//		update(2L, new Stock("2330", "台積電"));
//		delete(1L);
		query();
//		find("2330");
//		find(1L);
	}
	
	public static void create(Stock stock) {
		stockDAO.create(stock);
	}
	
	public static List<Stock> query() {
		List<Stock> stocks = stockDAO.query(Stock.class);
		stocks.stream().forEach(System.out::println);
		System.out.println();
		return stocks;
	}
	
	public static Stock find(Long id) {
		Stock stock = stockDAO.find(id, Stock.class);
		System.out.println(stock);
		return stock;
	}
	
	public static Stock find(String code) {
		Stock stock = stockDAO.find(code);
		System.out.println(stock);
		return stock;
	}
	
	public static void update(Long id, Stock stock) {
		stock.setId(id);
		stockDAO.update(id, stock);
	}
	
	public static void delete(Long id) {
		stockDAO.delete(id, stockDAO.find(id, Stock.class));
	}

}
