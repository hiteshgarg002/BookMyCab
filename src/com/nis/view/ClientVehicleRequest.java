package com.nis.view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


/**
 * Servlet implementation class ClientVehicleRequest
 */
@WebServlet("/ClientVehicleRequest")
public class ClientVehicleRequest extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ClientVehicleRequest() {
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
//		Client C = null;
			////***///
		    
			ses.putValue("SVID", request.getParameter("vid"));
		    ses.putValue("SPICTURE", request.getParameter("vpicture"));
		    ses.putValue("SVN", request.getParameter("vn"));
		    ses.putValue("SMODEL", request.getParameter("vmodel"));
		    ses.putValue("SCOLOR", request.getParameter("vcolor"));
		    ses.putValue("STYPE", request.getParameter("vtype"));
		    ses.putValue("SCAPACITY", request.getParameter("vcapacity"));
		    ses.putValue("SINS", request.getParameter("vins"));
		    ses.putValue("SVAC", request.getParameter("vac"));
		    ses.putValue("SFROM", request.getParameter("from"));
		    ses.putValue("STO", request.getParameter("to"));
		    ses.putValue("SCITY", request.getParameter("city"));
		    ses.putValue("SDCITY", request.getParameter("dcity"));
		    ses.putValue("SFTYPE", request.getParameter("vftype"));
		    
		  
		out.println("<html>");
		out.println("<head>");
		  /////////
				out.println("<script src='asset/jquery-3.2.1.min.js'></script>"
						+ "<script src='asset/statecity.js'></script>"
						+ "<script src='asset/clientreg.js'></script>"
						+ "<script src='asset/jquery-ui.js'></script>"
						+ "<link href='asset/jquery-ui.css' rel='stylesheet'>"
						+ "<link href='asset/jquery-ui.structure.css' rel='stylesheet'>"
						+ "<link href='asset/jquery-ui.theme.css' rel='stylesheet'>");
				
		out.println("        <link rel='stylesheet' href='ui/css/bootstrap.min.css'>");
		out.println("        <link rel='stylesheet' href='ui/css/font-awesome.min.css'>");
		out.println("        <link rel='stylesheet' href='ui/css/style.css'>");
		out.println("        <link rel='stylesheet' href='ui/css/animate.css'>");
		out.println("        <link rel='stylesheet' href='ui/css/magnific-popup.css'>");
		out.println("        <link rel='stylesheet' href='ui/plugins/FlexSlider/jquery.flexslider.css'>");
		out.println("        <link rel='stylesheet' href='ui/plugins/owl-carousel/owl.carousel.css'>");
		out.println("        <link rel='stylesheet' href='ui/plugins/owl-carousel/owl.theme.css'>");
		out.println("        <link rel='stylesheet' type='text/css' href='ui/css/slick.css'>");
		out.println("        <link rel='stylesheet' type='text/css' href='ui/css/slick-theme.css'>");
		out.println("        <link href='http://fonts.googleapis.com/css?family=Open+Sans:300,400,600,700' rel='stylesheet' type='text/css'>");
		out.println("        <link href='http://fonts.googleapis.com/css?family=Raleway:500,800' rel='stylesheet' property='stylesheet' type='text/css' media='all' />");
		out.println("    </head>");
		out.println("<body style='background-image:url(ui/bg.jpg);'>");
		out.println("        <div class='wrapper'>");
		out.println("            <div class='header header-static'>");
		out.println("                <div class='topbar'>");
		out.println("                    <div class='container'>");
		out.println("                        <div class='row'>");
	
		out.println("                        </div>");
		out.println("                    </div><!--container-->");
		out.println("                </div>");
		
