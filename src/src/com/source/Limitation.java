package src.com.source;

import java.util.ArrayList;
import src.com.bean.Bid;

public class Limitation {

	double instancePrice = 10;
	double exceedTimes = 10; // 30
	
	/**
	 * Purpose - If biddingPrice is greater than instancePrice*3 reject the bid
	 *
	 * @param al
	 * @return
	 */
	
	public Limitation(double instancePrice) {
		this.instancePrice = instancePrice;
	}
	
	public ArrayList<Bid> getValidBids(ArrayList<Bid> al) {
		
		for (int i = 0; i < al.size(); i++) {
			if (al.get(i).getBiddingPrice() > this.instancePrice * exceedTimes) {
				al.remove(i);
			}
		}
		return al;
	}
}
