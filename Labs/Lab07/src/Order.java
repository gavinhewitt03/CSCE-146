/*
 * Gavin Hewitt
 */
public class Order implements Comparable<Order>{
	private String customer;
	private String foodOrder;
	private int cookingTime;
	private int arrivalTime;
	private int cookingTimeLeft;
	public Order()
	{
		customer = "none";
		foodOrder = "none";
		cookingTime = 1;
		arrivalTime = 0;
		cookingTimeLeft = 1;
	}
	public Order(String c, String f, int ct, int at)
	{
		customer = c;
		foodOrder = f;
		cookingTime = ct;
		arrivalTime = at;
		cookingTimeLeft = ct;
	}
	public String getCustomer() {
		return customer;
	}
	public void setCustomer(String customer) {
		if(customer == null)
			return;
		this.customer = customer;
	}
	public String getFoodOrder() {
		return foodOrder;
	}
	public void setFoodOrder(String foodOrder) {
		if(foodOrder == null)
			return;
		this.foodOrder = foodOrder;
	}
	public int getCookingTime() {
		return cookingTime;
	}
	public void setCookingTime(int cookingTime) {
		if(cookingTime <= 0)
			return;
		this.cookingTime = cookingTime;
	}
	public int getArrivalTime() {
		return arrivalTime;
	}
	public void setArrivalTime(int arrivalTime) {
		if(arrivalTime <= 0)
			return;
		this.arrivalTime = arrivalTime;
	}
	public int getCookingTimeLeft() {
		return cookingTimeLeft;
	}
	public void setCookingTimeLeft(int cookingTimeLeft) {
		if(cookingTimeLeft <= 0)
			return;
		this.cookingTimeLeft = cookingTimeLeft;
	}
	public String toString()
	{
		return "Customer: " + this.getCustomer() + ", Order: " + this.getFoodOrder() + ", Cooking Time Left: " + this.getCookingTimeLeft();
	}
	public int compareTo(Order o)
	{
		if(this.cookingTime < o.cookingTime)
			return -1;
		else if(this.cookingTime > o.cookingTime)
			return 1;
		else
			return 0;
	}
	public void cookForOneMinute()
	{
		if(!this.isDone())
			cookingTimeLeft--;
	}
	public boolean isDone()
	{
		if(cookingTimeLeft == 0)
			return true;
		else
			return false;
	}
	
}
