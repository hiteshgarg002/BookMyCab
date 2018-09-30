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
 * Servlet implementation class VehicleDisplayById
 */
@WebServlet("/VehicleDisplayById")
public class VehicleDisplayById extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VehicleDisplayById() {
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
		out.println("<html>");
		out.println("<link href='bootstrap.min.css' rel='stylesheet'>");
		out.println("<form action='VehicleEditDelete'>");
		out.println("<center><caption ><b style='color:white;'><i>Search Vehicle</i></b></caption>");
		out.println("<table class='table table-bordered' style='width:70%; color:white; font-size:12px;'>");
		
	
		out.println(""
				+ "<tr>"
				+ "<td><b><i>Vehicle Id:</i></b></td>"
				+ "<td><input class='form-control' type=text name=vid size=30></td><td><input class='btn btn-info btn-xs' type=submit>"
				+ "</tr>"
				+ "</table></center>"
				+ "</html>");

		out.flush();
	
		
		
	}

}
