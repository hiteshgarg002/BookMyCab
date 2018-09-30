package com.hrrock.view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import org.softech.FileUpload;

import com.hrrock.controller.PhotographController;
import com.hrrock.model.Agency;
import com.hrrock.model.Photograph;

/**
 * Servlet implementation class PhotographUploadSubmit
 */
@WebServlet("/PhotographUploadSubmit")
@MultipartConfig(fileSizeThreshold=1024*1024*2,//2MB
maxFileSize=1024*1024*10,//10MB
maxRequestSize=1024*1024*50)//50 MB

public class PhotographUploadSubmit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PhotographUploadSubmit() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@SuppressWarnings("deprecation")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
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
		Photograph P=new Photograph();
		
		P.setAgencyid(request.getParameter("agency"));
		P.setVehicleid(request.getParameter("vehicle"));
		P.setType(request.getParameter("pictype"));
	//	P.setPicture(request.getParameter("photo"));
		
		Part part=request.getPart("photo");
		String path="M:/numeric/ProjectM/BookMyCab/WebContent/vehiclepicture";
		FileUpload F=new FileUpload(part,path);
		P.setPicture(F.filename);
		
		boolean ph=PhotographController.AddNewPhoto(P);
		if(ph)
		{	
			out.println("<b>photographs updated</b>");
		}	
		else { out.println("<b>Fail to submit Record</b>"); }
			
		out.println("</html>");
		out.flush();
	}

}
