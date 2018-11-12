package com.hrrock.view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hrrock.controller.ClientController;
import com.hrrock.model.Client;

/**
 * Servlet implementation class ClientLoginCheck
 */
@WebServlet("/ClientLoginCheck")
public class ClientLoginCheck extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ClientLoginCheck() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		Client C = ClientController.checkPassword(request.getParameter("uid"), request.getParameter("pwd"));
		PrintWriter out = response.getWriter();

		if (C != null) {
			HttpSession ses = request.getSession();
			ses.setAttribute("SCLIENT", C);
			ses.setAttribute("LTIME", new java.util.Date().toString());
			ses.setMaxInactiveInterval(15 * 60); // 15 minute
			response.sendRedirect("ClientHomeDirect");
		} else {
			out.println("<html><b><font color=red>Invalid EmailId/Password</font></b></html>");
		}

	}

}
