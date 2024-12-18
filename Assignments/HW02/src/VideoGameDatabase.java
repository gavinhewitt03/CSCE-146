/*
 * Gavin Hewitt
 */
import java.util.Scanner;
public class VideoGameDatabase {
	public static void main(String[] args)
	{
		System.out.println("Welcome to the Video Game Database! This database will allow you to search for video games from a list" +
							"\nof games based on name and console gathered from an input file. A wildcard character ('*') can be " + 
							"\ninput to search for all results that match either title or console." +
							"\n\nTo search for all games that match the console 'Super Nintendo,' input the wildcard for the title "+
							"\nsearch and 'Super Nintendo' for the console search." +
							"\n\nThe results of the search may then be written into a file of your choosing." +
							"\nIf the file already exists and contains information, you may choose to append or overwrite any current text.");
		
		Scanner keyboard = new Scanner(System.in);
		String q = "--------------------------------------------------------------------------------------------------------------";
		System.out.println(q);
		System.out.println("What is the name of the file you would like to be input? Please include the file extension. \n(Example: 'Collection.txt')");
		String fileName = keyboard.nextLine();
		VideoGameLL games = new VideoGameLL();
		games.readFile("./"+fileName);
		System.out.println(q);
		VideoGameLL searchResults = new VideoGameLL();
		boolean cont = true;
		while(cont)
		{
			System.out.println("Which action would you like to perform?" +
								"\n Press '1' to search" +
								"\n Press '2' to read from a new file" +
								"\n Press '3' to quit.");
			int input = keyboard.nextInt();
			keyboard.nextLine();
			switch(input)
			{
			case 1: System.out.println("What would you like to search game titles for?");
				String title = keyboard.nextLine();
				System.out.println("What video game console would you like to search for?");
				String console = keyboard.nextLine();
				games.search(title, console, searchResults);
				System.out.println("Would you like to print the results of the search to a file?" + 
									"\nEnter '1' for yes and '2' for no.");
				int print = keyboard.nextInt();
				keyboard.nextLine();
				switch(print)
				{
				case 1: System.out.println("What is the name of the file you would like to print to? Please include the file extension like earlier.");
					String printFile = keyboard.nextLine();
					System.out.println("Would you like to append to the file or overwrite it?" + 
										"\nPlease input '1' to append and '2' to overwrite.");
					int append = keyboard.nextInt();
					keyboard.nextLine();
					switch(append)
					{
					case 1: searchResults.writetoFile(printFile, true);
						break;
					case 2: searchResults.writetoFile(printFile, false);
						break;
					default: System.out.println("Incorrect value. Program will now terminate.");
						cont = false;
						break;
					}
					break;
				case 2: System.out.println("Search results will now be cleared for future search. \nTo print previous search results to a file, please repeat search when prompted.");
					break;
				default: System.out.println("Incorrect value. Program will now terminate.");
					break;
				}
				searchResults.clear();
				break;
			case 2: System.out.println("Database will now be cleared for data from new file. \nTo replenish the data, please enter the same file name from earlier when prompted.");
				games.clear();
				System.out.println("What is the name of the new input file? Please include the file extension like earlier.");
				String newFileName = keyboard.nextLine();
				games.readFile(newFileName);
				break;
			case 3: System.out.println("Have a nice day!");
				cont = false;
				break;
			}
			System.out.println(q);
		}
	}
}
