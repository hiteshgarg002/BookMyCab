package com.hrrock.view;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hrrock.controller.ClientController;
import com.hrrock.model.Client;

/**
 * Servlet implementation class PreviousBooking
 */
@WebServlet("/PreviousBooking")
public class PreviousBooking extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public PreviousBooking() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@SuppressWarnings("unused")
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		HttpSession ses = request.getSession();
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("    <link href='bootstrap.min.css' rel='stylesheet'>");
		Client C = null;
		try {
			C = (Client) ses.getAttribute("SCLIENT");
			String ltime = (String) ses.getAttribute("LTIME");
			C.getEmail();
		} catch (Exception e) {
			response.sendRedirect("ClientLogin");
		}

		try {
			ResultSet rs = ClientController.showPreviousBooking(C.getEmail());
			out.println("<html>");

			if (rs.next()) {
				out.println("<center><caption ><b style='color:white;'><i> List of Agency Bids</i></b></caption>");
				out.println("<table class='table table-bordered' style='width:90%; color:white; font-size:12px;'>");

				out.println(
						"<tr><th>Sn</th><th>Booking Id</th><th>Source/<br>Destination</th><th>From/<br>To</th><th>Vehicle</th><th>Current<Br>Date/Time</th><th>BidAmount</th><th>Confirm</th></tr>");
				int sn = 1;
				do {
					out.println("<tr><td>" + sn + "</td><td>" + rs.getString(1) + "</td><td>" + rs.getString(2)
							+ "&nbsp;<br>To &nbsp;" + rs.getString(3) + "</td><td>" + rs.getString(4) + "<br>"
							+ rs.getString(5) + "</td><td>" + rs.getString(6) + "</td><td>From " + rs.getString(7)
							+ "<br> to " + rs.getString(8) + "</td><td>" + rs.getString(9)
							+ "</td><td><a class='btn btn-info btn-xs' href=ChangeBookingStatus?bookingid="
							+ rs.getString(1) + ">Confirm</a></td></tr>");
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
