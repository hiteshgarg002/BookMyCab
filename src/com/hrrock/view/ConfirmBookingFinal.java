package com.hrrock.view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hrrock.controller.BookingController;
import com.hrrock.model.Booking;
import com.hrrock.model.Client;

/**
 * Servlet implementation class ConfirmBookingFinal
 */
@WebServlet("/ConfirmBookingFinal")
public class ConfirmBookingFinal extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ConfirmBookingFinal() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at: ").append(request.getContextPath());

		PrintWriter out = response.getWriter();
		HttpSession ses = request.getSession();

		Client C = (Client) ses.getAttribute("SCLIENT");
		/*
		 * out.println("<html>"); Booking B=new Booking(); String a=(String)
		 * ses.getAttribute("mail"); String b=(String) ses.getAttribute("mob"); String
		 * c=(String) ses.getAttribute("SVID"); String d=(String)
		 * ses.getAttribute("SFROM"); String e=(String) ses.getAttribute("STO"); String
		 * f=(String) ses.getAttribute("SCITY"); String g=(String)
		 * ses.getAttribute("SDCITY"); String h=(String) ses.getAttribute("time");
		 * 
		 * B.setClientEmail(a); B.setMobile(b); B.setVehicleId(c); B.setBookingFrom(d);
		 * B.setBookingTo(e); B.setSource(f); B.setDestination(g); B.setCurrentDate(h);
		 */
		out.println("<html>");
		Booking B = new Booking();
		B.setClientEmail(C.getEmail());
		B.setMobile(C.getMobile());
		B.setVehicleId(ses.getAttribute("SVID").toString());
		B.setBookingFrom(ses.getAttribute("SFROM").toString());
		B.setBookingTo(ses.getAttribute("STO").toString());
		B.setSource(ses.getAttribute("SCITY").toString());
		B.setDestination(ses.getAttribute("SDCITY").toString());
		B.setCurrentDate(new java.util.Date().toString());
		B.setStatus("UnBooked");

		boolean st = BookingController.AddRecord(B);
		if (st) {
			out.println("<b>Request Submitted Successfully...</b>");
		} else {
			out.println("<b>Failed to submit your request...</b>");
		}

		out.println("</html>");
		out.flush();

	}

}
