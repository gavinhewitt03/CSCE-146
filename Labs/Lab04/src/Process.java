/*
 * Gavin Hewitt
 */
public class Process {
	private String name;
	private double completionTime;
	private static final String DEF_NAME = "none";
	private static final double DEF_COMPLETION_TIME = 0.0;
	public Process()
	{
		name = DEF_NAME;
		completionTime = DEF_COMPLETION_TIME;
	}
	public Process(String s, double c)
	{
		name = s;
		completionTime = c;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		if(name == null)
			return;
		this.name = name;
	}
	public double getCompletionTime() {
		return completionTime;
	}
	public void setCompletionTime(double completionTime) {
		if(completionTime <= 0.0)
			completionTime = 0.0;
		this.completionTime = completionTime;
	}
	public String toString()
	{
		return "Process Name: " + this.name + " Completion Time: " + this.completionTime;
	}
}
