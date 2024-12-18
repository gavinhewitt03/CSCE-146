/*
 * Gavin Hewitt
 */
import java.math.*;
public class Fruit implements Comparable<Fruit> {
	private String type;
	private double weight;
	
	public Fruit()
	{
		type = "apple";
		weight = 1.0;
	}
	public Fruit(String s, double w)
	{
		if(s == null && w <= 0.0)
		{
			type = "apple";
			weight = 1.0;
			return;
		}
		type = s;
		weight = w;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		if(type == null)
			return;
		this.type = type;
	}
	public double getWeight() {
		return weight;
	}
	public void setWeight(double weight) {
		if(weight <= 0.0)
			return;
		this.weight = weight;
	}
	public String toString()
	{
		return "Type: "+this.type+" Weight: "+this.weight;
	}
	public int compareTo(Fruit f)
	{
		if(f == null)
			return -1;
		if(this.getWeight() == f.getWeight())
		{
			return this.getType().compareTo(f.getType());
		}
		if(this.getWeight() - f.getWeight() > 0)
			return 1;
		else
			return -1;
	}
}
