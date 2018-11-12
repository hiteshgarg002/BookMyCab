package com.hrrock.view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hrrock.model.Admin;

/**
 * Servlet implementation class AdminHome
 */
@WebServlet("/AdminHome")
public class AdminHome extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AdminHome() {
		super();

	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@SuppressWarnings("deprecation")
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at: ").append(request.getContextPath());

		HttpSession ses = request.getSession();
		PrintWriter out = response.getWriter();

		out.println("<html>");
		out.println("<head>");
		out.println("    <title></title>");
		out.println("    <link href='bootstrap.min.css' rel='stylesheet'>");
		out.println("    <link href='admin/css/application.min.css' rel='stylesheet'>");
		out.println("</head>");
		out.println("<body class='background-dark'>");
		out.println("<div class='logo'>");
		out.println("<img src='admin/logo.png' class='img-responsive' style='margin-top:50px; margin-left:-15px;'>");
		out.println("</div>");
		out.println("<nav id='sidebar' class='sidebar nav-collapse collapse'>");
		out.println("    <ul id='side-nav' class='side-nav'>");
		// out.println("<li class='panel'><a class='accordion-toggle collapsed'
		// href='#forms-collapse'><i class='fa fa-edit'></i> <span
		// class='name'>Forms</span></a></li> ");
		out.println(
				"<li class='panel'><a class='accordion-toggle collapsed' href=AgencyView target=mw><i class='fa fa-edit'></i> <span class='name'>Add Agency</span></a></li>");
		out.println(
				"<li class='panel'><a class='accordion-toggle collapsed' href=AgencyDisplayAll target=mw><i class='fa fa-edit'></i> <span class='name'>Display Agency</span></a></li>");
		out.println(
				"<li class='panel'><a class='accordion-toggle collapsed' href=AgencyDisplayById target=mw><i class='fa fa-edit'></i> <span class='name'>Edit/Delete</span></a></li>");
		out.println(
				"<li class='panel'><a class='accordion-toggle collapsed' href=DisplayBookingByClient target=mw><i class='fa fa-edit'></i> <span class='name'>Current Bookings</span></a></li>");
		out.println(
				"<li class='panel'><a class='accordion-toggle collapsed' href=AdminLogin target=mw><i class='fa fa-edit'></i> <span class='name'>Logout</span></a></li>");
		out.println("    </ul>");
		out.println("</nav>");
		out.println("<div class='wrap'>");
		out.println("    <header class='page-header'>");
		out.println("        <div class='navbar'>");
		out.println("                <ul class='nav navbar-nav navbar-right pull-right'>");
		out.println("                    <li class='visible-xs'>");
		out.println("                        <a href='#'");
		out.println("                           class='btn-navbar'");
		out.println("                           data-toggle='collapse'");
		out.println("                           data-target='.sidebar'");
		out.println("                           title=''>");
		out.println("                            <i class='fa fa-bars'></i>");
		out.println("                        </a>");
		out.println("                    </li>");
		out.println(
				"                    <li class='hidden-xs'><a href='AdminLogin'><i class='fa fa-sign-out'></i></a></li>");
		out.println("                </ul>  ");
		out.println("        </div>");
		out.println("    </header>");
		out.println("    <div class='content container'>");
		out.println("        <div class='row'>");
		out.println("            <div class='col-md-12'>");
		Admin A;
		try {
			A = (Admin) ses.getAttribute("SADMIN");
			String ltime = (String) ses.getAttribute("SLTIME");
			String navbar = "<h5><center><font color=white>Admin Id:" + A.getAdminId()
					+ "&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;" + A.getAdminName()
					+ "&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;" + ltime
					+ "</font>&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;<img src=picture/"
					+ A.getPicture()
					+ " width=40 height=40>&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;<a href=AdminLogout class='btn btn-info btn-xs'>Logout</a></center></h5>";
			out.println(navbar);
		} catch (Exception e) {
			// out.println(e);
			response.sendRedirect("AdminLogin");
		}
		out.println("            </div>");
		out.println("        </div>");
		out.println("        <div class='row'>");
		out.println("            <div class='col-md-12'>             ");
		out.println("                <section class='widget'>");
		out.println("                    <div class='body'>");
		out.println("  <iframe style='width:100%; height:800px;' frameborder=0 name=mw></iframe>");
		out.println("                    </div>");
		out.println("                </section>");
		out.println("            </div>");
		out.println("        </div>");
		out.println("    </div>");
		out.println("</div>");
		out.println("<script src='admin/lib/jquery/jquery-2.0.3.min.js'> </script>");
		out.println("<script src='admin/lib/jquery-pjax/jquery.pjax.js'></script>");
		out.println("<script src='admin/lib/bootstrap/transition.js'></script>");
		out.println("<script src='admin/lib/bootstrap/collapse.js'></script>");
		out.println("<script src='admin/lib/bootstrap/alert.js'></script>");
		out.println("<script src='admin/lib/bootstrap/tooltip.js'></script>");
		out.println("<script src='admin/lib/bootstrap/popover.js'></script>");
		out.println("<script src='admin/lib/bootstrap/button.js'></script>");
		out.println("<script src='admin/lib/bootstrap/tab.js'> </script>");
		out.println("<script src='admin/lib/bootstrap/dropdown.js'></script>");
		out.println("<script src='admin/js/app.js'></script>");
		out.println("</body>");
		out.println("</html>");

		out.flush();
	}

}
