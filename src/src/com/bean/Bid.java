package src.com.bean;

import java.time.Instant;
import java.util.ArrayList;

import src.com.main.Rc;

public class Bid {

	String customerName;
	String address;
	String phoneNumber;
	String occupation;
	Instant bidTime;
	double biddingPrice;
	int bidId;
	public ArrayList<Rc> allocatedRc = new ArrayList<>();
	
	public int Ram = 128, duration;
	public long bw = 100;
	public long Size = 1000;
	
	
	public Bid (String customerName, String address, String phoneNumber, String occupation, Instant bidTime,
			double biddingPrice) {
		super();
		this.bidId = 0;
		this.customerName = customerName;
		this.address = address;
		this.phoneNumber = phoneNumber;
		this.occupation = occupation;
		this.bidTime = bidTime;
		this.biddingPrice = biddingPrice;
				
	}
	
	public Bid(int bidId,String customerName, String address, String phoneNumber, String occupation, Instant bidTime,
			double biddingPrice,int Ram,
	long Bw,
	long Size, int duration
	) {
		super();
		this.bidId = bidId;
		this.customerName = customerName;
		this.address = address;
		this.phoneNumber = phoneNumber;
		this.occupation = occupation;
		this.bidTime = bidTime;
		this.biddingPrice = biddingPrice;
		
		this.Ram=Ram;
		this.bw=Bw;
		this.Size=Size;
		this.duration = duration;
	}
	
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getOccupation() {
		return occupation;
	}
	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}
	public Instant getBidTime() {
		return bidTime;
	}
	public void setBidTime(Instant bidTime) {
		this.bidTime = bidTime;
	}
	public double getBiddingPrice() {
		return biddingPrice;
	}
	public void setBiddingPrice(double biddingPrice) {
		this.biddingPrice = biddingPrice;
	}
	
	public void addAllocatedRc(Rc e) {
		this.allocatedRc.add(e);
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Customer Id : "+this.bidId+" and BW: "+this.bw+ " and RAM: "+this.Ram +" and DISK: "+this.Size +"  at price = "+this.biddingPrice;
	}

	public int getBiddingId() {
		// TODO Auto-generated method stub
		return this.bidId;
	}
}
