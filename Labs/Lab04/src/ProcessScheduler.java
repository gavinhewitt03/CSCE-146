/*
 * Gavin Hewitt
 */
public class ProcessScheduler {
	private LLQueue<Process> processes;
	private Process currentProcess; //begins after element has been removed from queue
	
	public ProcessScheduler()
	{
		processes = new LLQueue<Process>();
		currentProcess = null;
	}
	public Process getCurrentProcess()
	{
		return currentProcess;
	}
	public void addProcess(Process p)
	{
		if(currentProcess == null)
		{
			currentProcess = p;
		} else
		{
			processes.enqueue(p);
		}
	}
	public void runNextProcess()
	{
		currentProcess = processes.dequeue();
	}
	public void cancelCurrentProcess()
	{
		currentProcess.setCompletionTime(0);
		currentProcess = processes.dequeue();
	}
	public void printProcessQueue()
	{
		processes.print();
	}
}
