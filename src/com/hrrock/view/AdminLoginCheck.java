package com.hrrock.view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hrrock.controller.AdminController;
import com.hrrock.model.Admin;

/**
 * Servlet implementation class AdminLoginCheck
 */
@WebServlet("/AdminLoginCheck")
public class AdminLoginCheck extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AdminLoginCheck() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@SuppressWarnings("deprecation")
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		Admin A = AdminController.checkPassword(request.getParameter("aid"), request.getParameter("pwd"));
		PrintWriter out = response.getWriter();

		if (A != null) {
			HttpSession ses = request.getSession();
			ses.putValue("SADMIN", A);
			ses.putValue("SLTIME", new java.util.Date().toString());
			ses.setMaxInactiveInterval(15 * 60); // 10 minutes
			response.sendRedirect("AdminHome");
		} else {
			out.println("<html>Invalid AdminId/Password</html>");

		}

	}

}
