package com.nis.view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.nis.model.Agency;

/**
 * Servlet implementation class PhotographUpload
 */
@WebServlet("/PhotographUpload")
public class PhotographUpload extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PhotographUpload() {
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
		
		out.println("<script src='asset/jquery-3.2.1.min.js'></script>");
		out.println("<script src='asset/agencyvehicle.js'></script>");
		
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
				A =(Agency)ses.getValue("SAGENCY");
				
				out.println("<html>");
				out.println("    <link href='bootstrap.min.css' rel='stylesheet'>");
				out.println("<form action='PhotographUploadSubmit' method='post' enctype='multipart/form-data'>");
				out.println("<center><caption ><b style='color:white;'><i>Update Vehicle Pictures</i></b></caption>");
				out.println("<table class='table table-bordered' style='width:70%; color:white; font-size:12px;'>");
				
				
				out.println(""
						
		
				//	+ "<tr><td><b><i>Picture Id </i></b></td><td><input type=text id=pic name=pic></td></tr>"
					+ "<tr></tr><tr><td><b><i>Agency Id &emsp;</i></b></td>"
					+ "<td><input type=text class='form-control' id=agency name=agency value="+((Agency)ses.getValue("SAGENCY")).getAgencyid()+" readonly=true></td></tr>"
					+ "<tr><td><b><i>Vehicle Id </i></b></td>"
					+ "<td><select id=vehicle class='form-control' name=vehicle></select></td></tr>"
					+ "<tr><td><b><i>Type </i></b></td>"
					+ "<td><input type=radio name=pictype value=interior checked>&nbsp;Interior &emsp;<input type=radio name=pictype value=exterior>&nbsp;Exterior</td></tr>"
					+ "<tr><td><b><i>Photograph </i></b></td>"
					+ "<td><input type=file class='form-control' name=photo></td></tr>"
					+ "</table>"
					+ "<br><input type=submit class='btn btn-info btn-xs' value=Submit> <input class='btn btn-danger btn-xs' type=reset value=reset>"
					+ "</form></center></html>");
				out.flush();
		} catch(Exception e){
			out.println(e);
		}
	}

}
