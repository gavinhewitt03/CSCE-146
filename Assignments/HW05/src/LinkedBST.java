/*
 * Gavin Hewitt
 */
import java.io.*;
public class LinkedBST <T extends Comparable<T>>
{
	private class Node
	{
		T data;
		Node leftChild;
		Node rightChild;
		public Node(T aData)
		{
			data = aData;
			leftChild = rightChild = null;
		}
	}
	private Node root; //head
	private static FileWriter fileWriter; //filewriter object that is an instance of the class so you can close outside of write method
	public LinkedBST()
	{
		root = null;
	}
	public void add(T aData)
	{
		if(root == null)
			root = new Node(aData);
		else
			add(root, aData);
	}
	private Node add(Node aNode, T aData)
	{
		if(aNode == null)
			aNode = new Node(aData);
		else if(aData.compareTo(aNode.data) < 0) //data trying to add is less than data at the node, GO LEFT
			aNode.leftChild = add(aNode.leftChild, aData);
		else if(aData.compareTo(aNode.data)> 0) //data being added is greater than data at the node, GO RIGHT
			aNode.rightChild = add(aNode.rightChild, aData);
		return aNode;
	}
	public void printPreorder()
	{
		printPreorder(root);
	}
	private void printPreorder(Node aNode)
	{
		if(aNode == null)
			return;
		System.out.println(aNode.data); //process
		printPreorder(aNode.leftChild); //left
		printPreorder(aNode.rightChild); //right
	}
	public void printInorder()
	{
		printInorder(root);
	}
	private void printInorder(Node aNode)
	{
		if(aNode == null)
			return;
		printInorder(aNode.leftChild); //left
		System.out.println(aNode.data); //process
		printInorder(aNode.rightChild); //right
	}
	public void printPostorder()
	{
		printPostorder(root);
	}
	private void printPostorder(Node aNode)
	{
		if(aNode == null)
			return;
		printPostorder(aNode.leftChild); //left
		printPostorder(aNode.rightChild); //right
		System.out.println(aNode.data); //process
	}
	public boolean search(T aData)
	{
		return search(root, aData);
	}
	private boolean search(Node aNode, T aData)
	{
		if(aNode == null)
			return false;
		else if(aData.compareTo(aNode.data) < 0)//GO LEFT
			return search(aNode.leftChild, aData);
		else if(aData.compareTo(aNode.data) > 0)//Go RIGHT
			return search(aNode.rightChild, aData);
		else
			return true;
	}
	public void remove(T aData)
	{
		root = remove(root, aData);
	}
	private Node remove(Node aNode, T aData)
	{
		//Find the node
		if(aNode == null)
			return null;
		else if(aData.compareTo(aNode.data) < 0)
			aNode.leftChild = remove(aNode.leftChild, aData);
		else if(aData.compareTo(aNode.data) > 0)
			aNode.rightChild = remove(aNode.rightChild, aData);
		else
		{
			if(aNode.rightChild == null)
				return aNode.leftChild;
			else if(aNode.leftChild == null)
				return aNode.rightChild;
			Node temp = findMinInTree(aNode.rightChild);
			aNode.data = temp.data;
			aNode.rightChild = remove(aNode.rightChild, temp.data);
		}
		return aNode;
	}
	public void removeGreaterThan(T aData)
	{
		removeGreaterThan(root, aData);
	}
	private Node removeGreaterThan(Node aNode, T aData)
	{
		if(aNode == null)
			return null;
		else if(aData.compareTo(aNode.data) > 0)
			aNode.rightChild = removeGreaterThan(aNode.rightChild, aData);
		return aNode.leftChild; //everything on right side of node would be larger than target, so only left matters
	}		
	
	private Node findMinInTree(Node aNode)
	{
		if(aNode == null)
			return null;
		else if(aNode.leftChild == null)
			return aNode;
		else
			return findMinInTree(aNode.leftChild);
	}
	public T findMaxInTree()
	{
		return findMaxInTree(root);
	}
	private T findMaxInTree(Node aNode)
	{
		if(aNode == null)
			return null;
		else if(aNode.rightChild == null) //found the max value
			return aNode.data;
		else
			return findMaxInTree(aNode.rightChild);
	}
	public T peek()
	{
		return root.data;
	}
	public void writeFile(String fN)
	{
		try
		{
			fileWriter = new FileWriter(new File(fN));
			writeFile(fN, root);
			fileWriter.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	private void writeFile(String fN, Node aNode) 
	{
		if(aNode == null)
			return;
		try
		{
			writeFile(fN, aNode.leftChild); //left
			fileWriter.write(aNode.data.toString() + "\n"); //process
			writeFile(fN, aNode.rightChild); //right
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
