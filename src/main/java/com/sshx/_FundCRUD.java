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

import com.sshx.dao.FundDAO;
import com.sshx.dao.StockDAO;
import com.sshx.entity.Fund;
import com.sshx.entity.FundNet;
import com.sshx.entity.Stock;
import com.sshx.utils.SpringUtils;

/**
 * <pre>
 * [CRUD] 2020-02-09 12:57
 * </pre>
 * 
 * @author TiramiAsu (Email)
 */
public class _FundCRUD {

	private static FundDAO fundDAO;
	private static StockDAO stockDAO;
	
	static {
		fundDAO = SpringUtils.getBean(FundDAO.class);
		stockDAO = SpringUtils.getBean(StockDAO.class);
	}
	
	public static void main(String[] args) {
//		create(new Fund("高收益", "錢多多"));
//		create(new Fund("高科技", "有前途"));
//		update(1L, new Fund("高收益", "基本利息 1.2%"));
//		delete(1L);

//		addStock("高科技", "2330", "3008");

//		addFundNet("高科技", 27);

		query();
//		find(2L);
//		find("高收益");
	}
	
	public static void create(Fund fund) {
		fundDAO.create(fund);
	}
	
	public static List<Fund> query() {
		List<Fund> fund = fundDAO.query(Fund.class);
		fund.stream().forEach(System.out::println);
		System.out.println();
		return fund;
	}
	
	public static Fund find(Long id) {
		Fund fund = fundDAO.find(id, Fund.class);
		System.out.println(fund);
		return fund;
	}
	
	public static Fund find(String name) {
		Fund fund = fundDAO.find(name);
		System.out.println(fund);
		return fund;
	}
	
	public static void update(Long id, Fund fund) {
		fund.setId(id);
		fundDAO.update(id, fund);
		query();
	}
	
	public static void delete(Long id) {
		fundDAO.delete(id, fundDAO.find(id, Fund.class));
		query();
	}

	public static void addStock(String fundName, String... stockCodes) {
		// 查找新基金
		Fund fund = fundDAO.find(fundName);

		for (String stockCode : stockCodes) {
			// 查找 stock
			Stock stock = stockDAO.find(stockCode);
			// 加入股票
			fund.getStocks().add(stock);
		}

		fundDAO.update(fund.getId(), fund);
	}

	public static void addFundNet(String fundName, Integer value) {
		Fund fund = fundDAO.find(fundName);
		fund.setFundNet(new FundNet(value, fund));
		fundDAO.update(fund.getId(), fund);
	}
}
