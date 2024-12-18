/*
 * Gavin Hewitt
 */
public class LLQueue<T> implements QueueI<T> {
	private class ListNode
	{
		T data;
		ListNode link;
		public ListNode(T aData, ListNode aLink)
		{
			data = aData;
			link = aLink;
		}
	}
	private ListNode head; //current
	private ListNode tail; //previous
	private int size;
	public LLQueue()
	{
		head = tail = null;
		this.size = 0;
	}
	public void enqueue(T aData)
	{
		ListNode newNode = new ListNode(aData, null);
		if(head == null)
		{
			head = tail = newNode;
			this.size = 1;
			return;
		}
		tail.link = newNode;
		tail = newNode;
		//tail = tail.link;
		this.size++;
	}
	public T dequeue()
	{
		if(head == null)
			return null;
		T ret = head.data;
		head = head.link;
		this.size--;
		return ret;
	}
	public int getSize()
	{
		return this.size;
	}
	public T peek()
	{
		if(head == null)
		return null;
		return head.data;
	}
	public void print() 
	{
		for(ListNode temp = head; temp != null; temp = temp.link)
			System.out.println(temp.data);
	}
}
