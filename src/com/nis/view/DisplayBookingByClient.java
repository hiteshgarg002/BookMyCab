package com.nis.view;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nis.controller.BookingController;

/**
 * Servlet implementation class DisplayBookingByClient
 */
@WebServlet("/DisplayBookingByClient")
public class DisplayBookingByClient extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DisplayBookingByClient() {
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
		try{
			ResultSet rs=BookingController.DisplayBookingByClient();
			out.println("<html>");
			out.println("    <link href='bootstrap.min.css' rel='stylesheet'>");
			out.println("<center><caption ><b style='color:white;'><i>List of Bookings</i></b></caption>");
			
			
	
			out.println("<table class='table table-bordered' style='width:90%; color:white;'>");
			
			if(rs.next())
			{
			out.println("<tr><th>S no.</th><th>Booking id</th><th>Client Email</th><th>Client Contact no</th><th>Vehicle Id</th><th>Booking Date</th><th>Booking</th><th>Source/Destination</th></tr>");
			int sn=1;
			do
			{
		    out.println("<tr align=center><td>"+sn+"</td><td>"+rs.getString("bookingid")+"</td><td>"+rs.getString("clientemail")+"</td><td>"+rs.getString("mobile")+"</td><td>"+rs.getString("vehicleid")+"</td><td>"+rs.getString("currentdate")+"</td><td>From "+rs.getString("bfrom")+"<br> to "+rs.getString("bto")+"</td><td>"+rs.getString("source")+" to "+rs.getString("destination")+"</td></tr>");		
			sn++;
		    }while(rs.next());
			out.print("</table></center></html>");
			}
			else
			{
			 out.println("No Bookings...");	
			}
			
			out.flush();
		}catch(Exception e)
		{
			out.println(e);
		}
		
	
	}

}
