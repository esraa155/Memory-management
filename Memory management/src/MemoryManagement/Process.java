package MemoryManagement;

public class Process {
	 String ProcessName;
	    int ProcessSize;
	    public boolean Allocated;
	    public Process() {
	    }

	    public Process(String PName, int PSize,boolean allocated) {
	        ProcessName = PName;
	        ProcessSize = PSize;
	        Allocated = allocated;
	    }
}
