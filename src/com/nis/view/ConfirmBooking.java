package com.nis.view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ConfirmBooking
 */
@WebServlet("/ConfirmBooking")
public class ConfirmBooking extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ConfirmBooking() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@SuppressWarnings("deprecation")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at: ").append(request.getContextPath());
		
		PrintWriter out=response.getWriter();
	    HttpSession ses=request.getSession();
		out.println("<html> <link href='bootstrap.min.css' rel='stylesheet'>"
				
	    		+ "<center><table class='table table-bordered' style='width:90%; color:white; font-size:12px;' cellpadding=10 cellspacing=7>"
	    		+ "<tr>"
 	      		+ "<td><img class='img-thumbnail' src=vehiclepicture/"+ses.getValue("SPICTURE")+" width=150 height=150></td>"
	     		+ "<td>"
	     		+ "<b><i>Vehicle Id:</i></b>"+ses.getValue("SVID")+"<br>"
	     		+ "<b><i>Vehicle:</i></b>"+ses.getValue("SVN")+"("+ses.getValue("SFTYPE")+")<br>"
	    		+ "<b><i>Model:</i></b>"+ses.getValue("SMODEL")+"<br>"
	    		+ "<b><i>Color:</i></b>"+ses.getValue("SCOLOR")+"<br>"
	    		+ "</td>"
	    		+ "<td>"
	    		+ "<b><i>Type:</i></b>"+ses.getValue("STYPE")+"<br>"
	    		+ "<b><i>Capacity:</i></b>"+ses.getValue("SCAPACITY")+"<br>"
	    		+ "<b><i>Inssurance</i></b>"+ses.getValue("SINS")+"<br>"
	    		+ "<b><i>AC:</i></b>"+ses.getValue("SVAC")+"<br>"
	    		+ "</td>"
	    		+ "<td>"
	    
	    		+ "<b><i>From:</i></b>"+ses.getValue("SFROM")+"<br>"
	    		+ "<b><i>To:</i></b>"+ses.getValue("STO")+"<br>"
 
	    		+ "<b><i>Source:</i></b>"+ses.getValue("SCITY")+"<br>"
	    		+ "<b><i>Destination:</i></b>"+ses.getValue("SDCITY")+"<br>"
	   
	    		+ "</td></table><br>&emsp;<a class='btn btn-info btn-xs' href='ConfirmBookingFinal'><input class='btn btn-info btn-xs' type=button id='confirm' value='confirm'></a><br></center>");
	}

}
