/*
 * Gavin Hewitt
 */
public class SheepScheduler {
	private MinHeap<Sheep> sheep;
	private int currentMinute;
	private Sheep currentSheep;
	private int totalSheep;
	public SheepScheduler()
	{
		sheep = new MinHeap<Sheep>();
		currentMinute = 0;
		currentSheep = null;
		totalSheep = 0;
	}
	public void addSheep(Sheep s)
	{
		if(currentSheep == null)
			currentSheep = s;
		else
			sheep.add(s);
		totalSheep++;
	}
	public void advanceOneMinute()
	{
		currentMinute++;
		currentSheep.sheerForOneMinute();
		if(currentSheep.isDone())
			currentSheep = sheep.remove();
	}
	public boolean isDone()
	{
		if(currentSheep == null)
			return true;
		else
			return false;
	}
	public Sheep getCurrentSheep() {
		return currentSheep;
	}
	public void setCurrentSheep(Sheep currentSheep) {
		if(currentSheep == null)
			return;
		this.currentSheep = currentSheep;
	}
	public int getTotalSheep() {
		return totalSheep;
	}
	public void print()
	{
		sheep.print();
	}
}
