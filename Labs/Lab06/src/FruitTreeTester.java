/*
 * Gavin Hewitt
 */
import java.io.*;
import java.util.Scanner;
public class FruitTreeTester {
	private static LinkedBST<Fruit> fruitTree = new LinkedBST<Fruit>();
	public static void main(String[] args)
	{
		Scanner keyboard = new Scanner(System.in);
		String q = "------------------------------------------------------";
		System.out.println(q + "\nWelcome to the fruit tree!\nPlease enter the name of a fruit tree file with the file extension:");
		String fileName = keyboard.nextLine();
		readFile("./"+fileName);
		System.out.println(q+"\nPrinting in the pre-order traversal:");
		fruitTree.printPreorder();
		System.out.println(q+"\nPrinting in the in-order traversal:");
		fruitTree.printInorder();
		System.out.println(q+"\nPrinting in the post-order traversal:");
		fruitTree.printPostorder();
		System.out.println(q+"\nDeleting "+fruitTree.peek().toString());
		fruitTree.remove(fruitTree.peek());
		System.out.println(q+"\nPrinting in the in-order traversal:");
		fruitTree.printInorder();
	}
	private static void readFile(String fileName)
	{
		try
		{
			Scanner fileReader = new Scanner(new File(fileName));
			while(fileReader.hasNextLine()) 
			{
				String line = fileReader.nextLine();
				String[] splitLine = line.split("\t");
				if(splitLine.length > 2)
					continue;
				String type = splitLine[0];
				double weight = Double.parseDouble(splitLine[1]);
				fruitTree.add(new Fruit(type, weight));
			}
			fileReader.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
