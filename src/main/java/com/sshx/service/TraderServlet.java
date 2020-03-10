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

import static com.sshx.utils.JudgeUtils.isNotNull;
import static com.sshx.utils.JudgeUtils.isNotNullOrEmptyString;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sshx.dao.FundDAO;
import com.sshx.dao.TraderDAO;
import com.sshx.entity.Fund;
import com.sshx.entity.Trader;
import com.sshx.utils.SpringUtils;

/**
 * <pre>
 * [Trader Servlet] 2020-03-10 01:56
 * </pre>
 * 
 * @author TiramiAsu (Email)
 */
@WebServlet("/trader")
@SuppressWarnings("serial")
public class TraderServlet extends HttpServlet {

	private static TraderDAO traderDAO;
	private static FundDAO fundDAO;

	static {
		traderDAO = SpringUtils.getBean(TraderDAO.class);
		fundDAO = SpringUtils.getBean(FundDAO.class);
	}

	public void doHandle(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// TODO 之後改用 Filter
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");

		try {
			String action = req.getParameter("action");
			switch (action) {
			case "uiAdd": // button [Add]
				uiAdd(req, resp);
				break;
			case "uiEdit": // button [Edit]
				uiEdit(req, resp);
				break;
			case "add":
				add(req, resp);
				break;
			case "edit":
				edit(req, resp);
				break;
			case "remove":
				remove(req, resp);
				break;
			case "search":
				search(req, resp);
				break;
			}
		} catch (Exception e) {
			// action is null
			search(req, resp);
		}
	}

	public void uiAdd(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("./WEB-INF/jsp/TraderAdd.jsp").forward(req, resp);
	}

	public void uiEdit(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			Long id = Long.parseLong(req.getParameter("id"));
			if (isNotNull(id)) {
				Trader trader = traderDAO.find(id, Trader.class);
				req.setAttribute("trader", trader);
			} else {
				throw new Exception(">>> id is Null <<<");
			}
			req.getRequestDispatcher("./WEB-INF/jsp/TraderAdd.jsp").forward(req, resp);
		} catch (Exception e) {
			e.printStackTrace();
			resp.sendRedirect("./WEB-INF/jsp/Trader.jsp");
		}
	}

	public void add(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			String name = req.getParameter("name");

			if (isNotNullOrEmptyString(name)) {
				Trader trader = new Trader(name);
				traderDAO.create(trader);
				req.setAttribute("msg", "\"" + trader.getName() + "\" add Success!!");
			} else {
				throw new Exception(">>> Some attribute is Null <<<");
			}
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("msg", "Failed to add Trader, Please try again.");
		}
		resp.sendRedirect("/SSHx/trader");
	}

	public void edit(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			Long id = Long.parseLong(req.getParameter("id")); // 取得 hidden 中設定的 id 值
			String name = req.getParameter("name");

			if (isNotNullOrEmptyString(id, name)) {
				Trader trader = traderDAO.find(id, Trader.class);
				if (isNotNull(trader)) {
					trader.setName(name);
					traderDAO.update(id, trader);
					req.setAttribute("msg", "\"" + trader.getName() + "\" edit Success!!");
				} else {
					throw new Exception(">>> Not Found Trader by ID: " + id + " <<<");
				}
			} else {
				throw new Exception(">>> Some attribute is Null <<<");
			}
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("msg", "Failed to edit Trader, Please try again.");
		}
		resp.sendRedirect("/SSHx/trader");
	}

	public void search(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Trader> traderList;
		try {
			String name = req.getParameter("name") == null ? "" : req.getParameter("name");
			if (name.equals("")) {
				traderList = traderDAO.query(Trader.class).stream()
						.sorted((o1, o2) -> o2.getId().compareTo(o1.getId()))
						.collect(Collectors.toList());
				req.setAttribute("msg",
						req.getAttribute("msg") != null ? req.getAttribute("msg") :
						"Search results totally " + traderList.size() + " records.");
			} else {
				traderList = Arrays.asList(traderDAO.find(name));
				req.setAttribute("name", name);
				req.setAttribute("msg", "Search " + name + " Success.");
			}
			if (traderList.get(0) != null) {
				req.setAttribute("traderList", traderList);
			} else {
				req.setAttribute("traderList", null);
			}
		} catch (Exception e) {
			System.err.println(">>> Search Error: " + e.getMessage() + " <<<");
		}
		req.getRequestDispatcher("./WEB-INF/jsp/Trader.jsp").forward(req, resp);
	}

	public void remove(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			Long id = Long.parseLong(req.getParameter("id"));

			if (isNotNullOrEmptyString(id)) {
				Trader trader = traderDAO.find(id, Trader.class);
				if (isNotNull(id, trader)) {
					traderDAO.delete(id, trader);
					req.setAttribute("msg", "\"" + trader.getName() + "\" remove Success!!");
				} else {
					throw new Exception(">>> Not Found Trader by ID: " + id + " <<<");
				}
			} else {
				throw new Exception(">>> id is Null <<<");
			}
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("msg", "Failed to remove Trader, Please try again.");
		}
		search(req, resp);
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
