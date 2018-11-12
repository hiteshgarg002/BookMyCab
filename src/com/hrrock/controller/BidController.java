package com.hrrock.controller;

import java.sql.Connection;

import com.hrrock.model.BidModel;

public class BidController {

	public static boolean AddNewRecord(BidModel A) {
		try {
			Connection cn = DBHelper.openConnection();
			String query = "insert into agencybid(currentdate,currenttime,agencyid,bookingid,bidamount) values('"
					+ A.getCurrentdate() + "','" + A.getCurrenttime() + "'," + A.getAgencyid() + "," + A.getBookingid()
					+ "," + A.getBidamount() + ")";
			boolean st = DBHelper.executeUpdate(query, cn);
			return (st);

		} catch (Exception e) {
			System.out.println("AddNewRecord " + e);
			return false;
		}
	}

}
