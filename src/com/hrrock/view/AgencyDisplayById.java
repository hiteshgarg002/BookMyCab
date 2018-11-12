package com.hrrock.view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hrrock.model.Admin;

/**
 * Servlet implementation class AgencyDisplayById
 */
@WebServlet("/AgencyDisplayById")
public class AgencyDisplayById extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AgencyDisplayById() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@SuppressWarnings("deprecation")
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at: ").append(request.getContextPath());

		PrintWriter out = response.getWriter();
		HttpSession ses = request.getSession();

		////////////// session management////////////////
		Admin admin;
		try {
			admin = (Admin) ses.getValue("SADMIN");
			String ltime = (String) ses.getValue("SLTIME");
			@SuppressWarnings("unused")
			String navbar = "<h4>Admin Id:" + admin.getAdminId() + "&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;"
					+ admin.getAdminName() + "&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;" + ltime
					+ "&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;<img src=picture/"
					+ admin.getPicture()
					+ " width=40 height=40>&emsp;&emsp;&emsp;<a href=AdminLogout>Logout</a></h4><hr color=red>";
		} catch (Exception e) {
			// out.println(e);
			response.sendRedirect("AdminLogin");
		}
		////////////////////////////////////////////////

		try {
			out.println("<html>");
			out.println("    <link href='bootstrap.min.css' rel='stylesheet'>");
			out.println("<center><form action='AgencyEditDelete'>");
			out.println("<caption><b><i>Search Agency</i></b></caption>");
			out.println("<table class='table table-bordered' style='width:70%; color:white;'>");

			out.println("<tr><td><b><i>Agency Id:</i></b></td>");
			out.println(
					"<td><input type=text class='form-control' name=aid size=30></td><td><input class='btn btn-danger btn-xs' type=submit></tr>");
			out.println("</table></center></html>");
			out.flush();
		} catch (Exception e) {
			out.println("Invalid Id / No result found");
		}

	}

}
