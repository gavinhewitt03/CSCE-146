/*
 * Gavin Hewitt
 */
public class Sheep implements Comparable<Sheep> {
	private String name;
	private int sheeringTime;
	private int arrivalTime;
	private int sheeringTimeLeft;
	public Sheep()
	{
		name = "none";
		sheeringTime = 0;
		arrivalTime = 0;
		sheeringTimeLeft = 0;
	}
	public Sheep(String n, int s, int a)
	{
		name = n;
		sheeringTime = s;
		sheeringTimeLeft = s;
		arrivalTime = a;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		if(name == null)
			return;
		this.name = name;
	}
	public int getSheeringTime() {
		return sheeringTime;
	}
	public void setSheeringTime(int sheeringTime) {
		if(sheeringTime <= 0)
			return;
		this.sheeringTime = sheeringTime;
	}
	public int getArrivalTime() {
		return arrivalTime;
	}
	public void setArrivalTime(int arrivalTime) {
		if(arrivalTime <= 0)
			return;
		this.arrivalTime = arrivalTime;
	}
	public int compareTo(Sheep s)
	{
		if(this.sheeringTime > s.sheeringTime)
			return 1;
		else if(this.sheeringTime < s.sheeringTime)
			return -1;
		else
		{
			return this.name.compareTo(s.name);
		}
	}
	public void sheerForOneMinute() 
	{
		if(sheeringTimeLeft > 0)
			sheeringTimeLeft--;
	}
	public boolean isDone()
	{
		if(sheeringTimeLeft == 0)
			return true;
		else
			return false;
	}
	public String toString()
	{
		return "Name: " + this.getName() + ", Sheering Time: " + this.getSheeringTime() + ", Arrival Time: " + this.getArrivalTime();
	}
}
