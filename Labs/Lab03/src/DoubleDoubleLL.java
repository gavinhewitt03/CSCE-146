/*
 * Gavin Hewitt
 */
public class DoubleDoubleLL {
	private class ListNode
	{
		double data;
		ListNode fLink;
		ListNode pLink;
		public ListNode(double d, ListNode f, ListNode p)
		{
			data = d;
			fLink = f;
			pLink = p;
		}
	}
	private ListNode head;
	private ListNode current;
	private int size;
	public DoubleDoubleLL()
	{
		head = current = null;
	}
	public void gotoNext()
	{
		if(current == null)
			return;
		current = current.fLink;
	}
	public void gotoPrev()
	{
		if(current.pLink == null)
			return;
		current = current.pLink;
	}
	public void reset() //sets current back to head and previous to nothing
	{
		current = head;
		current.pLink = null;
	}
	public void gotoEnd() //sets current to tail and previous to previous link to tail
	{
		reset();
		while(current.fLink != null)
		{
			gotoNext();
		}
	}
	public boolean hasMore() //checks that current is not null
	{
		return current != null;
	}
	public double getCurrent()
	{
		if(current == null)
			return 0; //dr. shepherd said to return 0 because you cant return null when return type is double
		return current.data; //returns data of current node
	}
	public void setCurrent(double d)
	{
		if(current == null)
			return;
		current.data = d; //sets data of current node to value in parameter if current node exists
		
	}
	public void add(double d)
	{
		ListNode newNode = new ListNode(d, null, null);
		if(head == null)
		{
			head = current = newNode;
			this.size = 1;
			return;
		}
		ListNode temp = head;
		while(temp.fLink != null) //cycles through linked list
		{
			temp = temp.fLink;
		}
		temp.fLink = newNode; //sets link of last node in list to new node to be added at end
		newNode.pLink = temp; //sets the previous link of the newNode that is added to the temporary node aka the previous last node
		this.size++;
	}
	public void addAfterCurrent(double d)
	{
		if(current == null)
			return;
		ListNode newNode = new ListNode(d, current.fLink, current); //creates a new node with a link to the current link and a previous link to the current node
		current.fLink = newNode; //sets the link of the current node to the node that was just created
		this.size++;
	}
	public void removeCurrent()
	{
		if(current == null)
			return;
		if(current == head)
		{
			head = head.fLink;
			head.pLink = null;
			current = head;
			this.size--;
			return;
		}
		if(current.fLink != null)
		{
			current.pLink.fLink = current.fLink;
			current.fLink.pLink = current.pLink;
			this.size--;
		}
		if(current.fLink == null)
		{
			current = current.pLink;
			current.fLink = null;
		}
	}
	public void remove(double d)
	{
		reset();
		while(hasMore())
		{
			if(getCurrent() == d)
			{
				removeCurrent();
				break;
			}
			gotoNext();
		}
	}
	public void print()
	{
		reset();
		while(hasMore())
		{
			System.out.println(getCurrent());
			gotoNext();
		}
	}
	public boolean contains(double d)
	{
		reset();
		while(hasMore())
		{
			if(getCurrent() == d)
			{
				return true;
			}
			gotoNext();
		}
		return false;
	}
}
