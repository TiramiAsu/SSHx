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
import com.sshx.dao.InvestorDAO;
import com.sshx.entity.Fund;
import com.sshx.entity.Investor;
import com.sshx.utils.SpringUtils;

/**
 * <pre>
 * [Investor Servlet] 2020-03-11 12:43
 * </pre>
 * 
 * @author TiramiAsu (Email)
 */
@WebServlet("/investor")
@SuppressWarnings("serial")
public class InvestorServlet extends HttpServlet {

	private static InvestorDAO investorDAO;
	private static FundDAO fundDAO;

	static {
		investorDAO = SpringUtils.getBean(InvestorDAO.class);
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
			// 移除 uiEdit
			case "add":
				add(req, resp);
				break;
			// 移除 edit
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
		req.setAttribute("fundList", fundDAO.query(Fund.class));
		req.getRequestDispatcher("./WEB-INF/jsp/InvestorAdd.jsp").forward(req, resp);
	}

	public void uiEdit(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			Long id = Long.parseLong(req.getParameter("id"));
			if (isNotNull(id)) {
				Investor investor = investorDAO.find(id, Investor.class);
				req.setAttribute("investor", investor);
				req.setAttribute("fundList", fundDAO.query(Fund.class));
			} else {
				throw new Exception(">>> id is Null <<<");
			}
			req.getRequestDispatcher("./WEB-INF/jsp/InvestorAdd.jsp").forward(req, resp);
		} catch (Exception e) {
			e.printStackTrace();
			resp.sendRedirect("./WEB-INF/jsp/Investor.jsp");
		}
	}

	public void add(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			String name = req.getParameter("name");
			Double unit = Double.parseDouble(req.getParameter("unit"));
			String fundName = req.getParameter("fundName");

			if (isNotNullOrEmptyString(name, fundName)) {
				Fund fund = fundDAO.find(fundName);

				Investor investor = new Investor(name, unit, fund.getFundNet().getValue(), fund);
				investorDAO.create(investor);

				fund.getInvestors().add(investor);
				fundDAO.update(fund.getId(), fund);
				req.setAttribute("msg", "\"" + name + "\" add Success!!");
			} else {
				throw new Exception(">>> Some attribute is Null <<<");
			}
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("msg", "Failed to add Investor, Please try again.");
		}
		resp.sendRedirect("/SSHx/investor");
	}


	public void search(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Investor> investorList;
		try {
			String name = req.getParameter("name") == null ? "" : req.getParameter("name");
			if (name.equals("")) {
				investorList = investorDAO.query(Investor.class).stream()
						.sorted((o1, o2) -> o2.getId().compareTo(o1.getId()))
						.collect(Collectors.toList());
				req.setAttribute("msg",
						req.getAttribute("msg") != null ? req.getAttribute("msg") :
						"Search results totally " + investorList.size() + " records.");
			} else {
				investorList = Arrays.asList(investorDAO.find(name));
				req.setAttribute("name", name);
				req.setAttribute("msg", "Search " + name + " Success.");
			}
			if (investorList.get(0) != null) {
				req.setAttribute("investorList", investorList);
			} else {
				req.setAttribute("investorList", null);
			}
		} catch (Exception e) {
			System.err.println(">>> Search Error: " + e.getMessage() + " <<<");
		}
		req.getRequestDispatcher("./WEB-INF/jsp/Investor.jsp").forward(req, resp);
	}

	public void remove(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			Long id = Long.parseLong(req.getParameter("id"));

			if (isNotNullOrEmptyString(id)) {
				Investor investor = investorDAO.find(id, Investor.class);
				if (isNotNull(id, investor)) {
					investorDAO.delete(id, investor);
					req.setAttribute("msg", "\"" + investor.getName() + "\" remove Success!!");
				} else {
					throw new Exception(">>> Not Found Investor by ID: " + id + " <<<");
				}
			} else {
				throw new Exception(">>> id is Null <<<");
			}
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("msg", "Failed to remove Investor, Please try again.");
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
