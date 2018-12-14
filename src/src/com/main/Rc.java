package src.com.main;

import org.cloudbus.cloudsim.Datacenter;
import org.cloudbus.cloudsim.Vm;

import src.com.bean.Bid;

public class Rc {
	
	public CustomDatacenter dc;
	public int totalRAM = 0;
	public long totalBW = 0, totalSIZE;
	public double hourlyCost = 0.007;
	
	public Rc(CustomDatacenter someDc) {
		// TODO Auto-generated constructor stub
		this.dc = someDc;
		
		this.totalRAM = this.getTotalAvailableRam();
		this.totalSIZE = this.getTotalAvailableSize();
		this.totalBW = this.getTotalAvailableBW();	
		
		
		

	}
	
	long getTotalAvailableSize() {
		long totalR = 0;
		if (this.dc != null && this.dc.getVmList() != null) {

		for (Vm vm : this.dc.getVmList()) {
			totalR += vm.getSize();
			//			totalR = addAndCheck(totalR, vm.getCurrentAllocatedSize(), "unknown: ADD");
			
		}	
		}
		return totalR;
	}

	
	int getTotalAvailableRam() {
		int totalR = 0;
		if (this.dc != null && this.dc.getVmList() != null) {
			for (Vm vm : this.dc.getVmList()) {
				totalR += vm.getRam();
				
			}
		}
		return totalR;
	}
	
	
	long getTotalAvailableBW() {
		long totalR = 0;
		if (this.dc != null && this.dc.getVmList() != null) {

		for (Vm vm : this.dc.getVmList()) {
			totalR += vm.getBw();
			
		}				
		}
		return totalR;
	}

	
	
	long getTotalAllocatedSize() {
		long totalR = 0;
		if (this.dc != null && this.dc.getVmList() != null) {
		
		for (Vm vm : this.dc.getVmList()) {
			totalR += vm.getCurrentAllocatedSize();
			//			totalR = addAndCheck(totalR, vm.getCurrentAllocatedSize(), "unknown: ADD");
			
		}				
		}
		return totalR;
	}

	
	int getTotalAllocatedRam() {
		int totalR = 0;
		
		if (this.dc != null && this.dc.getVmList() != null) {

		for (Vm vm : this.dc.getVmList()) {
			totalR += vm.getCurrentAllocatedRam();
			
		}				
		}
		return totalR;
	}
	
	
	long getTotalAllocatedBW() {
		
		long totalR = 0;
		
		if (this.dc != null && this.dc.getVmList() != null) {

			for (Vm vm : this.dc.getVmList()) {
				totalR += vm.getCurrentAllocatedBw();
				
			}				
		}
		return totalR;
	}
	

	public void reduceby(Bid bid) { 
		reduceBWby(bid.bw);
		reduceSIZEby(bid.Size);
		reduceRAMby(bid.Ram);
	}

	
	void reduceBWby(long bw) { this.totalBW = this.totalBW-bw >=0 ? this.totalBW-bw  : 0; }
	void reduceRAMby(int ram) { this.totalRAM = this.totalRAM-ram >=0 ? this.totalRAM-ram  : 0; }
	void reduceSIZEby(long size) { this.totalSIZE = this.totalSIZE-size >=0 ? this.totalSIZE-size : 0; }	
	
	  private static long addAndCheck(long a, long b, String msg) {
	      long ret;
	      if (a > b) {
	          // use symmetry to reduce boundry cases
	          ret = addAndCheck(b, a, msg);
	      } else {
	          // assert a <= b
	          
	          if (a < 0) {
	              if (b < 0) {
	                  // check for negative overflow
	                  if (Long.MIN_VALUE - b <= a) {
	                      ret = a + b;
	                  } else {
	                      throw new ArithmeticException(msg);
	                  }
	              } else {
	                  // oppisite sign addition is always safe
	                  ret = a + b;
	              }
	          } else {
	              // assert a >= 0
	              // assert b >= 0

	              // check for positive overflow
	              if (a <= Long.MAX_VALUE - b) {
	                  ret = a + b;
	              } else {
	                  throw new ArithmeticException(msg);
	              }
	          }
	      }
	      return ret;
	  }

	public Cost getTotalCost() {
		// TODO Auto-generated method stub
		return this.dc.cost;
	}
}
