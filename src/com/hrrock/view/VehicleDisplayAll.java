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

import com.hrrock.controller.VehicleController;
import com.hrrock.model.Agency;

/**
 * Servlet implementation class VehicleDisplayAll
 */
@WebServlet("/VehicleDisplayAll")
public class VehicleDisplayAll extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VehicleDisplayAll() {
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

		
		
		try{
				out.println("<html>");
				out.println("    <link href='bootstrap.min.css' rel='stylesheet'>");
				ResultSet rs=VehicleController.DisplayAll();
				if(rs.next())
				{
					out.println("<center><caption ><b style='color:white;'><i>List of Agency Vehicles</i></b></caption>");
					out.println("<table class='table table-bordered' style='width:90%; color:white; font-size:12px;'>");
					
					
					
					out.println("<tr align=center><th>Sno</th><th>Vehicle</th><th>Agency Id</th><th>Model year</th><th>Colour</th><th>Vehicle Type</th><th>Capacity</th><th>Insurance</th><th>Air Conditionar</th><th>Fuel type</th><th>Picture</th><th>Update</th></tr>");
					int sn=1;
					do{
						out.println("<tr align=center><td>"+sn+"</td><td align=left>ID :&nbsp;"+rs.getString("vehicleid")+"<br>Name :&nbsp;"+rs.getString("vehiclename")+"</td><td>"+rs.getString("agencyid")+"</td><td>"+rs.getString("modelyear")+"</td><td align=left>"+rs.getString("vehiclecolor")+"</td><td>"+rs.getString("vehicletype")+"</td><td>"+rs.getString("vehiclecapacity")+"</td><td>"+rs.getString("insurance")+"</td><td>"+rs.getString("ac")+"</td><td>"+rs.getString("fueltype")+"</td><td><a href=vehiclepicture/"+rs.getString("picture")+"><img src=vehiclepicture/"+rs.getString("picture")+" width=50 height=50 class='img-thumbnail'></a></td><td><a class='btn btn-info btn-xs' href=VehicleEditDelete?vid="+rs.getString(1)+">Edit/Delete</a></td></tr>");
						sn++;
					} while(rs.next());
						out.println("</table></center>");
				}
				else
				{
					out.println("Record Not Found");
				}
				out.print("</html>");
					out.flush();
		}catch (Exception e) {
			out.println(e);
			}
		
	}

}
