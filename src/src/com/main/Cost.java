package src.com.main;

public class Cost {
	
//	public double costRam = 0.00233; // 1GB 
//	public double costBw = 0.00233; // 1TB 
//	public double costSize = 0.0001; // 1 GB SSD

	
	public double costRam = 0.0; // 1GB 
	public double costBw = 0.0; // 1TB 
	public double costSize = 0.0; // 1 GB SSD	
	
	public Cost() {

		this.costBw = 0.00233; // 1GB 
		this.costRam = 0.00233; // 1TB 
		this.costSize = 0.0001; // 1 GB SSD
		
	}
	
	public Cost(double costRam, double costBw, double costSize) {
		
		this.costBw = costBw;		
		this.costRam = costRam;		
		this.costSize = costSize;
	}
	
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "BW : "+this.costBw +"  ,  RAM : "+this.costRam +"  , Size : "+this.costSize;
	}

	public double getTotalPrice() {
		// TODO Auto-generated method stub
		return (this.costBw+(double)this.costRam+this.costSize);
	}
}
