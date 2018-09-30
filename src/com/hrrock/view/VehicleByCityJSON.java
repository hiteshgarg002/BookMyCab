package com.hrrock.view;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import com.hrrock.controller.DBHelper;
import com.hrrock.controller.VehicleController;

/**
 * Servlet implementation class VehicleByCityJSON
 */
@WebServlet("/VehicleByCityJSON")
public class VehicleByCityJSON extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VehicleByCityJSON() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at: ").append(request.getContextPath());
		
		PrintWriter out=response.getWriter();
		ResultSet rs=VehicleController.VehicleByCity(request.getParameter("city"),request.getParameter("tp"));
        ArrayList<JSONObject> obj=DBHelper.JsonEngine(rs);
        out.println(obj);
		
	}

}