		out.println("                <div class='navbar navbar-default mega-menu' role='navigation'>");
		out.println("                    <div class='container'>");
		out.println("                        <div class='navbar-header'>");
		out.println("                            <button type='button' class='navbar-toggle' data-toggle='collapse' data-target='.cd-navbar-collapse'>");
		out.println("                                <span class='sr-only'>Toggle navigation</span>");
		out.println("                                <span class='icon-bar'></span>");
		out.println("                                <span class='icon-bar'></span>");
		out.println("                                <span class='icon-bar'></span>");
		out.println("                            </button>");
		out.println("                            <a class='navbar-brand' href='UserCategoryView'>");
		out.println("                                <img id='logo-header' src='ui/img/logo.png' alt='Logo'>");
		out.println("                            </a>");
		out.println("                        </div>");
	
	//	out.println("<div class=cresult id=result></div>");
		out.println("<div class='collapse navbar-collapse cd-navbar-collapse'>");
		
		out.println("                            <ul class='nav navbar-nav'>");
		out.println("<li class='dropdown'>");
		out.println("<a href='#' class='dropdown-toggle' data-hover='dropdown' data-toggle='dropdown'>Home</a></li>");
		
		out.println("<li class='dropdown'>");
		out.println("<a href='#' class='dropdown-toggle' data-hover='dropdown' data-toggle='dropdown'>Login Pages</a>");
		out.println("<ul class='dropdown-menu'>");
		out.println("<li><a href='cart.html'>Admin</a></li>");
		out.println("<li><a href='cart.html'>Client</a></li>");
		out.println("<li><a href='cart.html'>Agency</a></li>");
		out.println("</ul>");
		out.println("</li>");
		out.println("</ul>");
		out.println("                        </div>");
		out.println("                    </div>");
		out.println("                </div>");
		
		out.println("            </div>");
		
		out.println("            <section class='clearfix'>");
		
		out.println("            </section>");
	
		out.println("            <section class='home-main-contant-style2 dip-bg-style dip-style bg-white' style='background-image:url(ui/bg.jpg);'>");
		out.println("                <div class='container'>");
		
		out.println("                    <div class='widget'>");
		out.println("                    <br>    <h5 class='text-uppercase bottom-line'>BOOKMYCAB</h5>");
		out.println("                    </div>");
		out.println("                    <div class='row'>");
		out.println("                        <div class='new-product slider'>");

			
		out.println(""
				+ "<table class='table table-bordered' align=center cellspacing=5 cellpadding=5>"
				+ "<tr>"
				+ "<td><img src=vehiclepicture/"+request.getParameter("vpicture")+" width=100 height=100></td>"
				+ "<td>"
				+ "<b><i>Vehicle Id:</i></b>"+request.getParameter("vid")+"<br>"
				+ "<b><i>Vehicle:</i></b>"+request.getParameter("vn")+"("+request.getParameter("vftype")+")<br>"
				+ "<b><i>Model:</i></b>"+request.getParameter("vmodel")+"<br>"
				+ "<b><i>Color:</i></b>"+request.getParameter("vcolor")+"<br>"
				+ "</td>"
				+ "<td>"
				+ "<b><i>Type:</i></b>"+request.getParameter("vtype")+"<br>"
				+ "<b><i>Capacity:</i></b>"+request.getParameter("vcapacity")+"<br>"
				+ "<b><i>Inssurance</i></b>"+request.getParameter("vins")+"<br>"
				+ "<b><i>AC:</i></b>"+request.getParameter("vac")+"<br>"
				+ "</td>");
    out.println("<td>");
    
    out.println("<b><i>From:</i></b>"+request.getParameter("from")+"<br>");
    out.println("<b><i>To:</i></b>"+request.getParameter("to")+"<br>");

    out.println("<b><i>Source:</i></b>"+request.getParameter("city")+"<br>");
    out.println("<b><i>Destination:</i></b>"+request.getParameter("dcity")+"<br>");
   
