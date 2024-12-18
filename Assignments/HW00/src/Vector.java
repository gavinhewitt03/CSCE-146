/*
 * Gavin Hewitt
 */
import java.util.Scanner;
public class Vector 
{
	public static void main(String[] args)
	{
		Scanner keyboard = new Scanner(System.in);
		System.out.println("Welcome! This program allows you to add, subtract, and find the magnitutde of two vectors of any number of sizes greater than one."
				+ "\nIn order for these operations to be carried out, the two vectors must be defined and of equal sizes.");
		int length = 0;
		boolean right = false;
		while(!right)
		{
			System.out.println("How many dimensions would you like the two vectors to have? (Must be a whole number greater than one.)");
			if(keyboard.hasNextInt()) 
			{
				length = keyboard.nextInt();
				right = true;
				if(length < 1) //checks to make sure user follows instructions
				{
					System.out.println("Vector size cannot be less than 1. Please enter a value greater than or equal to 1.");
					keyboard.nextLine();
					right = false;
				} else
				{
					keyboard.nextLine();
				}
			} else
			{
				System.out.println("Error. You must enter a whole number greater than 0."); 
				keyboard.nextLine();
				right = false;
			}
		}
		double[] vector1 = new double[length];
		double[] vector2 = new double[length];
		for(int i = 0; i < length; i++)
		{
			System.out.println("What would you like the value of the "+(i)+" component of the first vector to be? You must enter a numerical value.");
			if(keyboard.hasNextDouble())
			{
				vector1[i] = keyboard.nextDouble();
				keyboard.nextLine();
			} else
			{
				System.out.println("Error. You must enter a numerical value."); //safeguard if double is not entered
				i--;
				keyboard.nextLine();
			}
		}
		for(int i = 0; i < length; i++)
		{
			System.out.println("What would you like the value of the "+(i)+" component of the second vector to be? You must enter a numerical value.");
			if(keyboard.hasNextDouble())
			{
				vector2[i] = keyboard.nextDouble();
				keyboard.nextLine();
			} else
			{
				System.out.println("Error. You must enter a numerical value."); //safeguard if double is not entered
				i--;
				keyboard.nextLine();
			}
		}
		boolean cont = true;
		while(cont)
		{
			String oper;
			System.out.println("Would you like to add, subtract, or find the magnitude? (Type 'Add', 'Subtract', or 'Magnitude' to choose and 'q' to quit.)");
			oper = keyboard.nextLine();
			if(oper.toUpperCase().contains("ADD"))
				System.out.println("The sum of the two vectors is "+ addVectors(vector1, vector2));
			else if(oper.toUpperCase().contains("SUBTRACT"))
			{
				System.out.println("Which vector would you like to subtract from? (Enter either '1' or '2'.)");
				if(keyboard.hasNextInt())
				{
					int q = keyboard.nextInt();					
					if(q == 1)
					{
						System.out.println("The difference of the two vectors is "+ subVectors(vector1, vector2));
						keyboard.nextLine();
					}
					else if(q == 2)
					{	
						System.out.println("The difference of the two vectors is "+ subVectors(vector2, vector1));
						keyboard.nextLine();
					}
					else
					{
						System.out.println("Error. You must enter one of the provided options in the instructions."); //safeguard if integer not equal to 1 or 2 is entered
						keyboard.nextLine();
					}
				} else
				{
					System.out.println("Error. You must enter one of the provided options in the instructions."); //safeguard if integer is not entered
					keyboard.nextLine();
				}
			}
			else if(oper.toUpperCase().contains("MAGNITUDE"))
			{
				int vect;
				System.out.println("Which vector would you like to find the magnitude of? (Enter either '1' or '2'.)");
				if(keyboard.hasNextInt()) 
				{
					vect = keyboard.nextInt();
					keyboard.nextLine();
					if(vect == 1)
						System.out.println(magnitude(vector1));
					else if(vect == 2)
						System.out.println(magnitude(vector2));
					else 
						System.out.println("Error. You must enter one of the provided options in instructions.");	//safeguard in case user does not follow directions	
				} else
				{
					System.out.println("Error. You must enter one of the provided options in instructions.");
					keyboard.nextLine();
				}
			} else if(oper.toUpperCase().contains("Q"))
				cont = false;
			else
			{
				System.out.println("Error. You must enter one of the provided options in instructions."); //safeguard in case user does not follow directions
			}
		}
		System.out.println("Program will now quit. Please run again if necessary.");
	}
	public static String addVectors(double[] v1, double[] v2)
	{
		if(v1 == null || v2 == null)
			return "Error. One or more of the required vectors has not been properly defined."; //program requires both vectors to be defined, safeguard
		else if(v1.length != v2.length)
			return "Error. One vector has a different size than the other."; //despite the program not allowing the two vectors to be defined with different dimensions, safeguard
		else
		{
			double[] result = new double[v1.length]; //creates an array equal in length/components of the arrays being added to display the sum.
			String display = "["; //creates a String object that will be returned to display the components of the resultant vector that occurs from addition operation.
			for(int i = 0; i < v1.length - 1; i++)
			{
				result[i] = v1[i] + v2[i];
				display += result[i] + ", ";
			}
			result[v1.length - 1] = v1[v1.length - 1] + v2[v1.length - 1];  
			display += result[v1.length - 1] + "]";
			return display;
		}
	}
	public static String subVectors(double[] v1, double[] v2) //straight copy of addVector method, but with a subtraction sign in between the two vectors
	{
		if(v1 == null || v2 == null)
			return "Error. One or more of the required vectors has not been properly defined."; 
		else if(v1.length != v2.length)
			return "Error. One vector has a different size than the other."; 
		else
		{
			double[] result = new double[v1.length]; 
			String display = "["; 
			for(int i = 0; i < v1.length - 1; i++)
			{
				result[i] = v1[i] - v2[i];
				display += result[i] + ", ";
			}
			result[v1.length - 1]= v1[v1.length - 1] - v2[v1.length - 1];
			display += result[v1.length - 1] + "]";
			return display;
		}
	}
	public  static String magnitude(double[] v1)
	{
		if(v1 == null)
			return "Error. Vector has not been properly defined.";
		else
		{
			double result = 0;
			for(double x : v1)
				result += x;
			result = Math.sqrt(result);
			return "The magnitude of the vector is " +result+".";
		}
	}
}
