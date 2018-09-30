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

import com.hrrock.controller.AgencyController;
import com.hrrock.model.Admin;
import com.hrrock.model.Agency;

/*Servlet implementation class AgencySubmit
 */
@WebServlet("/AgencySubmit")
@MultipartConfig(fileSizeThreshold=1024*1024*2,//2MB
maxFileSize=1024*1024*10,//10MB
maxRequestSize=1024*1024*50)  //50 MB
public class AgencySubmit extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public AgencySubmit() {
    	super();
        // TODO Auto-generated constructor stub
    }

	 //@see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)

	 @SuppressWarnings("deprecation")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
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

		
		out.println("<html>");
		Agency A=new Agency();
		A.setAgencyname(request.getParameter("aname"));
		A.setOwnername(request.getParameter("oname"));
		A.setAddress(request.getParameter("add"));
		A.setState(request.getParameter("state"));
		A.setCity(request.getParameter("city"));
		A.setContactperson(request.getParameter("cperson"));
		A.setMobileno(request.getParameter("mobileno"));
	    A.setPhoneno(request.getParameter("phoneno"));
	    A.setEmailid(request.getParameter("emailid"));
	    A.setRegistrationid(request.getParameter("regid"));
	//  A.setRegistrationid_proof(request.getParameter("regproof"));
	    A.setIdentity(request.getParameter("identity"));
	//  A.setIdentity_proof(request.getParameter("idproof"));
	//  A.setLogo(request.getParameter("logo"));
	    A.setPassword(request.getParameter("pwd"));
	    A.setStatus(request.getParameter("status"));     
	   
	    Part p=request.getPart("regproof");
	    String path="M:\\numeric\\ProjectM\\BookMyCab\\WebContent\\picture";
	    FileUpload F=new FileUpload(p,path);
	    A.setRegistrationid_proof(F.filename);
	     
	    p=request.getPart("idproof");
	    path="M:\\numeric\\ProjectM\\BookMyCab\\WebContent\\picture";
	    F=new FileUpload(p,path);
	    A.setIdentity_proof(F.filename);
	    
	    p=request.getPart("logo");
	    path="M:\\numeric\\ProjectM\\BookMyCab\\WebContent\\picture";
	    F=new FileUpload(p,path);
	    A.setLogo(F.filename);
		boolean st=AgencyController.AddNewRecord(A);
		if(st)
		{ out.println("<b>Record Submitted</b>");
		}
		else {
			out.println("<b>Fail to submit Record</b>");
		}
		out.println("</html>");
		out.flush();
	}

}
