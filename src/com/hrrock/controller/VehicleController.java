package com.hrrock.controller;

import java.sql.Connection;
import java.sql.ResultSet;

import com.hrrock.model.AgencyVehicle;

public class VehicleController {
	 
		public static boolean AddNewRecord(AgencyVehicle V)
		{
			try{
				Connection cn=DBHelper.openConnection();
				String query="insert into agencyvehicle(agencyid,vehicleid,vehiclename,modelyear,vehiclecolor,vehicletype,vehiclecapacity,insurance,ac,fueltype,picture) values('"+V.getAgencyid()+"','"+V.getVehicleid()+"','"+V.getVehiclename()+"','"+V.getModelyear()+"','"+V.getVehiclecolor()+"','"+V.getVehicletype()+"','"+V.getVehiclecapacity()+"','"+V.getInsurance()+"','"+V.getAc()+"','"+V.getFueltype()+"','"+V.getVehiclepicture()+"')";
				System.out.println(query);
				boolean st=DBHelper.executeUpdate(query,cn);
				return(st);
				
			}	catch(Exception e){
					System.out.println("Add New Record"+e);
					return false;	
				}
		}
		
		
		public static ResultSet DisplayAll()
		{
			try{
				 Connection cn=DBHelper.openConnection();
				 String query="select vehicleid,vehiclename,agencyid,modelyear,vehiclecolor,vehicletype,vehiclecapacity,insurance,ac,fueltype,picture from agencyvehicle";
				 System.out.println(query);
				 ResultSet rs=DBHelper.executeQuery(query,cn);
				 return(rs);
			}catch(Exception e){
				System.out.println("AddNewRecord"+e);
				return null;
			}	
		}
		
		
		public static AgencyVehicle DisplayById(String vid)
		{
			try{
				 Connection cn=DBHelper.openConnection();
				 String query="select vehicleid,agencyid,vehiclename,modelyear,vehiclecolor,vehicletype,vehiclecapacity,insurance,ac,fueltype,picture from agencyvehicle where vehicleid='"+vid+"'";
				 ResultSet rs=DBHelper.executeQuery(query, cn);
				 if(rs.next())
				 {
					 AgencyVehicle V=new AgencyVehicle();
					 V.setAgencyid(rs.getString("agencyid"));
					 V.setVehicleid(rs.getString("vehicleid"));
					 V.setVehiclename(rs.getString("vehiclename"));
					 V.setModelyear(rs.getString("modelyear"));
					 V.setVehiclecolor(rs.getString("vehiclecolor"));
					 V.setVehicletype(rs.getString("vehicletype"));
					 V.setVehiclecapacity(rs.getString("vehiclecapacity"));
					 V.setInsurance(rs.getString("insurance"));
					 V.setAc(rs.getString("ac"));
					 V.setFueltype(rs.getString("fueltype"));
					 V.setVehiclepicture(rs.getString("picture"));
					 return(V);
				 }
				 return(null);
				
			}catch(Exception e){
					System.out.println("AddNewRecord"+e);
					return null;
				}
		}
		
		public static boolean EditRecord(AgencyVehicle V)
		{
		try{
			Connection cn=DBHelper.openConnection();
			String query="update agencyvehicle set agencyid='"+V.getAgencyid()+"', vehiclename='"+V.getVehiclename()+"', modelyear='"+V.getModelyear()+"', vehiclecolor='"+V.getVehiclecolor()+"', vehicletype='"+V.getVehicletype()+"', vehiclecapacity='"+V.getVehiclecapacity()+"', insurance='"+V.getInsurance()+"', ac='"+V.getAc()+"', fueltype='"+V.getFueltype()+"'  where vehicleid='"+V.getVehicleid()+"'"; 
			System.out.println(query);
			boolean st=DBHelper.executeUpdate(query, cn);
			return(st);
				
			}catch(Exception e){
				System.out.println("AddNewRecord "+e);
				return false;
				}
		}
		
		
		public static boolean DeleteRecord(String vid)
		{
		try{
			Connection cn=DBHelper.openConnection();
			String query="delete from agencyvehicle where vehicleid='"+vid+"'"; 
			System.out.println(query);
			boolean st=DBHelper.executeUpdate(query, cn);
			return(st);		
			}
			catch(Exception e){
			System.out.println("AddNewRecord "+e);
			return false;
			}
		}
		
		
		public static boolean EditVehiclePicture(AgencyVehicle V)
		{
		try{
			Connection cn=DBHelper.openConnection();
			String query="update agencyvehicle set picture='"+V.getVehiclepicture()+"' where vehicleid='"+V.getVehicleid()+"'"; 
			System.out.println(query);
			boolean st=DBHelper.executeUpdate(query, cn);
			return(st);
			
			
		}catch(Exception e){
			System.out.println("AddNewRecord "+e);
			return false;
			}
		}
		
		
		public static ResultSet VehicleByCity(String city, String tp)
		{
			try
			{
				int tpp=Integer.parseInt(tp);
				Connection cn=DBHelper.openConnection();
				String query="";
				if(tpp<=5){
					query="select v.* from agencyvehicle v ,agency a where v.agencyid=a.agencyid and a.city='"+city+"' and v.vehiclecapacity between 1 and 5";
				} else {
					query="select v.* from agencyvehicle v ,agency a where v.agencyid=a.agencyid and a.city='"+city+"' and v.vehiclecapacity>5";
				}
				ResultSet rs=DBHelper.executeQuery(query, cn);
				return(rs);
			}
			catch(Exception e)
			{
				System.out.println("Display All "+e);
				return null;
			}
	    }

		
}