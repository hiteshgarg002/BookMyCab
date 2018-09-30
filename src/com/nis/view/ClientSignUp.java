package com.nis.view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ClientSignUp
 */
@WebServlet("/ClientSignUp")
public class ClientSignUp extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ClientSignUp() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at: ").append(request.getContextPath());
		
		PrintWriter out=response.getWriter();
//		
		out.println("<script src='asset/jquery-3.2.1.min.js'></script>");
		out.println("<script src='asset/statecity.js'></script>");

		out.println("<html>");
		out.println("<form action='ClientSignupSubmitDirect' method='post'>");
		
		out.println("<table valign=top cellspacing=4 cellpadding=2>"
				+ "<caption><b><i>Client Registration</i></b></caption>"
				+ "<tr><tr></tr></tr>"
				+ "<tr><td><b><i>Email ID:</i></b></td>"
				+ "<td><input type=text name=email id=email ></td></tr>"
				+ "<tr><td><b><i>Mobile:</i></b></td>"
				+ "<td><input type=text name=mobile id=mobile></td></tr>"
				+ "<tr><td><b><i>First Name:</i></b></td>"
				+ "<td><input type=text name=fname id=fname></td></tr>"
				+ "<tr><td><b><i>Last Name:</i></b></td>"
				+ "<td><input type=text name=lname id=lname></td></tr>"
				+ "<tr><td><b><i>Date of Birth:</i></b></td>"
				+ "<td><input type=date name=dob id=dob></td></tr>"
				+ "<tr><td><b><i>Gender:</i></b></td>"
					+ "<td><select name=gen id=gen>"
					+ "<option>-SELECT-</option>"
					+ "<option>Male</option>"
					+ "<option>Female</option>"
					+ "<option>other</option>"
					+ "</select></td></tr>");
					
		out.println("<tr><td><b><i>Address:</i></b></td>"
				+ "<td><textarea name=add id=add rows=3 cols=22></textarea></td></tr>"
				+ "<tr><td><b><i>State:</i></b></td>"
				+ "<td><select  name=state id=state></select></td></tr>"
				+ "<tr><td><b><i>City:</i></b></td>"
				+ "<td><select name=city id=city></select></td></tr>"
			
				+ "<tr><td><b><i>Password:</i></b></td>"
				+ "<td><input type=text name=pwd id=pwd></td></tr>"
				+ "<tr><td><b><i>Confirm Password:</i></b></td>"
				+ "<td><input type=text name=cpwd id=cpwd></td></tr>");
		
		out.println("</table><br>"
				+ "&nbsp;<input type=submit value=SignUp>&nbsp;&ensp;&emsp;&emsp;&emsp;&emsp;&nbsp;<input type=reset value=Reset>");
		out.println("</form></html>");
	
	
	
	
	}

}
