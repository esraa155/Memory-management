package MemoryManagement;

import java.util.LinkedList;
import java.util.*;

public class Compaction {
	LinkedList<Partition> Contacts;
	LinkedList<Partition> Compactlist = new LinkedList<Partition>();
	LinkedList<Process> data;
	int SpaceSize = 0;

	public Compaction(LinkedList<Partition> Contacts, LinkedList<Process> data) {
		this.Contacts = Contacts;
		this.data = data;
	}

	public void CompactOperation() {
		
		int size=Contacts.size();
		int spacesize=0;
		
		
		for (int i=0;i<size;i++) {
			if(Contacts.get(i).Status==false) {
				 Compactlist.add(Contacts.get(i));
				 spacesize+=Contacts.get(i).PartitionSize;
			}
		}
		
		Partition p=new Partition();
		p.PartitionName="Partition"+size;
		p.Status=false; 
		Contacts.addLast(p);
		p.PartitionSize=spacesize;
		for (int i=0;i<Compactlist.size();i++) {
			Contacts.remove(Compactlist.get(i));
		}
		
		for (int i=0;i<data.size();i++) {
			int size2=Contacts.size();
			if(Contacts.get(size2-1).PartitionSize==data.get(i).ProcessSize) {
				Contacts.get(size2-1).process=data.get(i);
				Contacts.get(size2-1).process.Allocated=true;
				Contacts.get(size2-1).Status=true;
				Contacts.get(size2-1).PartitionSize=data.get(i).ProcessSize;
			}
			else if(!data.get(i).Allocated) {
				if(Contacts.get(size2-1).PartitionSize>data.get(i).ProcessSize) {
				Contacts.get(size2-1).process=data.get(i);
				Contacts.get(size2-1).process.Allocated=true;
				Contacts.get(size2-1).Status=true;
				Contacts.get(size2-1).PartitionSize=data.get(i).ProcessSize;
				spacesize-=Contacts.get(size2-1).PartitionSize;
				Partition p2=new Partition();
				p2.PartitionName="Partition"+(size+1);
				p2.Status=false; 
				Contacts.addLast(p2);
				p2.PartitionSize=spacesize;}
				
				
			}
			
		}
		
		
		

		for (int i = 0; i < Contacts.size(); i++) {

			if (Contacts.get(i).Status == true) {
				System.out.println(Contacts.get(i).PartitionName + "  " + "(" + Contacts.get(i).process.ProcessSize
						+ " KB)" + " => " + Contacts.get(i).process.ProcessName);
			} else {
				System.out.println(Contacts.get(i).PartitionName + "  " + "(" + Contacts.get(i).PartitionSize + " KB)"
						+ " => External Fragmentation");
			}
		}

	}

}
