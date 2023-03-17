package MemoryManagement;

import java.util.*;
import java.util.ArrayList;


public class WorstFit {

	LinkedList<Partition> partitions =new LinkedList<Partition>();
	LinkedList<Process> processes =new LinkedList<Process>();

	public WorstFit (LinkedList<Partition>partitions,LinkedList<Process>processes)
	{
		this.partitions=partitions;
		this.processes=processes;
		
	
	}

	public void worstFitSimulation()
	{
		for(int j=0;j<processes.size();j++)
		{
			int maxindex=-1;
			for(int i=0;i<partitions.size();i++)
			{

				if(processes.get(j).ProcessSize<=partitions.get(i).PartitionSize)
				{
					if(maxindex==-1)
					{
						maxindex=i;
					}
					else if (partitions.get(maxindex).PartitionSize<partitions.get(i).PartitionSize)
					{
						maxindex=i;
					}
								
				}
				
				
			}
			
			if(maxindex!=-1)
			{
				partitions.get(maxindex).setProcess(processes.get(j));
				partitions.get(maxindex).Status=true;
				processes.get(j).Allocated=true;
				int x=partitions.get(maxindex).PartitionSize-processes.get(j).ProcessSize;
				partitions.get(maxindex).PartitionSize=processes.get(j).ProcessSize;
				if(x>0)
				{
					int num=partitions.size();
					String newstr="partition"+num;
					Partition P=new Partition(newstr,x,false);
					partitions.add(maxindex+1,P);			
					
				}
				
				 

			}
			
		
			
			
		}
        
		for(int i=0;i<partitions.size();i++)
		{
			 if (partitions.get(i).Status == true)
	            {
	                System.out.println(partitions.get(i).PartitionName + "  "+"(" + partitions.get(i).process.ProcessSize + " KB)"
	                                + " => " + partitions.get(i).process.ProcessName);
	            } 
			  else if(partitions.get(i).Status == false)
			  {
	                System.out.println(partitions.get(i).PartitionName +"  "+ "(" + partitions.get(i).PartitionSize + " KB)"
	                        + " => External Fragmentation");
	          }
		}
		
	
        for (int i = 0; i < processes.size(); i++) 
        {
            if (!processes.get(i).Allocated) 
            {
                System.out.println(processes.get(i).ProcessName + " Can Not be Allocated");
            }

        }
		
		
		
	}
	

	
}