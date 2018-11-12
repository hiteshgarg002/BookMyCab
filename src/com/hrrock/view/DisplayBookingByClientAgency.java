package com.hrrock.view;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hrrock.controller.BookingController;

/**
 * Servlet implementation class DisplayBookingByClientAgency
 */
@WebServlet("/DisplayBookingByClientAgency")
public class DisplayBookingByClientAgency extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DisplayBookingByClientAgency() {
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
		try {
			ResultSet rs = BookingController.DisplayBookingByClient();
			out.println("<html>");
			out.println("    <link href='bootstrap.min.css' rel='stylesheet'>");
			out.println(
					"<center><caption><b>List of Bookings</b></caption><table class='table table-bordered' style='width:90%; color:white; font-size:12px;'>");

			if (rs.next()) {
				out.println(
						"<tr><th>S no.</th><th>Booking Id</th><th>Vehicle Description</th><th>Booking Date</th><th>Booking</th><th>Source/Destination</th><th>Action</th></tr>");
				int sn = 1;
				do {
					out.println("<tr align=center><td>" + sn + "</td><td>" + rs.getString("bookingid")
							+ "</td><td><a class='btn btn-danger btn-xs' href=#?vid=" + rs.getString("vehicleid")
							+ ">Click Here</a>" + "</td><td>" + rs.getString("currentdate") + "</td><td>From "
							+ rs.getString("bfrom") + "<br> To " + rs.getString("bto") + "</td><td>"
							+ rs.getString("source") + " <br> to " + rs.getString("destination")
							+ "</td><td><a class='btn btn-info btn-xs' href=ApplyBid?bid=" + rs.getString(2)
							+ ">ApplyBid</a></td></tr>");
					sn++;
				} while (rs.next());
				out.print("</table></center></html>");
			} else {
				out.println("No Bookings...");
			}

			out.flush();
		} catch (Exception e) {
			out.println(e);
		}

	}

}
