package src.com.source;

import java.util.Comparator;

import src.com.bean.Bid;

/**
 * Purpose - 
 * 1. Accept Incoming requests
 * 2. Sorting of bids in descending order
 * 3. Get highest bidding price 
 * 
 */
public class Auction implements Comparator {
	
	/**
	 * This method is used to sorting
	 * @param o1
	 * @param o2
	 * @return
	 */
	public int compare(Object o1,Object o2){  
			Bid s1=(Bid)o1;  
			Bid s2=(Bid)o2;  
			if(s1.getBiddingPrice()==s2.getBiddingPrice())  
				return 0;  
			else if(s1.getBiddingPrice()>s2.getBiddingPrice())  
				return 1;  
			else  
				return -1;  
		}  
}
