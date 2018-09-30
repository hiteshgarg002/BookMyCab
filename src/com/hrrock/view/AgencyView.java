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
 * Servlet implementation class AgencyView
 */
@WebServlet("/AgencyView")

public class AgencyView extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public AgencyView() {
    super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@SuppressWarnings("deprecation")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		PrintWriter out=response.getWriter();
		HttpSession ses=request.getSession();

		//////////////session management////////////////
		Admin admin;
		try{
		admin=(Admin)ses.getValue("SADMIN");	
		String ltime=(String)ses.getValue("SLTIME");
		@SuppressWarnings("unused")
		String navbar="<h4>Admin Id:"+admin.getAdminId()+"&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;"+admin.getAdminName()+"&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;"+ltime+"&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;<img src=picture/"+admin.getPicture()+" width=40 height=40>&emsp;&emsp;&emsp;<a href=AdminLogout>Logout</a></h4><hr color=red>";
		}catch(Exception e){
		//	out.println(e);
		response.sendRedirect("AdminLogin");	
		}
		////////////////////////////////////////////////


		
		out.println("<script src='asset/jquery-3.2.1.min.js'></script>");
		out.println("<script src='asset/statecity.js'></script>");
		
		out.println("<html>");
		out.println("    <link href='bootstrap.min.css' rel='stylesheet'>");
		out.println("<center><form action='AgencySubmit' method='post' enctype='multipart/form-data'>");
		out.println("<caption ><b style='color:white;'><i>Agency Registration</i></b></caption>");
		out.println("<table class='table table-bordered' style='width:70%; color:white; font-size:12px;'>");

		out.println("<tr><tr></tr></tr><tr><td><b><i>Agency Name:</i></b></td>");
		out.println("<td><input class='form-control' type=text name=aname size=30></td></tr>");
		
		out.println("<tr><td><b><i>Owner Name:</i></b></td>");
		out.println("<td><input class='form-control' type=text name=oname size=30></td></tr>");
	
		out.println("<tr><td><b><i>Address:</i></b></td>");
		out.println("<td><textarea class='form-control' name=add row=3 cols=32></textarea></td></tr>");
		
		out.println("<tr><td><b><i>State:</i></b></td>");
		out.println("<td><select class='form-control'  name=state id=state></select></td></tr>");
		
		out.println("<tr><td><b><i>City:</i></b></td>");
		out.println("<td><select class='form-control'  name=city id=city></select></td></tr>");
		
		out.println("<tr><td><b><i>Contact Person:</i></b></td>");
		out.println("<td><input class='form-control' type=text name=cperson size=30></td></tr>");
		
		out.println("<tr><td><b><i>Mobile No:</i></b></td>");
		out.println("<td><input class='form-control' type=text name=mobileno size=30></td></tr>");
		
		out.println("<tr><td><b><i>Phone No:</i></b></td>");
		out.println("<td><input class='form-control' type=text name=phoneno size=30></td></tr>");
		
		out.println("<tr><td><b><i>Email Id:</i></b></td>");
		out.println("<td><input class='form-control' type=email name=emailid size=30></td></tr>");
		
		out.println("<tr><td><b><i>Registration Id:</i></b></td>");
		out.println("<td><input class='form-control' type=text name=regid size=30></td></tr>");
		
		out.println("<tr><td><b><i>Upload Registration Proof:</i></b></td>");
		out.println("<td><input class='form-control' type=file name=regproof></td></tr>");
		
		out.println("<tr><td><b><i>Identity:</i></b></td>");
		out.println("<td><input class='form-control' type=text name=identity size=30></td></tr>");
		
		out.println("<tr><td><b><i>Upload Identity proof:</i></b></td>");
		out.println("<td><input class='form-control' type=file name=idproof></td></tr>");
		
		out.println("<tr><td><b><i>Logo:</i></b></td>");
		out.println("<td><input class='form-control' type=file name=logo></td></tr>");
		
		out.println("<tr><td><b><i>Password:</i></b></td>");
		out.println("<td><input class='form-control' type=password name=pwd size=30></td></tr>");
		
		out.println("<tr><td><b><i>Confirm Password:</i></b></td>");
		out.println("<td><input class='form-control' type=password name=cpwd size=30></td></tr>");
		
		out.println("<tr><td><b><i>Status:</i></b></td>");
		out.println("<td><input class='form-control' type=text readonly=true name=status size=30 value='Not Verified'></td></tr>");
		
		out.println("</table><br>");
		out.println("<input type=submit class='btn btn-success'>&nbsp;&nbsp;<input class='btn btn-danger' type=reset></br>");

		out.println("</form></center></html>");
		out.flush();
		
	}

}
