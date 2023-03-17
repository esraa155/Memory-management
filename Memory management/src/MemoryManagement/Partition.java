package MemoryManagement;

public class Partition {
	String PartitionName;
   public int PartitionSize;
    public boolean Status;
    public Process process;
    public Partition() {
    }

    public Partition(String PtName, int PtSize,boolean s) {
        PartitionName = PtName;
        PartitionSize = PtSize;
        Status = s;
    }
    
    public Process getProcess() {
        return process;
    }
    public int getPartitionSize() {
        return PartitionSize;
    }
    public void setProcess(Process process) {
        this.process = process;
    }
}
