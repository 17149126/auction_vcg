package src.com.main;

import java.util.List;

import src.com.bean.Bid;

public class Pool {
	
	
	public int RAM;	
	public long SIZE;
	public long BW;
	
	public int cRAM =0;	
	public int cSIZE = 0;
	public int cBW = 0 ;	
	
	public List<Rc> rcs ;
	
//	public Pool(int ram ,long size, long bw,List<Rc> rcs) {
//		// TODO Auto-generated constructor stub
//		this.RAM = ram;
//		this.SIZE= size;
//		this.BW = bw;
//		this.rcs = rcs;
//	}
	
	
	
	public Pool(List<Rc> rcs) {
		// TODO Auto-generated constructor stub
		this.rcs = rcs;

		this.reCalculate();
		
//		this.RAM = this.RAM*10;
//		this.SIZE= this.SIZE*10;
//		this.BW = this.BW*10;
	}

	public void updatePool(Bid bid) {
		// TODO Auto-generated method stub
		System.out.println(this.BW + "," + this.RAM + "," + this.SIZE);
//		this.BW = this.BW-bid.bw;
//		this.RAM = this.RAM-bid.Ram;		
//		this.SIZE = this.SIZE-bid.Size;
		
		this.cBW += bid.bw;
		this.cRAM += bid.Ram;
		this.cSIZE += bid.Size;
		
		
		System.out.println(this.BW + "," + this.RAM + "," + this.SIZE);
		
		for (int i = 0; i < this.rcs.size(); i++) {
						
			for (Rc rc2 : bid.allocatedRc) {
				
				if (this.rcs.get(i).dc.getId() == rc2.dc.getId()) {
					
					// Found the allocated instance
					this.rcs.get(i).reduceby(bid);
				}
			}			
		}
		
		
//		this.reCalculate();
		

	}
	
	



	private void reCalculate() {
		// TODO Auto-generated method stub
		
		
//		System.out.println("calculating pool");
		this.BW = getTotalRcBW();
		this.RAM = getTotalRcRam();		
		this.SIZE = getTotalRcSize();
				

//		System.out.println("calculating pool done" + this.BW);

	}
	
	
	public Cost getTotalHourlyCost() {
		
		int totalRam = 0;
		Cost totalCost = new Cost();
		for (Rc rc : this.rcs) {
//			
//			totalCost.costBw += this.BW * rc.dc.cost.costBw;
//			totalCost.costRam += this.RAM * rc.dc.cost.costRam;
//			totalCost.costSize += this.SIZE * rc.dc.cost.costSize;			
			
			
			
			totalCost.costBw += this.cBW* rc.dc.cost.costBw;
			totalCost.costRam += this.cRAM * rc.dc.cost.costRam;
			totalCost.costSize += this.cSIZE * rc.dc.cost.costSize;						
		}				
		return totalCost;
	}
	
	public int getTotalRcRam() {
    	// for all rc, compute their ram's.
    	int totalRam = 0;
		for (Rc rc : this.rcs) {
			
//			totalRam += rc.getTotalAllocatedRam();
			totalRam += rc.getTotalAvailableRam();
			
		}				
		return totalRam;
   
    }

	public long getTotalRcSize() {
    	// for all rc, compute their ram's.
    	long totalSize = 0;
		for (Rc rc : this.rcs) {
//			totalSize += rc.getTotalAllocatedSize();	
			totalSize += rc.getTotalAvailableSize();			
			
		}				
		return totalSize;
    }
	
    
	public long getTotalRcBW() {
    	// for all rc, compute their ram's.
    	long totalBW = 0;
		for (Rc rc : this.rcs) {
//			System.out.println(rc.totalBW+" , "+rc.totalRAM);
//			totalBW += rc.getTotalAllocatedBW();			
			totalBW += rc.getTotalAvailableBW();			

		}				
		return totalBW;
    }

    
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "BW : "+this.BW +"  , RAM : "+this.RAM +"  , SIZE : "+this.SIZE;
	}
	
	
	
	
	public Cost getTotalHourlyCostUpdated(Bid bid) {
		// TODO Auto-generated method stub
		
		Cost totalCost = new Cost();

//		for (Bid bid : allBids) {
		double prc = bid.getBiddingPrice();
		
		double CostBW = ( prc / 3.0 ) / 1000.0;
		double CostSize = ( prc / 3.0 ) / 25;			
		double CostRam = prc / 3.0 ;			

		System.out.println("-->BW : "+CostBW +" , RAM: "+CostRam +" , Size: "+CostSize);
		
		
		totalCost.costBw += this.cBW* CostBW;
		totalCost.costRam += this.cRAM * CostRam;
		totalCost.costSize += this.cSIZE * CostSize;	
			
//		}
		return totalCost;
		
		
	}

}
