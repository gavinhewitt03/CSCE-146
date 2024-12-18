/*
 * Gavin Hewitt
 */
public class Prize {
	private double price;
	private String name;
	private boolean hasOccured;
	public Prize(String n, double p, boolean o)
	{
		name = n;
		price = p;
		hasOccured = o;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public boolean hasOccurred() {
		return hasOccured;
	}
	public void setHasOccurred(boolean hasOccured) {
		this.hasOccured = hasOccured;
	}
	public String print()
	{	
		return "Prize: "+this.getName()+" Price: "+this.getPrice();
	}
}
