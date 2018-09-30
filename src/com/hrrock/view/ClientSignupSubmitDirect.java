package com.hrrock.view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hrrock.controller.ClientController;
import com.hrrock.model.Client;

/**
 * Servlet implementation class ClientSignupSubmitDirect
 */
@WebServlet("/ClientSignupSubmitDirect")
public class ClientSignupSubmitDirect extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ClientSignupSubmitDirect() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		PrintWriter out= response.getWriter();
		
		
		out.println("<html>");
		Client C=new Client();
		
		C.setEmail(request.getParameter("email"));
		C.setMobile(request.getParameter("mobile"));
		C.setFirstname(request.getParameter("fname"));
		C.setLastname(request.getParameter("lname"));
		C.setDob(request.getParameter("dob"));
		C.setGender(request.getParameter("gender"));
		C.setAddress(request.getParameter("add"));
		C.setState(request.getParameter("state"));
		C.setCity(request.getParameter("city"));
		C.setPassword(request.getParameter("pwd"));
		
		boolean st=ClientController.AddNewRecord(C);
		if(st)
		{	
			out.println("<b>Record Submitted</b>");
			response.sendRedirect("ClientHomeDirect");
		}	
		else { out.println("<b>Fail to submit Record</b>"); }
			
		out.println("</html>");
		out.flush();
		
	
	}

}
