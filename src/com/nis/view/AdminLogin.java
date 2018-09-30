package com.nis.view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AdminLogin
 */
@WebServlet("/AdminLogin")
public class AdminLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminLogin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	//	response.getWriter().append("Served at: ").append(request.getContextPath());
		
		PrintWriter out=response.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("    <link href='admin/css/application.min.css' rel='stylesheet'>");
		//out.println("    <link href='bootstrap.min.css' rel='stylesheet'>");
		out.println("    <script src='admin/lib/jquery/jquery-2.0.3.min.js'></script>");
		out.println("    <script src='admin/lib/jquery-pjax/jquery.pjax.js'></script>");
		out.println("    <script src='admin/lib/backbone/underscore-min.js'></script>");
		out.println("    <script src='admin/js/settings.js'></script>");
		out.println("</head>");
		out.println("<body>");
		out.println("<div class='single-widget-container'>");
		out.println("<section class='widget login-widget'>");
		out.println("<header class='text-align-center'>");
		out.println("<center><img src='admin/logo.png' class='img-responsive'></center>");
		out.println("<h4>Admin Login to your account</h4>");
		out.println("</header>");
		out.println("<div class='body'>");
		out.println("<form class='no-margin' action=AdminLoginCheck method=post>");
		out.println(" <fieldset>");
		out.println(" <div class='form-group no-margin'>");
		out.println(" <label for='email' >ADMIN ID</label>");
		out.println(" <div class='input-group input-group-lg'>");
		out.println(" <span class='input-group-addon'>");
		out.println(" <i class='eicon-user'></i>");
		out.println(" </span>");
		out.println("<input  type='text' name=aid class='form-control input-lg' placeholder='Your ID'>");
		out.println("</div>");
		out.println("</div>");
		out.println("<div class='form-group'>");
		out.println("<label for='password' >PASSWORD</label>");
		out.println("<div class='input-group input-group-lg'>");
		out.println("<span class='input-group-addon'>");
		out.println("<i class='fa fa-lock'></i>");
		out.println("</span>");
		out.println("<input  type='password' name=pwd class='form-control input-lg' placeholder='Your Password'>");
		out.println("</div>");
		out.println("</div>");
		out.println("</fieldset>");
		out.println("<div class='form-actions'>");
		out.println("<button type='submit' class='btn btn-block btn-lg btn-danger'>");
		out.println("<span class='small-circle'><i class='fa fa-caret-right' style='margin-top:3px;'></i></span>");
		out.println("<small>Sign In</small>");
		out.println("</button>");
		//out.println("<div class='forgot'><a class='forgot' href='#'>Forgot Username or Password?</a></div>");
		out.println("</div>");
		out.println("</form>");
		out.println("</div>");
		out.println("<footer>");
	//	out.println("<div class='facebook-login'>");
	//	out.println("<a href='UserCategoryView'><span> User Form</span></a>");
	//	out.println("</div>");
		out.println("</footer>");
		out.println("</section>");
		out.println("</div>");
		out.println("</body>");
		out.println("</html>");
		
		

		out.flush();
	}
		
}
