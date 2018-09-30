package com.nis.view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ClientView
 */
@WebServlet("/ClientView")
public class ClientView extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ClientView() {
        super(); 
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at: ").append(request.getContextPath());
		
		PrintWriter out=response.getWriter();
		
		
	
		
		out.println("<html>");
		out.println("<head>");
		out.println("<script src='asset/jquery-3.2.1.min.js'></script>");
		out.println("<script src='asset/clientview.js'></script>");
		out.println("<script src='asset/jquery-ui.js'></script>");
		out.println("<link href='asset/jquery-ui.css' rel='stylesheet'>");
		out.println("<link href='asset/jquery-ui.structure.css' rel='stylesheet'>");
		out.println("<link href='asset/jquery-ui.theme.css' rel='stylesheet'>");
		
		
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
		out.println("                <div  id='mega-slider' style='height:42%;' class='carousel slide' data-ride='carousel'>");
		out.println("                    <ol class='carousel-indicators'>");
		out.println("                        <li data-target='#mega-slider' data-slide-to='0' class='active'></li>");
		out.println("                        <li data-target='#mega-slider' data-slide-to='1'></li>");
		out.println("                        <li data-target='#mega-slider' data-slide-to='2'></li>");
		out.println("                    </ol>");
		out.println("                    <div class='carousel-inner' role='listbox'>");
		out.println("                        <div class='item active beactive'>");
		out.println("                            <img src='ui/img/banner/slide-1.jpg' alt='...'>");
		out.println("                            <div class='carousel-caption'>");
		out.println("                                <h2>Welcome to BOOKMYCAB</h2>");
	//	out.println("                                <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit.</p>");
		out.println("                            </div>");
		out.println("                        </div>");
		out.println("                        <div class='item'>");
		out.println("                            <img src='ui/img/banner/slide-2.jpg' alt='...'>");
		out.println("                            <div class='carousel-caption'>");
		out.println("                                <h2>Welcome to BOOKMYCAB</h2>");
		//out.println("                                <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit.</p>");
		out.println("                            </div>");
		out.println("                        </div>");
		out.println("                        <div class='item'>");
		out.println("                            <img src='ui/img/banner/slide-3.jpg' alt='...'>");
		out.println("                            <div class='carousel-caption'>");
		out.println("                                <h2>Welcome to BOOKMYCAB</h2>");
		out.println("                            </div>");
		out.println("                        </div>");
		out.println("                    </div>");
		out.println("                    <a  class='left carousel-control' href='#mega-slider' role='button' data-slide='prev'>");
		out.println("                    </a>");
		out.println("                    <a  class='right carousel-control' href='#mega-slider' role='button' data-slide='next'>");
		out.println("                    </a>");
		out.println("                </div>");
		out.println("            </section>");
	
		out.println("            <section class='home-main-contant-style2 dip-bg-style dip-style bg-white' style='background-image:url(ui/bg.jpg);'>");
		out.println("                <div class='container'>");
		
		out.println("                    <div class='widget'>");
		out.println("                    <br>    <h5 class='text-uppercase bottom-line'>BOOKMYCAB</h5>");
		out.println("                    </div>");
		out.println("                    <div class='row'>");
		out.println("                        <div class='new-product slider'>");

			
		out.println("<table cellspacing=5 class='table table-bordered'>");
		out.println("<tr align=left><th>Booking From</th><th>Booking To</th><th>Total Person</th><th>Source</th><th>Destination</th></tr>");
	    out.println("<tr align=left><td><input class='form-control' type=date id=from name=fdate></td><td><input class='form-control' type=date id=to name=tdate></td><td><input class='form-control' type=number name=tp id=tp></td><td><select class='form-control' id=city name=city><option>-City-</option></select></td><td><select class='form-control' id=dcity name=dcity><option>-City-</option></select></td>");	
		out.println("</table><br>");
		out.println("<div id=result></div>");
		out.println("<div id=vpic></div>");

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