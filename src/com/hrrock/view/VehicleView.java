package com.hrrock.view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hrrock.model.Agency;

/**
 * Servlet implementation class VehicleView
 */
@WebServlet("/VehicleView")
public class VehicleView extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public VehicleView() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@SuppressWarnings("deprecation")
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at: ").append(request.getContextPath());
		PrintWriter out = response.getWriter();
		HttpSession ses = request.getSession();

		//////////// Session invoke/////////////
		Agency A;
		try {
			A = (Agency) ses.getValue("SAGENCY");
			String ltime = (String) ses.getValue("SLTIME");
			@SuppressWarnings("unused")
			String navigbar = "<h4><font color=darkblue>Agency Id:" + A.getAgencyid()
					+ "&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;" + A.getAgencyname()
					+ "&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;" + ltime
					+ "</font>&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;<img src=picture/"
					+ A.getLogo()
					+ " width=40 height=40 valign=bottom>&emsp;&emsp;&emsp;<a href=AgencyLogout>Logout</a></h4><hr color=red>";
		} catch (Exception e) { // out.println(e);
			response.sendRedirect("AgencyLogin");
		}
		////////////////////////////////////////

		out.println("<html>");
		out.println("    <link href='bootstrap.min.css' rel='stylesheet'>");
		out.println("<form action='VehicleSubmit' method='post' enctype='multipart/form-data'>");
		out.println("<center><caption ><b style='color:white;'><i>Agency Vehicle Data</i></b></caption>");
		out.println("<table class='table table-bordered' style='width:70%; color:white; font-size:12px;'>");

		out.println("<tr><tr></tr></tr><tr><td><b><i>Agency Id :</i></b></td>");
		out.println("<td><input class='form-control' type=text name=aid size=30></td></tr>");

		out.println("<tr><td><b><i>Vehicle Id:</i></b></td>");
		out.println("<td><input class='form-control' type=text name=vid size=30></td></tr>");

		out.println("<tr><td><b><i>Vehicle Name:</i></b></td>");
		out.println("<td><input class='form-control' type=text name=vname size=30></td></tr>");

		out.println("<tr><td><b><i>Model Year:</i></b></td>");
		out.println("<td><input class='form-control' type=month name=myear></td></tr>");

		out.println("<tr><td><b><i>Vehicle Colour:</i></b></td>");
		// out.println("<td><input type=text name=vcolor size=30></td></tr>");
		out.println("<td><select class='form-control' name=vcolor>" + "<option>SELECT COLOR</option>"
				+ "<option>Black</option>" + "<option>White</option>" + "<option>Red</option>" + "<option>Blue</option>"
				+ "<option>Orange</option>" + "<option>Greay</option>" + "<option>Violet</option>"
				+ "<option>Green</option>" + "<option>Brown</option>" + "<option>Chocolate</option>"
				+ "<option>Matte Black</option>" + "<option>Lava Red</option>" + "</select></td></tr>");

		out.println("<tr><td><b><i>Vehicle Type:</i></b></td>");
		// out.println("<td><input type=text name=vtype size=30></td></tr>");
		out.println(
				"<td><select class='form-control' name=vtype>" + "<option>SELECT TYPE</option>" + "<option>SUV</option>"
						+ "<option>Hatchback</option>" + "<option>Sedans</option>" + "<option>MUV</option>"
						+ "<option>Luxury</option>" + "<option>Coupe</option>" + "<option>Convertible</option>"
						+ "<option>Minivans</option>" + "<option>Hybrids</option>" + "<option>Van</option>"
						+ "<option>Crossover</option>" + "<option>Pickup Truks</option>" + "</select></td></tr>");

		out.println("<tr><td><b><i>Vehicle Capacity:</i></b></td>");
		// out.println("<td><input type=text name=vcapacity size=30></td></tr>");
		out.println("<td><select class='form-control' name=vcapacity>" + "<option>SELECT</option>"
				+ "<option value=2>2 Seater</option>" + "<option value=4>4 Seater</option>"
				+ "<option value=6>6 Seater</option>" + "<option value=7>7 Seater</option>"
				+ "<option value=9>9 Seater</option>" + "<option value=12>12 Seater</option>"
				+ "<option value=14>14 Seater</option>" + "<option value=28>28 Seater</option>"
				+ "</select></td></tr>");

		out.println("<tr><td><b><i>Insurance Policy:&emsp;</i></b></td>");
		// out.println("<td><input type=text name=ipolicy size=30></td></tr>");
		out.println(
				"<td>Yes <input type=radio name=insurance value=Yes checked>&emsp;No &nbsp;<input type=radio name=insurance Value=No></td></tr>");

		out.println("<tr><td><b><i>Air Conditioner:</i></b></td>");
		out.println(
				"<td>Yes <input type=radio name=ac value=Yes checked>&emsp;No &nbsp;<input type=radio name=ac value=No></td></tr>");

		out.println("<tr><td><b><i>Fuel Type:</i></b></td>");
		// out.println("<td><input name=fuel type=checkbox
		// value=petrol>&nbsp;<label>Petrol</label>&emsp;<input name=fuel type=checkbox
		// value=diesel>&nbsp;<label>diesel</label>&emsp;<input name=fuel type=checkbox
		// value=gas>&nbsp;<label>gas</label></td></tr>");
		// out.println("<td><input type=text name=fuel></td></tr>");
		out.println("<td><select class='form-control' name=fuel>" + "<option>SELECT</option>"
				+ "<option>Petrol</option>" + "<option>Diesel</option>" + "<option>CNG</option>"
				+ "<option>LPG</option>" + "<option>Electric</option>" + "<option>Petrol & CNG</option>"
				+ "<option>Petrol & LPG</option>" + "</select></td></tr>");

		out.println("<tr><td><b><i>Upload Pictures :</i></b></td>");
		out.println("<td><input class='form-control' type=file name=vpicture></td></tr>");

		out.println("</table><br>");
		out.println(
				"<input class='btn btn-success btn-xs' type=submit> <input class='btn btn-danger btn-xs' type=reset></br>");

		out.println("</form><center></html>");
		out.flush();

	}

}
