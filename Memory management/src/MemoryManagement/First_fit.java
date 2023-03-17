package MemoryManagement;

import java.util.*;
public class First_fit {
	Scanner input = new Scanner(System.in);
	
    LinkedList<Process> processes;
    LinkedList<Partition> partitions;
    static int size;
  

    public First_fit(LinkedList<Process> processes, LinkedList<Partition> partitions) {
        this.processes = processes;
        this.partitions = partitions;
        size = partitions.size();
        
    }
    public void FirstFit() {

        for (int i = 0; i < processes.size(); i++) {
            for (int j = 0; j < partitions.size(); j++) {

                if (partitions.get(j).PartitionSize >= processes.get(i).ProcessSize) {
                    processes.get(i).Allocated = true;
                    partitions.get(j).setProcess(processes.get(i));
                    partitions.get(j).PartitionSize -= processes.get(i).ProcessSize;
                    partitions.get(j).Status = true;
                    if (partitions.get(j).PartitionSize > 0) {
                    	size += 1;
                        Partition partition = new Partition("partition" + (size - 1), partitions.get(j).PartitionSize,
                                false);
                        partitions.add(j + 1, partition);
                        partitions.get(j).PartitionSize = 0;
                    }
                    break;
                }

            }
        }
        for (int i = 0; i < partitions.size(); i++) {
            if (partitions.get(i).Status == true) {
                System.out.println(partitions.get(i).PartitionName + "  "+"(" + partitions.get(i).process.ProcessSize + " KB)"
                                + " => " + partitions.get(i).process.ProcessName);
            } else {
                System.out.println(partitions.get(i).PartitionName +"  "+ "(" + partitions.get(i).PartitionSize + " KB)"
                        + " => External Fragmentation");
            }
        }
        
        for (int i = 0; i < processes.size(); i++) {
            if (!processes.get(i).Allocated) {
                System.out.println(processes.get(i).ProcessName + " Can Not be Allocated");
            }

        }

    }
}