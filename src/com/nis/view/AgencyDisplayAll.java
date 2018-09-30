package com.nis.view;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.nis.controller.AgencyController;
import com.nis.model.Admin;

/**
 * Servlet implementation class AgencyDisplayAll
 */
@WebServlet("/AgencyDisplayAll")
public class AgencyDisplayAll extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AgencyDisplayAll() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@SuppressWarnings("deprecation")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
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

		
		try{
				out.println("<html>");
				out.println("    <link href='bootstrap.min.css' rel='stylesheet'>");
				ResultSet rs=AgencyController.DisplayAll();
				if(rs.next())
				{
					out.println("<center><caption ><b style='color:white;'><i>List of Agencies</i></b></caption>");
					out.println("<table class='table table-bordered' style='width:70%; color:white; font-size:12px;'>");
					
					
					
					out.println("<tr><th>Sno</th><th>Agency</th><th>Address</th><th>Contact</th><th>Registration</th><th>Id Proof</th><th>Logo</th><th>Update</th></tr>");
					int sn=1;
					do{
						out.println("<tr><td align=center>"+sn+"</td><td>"+rs.getString(1)+"<br>"+rs.getString(2)+"<br>"+rs.getString(3)+"</td><td>"+rs.getString(4)+"<br>"+rs.getString(6)+",&nbsp;"+rs.getString(5)+"</td><td>"+rs.getString(7)+"<br>Mobile:&nbsp;"+rs.getString(8)+"<br>PH:&nbsp;"+rs.getString(9)+"<br>Email:&nbsp;"+rs.getString(10)+"</td><td>"+rs.getString(11)+"<br><a href=picture/"+rs.getString(12)+"><img src=picture/"+rs.getString(12)+" width=50 height=50></a></td><td>"+rs.getString(13)+"<br><a href=picture/"+rs.getString(14)+"><img src=picture/"+rs.getString(14)+" width=50 height=50></a></td><td><a href=picture/"+rs.getString(15)+"><img src=picture/"+rs.getString(15)+" height=50 width=50></a></td><td><a class='btn btn-info btn-xs' href=AgencyEditDelete?aid="+rs.getString(1)+">Edit/Delete</a></td></tr>");
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
