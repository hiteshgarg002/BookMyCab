package com.hrrock.view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hrrock.controller.AgencyController;
import com.hrrock.model.Admin;
import com.hrrock.model.Agency;

/**
 * Servlet implementation class AgencyEditDelete
 */
@WebServlet("/AgencyEditDelete")
public class AgencyEditDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AgencyEditDelete() {
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
		Agency A = AgencyController.DisplayById(Integer.parseInt(request.getParameter("aid")));
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

		out.println("<script src='asset/jquery-3.2.1.min.js'></script>");
		out.println("<script src='asset/statecity.js'></script>");

		out.println("<html>");
		out.println("    <link href='bootstrap.min.css' rel='stylesheet'>");
		out.println("<form action='AgencyFinalEditDelete' method=post enctype='multipart/form-data'>");
		out.println("<input type=hidden value=" + A.getAgencyid() + " name=aid>");
		out.println("<center><caption ><b style='color:white;'><i>Agency Update</i></b></caption>");
		out.println("<table class='table table-bordered' style='width:70%; color:white;'>");

		out.println("<table valign=top><tr>");
		out.println("<td valign=top>");
		out.println("<table class='table table-bordered' style='width:70%; color:white;'>");
		out.println("<tr><td></td></tr><tr><td></td></tr><tr><td><b><i>Agency Name:</i></b></td>");
		out.println("<td><input class='form-control' type=text name=aname value='" + A.getAgencyname()
				+ "' size=30></td></tr>");

		out.println("<tr><td><b><i>Owner Name:</i></b></td>");
		out.println("<td><input class='form-control' type=text name=oname  value='" + A.getOwnername()
				+ "' size=30></td></tr>");

		out.println("<tr><td><b><i>Address:</i></b></td>");
		out.println("<td><textarea class='form-control' name=add rows=3 cols=32>" + A.getAddress()
				+ "</textarea></td></tr>");

		String st[] = A.getState().split(",");
		out.println("<tr><td><b><i>State:</i></b></td>");
		out.println("<td><select class='form-control' name=state id=state><option value=" + st[0] + ">" + st[1]
				+ "</option></select></td></tr>");

		String ct[] = A.getCity().split(",");
		out.println("<tr><td><b><i>City:</i></b></td>");
		out.println("<td><select class='form-control' name=city id=city><option value=" + ct[0] + ">" + ct[1]
				+ "</option></select></td></tr>");

		out.println("<tr><td><b><i>Contact Person:</i></b></td>");
		out.println("<td><input class='form-control' type=text value='" + A.getContactperson()
				+ "' name=cperson size=30></td></tr>");

		out.println("<tr><td><b><i>Mobile No:</i></b></td>");
		out.println("<td><input class='form-control' type=text name=mobileno value='" + A.getMobileno()
				+ "' size=30></td></tr>");

		out.println("<tr><td><b><i>Phone No:</i></b></td>");
		out.println("<td><input class='form-control' type=text value='" + A.getPhoneno()
				+ "' name=phoneno size=30></td></tr>");

		out.println("<tr><td><b><i>Email Id:</i></b></td>");
		out.println("<td><input class='form-control' type=text name=emailid value='" + A.getEmailid()
				+ "' size=30></td></tr>");

		out.println("<tr><td><b><i>Status:</i></b></td>");
		out.println("<td><select class='form-control' name=status>");
		out.println("<option>" + A.getStatus() + "</option>");
		out.println("<option>Verified</option>");
		out.println("<option>Not Verified</option></select>");

		out.println("</table><br>");
		out.println(
				"&nbsp;<input type=submit value=Update name=btn class='btn btn-info btn-xs'>&nbsp;&emsp;&emsp;&emsp;&nbsp;&nbsp;<input type=submit value=Delete name=btn class='btn btn-danger btn-xs'></br>");

		out.println("</td><td width=50></td><td valign=top>");
		out.println("<b>Registration Id:</b>&nbsp;<input class='form-control' type=text name=regid value='"
				+ A.getRegistrationid() + "'><br>");
		out.println("<input type=hidden name=regproof2 value='" + A.getRegistrationid_proof() + "'>");
		out.println("<br><img class='img-thumbnail' src=picture/" + A.getRegistrationid_proof()
				+ " width=50 height=50><br><br>");
		out.println("Update Registration Id :&nbsp; <input class='form-control' type=file name=regproof><br><br>");
		out.println("<input class='btn btn-danger btn-xs' type=submit name=btn value='Update Registration'>"
				+ "<br><br><hr color=darkpink><br>");

		out.println("<b>Identity :</b>&nbsp;<input class='form-control' type=text name=identity value='"
				+ A.getIdentity() + "'><br>");
		out.println("<input type=hidden name=idproof2 value='" + A.getIdentity_proof() + "'>");
		out.println("<br><img src=picture/" + A.getIdentity_proof() + " width=50 height=50><br><br>");
		out.println("Update Identity :&nbsp; <input type=file class='form-control' name=idproof><br><br>");
		out.println("<input type=submit class='btn btn-danger btn-xs' name=btn value='Update Identity'>"
				+ "<br><br><hr color=darkpink><br>");

		out.println(
				"<b>Agency Logo:</b>&nbsp;<br><br><img src=picture/" + A.getLogo() + " width=50 height=50><br><br>");
		out.println("Update Logo :&nbsp; <input type=file class='form-control' name=logo><br><br>");
		out.println("<input type=submit class='btn btn-danger btn-xs' name=btn value='Update Logo'>");
		out.println("</td></table>");

		out.println("</form></html>");
		out.flush();

	}

}
