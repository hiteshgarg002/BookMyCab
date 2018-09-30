package com.nis.controller;

import java.sql.Connection;
import java.sql.ResultSet;

import com.nis.model.Client;

public class ClientController {

	public static Client checkPassword(String uid, String pwd) {
		try{
				Connection cn=DBHelper.openConnection();
				String query="select * from client where (email='"+uid+"' or mobile='"+uid+"') and password='"+pwd+"'";
				System.out.println(query);
				ResultSet rs=DBHelper.executeQuery(query, cn);
				if(rs.next())
				{
					Client C=new Client();
					C.setEmail(rs.getString("email"));
					C.setMobile(rs.getString("mobile"));
					C.setFirstname(rs.getString("firstname"));
					C.setLastname(rs.getString("lastname"));
					C.setDob(rs.getString("dob"));
					C.setGender(rs.getString("gender"));
					C.setAddress(rs.getString("address"));
					C.setState(rs.getString("state"));
					C.setCity(rs.getString("city"));

					return(C);
				}
				return null;
		}	
			catch(Exception e)
			{	return(null);	}
	}

	public static boolean AddNewRecord(Client c) {
		
		try{
			Connection cn=DBHelper.openConnection();
			String query="insert into client(firstname,lastname,dob,gender,email,mobile,address,state,city,password) values('"+c.getFirstname()+"','"+c.getLastname()+"','"+c.getDob()+"','"+c.getGender()+"','"+c.getEmail()+"','"+c.getMobile()+"','"+c.getAddress()+"','"+c.getState()+"','"+c.getCity()+"','"+c.getPassword()+"')";
			System.out.println(query);
			boolean st=DBHelper.executeUpdate(query,cn);
			return(st);
			
			} catch(Exception e){
				System.out.println("Error in client "+e.getMessage());
				return false;
			}
	}

	public static ResultSet showAllBid(String email) {
		
		try{
				Connection cn=DBHelper.openConnection();
				String query="select b.bookingid,b.source,b.destination,b.bfrom,b.bto,v.picture,ab.currentdate,ab.currenttime,ab.bidamount from agencybid ab,bookings b,agencyvehicle v,client c where (c.email='"+email+"' or c.mobile='"+email+"') and b.bookingid=ab.bookingid and b.vehicleid=v.vehicleid and v.agencyid=ab.agencyid and b.status='UnBooked'";
				System.out.println(query);
				ResultSet rs=DBHelper.executeQuery(query, cn);
				return(rs);
		}	catch(Exception e)
			{
				System.out.println(e);	
				return(null);	
		} 

		
		
	}

	public static ResultSet showPreviousBooking(String email) {
		
		try{
			Connection cn=DBHelper.openConnection();
			String query="select b.bookingid,b.source,b.destination,b.bfrom,b.bto,v.picture,ab.currentdate,ab.currenttime,ab.bidamount from agencybid ab,bookings b,agencyvehicle v,client c where (c.email='"+email+"' or c.mobile='"+email+"') and b.bookingid=ab.bookingid and b.vehicleid=v.vehicleid and v.agencyid=ab.agencyid and b.status='Booked'";
			System.out.println(query);
			ResultSet rs=DBHelper.executeQuery(query, cn);
			return(rs);
		}	catch(Exception e)
			{
			System.out.println(e);	
			return(null);
			} 

				
		
		
	}

}
