package com.hrrock.controller;

import java.sql.Connection;
import java.sql.ResultSet;

import com.hrrock.model.Photograph;

public class PhotographController {

		
		public static boolean AddNewPhoto(Photograph P) {
		
			try{ 
					Connection cn=DBHelper.openConnection();
					String query="insert into photograph(agencyid,vehicleid,type,picture) values('"+P.getAgencyid()+"','"+P.getVehicleid()+"','"+P.getType()+"','"+P.getPicture()+"')";
					System.out.println(query);
					boolean ph=DBHelper.executeUpdate(query, cn);
					return(ph);
				} 
				catch(Exception e){
					System.out.println("AddNewPhograph");
					return false;
				}
		}
		
		
		public static ResultSet getAllAgencies() {
			try {
					Connection cn=DBHelper.openConnection();
					String query="select agencyid from agency";
					ResultSet rs=DBHelper.executeQuery(query, cn);
					System.out.println(query);
					return(rs);
			} catch(Exception e){
				System.out.println("getAllAgencies:"+e);
				return(null);
			}
		}
		public static ResultSet getAllVehiclesByAgency(String agencyid) {
			try {
					Connection cn=DBHelper.openConnection();
					ResultSet rs=DBHelper.executeQuery("select vehicleid from agencyvehicle where agencyid="+agencyid, cn);	
					return(rs);
			} catch(Exception e) { 
					System.out.println("getAllVehicles:"+e);
					return(null);
			}
		}
		
		
		public static ResultSet getVehiclePictures(String vid)	{
			try	{
					Connection cn=DBHelper.openConnection();
					String query="select * from Photograph where vehicleid='"+vid+"'";
					ResultSet rs=DBHelper.executeQuery(query, cn); 
					return(rs);

			}	catch(Exception e)	{	
					System.out.println("PhotographController:"+e);
					return null;}

		}

		
}
