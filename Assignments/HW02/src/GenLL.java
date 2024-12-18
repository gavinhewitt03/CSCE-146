import java.util.Iterator;

/*
 * Gavin Hewitt
 */
public class GenLL <T> implements Iterable<T>{ //variable of types so type can be dynamically created
	protected class ListNode //protected allows data to be accessed in a class that extends current class
	{
		T data; //T is the data type and the compiler fills in what data type is in the moment so you dont have to write it yourself
		ListNode link;
		public ListNode(T aData, ListNode alink)
		{
			data = aData;
			link = alink;
		}
	}
	protected class ListIterator implements Iterator<T>
	{
		private ListNode curr;
		public ListIterator()
		{
			curr = head;
		}
		public boolean hasNext()
		{
			return curr != null;
		}
		public T next()
		{
			T ret = curr.data;
			curr = curr.link;
			return ret;
		}
	}
	/*
	public void test()
	{
		T aData = null;
		ListNode aHead = new ListNode(aData, null);
		aHead.link = new ListNode(aData, null);
		aHead.link.link = new ListNode(aData, null);
		aHead.link.link.link = new ListNode(aData, null);
	}
	*/
	protected ListNode head; //first element
	protected ListNode current; //current node of interest
	protected ListNode previous; //one node behind current
	protected int size;
	public GenLL()
	{
		head = current = previous = null;
		this.size = 0;
	}
	public void add(T aData)
	{
		ListNode newNode = new ListNode(aData, null);
		if(head == null)
		{
			head = current = newNode;
			this.size = 1;
			return;
		}
		ListNode temp = head;
		while(temp.link != null)
			temp = temp.link;
		temp.link = newNode;
		this.size++;
	}
	public void addAfterCurrent(T aData)
	{
		if(current == null)
			return;
		ListNode newNode = new ListNode(aData, current.link);
		current.link = newNode;
		this.size++;
	}
	public void print()
	{
		for(ListNode temp = head; temp != null; temp= temp.link) 
			System.out.println(temp.data);
		System.out.println();
	}
	public T getCurrent()
	{
		if(current == null)
			return null;
		return current.data;
	}
	public void setCurrent(T aData)
	{
		if(current != null && aData != null)
			return;
		current.data= aData;
	}
	public void gotoNext()
	{
		if(current == null)
			return;
		previous = current;//previous.link
		current = current.link;
	}
	public void reset()
	{
		current = head; //doesn't need to check for null because not running a method with the "."
		previous = null;
	}
	public boolean hasMore()
	{
		return current != null;
	}
	public void removeCurrent()
	{
		if(current == head)
		{
			head = head.link;
			current = head;
		}
		else
		{
			previous.link = current.link;
			current = current.link;
		}
		this.size--;
	}
	public int getSize()
	{
		return this.size;
	}
	public T getAt(int index)
	{
		if(index < 0 || index >= size)
			return null;
		ListNode temp = head;
		for(int i = 0; i < index; i++)
			temp = temp.link;
		return temp.data;
	}
	public void setAt(int index, T aData)
	{
		if(index < 0 || index >= size || aData == null)
			return;
		ListNode temp = head;
		for(int i = 0; i < index ; i++)
			temp = temp.link;
		temp.data = aData;
	}
	public Iterator<T> iterator() 
	{
		return new ListIterator();
	}
}
