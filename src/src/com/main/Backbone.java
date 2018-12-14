package src.com.main;

import java.util.ArrayList;
import java.util.List;

import org.cloudbus.cloudsim.Vm;

import src.com.bean.Bid;

public class Backbone {
	
	
	private List<?> requests;
	private Pool pool;

	
    private static Backbone uniqInstance;
	
	// Singleton class
	// holds single refrences to the reqs, rcs, and pool#
	
	
	// contains/call poolUpdator
	// contains pool utilizer
	
	
	public Backbone(Pool poolObject) {
		// TODO Auto-generated constructor stub
		this.pool = poolObject;
		
	}
	
    public static Backbone getInstance(Pool poolObject) {
        if (uniqInstance == null) {
                uniqInstance = new Backbone(poolObject);
        }
       
        return uniqInstance;
    }
    
    
    private int getTotalRcRam() {
    	// for all rc, compute their ram's.
    	int totalRam = 0;
		for (Rc rc : this.pool.rcs) {
			totalRam += rc.getTotalAllocatedRam();
			
		}				
		return totalRam;
    }
	
    
    public String getUnUtilization () {
    	// Difference of allocated vs unutilized recources
    	
    	// getting RAM utilisation
    	
    	int UntilizedRam = this.pool.RAM;
    	long UntilizedBW = this.pool.BW;
    	long UntilizedSize = this.pool.SIZE;
    	
//    	this.pool.SIZE
    	
    	return "RAM:"+UntilizedRam+";BW:"+UntilizedBW+";SIZE:"+UntilizedSize;
    }
    
    public Cost getUtilizationPercentage() {
    	// Difference of allocated vs unutilized recources
    	
    	// getting RAM utilisation
    	
    	double r = this.pool.cRAM;// *100 % (double)this.pool.RAM;
    	double bw = this.pool.cBW;// *100 % (double)this.pool.BW;
    	double s = this.pool.cSIZE;// *100 % (double)this.pool.SIZE;
    	
    	return new Cost(r,bw,s);
    }
    
    
    
    public Cost getUtilization() {

    	return this.pool.getTotalHourlyCost();

    }
    
    
    public Cost getTotalCost() {
    	
    	return this.pool.getTotalHourlyCost();

    }
    
    public Cost getTotalCostUpdated(Bid bidList) {
    	
    	
    	return this.pool.getTotalHourlyCostUpdated(bidList);
    }
    
    private void findMeASweetSweetRecource(Bid bid) {
    	int reqRam = bid.Ram;
    	long reqBw = bid.bw;
    	long reqSize = bid.Size;
    	
    	for (Rc rc : this.pool.rcs) {
			
    		int count = 0;
    		if(rc.getTotalAvailableBW() > reqBw) {count ++;}
    		if(rc.getTotalAvailableSize() > reqSize) {count ++;}
    		if(rc.getTotalAvailableRam() > reqRam) {count ++;}    		
    		
    		
//    		System.out.println(count);
    		if (count > 2) {
    			this.pool.updatePool(bid);

    			bid.addAllocatedRc(rc);

    			break; 
    		}else{
    			this.pool.updatePool(bid);

    			bid.addAllocatedRc(rc);
    		}
    		
    		if (count == 0) {
    			
    			// recource not available anymore
    			break;
    		}
    		
    	}
    }
    
    public void allocatePool(List<Bid> bidList) {
    	// updates the pool.
    	
    	
    	
    	for (Bid bid : bidList) {
    		System.out.println("Bid # "+bid.toString());
			this.findMeASweetSweetRecource(bid);
		}
    	
    }

}
