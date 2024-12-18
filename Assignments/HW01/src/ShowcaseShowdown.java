/*
 * Gavin Hewitt
 */
import java.util.Scanner;
import java.io.*;
public class ShowcaseShowdown {
	public static Scanner keyboard = new Scanner(System.in);
	public static void main(String[] args)
	{
		printGreetings();
		String fileName = keyboard.nextLine();
		int size = getNumberOfPrizes("./"+fileName);
		PrizeManager p = new PrizeManager(size);
		p.readPrizeFile("./"+fileName);
		boolean cont = true;
		while(cont)
		{
			double sum = p.selectPrize();
			showdown(sum);
			System.out.println("Would you like to play again? Enter '1' to continue or '2' to quit.");
			int answer = keyboard.nextInt();
			keyboard.nextLine();
			switch(answer)
			{
			case 1: cont = true;
			break;
			case 2: cont = false;
			System.out.println("Have a good day!");
			break;
			default: System.out.println("Incorrect value. Program will now quit.");
			cont = false;
			break;
			}
		}
		
	}
	public static int getNumberOfPrizes(String fileName)
	{
		int count = 0;
		try
		{
			Scanner fileReader = new Scanner(new File(fileName));
			while(fileReader.hasNextLine())
			{
				fileReader.nextLine();
				count++;
			}
			fileReader.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return count;
	}
	public static void showdown(double sum)
	{
		System.out.println("Please guess the total price of all selected prizes added together.");
		System.out.print("$");
		int guess = keyboard.nextInt();
		keyboard.nextLine();
		if(guess >= sum - 1000 && guess <= sum)
			System.out.println("Congratulations! You have won the Prize Showcase Showdown! The total was $"+sum+".");
		else
			System.out.println("Sorry, the total was $"+sum+". Better luck next time!");
	}
	public static void printGreetings()
	{
		System.out.println("Welcome to the Prize Showcase Showdown!"
				+ "\nThis program chooses five random prizes from a list in a file provided by the user and computes the sum of the prizes for the user to guess."
				+ "\nIf your guess is between or equal to $1000 less than the sum and the sum, you win the showcase!"
				+ "\nPlease enter the name of the file containing the list of prizes including the .filetype at the end:");
	}
}
