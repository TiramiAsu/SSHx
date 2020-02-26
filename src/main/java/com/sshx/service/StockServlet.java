/*
 * 
 * 
 * 
 * 
 * 
 * &copy;TiramiAsu
 * 
 */
package com.sshx.service;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sshx.dao.StockDAO;
import com.sshx.entity.Stock;
import com.sshx.utils.SpringUtils;

/**
 * <pre>
 * [Stock Servlet] 2020-02-25 16:47
 * </pre>
 * 
 * @author TiramiAsu (Email)
 */
@WebServlet("/stock")
@SuppressWarnings("serial")
public class StockServlet extends HttpServlet {

	private static StockDAO stockDAO;

	static {
		stockDAO = SpringUtils.getBean(StockDAO.class);
	}

	public void doHandle (HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// TODO 之後改用 Filter
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");

		String action = req.getParameter("action");
		if (action.equals("search")) {
			search(req, resp);
		} else {
			System.out.println("Error");
		}
	}

	public void search(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Stock> stockList;
		stockList = stockDAO.query(Stock.class).stream()
				.sorted((o1, o2) -> o2.getId().compareTo(o1.getId()))
				.collect(Collectors.toList());
		req.setAttribute("stockList", stockList);
		req.setAttribute("msg", "Search results totally " + stockList.size() + " records.");
		req.getRequestDispatcher("./WEB-INF/jsp/Stock.jsp").forward(req, resp);
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doHandle(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doHandle(req, resp);
	}

}
