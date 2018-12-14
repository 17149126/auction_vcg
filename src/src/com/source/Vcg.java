package src.com.source;

import java.util.ArrayList;
import java.util.Collections;
import src.com.bean.Bid;

/**
 * Purpose - 
 * 	1. Instance availability 
 * 	2. Incoming traffic
 * 	3. Detection of Second highest bidding price
 * 
 * @author User
 *
 */
public class Vcg {

	//final static float availableInstances = 1;
	final static float availableInstances = 2;

	/**
	 * Purpose - Second highest price detection
	 * @param bids
	 * @return
	 */
	//	VCG for 1 resources
	public Bid secondPriceOcution(ArrayList<Bid> bids) {
		Bid secondPriceBid = null;
		Collections.sort(bids,Collections.reverseOrder(new Auction()));  
		for (int i = 0; i < bids.size(); i++) {
			if (i==0) {
				secondPriceBid = bids.get(i);
			} else if (i==1) {
				secondPriceBid.setBiddingPrice(bids.get(i).getBiddingPrice());
			}
		}
		return secondPriceBid;
	}
	
	
	
	//	VCG for multiple resources
	public static ArrayList<Bid> AcutionForNResourcesVCG(ArrayList<Bid> bids) {
		Bid secondPriceBid = null;
		Collections.sort(bids,Collections.reverseOrder(new Auction()));  
		System.out.println("Sorted bids");
		System.out.println(bids);
		
		int trueValue = (int) availableInstances;
		
		ArrayList<Bid> winners = new ArrayList<>();
		for (int i = 0; i < trueValue; i++)
		{
			Bid temp = bids.get(i);
			temp.setBiddingPrice( bids.get(trueValue).getBiddingPrice());
			winners.add(temp);
		}
		return winners;
	}
	
	//	Fifo for multiple resources
	public static ArrayList<Bid> AcutionForNResourcesFIFO(ArrayList<Bid> bids) {
		Bid secondPriceBid = null;

		int trueValue = (int) availableInstances;
		
		ArrayList<Bid> winners = new ArrayList<>();
		for (int i = 0; i < trueValue; i++)
		{
			Bid temp = bids.get(i);
			winners.add(temp);
		}
		return winners;
	}
	
	public static ArrayList<Bid> AcutionForNResources(ArrayList<Bid> bids) {
		Bid secondPriceBid = null;
		Collections.sort(bids,Collections.reverseOrder(new Auction()));  
		System.out.println("Sorted bids");
		System.out.println(bids);
		
		int trueValue = (int) availableInstances;
		
		ArrayList<Bid> winners = new ArrayList<>();
		for (int i = 0; i < trueValue; i++)
		{
			Bid temp = bids.get(i);
//			temp.setBiddingPrice(temp.getBiddingPrice());
			winners.add(temp);
		}
		return winners;
	}
}
