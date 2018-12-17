package src.com.main;

import java.security.Timestamp;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import org.cloudbus.cloudsim.Cloudlet;
import org.cloudbus.cloudsim.CloudletSchedulerTimeShared;
import org.cloudbus.cloudsim.Datacenter;
import org.cloudbus.cloudsim.DatacenterBroker;
import org.cloudbus.cloudsim.DatacenterCharacteristics;
import org.cloudbus.cloudsim.Host;
import org.cloudbus.cloudsim.Log;
import org.cloudbus.cloudsim.Pe;
import org.cloudbus.cloudsim.Storage;
import org.cloudbus.cloudsim.UtilizationModel;
import org.cloudbus.cloudsim.UtilizationModelFull;
import org.cloudbus.cloudsim.Vm;
import org.cloudbus.cloudsim.VmAllocationPolicySimple;
import org.cloudbus.cloudsim.VmSchedulerTimeShared;
import org.cloudbus.cloudsim.core.CloudSim;
import org.cloudbus.cloudsim.provisioners.BwProvisionerSimple;
import org.cloudbus.cloudsim.provisioners.PeProvisionerSimple;
import org.cloudbus.cloudsim.provisioners.RamProvisionerSimple;

import src.com.bean.Bid;
import src.com.output.Output;
import src.com.source.Limitation;
import src.com.source.Vcg;

/**
 * This is starting point of demo
 * @author Priyanka Ranalkar
 *
 */
public class AuctionVcg {

	/** The cloudlet list. */
	private static List<Cloudlet> cloudletList;

	/** The vmlist. */
	private static List<Vm> vmlist;
	
	
	private static String [] regions = {"nyc1","ams3","lon1","sfo2","fra1","sgp1","blr1","tor1"};


	public static double getRandomDoubleBetweenRange(double min, double max){
	
	    double x = (Math.random()*((max-min)+1))+min;
	
	    return x;
	
	}
	public static ArrayList<Bid> CreateBids(double limit){
		Limitation limitation = new Limitation(limit);

		
		ArrayList<Bid> al = new ArrayList<Bid>();

		Random r = new Random();
		
		for (int i = 0; i < 10; i++) {
			// Everything is in GB
			int ram = (int) getRandomDoubleBetweenRange(1,64);
			int bw = (int) getRandomDoubleBetweenRange(1000,9000);			
			int volume = (int) getRandomDoubleBetweenRange(1,40); // Ssd
			int regionIndex = (int) getRandomDoubleBetweenRange(0,7); // Ssd
			
			String bidId = "";
			for (int j = 0; j < 10; j++) {
				bidId+=(int) getRandomDoubleBetweenRange(0,7);

			}


			double price = 0.007 + (0.023 - 0.007) * r.nextDouble();
			System.out.println(price);

			int duration =  (int)getRandomDoubleBetweenRange(1,300); // in hour
			
			al.add(new Bid(i+1,bidId,regions[regionIndex], "11", "Student", new Date(System.currentTimeMillis()).toString(), price,
					ram,bw,volume,duration));
		}
		

		return limitation.getValidBids(al);
	}
	
	public static void main(String[] args) {
		
		CustomGraph cGRaph = new CustomGraph();
		
		for (int i = 0; i < 10; i++) {
			
			// Fourth step: Create one virtual machine
			vmlist = new ArrayList<Vm>();
	
			// VM description
			int vmid = 0;
			int mips = 1000;
			long size = 3840; // 3840 disk size (GB)
			int ram = 192; // vm 192 memory (GB) 
			long bw = 12000; // 12,000 GB = 12 tb 
			int pesNumber = 1; // number of cpus
			String vmm = "Xen"; // VMM name
	
			// create VM
			Vm vm = new Vm(vmid, pesNumber, mips, pesNumber, ram, bw, size, vmm, new CloudletSchedulerTimeShared());		
			// add the VM to the vmList
			vmlist.add(vm);	
			CustomDatacenter datacenter0 = new CustomDatacenter(2, "Datacenter_0", ram, bw, size,vmlist);
	
		
			Vcg vcg = new Vcg();
			Output output = new Output();
			
			ArrayList<Bid> al = CreateBids(datacenter0.cost.getTotalPrice());
			System.out.println("========== All Bids ==========");
			output.printOutput(al);
			
			
			// Get bids for multiple resources
//			List<Bid> winners = vcg.AcutionForNResourcesVCG(al);
			List<Bid> winners = vcg.AcutionForNResourcesFIFO(al);
//			List<Bid> winners = vcg.AcutionForNResources(al);

			System.out.println(winners.toString());		
	
			/*
			 * Custom Module Starts here
			 * 
			 */
			
			System.out.println("############################");
			System.out.println("######### Custom Module Starts  ########");		
			System.out.println("############################");

			
			
			System.out.println(datacenter0.dataCenterName);
	
			System.out.println(datacenter0.dataCenterId);
	//		System.out.println(datacenter0.getVmList().toString());
			
			// TODO: VM List is zero !!
	//		System.out.println(datacenter0.getVmList().size());
	
			
			Rc rc1 = new Rc(datacenter0);
			List<Rc> rclist = new ArrayList<>();
			rclist.add(rc1);
			Pool pool = new Pool(rclist);
			System.out.println(pool.toString());
	
			Backbone BackBoneObject = Backbone.getInstance(pool);			
			BackBoneObject.allocatePool(winners);				
			System.out.println(BackBoneObject.getUnUtilization());
	
			System.out.println(BackBoneObject.getTotalCost().toString());
			System.out.println("Data for bid "+winners.get(0));
			Cost vcgCost = BackBoneObject.getTotalCostUpdated(winners.get(0));
			System.out.println(vcgCost.toString());
			
			
			cGRaph.profitListVcg.add(vcgCost);
			cGRaph.biddingCount.add(al.size());		
			cGRaph.utilizationList.add(BackBoneObject.getUtilizationPercentage());
		}
	
		cGRaph.DisplayProfitvsPeriods();
		cGRaph.DisplayUtilizationsvsPeriods();
		
	}


}
