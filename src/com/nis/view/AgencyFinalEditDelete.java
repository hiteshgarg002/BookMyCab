package com.nis.view;

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

import com.nis.controller.AgencyController;
import com.nis.model.Admin;
import com.nis.model.Agency;

/**
 * Servlet implementation class AgencyFinalEditDelete
 */
@WebServlet("/AgencyFinalEditDelete")
@MultipartConfig(fileSizeThreshold=1024*1024*2,//2 MB
 maxFileSize=1024*1024*10,//10 MB 
 maxRequestSize=1024*1024*50)

public class AgencyFinalEditDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AgencyFinalEditDelete() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@SuppressWarnings("deprecation")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		HttpSession ses= request.getSession();
		//////////////session management////////////////
		Admin admin;
		try{
		admin=(Admin)ses.getValue("SADMIN");	
		String ltime=(String)ses.getValue("SLTIME");
		@SuppressWarnings("unused")
		String navbar="<h4>Admin Id:"+admin.getAdminId()+"&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;"+admin.getAdminName()+"&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;"+ltime+"&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;<img src=picture/"+admin.getPicture()+" width=40 height=40>&emsp;&emsp;&emsp;<a href=AdminLogout>Logout</a></h4><hr color=red>";
		}catch(Exception e){
		//	out.println(e);
		response.sendRedirect("AdminLogin");	
		}
		////////////////////////////////////////////////

		
		String btn=request.getParameter("btn");
		if(btn.equals("Update"))
		{
			Agency A=new Agency();
			A.setAgencyid(request.getParameter("aid"));
			A.setAgencyname(request.getParameter("aname"));
			A.setOwnername(request.getParameter("oname"));
			A.setAddress(request.getParameter("add"));
			A.setState(request.getParameter("state"));
			A.setCity(request.getParameter("city"));
			A.setContactperson(request.getParameter("cperson"));
			A.setMobileno(request.getParameter("mobileno"));
			A.setPhoneno(request.getParameter("phoneno"));
			A.setEmailid(request.getParameter("emailid")); 
			A.setStatus(request.getParameter("status"));      
			@SuppressWarnings("unused")
			boolean st=AgencyController.EditRecord(A);
			response.sendRedirect("AgencyDisplayAll");
			}
		else if(btn.equals("Delete"))
			{
				@SuppressWarnings("unused")
				boolean st=AgencyController.DeleteRecord(Integer.parseInt(request.getParameter("aid")));
				response.sendRedirect("AgencyDisplayAll");
			}
		else if(btn.equals("Update Registration"))
			{
				String path="M:\\numeric\\ProjectM\\BookMyCab\\WebContent\\picture";
				Part part=request.getPart("regproof");
				FileUpload F=new FileUpload(part,path);
				Agency A=new Agency();
				A.setAgencyid(request.getParameter("aid"));
				A.setRegistrationid(request.getParameter("regid"));
				if(F.filename.equals("")){
					A.setRegistrationid_proof(request.getParameter("regproof2"));
				}else{
					A.setRegistrationid_proof(F.filename);
				}
				@SuppressWarnings("unused")
				boolean st=AgencyController.EditRegistration(A);
				response.sendRedirect("AgencyDisplayAll");
			}
		
		else if(btn.equals("Update Identity"))
		{
			String path="M:\\numeric\\ProjectM\\BookMyCab\\WebContent\\picture";
			Part part=request.getPart("idproof");
			FileUpload F=new FileUpload(part,path);
			Agency A=new Agency();
			A.setAgencyid(request.getParameter("aid"));
			A.setIdentity(request.getParameter("identity"));
			if(F.filename.equals("")){
				A.setIdentity_proof(request.getParameter("ifproof2"));
			}else{
					A.setIdentity_proof(F.filename);
			}
			@SuppressWarnings("unused")
			boolean st=AgencyController.EditIdentity(A);
			response.sendRedirect("AgencyDisplayAll");
		}
		
		else if(btn.equals("Update Logo"))
		{
			String path="M:\\numeric\\ProjectM\\BookMyCab\\WebContent\\picture";
			Part part=request.getPart("logo");
			FileUpload F=new FileUpload(part,path);
			Agency A=new Agency();
			A.setAgencyid(request.getParameter("aid"));
			A.setLogo(F.filename);
			@SuppressWarnings("unused")
			boolean st=AgencyController.EditLogo(A);
			response.sendRedirect("AgencyDisplayAll");
		}
	
	}
}
