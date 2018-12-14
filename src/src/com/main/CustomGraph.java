package src.com.main;

import java.util.ArrayList;
import java.util.List;

public class CustomGraph {
	
	
	public List<Cost> profitListVcg;
	public List<Cost> utilizationList;	
	
	public List<Integer> biddingCount;	
	
	public CustomGraph() {
		// TODO Auto-generated constructor stub
		this.profitListVcg = new ArrayList<>();
		this.biddingCount = new ArrayList<>();
		this.utilizationList = new ArrayList<>();
	}
	
	public void DisplayProfitvsPeriods() {
		// TODO Auto-generated method stub
		System.out.println("Profit   ,    Count");
		for (int i = 0; i < profitListVcg.size(); i++) {
			System.out.println(profitListVcg.get(i).getTotalPrice()+"  , " +biddingCount.get(i));
		}
	}
	
	
	public void DisplayUtilizationsvsPeriods() {
		// TODO Auto-generated method stub
		System.out.println("Profit   ,    Count  ,   RAM   ,   Disk   , BW ");
		for (int i = 0; i < utilizationList.size(); i++) {
			System.out.println(profitListVcg.get(i).getTotalPrice()+"  , " +biddingCount.get(i) +" , "+
					utilizationList.get(i).costRam +" , "+utilizationList.get(i).costSize +"  ,  "+utilizationList.get(i).costBw);
		}
	}
	

}
