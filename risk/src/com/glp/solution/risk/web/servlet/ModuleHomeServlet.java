package com.glp.solution.risk.web.servlet;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class ModuleHomeServlet extends HttpServlet {
	private static final long serialVersionUID = 7960726056945273693L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher;
		String[] uri = request.getRequestURI().split("/");
		if (uri.length < 4) {
			dispatcher = request.getRequestDispatcher("/xava/homeMenu.jsp");
		} else {
			dispatcher = request
					.getRequestDispatcher("/xava/home.jsp?application="
							+ uri[1] + "&module=" + uri[3]);
		}
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}