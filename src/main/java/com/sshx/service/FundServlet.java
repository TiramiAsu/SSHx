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
import com.sshx.dao.StockDAO;
import com.sshx.entity.Fund;
import com.sshx.entity.Stock;
import com.sshx.utils.SpringUtils;

/**
 * <pre>
 * [Fund Servlet] 2020-02-25 16:47
 * </pre>
 * 
 * @author TiramiAsu (Email)
 */
@WebServlet("/fund")
@SuppressWarnings("serial")
public class FundServlet extends HttpServlet {

	private static FundDAO fundDAO;
	private static StockDAO stockDAO;

	static {
		fundDAO = SpringUtils.getBean(FundDAO.class);
		stockDAO = SpringUtils.getBean(StockDAO.class);
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
		req.getRequestDispatcher("./WEB-INF/jsp/FundAdd.jsp").forward(req, resp);
	}

	public void uiEdit(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			Long id = Long.parseLong(req.getParameter("id"));
			if (isNotNull(id)) {
				Fund fund = fundDAO.find(id, Fund.class);
				req.setAttribute("fund", fund);
			} else {
				throw new Exception(">>> id is Null <<<");
			}
			req.getRequestDispatcher("./WEB-INF/jsp/FundAdd.jsp").forward(req, resp);
		} catch (Exception e) {
			e.printStackTrace();
			resp.sendRedirect("./WEB-INF/jsp/Fund.jsp");
		}
	}

	public void add(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			String name = req.getParameter("name");
			String desc = req.getParameter("desc");

			if (isNotNullOrEmptyString(name, desc)) {
				Fund fund = new Fund(name, desc);
				fundDAO.create(fund);
				req.setAttribute("msg", "\"" + fund.getName() + "\" add Success!!");
			} else {
				throw new Exception(">>> Some attribute is Null <<<");
			}
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("msg", "Failed to add Fund, Please try again.");
		}
		resp.sendRedirect("/SSHx/fund");
	}

	public void edit(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			Long id = Long.parseLong(req.getParameter("id")); // 取得 hidden 中設定的 id 值
			String name = req.getParameter("name");
			String desc = req.getParameter("desc");

			if (isNotNullOrEmptyString(id, name)) {
				Fund fund = fundDAO.find(id, Fund.class);
				if (isNotNull(fund)) {
					fund.setName(name);
					fund.setDesc(desc);
					fundDAO.update(id, fund);
					req.setAttribute("msg", "\"" + fund.getName() + "\" edit Success!!");
				} else {
					throw new Exception(">>> Not Found Fund by ID: " + id + " <<<");
				}
			} else {
				throw new Exception(">>> Some attribute is Null <<<");
			}
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("msg", "Failed to edit Fund, Please try again.");
		}
		resp.sendRedirect("/SSHx/fund");
	}

	public void search(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Fund> fundList;
		try {
			String name = req.getParameter("name") == null ? "" : req.getParameter("name");
			if (name.equals("")) {
				fundList = fundDAO.query(Fund.class).stream()
						.sorted((o1, o2) -> o2.getId().compareTo(o1.getId()))
						.collect(Collectors.toList());
				req.setAttribute("msg",
						req.getAttribute("msg") != null ? req.getAttribute("msg") :
						"Search results totally " + fundList.size() + " records.");
			} else {
				fundList = Arrays.asList(fundDAO.find(name));
				req.setAttribute("name", name);
				req.setAttribute("msg", "Search " + name + " Success.");
			}
			if (fundList.get(0) != null) {
				req.setAttribute("fundList", fundList);
			} else {
				req.setAttribute("fundList", null);
			}
		} catch (Exception e) {
			System.err.println(">>> Search Error: " + e.getMessage() + " <<<");
		}
		req.getRequestDispatcher("./WEB-INF/jsp/Fund.jsp").forward(req, resp);
	}

	public void remove(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			Long id = Long.parseLong(req.getParameter("id"));

			if (isNotNullOrEmptyString(id)) {
				Fund fund = fundDAO.find(id, Fund.class);
				if (isNotNull(id, fund)) {
					fundDAO.delete(id, fund);
					req.setAttribute("msg", "\"" + fund.getName() + "\" remove Success!!");
				} else {
					throw new Exception(">>> Not Found Fund by ID: " + id + " <<<");
				}
			} else {
				throw new Exception(">>> id is Null <<<");
			}
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("msg", "Failed to remove Fund, Please try again.");
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
