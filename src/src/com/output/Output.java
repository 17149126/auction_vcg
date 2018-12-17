package src.com.output;

import java.util.ArrayList;

import src.com.bean.Bid;

public class Output {

	public void printOutput(Bid bid) {
		System.out.println("Customer Name : "+bid.getCustomerName());
		System.out.println("Address "+bid.getAddress());
		System.out.println("Phone Number "+bid.getPhoneNumber());
		System.out.println("Occupation "+bid.getOccupation());
		System.out.println("Bid Time "+bid.getBidTime());
		System.out.println("Bidding Price "+bid.getBiddingPrice());
	}
	
	public void printOutput(ArrayList<Bid> bid) {
		for (int i = 0; i < bid.size(); i++) {
			System.out.println("========== Bid"+ i +" ==========");
			System.out.println("BidID: "+bid.get(i).getCustomerName());
			System.out.println("Region: "+bid.get(i).getAddress());
			System.out.println("BidTime: "+bid.get(i).getBidTime());
			System.out.println("BiddingPrice: "+bid.get(i).getBiddingPrice());
		}
	}
}
