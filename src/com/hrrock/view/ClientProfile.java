package com.hrrock.view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hrrock.model.Client;

/**
 * Servlet implementation class ClientProfile
 */
@WebServlet("/ClientProfile")
public class ClientProfile extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ClientProfile() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@SuppressWarnings({ "deprecation", "unused" })
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	 
		HttpSession ses=request.getSession();
		PrintWriter out=response.getWriter();
	
		Client C = new Client();
		try {
				C=(Client) ses.getValue("SCLIENT");	
				String ltime=(String)ses.getValue("LTIME");
		//		String navbar="<h4>&emsp;"+C.getEmail()+"&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;"+C.getFirstname()+"&nbsp;"+C.getLastname()+"&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;"+ltime+"&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;<a href='ClientLogout'>Logout</a></h4><hr color=Green><br>";
		//		out.println(navbar);
			} catch(Exception e){
	//		out.println(e);
				response.sendRedirect("ClientLogin");	
				}
		
		out.println("<script src='asset/jquery-3.2.1.min.js'></script>");
		out.println("<script src='asset/statecity.js'></script>");
		
		out.println("<html>");
		out.println("    <link href='bootstrap.min.css' rel='stylesheet'>");
		out.println("<form action='ClientProfileSubmit' method='post'>");
		out.println("<center><caption ><b style='color:white;'><i>Client Registration</i></b></caption>");
		out.println("<table class='table table-bordered' style='width:70%; color:white; font-size:12px;'>");
		
		out.println(""
				+ "<tr><tr></tr></tr>"
				+ "<tr><td><b><i>Email ID:</i></b></td>"
				+ "<td><input class='form-control' type=text name=email id=email value="+C.getEmail()+"></td></tr>"
				+ "<tr><td><b><i>Mobile:</i></b></td>"
				+ "<td><input class='form-control' type=text name=mobile id=mobile value="+C.getMobile()+"></td></tr>"
				+ "<tr><td><b><i>First Name:</i></b></td>"
				+ "<td><input class='form-control' type=text name=fname id=fname value="+C.getFirstname()+"></td></tr>"
				+ "<tr><td><b><i>Last Name:</i></b></td>"
				+ "<td><input class='form-control' type=text name=lname id=lname value="+C.getLastname()+"></td></tr>"
				+ "<tr><td><b><i>Date of Birth:</i></b></td>"
				+ "<td><input class='form-control' type=date name=dob id=dob value="+C.getDob()+"></td></tr>"
				+ "<tr><td><b><i>Gender:</i></b></td>"
					+ "<td><select class='form-control' name=gen id=gen>"
					+ "<option>-SELECT-</option>"
					+ "<option>Male</option>"
					+ "<option>Female</option>"
					+ "<option>other</option>"
					+ "</select></td></tr>");
					
		out.println("<tr><td><b><i>Address:</i></b></td>"
				+ "<td><textarea class='form-control' name=add id=add rows=3 cols=22 value="+C.getAddress()+"></textarea></td></tr>"
				+ "<tr><td><b><i>State:</i></b></td>"
				+ "<td><select class='form-control'  name=state id=state value="+C.getState()+"></select></td></tr>"
				+ "<tr><td><b><i>City:</i></b></td>"
				+ "<td><select class='form-control' name=city id=city>"+C.getCity()+"</select></td></tr>");
		
		out.println("</table><br>"
				+ "&nbsp;<input type=submit class='btn btn-success btn-xs' value=SignUp>&nbsp;&ensp;&emsp;&emsp;&emsp;&emsp;&nbsp;<input class='btn btn-danger btn-xs' type=reset value=Reset>");
		out.println("</form></center></html>");
	
	}

}
