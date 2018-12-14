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
			System.out.println("Customer Name : "+bid.get(i).getCustomerName());
			System.out.println("Address "+bid.get(i).getAddress());
			System.out.println("Phone Number "+bid.get(i).getPhoneNumber());
			System.out.println("Occupation "+bid.get(i).getOccupation());
			System.out.println("Bid Time "+bid.get(i).getBidTime());
			System.out.println("Bidding Price "+bid.get(i).getBiddingPrice());
		}
	}
}
