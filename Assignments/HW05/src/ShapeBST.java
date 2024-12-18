/*
 * Gavin Hewitt
 */
import java.io.*;
import java.util.Scanner;
public class ShapeBST {
	private static LinkedBST<Shape> shapes = new LinkedBST<Shape>();
	public static void main(String[] args)
	{
		Scanner keyboard = new Scanner(System.in);
		String q = "----------------------------------------------------------------------------------";
		System.out.println(q+"\nWelcome! This program allows you to input"
				+ " rectangle, circle, and right triangle\nobjects that will be added "
				+ "into a binary search tree to be accessed and modified.\n"+q);
		//shapes.printInorder(); test code
		boolean cont = true;
		while(cont)
		{
			System.out.println("Please enter the corresponding number from the following options:"
					+ "\n1. Add a shape"
					+ "\n2. Remove a shape"
					+ "\n3. Search for a shape"
					+ "\n4. Find shape with maximum area"
					+ "\n5. Remove all shapes greater than a certain area"
					+ "\n6. Read from a shape file"
					+ "\n7. Write to a shape file"
					+ "\n8. Print tree"
					+ "\n9. Quit");
			int input = keyboard.nextInt();
			keyboard.nextLine();
			System.out.println(q);
			switch(input)
			{
			case 1:
				System.out.println("Please enter the type of shape you would like to add. The first letter must "
						+ "be\ncapitalized and it must be one of the three shapes listed.");
				String type = "Circle";
				switch(type)
				{
					case "Circle": System.out.println("Please enter a radius:");
					double radius = keyboard.nextDouble();
					shapes.add(new Circle(radius));
					break;
					case "Rectangle": System.out.println("Please enter a length:");
					double length = keyboard.nextDouble();
					System.out.println("Please enter a width:");
					double width = keyboard.nextDouble();
					shapes.add(new Rectangle(length, width));
					break;
					case "Right Triangle": System.out.println("Please enter a value for the base:");
					double base = keyboard.nextDouble();
					System.out.println("Please enter a height");
					double height = keyboard.nextDouble();
					shapes.add(new RightTriangle(base, height));
					break;
				default: System.out.println("Error. Invalid input. You will now be prompted to choose another option.");
					break;
				}
				break;
			case 2: cont = true;
			System.out.println("Please enter the type of shape you would like to remove. The first letter must "
					+ "be\ncapitalized and it must be one of the three shapes listed.");
			String type2 = keyboard.nextLine();
			switch(type2)
			{
			case "Circle": System.out.println("Please enter a radius:");
			double radius = keyboard.nextDouble();
			shapes.remove(new Circle(radius));
			break;
			case "Rectangle": System.out.println("Please enter a length:");
			double length = keyboard.nextDouble();
			System.out.println("Please enter a width:");
			double width = keyboard.nextDouble();
			shapes.remove(new Rectangle(length, width));
			break;
			case "Right Triangle": System.out.println("Please enter a value for the base:");
			double base = keyboard.nextDouble();
			System.out.println("Please enter a height");
			double height = keyboard.nextDouble();
			shapes.remove(new RightTriangle(base, height));
			break;
			default: System.out.println("Error. Invalid input. You will now be prompted to choose another option.");
			break;
			}
			break;
			case 3: cont = true;
			System.out.println("Please enter the type of shape you would like to search for. The first letter must "
					+ "be\ncapitalized and it must be one of the three shapes listed.");
			String type3 = keyboard.nextLine();
			switch(type3)
			{
			case "Circle": System.out.println("Please enter a radius:");
			double radius = keyboard.nextDouble();
			if(shapes.search(new Circle(radius)))
				System.out.println("The tree contains that circle.");
			else
				System.out.println("The tree does not contain that circle.");
			break;
			case "Rectangle": System.out.println("Please enter a length:");
			double length = keyboard.nextDouble();
			System.out.println("Please enter a width:");
			double width = keyboard.nextDouble();
			if(shapes.search(new Rectangle(length, width)))
				System.out.println("The tree contains that rectangle.");
			else
				System.out.println("The tree does not contain that rectangle.");
			break;
			case "Right Triangle": System.out.println("Please enter a value for the base:");
			double base = keyboard.nextDouble();
			System.out.println("Please enter a height");
			double height = keyboard.nextDouble();
			if(shapes.search(new RightTriangle(base, height)))
				System.out.println("The tree contains that right triangle.");
			else
				System.out.println("The tree does not contain that right triangle.");
			break;
			default: System.out.println("Error. Invalid input. You will now be prompted to choose another option.");
			break;
			}
			break;
			case 4: cont = true;
			System.out.println("The shape with the largest area is " + shapes.findMaxInTree().toString());
			break;
			case 5: cont = true;
			System.out.println("Please enter the value of the area that you would like to be the maximum:");
			double maxArea = keyboard.nextDouble();
			shapes.removeGreaterThan(new Shape(maxArea));
			break;
			case 6: cont = true;
			System.out.println("Please enter the name of the file you would to read from. Include file extension.");
			String fileName = keyboard.nextLine();
			readFile(fileName);
			break;
			case 7: cont = true;
			System.out.println("Please enter the name of the file you would like to write to:");
			String fileName2 = keyboard.nextLine();
			shapes.writeFile("./"+fileName2);
			break;
			case 8: cont = true;
			System.out.println("Please enter the print method you would like to use."
					+ "\nYou must follow this example format: 'Pre-Order'.");
			String method = keyboard.nextLine();
			switch(method)
			{
			case "Pre-Order": shapes.printPreorder();
			break;
			case "In-Order": shapes.printInorder();
			break;
			case "Post-Order": shapes.printPostorder();
			break;
			default: System.out.println("Error. Invalid input. You will now be prompted to choose another option.");
			break;
			}
			break;
			case 9: cont = false;
			System.out.println("Have a nice day!");
			break;
			default: cont = false;
			System.out.println("Error. Invalid input. Program will now terminate.");
			}
			System.out.println(q);
		}
	}
	public static void readFile(String fN)
	{
		try
		{
			Scanner fileReader = new Scanner(new File(fN));
			while(fileReader.hasNextLine()) 
			{
				String line = fileReader.nextLine();
				String[] splitLine = line.split("\t");
				if(splitLine.length < 2 || splitLine.length > 3)
					continue;
				if(splitLine[0].toUpperCase().contains("CIRCLE"))
				{
					double radius = Double.parseDouble(splitLine[1]);
					shapes.add(new Circle(radius));
				} else if(splitLine[0].toUpperCase().contains("RECTANGLE"))
				{
					double length = Double.parseDouble(splitLine[1]);
					double width = Double.parseDouble(splitLine[2]);
					shapes.add(new Rectangle(length, width));
				} else if(splitLine[0].toUpperCase().contains("RIGHT TRIANGLE"))
				{
					double base = Double.parseDouble(splitLine[1]);
					double height = Double.parseDouble(splitLine[2]);
					shapes.add(new RightTriangle(base, height));
				}
			}
			fileReader.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
}