    out.println("</td>");
	out.println("</table><br><br>");
	
	
	//login form
	out.println("<table align=center class='table table-bordered'><tr><td valign=top><table class=''>"
			+ "<caption><b><i>Client Login</i></b></caption>"
			+ "<tr><td><b><i>EmailId or Mobile No:</i></b></td><td><input class='form-control' type=text id=uid name=uid required size=25></td></tr>"
			+ "<tr><td><b><i>Password:</i></b></td><td><input type=password class='form-control' id=clpwd name=pwd required size=25></td></tr>"
			+ "<tr><td><input type=button id='login' class='btn btn-info btn-xs' value='Login'></td><td>&nbsp;</td></tr>"
			+ "</table><br><br><span id=lmsg></span></td><td>&emsp;</td><td>&emsp;</td>");
	
	//signup form		
	out.println("<td valign=top>"
			+ "<table valign=top align=center cellspacing=4 cellpadding=2 class=''>"
			+ "<caption><b><i>Client Registration</i></b></caption>"
			+ "<tr><tr></tr></tr>"
			+ "<tr><td><b><i>Email Id:</i></b></td>"
			+ "<td><input type=email class='form-control' id=email size=30></td></tr>"
			+ "<tr><td><b><i>Mobile:</i></b></td>"
			+ "<td><input type=text class='form-control' id=mobile size=30></td></tr>"
			+ "<tr><td><b><i>First Name:</i></b></td>"
			+ "<td><input type=text class='form-control' id=fname size=30></td></tr>"
			+ "<tr><td><b><i>Last Name:</i></b></td>"
			+ "<td><input type=text class='form-control' id=lname size=30></td></tr>"
			+ "<tr><td><b><i>Date of Birth:</i></b></td>"
			+ "<td><input type=date class='form-control' id=dob size=30></td></tr>"
			+ "<tr><td><b><i>Gender:</i></b></td>"
			+ "<td><select class='form-control' id=gender>"
				+ "<option>Male</option>"
				+ "<option>Female</option>"
				+ "<option>other</option></select></td></tr>");
				
	out.println("<tr><td><b><i>Address:</i></b></td>"
			+ "<td><textarea class='form-control' id=add rows=3 cols=32></textarea></td></tr>"
			+ "<tr><td><b><i>State:</i></b></td>"
			+ "<td><select class='form-control' id=state></select></td></tr>"
			+ "<tr><td><b><i>City:</i></b></td>"
			+ "<td><select class='form-control' id=city></select></td></tr>"
		
			+ "<tr><td><b><i>Password:</i></b></td>"
			+ "<td><input class='form-control' type=password id=pwd size=30></td></tr>"
			+ "<tr><td><b><i>Confirm Password:</i></b></td>"
			+ "<td><input class='form-control' type=password id=cpwd size=30></td></tr>"
			+ "</table><br>"
			+ "<input type=button class='btn btn-info btn-xs' value='Sign Up' id='su'><br>&emsp;&emsp;&emsp;"
			+ "<span id='res'></span></td></tr>"
			
			+ "</table>");

		out.println("                            </div>");
		out.println("                        </div>");
		out.println("                    </div>");
		out.println("                </div>");
		out.println("            </section>");
		out.println("            <div class='news-subscribe'>");
		out.println("                <div class='container'>");
		out.println("<center> <p style='color:#FFFFFF;'>© All Rights Reserved @ BOOKMYCAB </p></center>");

		out.println("                </div>");
		out.println("            </div>");
		out.println("        </div>");
	//	out.println("        <script type='text/javascript'  src='ui/js/jquery.min.js'></script>");
		out.println("        <script type='text/javascript' src='ui/js/bootstrap.min.js'></script>");
		out.println("        <script type='text/javascript' src='ui/plugins/owl-carousel/owl.carousel.min.js'></script>");
		out.println("        <script type='text/javascript' src='ui/plugins/FlexSlider/jquery.flexslider-min.js'></script>");


		//out.println("        <script type='text/javascript' src='ui/js/plugins.min.html'></script>");
		out.println("        <script type='text/javascript' src='ui/js/custom.js'></script>");
		out.println("    </body>");
		out.println("</html>");
		
		
		
	}

}