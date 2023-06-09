package MemoryManagement;
import java.util.*;


public class BestFit {
	Scanner input = new Scanner(System.in);
    LinkedList<Process> processes;
    LinkedList<Partition> partitions;
    static int sz;
    Compaction c;
    public BestFit(LinkedList<Process> processes, LinkedList<Partition> partitions) {
        this.processes = processes;
        this.partitions = partitions;
        sz = partitions.size();
     
    }
	 public void BestFit() {
	        for (int i = 0; i < processes.size(); i++) {
	            int BIdx = -1;
	            for (int j = 0; j < partitions.size(); j++) {
	                if (partitions.get(j).PartitionSize >= processes.get(i).ProcessSize) {
	                    if (BIdx == -1)
	                    	BIdx = j;
	                    else if (partitions.get(BIdx).PartitionSize > partitions.get(j).PartitionSize)
	                    	BIdx = j;
	                }
	            }
	            
	            
	            if (BIdx != -1) {
	                processes.get(i).Allocated = true;
	                partitions.get(BIdx).setProcess(processes.get(i));
	                partitions.get(BIdx).PartitionSize -= processes.get(i).ProcessSize;
	                partitions.get(BIdx).Status = true;

	                if (partitions.get(BIdx).PartitionSize > 0) {
	                    sz += 1;
	                    Partition partition = new Partition("partition" + (sz - 1), partitions.get(BIdx).PartitionSize,
	                            false);
	                    partitions.add(BIdx + 1, partition);
	                    partitions.get(BIdx).PartitionSize = 0;
	                }
	            }
	        }
	        for (int i = 0; i < partitions.size(); i++) {
	            // if partition contain process
	            if (partitions.get(i).Status == true) {
	                System.out
	                        .println(partitions.get(i).PartitionName + "(" + partitions.get(i).process.ProcessSize + " KB)"
	                                + "=> " + partitions.get(i).process.ProcessName);
	            } else {
	                System.out.println(partitions.get(i).PartitionName + "(" + partitions.get(i).PartitionSize + " KB)"
	                        + "=> External Fragmentation");
	            }
	        }
	        for (int i = 0; i < processes.size(); i++) {
	            if (!processes.get(i).Allocated) {
	                System.out.println(processes.get(i).ProcessName + " Can Not be Allocated");
	            }
	        }

	        

	    }
}