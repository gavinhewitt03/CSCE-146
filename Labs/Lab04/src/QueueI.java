/*
 * Gavin Hewitt
 */
public interface QueueI<T> {
	public void enqueue(T aData); //add
	public T dequeue(); //remove
	public T peek(); //observe first element
	public void print();
}
