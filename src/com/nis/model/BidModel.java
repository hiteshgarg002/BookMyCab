package com.nis.model;

public class BidModel {
	
	private int transactionid;
	private String currentdate;
	private String currenttime;
	private int agencyid;
	private int bookingid;
	private int bidamount;
	
	public int getTransactionid() {
		return transactionid;
	}
		public void setTransactionid(int transactionid) {
			this.transactionid = transactionid;
		}
	public String getCurrentdate() {
		return currentdate;
	}
		public void setCurrentdate(String currentdate) {
			this.currentdate = currentdate;
		}
	public String getCurrenttime() {
		return currenttime;
	}
		public void setCurrenttime(String currenttime) {
			this.currenttime = currenttime;
		}
	public int getAgencyid() {
		return agencyid;
	}
		public void setAgencyid(int agencyid) {
			this.agencyid = agencyid;
		}
	public int getBookingid() {
		return bookingid;
	}
		public void setBookingid(int bookingid) {
			this.bookingid = bookingid;
		}
	public int getBidamount() {
		return bidamount;
	}
		public void setBidamount(int bidamount) {
			this.bidamount = bidamount;
		}

}
