package com.nis.view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.nis.controller.VehicleController;
import com.nis.model.Agency;
import com.nis.model.AgencyVehicle;

/**
 * Servlet implementation class VehicleEditDelete
 */
@WebServlet("/VehicleEditDelete")
public class VehicleEditDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VehicleEditDelete() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@SuppressWarnings("deprecation")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	//	response.getWriter().append("Served at: ").append(request.getContextPath());
	
		AgencyVehicle V=VehicleController.DisplayById(request.getParameter("vid"));
		PrintWriter out=response.getWriter();

		HttpSession ses=request.getSession();
		
		////////////Session invoke/////////////
		Agency A;
		try	{
				A =(Agency)ses.getValue("SAGENCY");
				String ltime=(String)ses.getValue("SLTIME");
				@SuppressWarnings("unused")
				String navigbar="<h3><font color=darkblue>Agency Id:"+A.getAgencyid()+"&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;"+A.getAgencyname()+"&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;"+ltime+"</font>&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;<img src=picture/"+A.getLogo()+" width=40 height=40 valign=bottom>&emsp;&emsp;&emsp;<a href=AgencyLogout>Logout</a></h3><hr color=red>";
		}	
		catch(Exception e){		//	out.println(e);
			response.sendRedirect("AgencyLogin");	}
		////////////////////////////////////////

		
		
		out.println("<html>");
		out.println("    <link href='bootstrap.min.css' rel='stylesheet'>");
		out.println("<center><caption><b>Vehicle Data</b></caption>");
	
		
		out.println("<center><form action='VehicleFinalEditDelete' method='post' enctype='multipart/form-data'>");
		
		out.println("<input type=hidden value="+V.getVehicleid()+" name=vid>");
	   	out.println("<table valign=top class='table table-bordered' style='width:90%; color:white; font-size:12px;'><tr>");
	   	out.println("<td valign=top>");
	   	
	   	out.println("<table valign=top cellspacing=5 cellpadding=2 class='table table-bordered' style='width:90%; color:white; font-size:12px;'>");
	 
		
		out.println("<tr><tr></tr></tr><tr><td><b><i>Agency Id :</i></b></td>");
		out.println("<td><input class='form-control' type=text name=aid value='"+V.getAgencyid()+"' size=30></td></tr>");
				
	//	out.println("<tr><td><b><i>Vehicle Id:</i></b></td>");
	//	out.println("<td><input type=text name=vid size=30></td></tr>");
		
		out.println("<tr><td><b><i>Vehicle Name:</i></b></td>");
		out.println("<td><input class='form-control' type=text name=vname value='"+V.getVehiclename()+"' size=30></td></tr>");
		
		out.println("<tr><td><b><i>Model Year:</i></b></td>");
		out.println("<td><input class='form-control' type=month name=myear value='"+V.getModelyear()+"'></td></tr>");
			
		out.println("<tr><td><b><i>Vehicle Colour:</i></b></td>");
		//	out.println("<td><input type=text name=vcolor size=30></td></tr>");
		out.println("<td><select class='form-control' name=vcolor value='"+V.getVehiclecolor()+"'>"
					+ "<option>"+V.getVehiclecolor()+"</option>"
					+ "<option>SELECT COLOR</option>"
					+ "<option>Black</option>"
					+ "<option>White</option>"
					+ "<option>Red</option>"
					+ "<option>Blue</option>"
					+ "<option>Orange</option>"
					+ "<option>Grey</option>"
					+ "<option>Violet</option>"
					+ "<option>Green</option>"
					+ "<option>Brown</option>"
					+ "<option>Chocolate</option>"
					+ "<option>Matte Black</option>"
					+ "<option>Lava Red</option>"
					+ "</select></td></tr>");
		
		out.println("<tr><td><b><i>Vehicel Type:</i></b></td>");
		out.println("<td><select class='form-control' name=vtype value='"+V.getVehicletype()+"'>"
				+ "<option>"+V.getVehicletype()+"</option>"
				+ "<option>SELECT TYPE</option>"
				+ "<option>SUV</option>"
				+ "<option>Hatchback</option>"
				+ "<option>Sedans</option>"
				+ "<option>MUV</option>"
				+ "<option>Luxury</option>"
				+ "<option>Coupe</option>"
				+ "<option>Convertible</option>"
				+ "<option>Minivans</option>"
				+ "<option>Hybrids</option>"
				+ "<option>Van</option>"
				+ "<option>Crossover</option>"
				+ "<option>Pickup Truks</option>"
				+ "</select></td></tr>");
		
		out.println("<tr><td><b><i>Capacity:</i></b></td>");
		out.println("<td><select class='form-control' name=vcapacity value='"+V.getVehiclecapacity()+"' >"
				+ "<option>"+V.getVehiclecapacity()+"</option>"
				+ "<option>SELECT</option>"
				+ "<option value=2>2 Seater</option>"
				+ "<option value=4>4 Seater</option>"
				+ "<option value=6>6 Seater</option>"
				+ "<option value=7>7 Seater</option>"
				+ "<option value=9>9 Seater</option>"
				+ "<option value=12>12 Seater</option>"
				+ "<option value=14>14 Seater</option>"
				+ "<option value=28>28 Seater</option>"
				+ "</select></td></tr>");
		
		out.println("<tr><td><b><i>Insurance:</i></b></td>");
		if(V.getInsurance().equalsIgnoreCase("yes")){
			out.println("<td>Yes &nbsp;<input type=radio name=insurance Value=Yes checked>&emsp;No &nbsp;<input type=radio name=insurance value=No></td></tr>");
		}else //if(V.getInsurance().equalsIgnoreCase("no")){
			{out.println("<td>Yes &nbsp;<input type=radio name=insurance Value=Yes>&emsp;No &nbsp;<input type=radio name=insurance value=No checked></td></tr>");
		} 
		
		out.println("<tr><td><b><i>Air Conditioner:</i></b></td>");
		if(V.getAc().equalsIgnoreCase("yes")){
			out.println("<td>Yes &nbsp;<input type=radio name=ac value=Yes checked>&emsp;No &nbsp;<input type=radio name=ac value=No></td></tr>");	
		} else //if(V.getAc().equalsIgnoreCase("no")){
			{out.println("<td>Yes &nbsp;<input type=radio name=ac value=Yes>&emsp;No &nbsp;<input type=radio name=ac value=No checked></td></tr>");
		}
		
		
		out.println("<tr><td><b><i>Fuel Type:</i></b></td>");
		out.println("<td><select class='form-control' name=fuel value='"+V.getFueltype()+"' >"
				+ "<option>"+V.getFueltype()+"</option>"
				+ "<option>TYPE</option>"
				+ "<option>Petrol</option>"
				+ "<option>Diesel</option>"
				+ "<option>CNG</option>"
				+ "<option>LPG</option>"
				+ "<option>Electric</option>"
				+ "<option>Petrol & CNG</option>"
				+ "<option>Petrol & LPG</option>"
				+ "</select></td></tr>");
			
		out.println("</table><br>");
		out.println("&nbsp;&nbsp;<input class='btn btn-info btn-xs' type=submit value=Update name=btn>  <input type=submit class='btn btn-danger btn-xs' value=Delete name=btn>");
	   	
		out.println("</td><td valign=top>");
		out.println("<input type=hidden class='form-control' name=vpicture2 value='"+V.getVehiclepicture()+"'>");
	    out.println("<b><i>Vehicle picture:</i></b>&nbsp;<br><br><img class='img-thumbnail' src=vehiclepicture/"+V.getVehiclepicture()+" width=80 height=80><br><br>");
	    out.println("Update Vehicle Picture :&nbsp; <input class='form-control' type=file name=vpicture><br><br>");
	    out.println("<input type=submit class='btn btn-info btn-xs' name=btn value='Update Picture'>");
	    out.println("</td>");
	        
	    out.println("</tr></table>");
	    out.println("</form></center></html>");
	   	out.flush();
	
	}
}
