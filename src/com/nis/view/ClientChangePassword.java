package com.nis.view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.nis.model.Client;

/**
 * Servlet implementation class ClientChangePassword
 */
@WebServlet("/ClientChangePassword")
public class ClientChangePassword extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ClientChangePassword() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
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
		
		
		out.println("<html>");
		out.println("    <link href='bootstrap.min.css' rel='stylesheet'>");
		out.println("<center><form action='ClientChangePasswordFinal' method='post'>");
		out.println("<table class='table table-bordered' style='width:70%; color:white; font-size:12px;'>");
		out.println("<tr><td><b><i>Old Password:</i></b></td>");
		out.println("<td><input class='form-control' type=text name=opwd value='"+C.getPassword()+"' size=30></td></tr><br>");
		
		out.println("<tr><td><b><i>New Password:</i></b></td>");
		out.println("<td>&emsp;&emsp;<input class='form-control' type=text name=npwd size=30></td></tr><br>");
		
		out.println("<tr><td><b><i>Confirm Password:</i></b></td>");
		out.println("<td>&nbsp;<input class='form-control' type=text name=cpwd size=30></td></tr></form></table></html><br>");
		
		out.println("<input type=submit class='btn btn-danger btn-xs' name=button value='Update'></center>");
		
		
	}

}
