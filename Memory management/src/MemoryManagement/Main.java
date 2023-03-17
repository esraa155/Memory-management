package MemoryManagement;



import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {
	 public static void main(String[] args) {
	System.out.println("Enter number of partitions:");
    Scanner myObj = new Scanner(System.in);
    int  pnumbers = myObj.nextInt();
    LinkedList<Partition> Contacts = new LinkedList<Partition>();
    LinkedList<Process> data = new LinkedList<Process>();
    LinkedList<Partition> Contacts2 = new LinkedList<Partition>();
    LinkedList<Process> data2 = new LinkedList<Process>();
    LinkedList<Partition> Contacts3 = new LinkedList<Partition>();
    LinkedList<Process> data3 = new LinkedList<Process>();
 
 
    for (int j=0 ; j< pnumbers ; j++)
   {
       System.out.println("Enter name and size of partition:");
       String pName = myObj.next();
       int  psize = myObj.nextInt();
        Partition obj2= new Partition(pName, psize,false);
        Partition obj3= new Partition(pName, psize,false);
        Partition obj = new Partition(pName, psize,false);
        Contacts.add(obj);
        Contacts2.add(obj2);
        Contacts3.add(obj3);
       
   }

    System.out.println("Enter number of processes:");
    int  prosnumbers = myObj.nextInt();
    for (int i=0 ; i< prosnumbers ; i++)
    {
        System.out.println("Enter process name and its size:");
       String prName = myObj.next();
        int  prsize = myObj.nextInt();
        Process obj = new Process(prName, prsize,false);
        Process obj3 = new Process(prName, prsize,false);
        Process obj2 = new Process(prName, prsize,false);
        data.add(obj);
        data2.add(obj2);
        data3.add(obj2);
   }



 
	 
  while(true){
    System.out.println("Select the policy you want to apply:");
    System.out.println("1. First fit");
    System.out.println("2. Worst fit");
    System.out.println("3. Best fit");
	System.out.println("4.Exist");
    int num = myObj.nextInt();

    if (num==1)
    {
    	 
    		 

        First_fit ff = new  First_fit(data,Contacts);
        ff.FirstFit();
    System.out.println("Do you want to compact? 1.yes 2.no");
    int choose = myObj.nextInt();

       if (choose==1)
    {
    	Compaction c=new Compaction(Contacts,data);
    	c.CompactOperation();
    }
    }
    else if (num==2)
    {
    	
 
	 

        WorstFit w=new WorstFit(Contacts2, data2);
        w.worstFitSimulation();
    System.out.println("Do you want to compact? 1.yes 2.no");
    int choose = myObj.nextInt();

     if (choose==1)
    {
    	Compaction c=new Compaction(Contacts2,data2);
    	c.CompactOperation();
    }
    

    }

    else if (num==3)
    {

  
    
        BestFit ff = new  BestFit(data3,Contacts3);
        ff.BestFit();
    System.out.println("Do you want to compact? 1.yes 2.no");
    int choose = myObj.nextInt();

    if (choose==1)
    {
    	Compaction c=new Compaction(Contacts3,data3);
    	c.CompactOperation();
    }
    

    }

    else if(num==4){
	break;
}

}
  }
}
