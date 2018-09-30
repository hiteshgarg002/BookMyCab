package com.nis.controller;

import java.sql.Connection;
import java.sql.ResultSet;

import com.nis.model.Booking;

public class BookingController {
	
	
	public static boolean AddRecord(Booking B)
	{
		try{
		Connection cn=DBHelper.openConnection();
		String query="insert into bookings(clientemail,mobile,vehicleid,currentdate,bfrom,bto,source,destination,status) values('"+B.getClientEmail()+"','"+B.getMobile()+"','"+B.getVehicleId()+"','"+B.getCurrentDate()+"','"+B.getBookingFrom()+"','"+B.getBookingTo()+"','"+B.getSource()+"','"+B.getDestination()+"','"+B.getStatus()+"')";
		System.out.println(query);
		boolean st=DBHelper.executeUpdate(query,cn);
		return(st);
		
		} catch(Exception e){
			System.out.println("Add Record "+e);
			return false;
		}
	}

	public static ResultSet DisplayBookingByClient() 
	{
		try {
				Connection cn=DBHelper.openConnection();
				String query="select * from bookings where status='UnBooked'";
				ResultSet rs=DBHelper.executeQuery(query, cn);
				return(rs);
			
		} catch(Exception e){
				System.out.println("DisplayBookingByClient "+e);
				return null;
		}
		
	}

	public static boolean changeBookingStatus(int bookingid) {
		
		try{
			Connection cn=DBHelper.openConnection();
			String query="update bookings set status='Booked' where bookingid="+bookingid;
					
			boolean st=DBHelper.executeUpdate(query, cn);
			return(st);
			
		}catch(Exception e){
			System.out.println("AddNewRecord "+e);
			return false;
		}
	}

}
