/*
 * Gavin Hewitt
 */
public class OrderScheduler {
	private MinHeap<Order> orders;
	private Order currentOrder;
	private int currentMinute;
	private int totalOrders;
	private int summedWaitingTimes;
	public OrderScheduler()
	{
		orders = new MinHeap<Order>();
		currentOrder = null;
		currentMinute = 0;
		totalOrders = 0;
		summedWaitingTimes = 0;
	}
	public void addOrder(Order o)
	{
		if(currentOrder == null)
			currentOrder = o;
		else
			orders.add(o);
		totalOrders++;
	}
	public void advanceOneMinute()
	{
		currentMinute++;
		currentOrder.cookForOneMinute();
		if(currentOrder.isDone())
		{
			summedWaitingTimes += (currentMinute - currentOrder.getArrivalTime());
			currentOrder = orders.remove();
		}
	}
	public boolean isDone()
	{
		if(currentOrder == null)
			return true;
		else
			return false;
	}
	public double getAverageWaitingTime()
	{
		return (double)summedWaitingTimes / totalOrders;
	}
	public Order getCurrentOrder() {
		return currentOrder;
	}
	public void setCurrentOrder(Order currentOrder) {
		if(currentOrder == null)
			return;
		this.currentOrder = currentOrder;
	}
}

