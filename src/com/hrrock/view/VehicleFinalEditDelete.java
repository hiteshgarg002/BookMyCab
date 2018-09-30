package com.hrrock.view;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import org.softech.FileUpload;

import com.hrrock.controller.VehicleController;
import com.hrrock.model.Agency;
import com.hrrock.model.AgencyVehicle;

/**
 * Servlet implementation class VehicleFinalEditDelete
 */
@WebServlet("/VehicleFinalEditDelete")
@MultipartConfig(fileSizeThreshold=1024*1024*2,//2 MB
maxFileSize=1024*1024*10,//10 MB 
maxRequestSize=1024*1024*50)

public class VehicleFinalEditDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VehicleFinalEditDelete() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@SuppressWarnings("deprecation")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
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

		
		String btn=request.getParameter("btn");
		AgencyVehicle V=new AgencyVehicle();
		
		if(btn.equals("Update"))
		{
			V.setVehicleid(request.getParameter("vid"));
			V.setAgencyid(request.getParameter("aid"));
			V.setVehiclename(request.getParameter("vname"));
			V.setModelyear(request.getParameter("myear"));
			V.setVehiclecolor(request.getParameter("vcolor"));
			V.setVehicletype(request.getParameter("vtype"));
			V.setVehiclecapacity(request.getParameter("vcapacity"));
			V.setInsurance(request.getParameter("insurance"));
			V.setAc(request.getParameter("ac"));
			V.setFueltype(request.getParameter("fuel"));
			@SuppressWarnings("unused")
			boolean st=VehicleController.EditRecord(V);
			response.sendRedirect("VehicleDisplayAll");
		}	
		else if(btn.equals("Delete"))
			{
				@SuppressWarnings("unused")
				boolean st=VehicleController.DeleteRecord(request.getParameter("vid"));
				response.sendRedirect("VehicleDisplayAll");
			}
		
		else if(btn.equals("Update Picture"))
		{
			String path="M:/numeric/ProjectM/BookMyCab/WebContent/vehiclepicture";
			Part p=request.getPart("vpicture");
			FileUpload F=new FileUpload(p,path);
			V.setVehicleid(request.getParameter("vid"));
			if(F.filename.equals("")){
				V.setVehiclepicture(request.getParameter("vpicture2"));
			} else {
				V.setVehiclepicture(F.filename);
			}
			@SuppressWarnings("unused")
			boolean st=VehicleController.EditVehiclePicture(V);
			response.sendRedirect("VehicleDisplayAll");
		}
	}
}
