package com.nis.view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONException;
import org.json.JSONObject;

import com.nis.controller.ClientController;
import com.nis.model.Client;

/**
 * Servlet implementation class ClientSignUpSubmit
 */
@WebServlet("/ClientSignUpSubmit")
public class ClientSignUpSubmit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ClientSignUpSubmit() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		PrintWriter out= response.getWriter();
/*		HttpSession ses= request.getSession();
		
		//////////////session management////////////////
		Client client;
		try{
				client=(Client)ses.getValue("CLIENT");	
				String ltime=(String)ses.getValue("CLTIME");
				ses.setMaxInactiveInterval(15*60); //15 minute
				@SuppressWarnings("unused")
				String navbar="<h4>User Id:"+client.getEmail()+"&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;"+client.getFirstname()+"&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;"+ltime+"&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;<a href=ClientLogout>Logout</a></h4><hr color=red>";
				}
			catch(Exception e){
				//	out.println(e);
				response.sendRedirect("ClientLogin");	
		}
		////////////////////////////////////////////////
*/	  
 	   
		Client C=new Client();
		
		C.setEmail(request.getParameter("email"));
		C.setMobile(request.getParameter("mobile"));
		C.setFirstname(request.getParameter("fname"));
		C.setLastname(request.getParameter("lname"));
		C.setDob(request.getParameter("dob"));
		C.setGender(request.getParameter("gender"));
		C.setAddress(request.getParameter("add"));
		C.setState(request.getParameter("state"));
		C.setCity(request.getParameter("city"));
		C.setPassword(request.getParameter("pwd"));
		
		boolean st=ClientController.AddNewRecord(C);
		JSONObject obj=new JSONObject();
		try{
				if(st)
					{obj.put("result", "Record Submitted...");}
				else
					{obj.put("result", "Fail to Submit Record...");}
			out.println(obj);
			} catch(Exception e)
				{
				try {
					obj.put("result", e.getMessage());
				} catch (JSONException e1) {
					e1.printStackTrace();
					}
				out.println(e);
			}


	}

}
