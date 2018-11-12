package com.hrrock.controller;

import java.sql.Connection;
import java.sql.ResultSet;

import com.hrrock.model.Admin;

public class AdminController {

	public static Admin checkPassword(String aid, String pwd) {
		try {
			Connection cn = DBHelper.openConnection();
			String query = "select * from admin where adminid='" + aid + "' and password='" + pwd + "'";
			ResultSet rs = DBHelper.executeQuery(query, cn);
			if (rs.next()) {
				Admin A = new Admin();
				A.setAdminId(rs.getString("adminid"));
				A.setAdminName(rs.getString("adminname"));
				A.setPicture(rs.getString("picture"));
				A.setPassword(rs.getString("password"));
				return (A);
			}
			return null;
		} catch (Exception e) {
			return (null);
		}
	}

}
