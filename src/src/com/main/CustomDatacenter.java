package src.com.main;

import java.util.ArrayList;
import java.util.List;

import org.cloudbus.cloudsim.Vm;

public class CustomDatacenter {
	
	public long bw,size;
	public int ram,dataCenterId ;
	public String dataCenterName;
	private List<Vm> vm;
	
	private double costRam = 0.00233; // 1GB 
	private double costBw = 0.00000233; // 1GB 
	private double costSize = 0.0001; // 1 GB SSD
	
	public Cost cost;
	
	public CustomDatacenter(int id, String name, int ram,long bw, long size,List<Vm> vmList) {
		// TODO Auto-generated constructor stub
		this.bw = bw;
		this.size = size;
		this.ram = ram;
		
		this.dataCenterName = name;
		this.dataCenterId = id;
		
		this.vm = vmList;
		
		
		this.cost = new Cost(0.00233,0.00000233,0.0001);
		
	}
	
	
	
	public List<Vm> getVmList() {
		return this.vm;
	}
	
	
	
	public int getId() {
		return dataCenterId;
	}
	
	

}
