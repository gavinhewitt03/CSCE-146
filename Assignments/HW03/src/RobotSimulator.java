/*
 * Gavin Hewitt
 */
import java.util.Scanner;
import java.io.*;
public class RobotSimulator {
	public static final int BOARD_SIZE = 10;
	private static char[][] board = new char[BOARD_SIZE][BOARD_SIZE];
	private static LLQueue<String> cmmds = new LLQueue<String>();
	private static int currX = 0;
	private static int currY = 0;
	private static final String q = "------------------------------------------------------------------------------------------------------------------";
	public static void readFile(String fileName)
	{
		try
		{
			Scanner fileReader = new Scanner(new File(fileName));
			int i = 0;
			while(fileReader.hasNextLine())
			{
				String line = fileReader.nextLine(); //sets entire line to a String
				board[i] = line.toCharArray(); //converts that string to a char[] and sets the char[] at index i to the converted char[]
				i++;
			}
			currX = 0;
			currY = 0;
			board[0][0] = 'O'; //places robot on board
			fileReader.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}
	public static void readCommands(String fileName)
	{
		try
		{
			Scanner fileReader = new Scanner(new File(fileName));
			while(fileReader.hasNextLine())
			{
				String line = fileReader.nextLine();
				if(line.equals("Move Up") ||  //compound if statement to check that the line in the command file is a proper command
				 line.equals("Move Down") ||
				 line.equals("Move Left") ||
				 line.equals("Move Right"))
				{
					cmmds.enqueue(line); //adds command to linked list queue
				}
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	public static void move(String s) //method to move the robot
	{
		if(s.equals("Move Up"))
		{
			if(!(currY - 1 < 0) && board[currY - 1][currX] != 'X')
			{
				board[currY][currX] = '_';
				currY--;
				board[currY][currX] = 'O';
			}
		}
		else if(s.equals("Move Down"))
		{
			if(!(currY + 1 >= board.length) && board[currY + 1][currX] != 'X')
			{
				board[currY][currX] = '_';
				currY++;
				board[currY][currX] = 'O';
			}
		}
		else if(s.equals("Move Left"))
		{
			if(!(currX - 1 < 0) && board[currY][currX - 1] != 'X')
			{
				board[currY][currX] = '_';
				currX--;
				board[currY][currX] = 'O';
			}
		}
		else if(s.equals("Move Right"))
		{
			if(!(currX +  1 >= board[currY].length) && board[currY][currX + 1] != 'X')
			{
				//System.out.println(currX + " " + currY);
				board[currY][currX] = '_';
				currX++;
				//System.out.println(currX + " " + currY);
				board[currY][currX] = 'O';
			}
		}
	}
	public static void printBoard() //method to print board for both testing and actual program application
	{
		for(int i = 0; i < board.length; i++)
		{
			for(int j = 0; j < board[i].length; j++)
			{
				System.out.print(board[i][j]);
			}
			System.out.println();
		}
		System.out.println(q);
	}
	public static void main(String[] args)
	{
		/* Testing
		readFile("./board.txt");
		for(int i = 0; i < board.length; i++)
		{
			for(int j = 0; j < board.length; j++)
			{
				System.out.print(board[i][j]);
			}
			System.out.println();
		}
		*/
		Scanner keyboard = new Scanner(System.in);
		System.out.println(q + "\nHello! Welcome to the Robot Command Simulator.\n"
		+ "This program allows you to input the name of a file containing a 10x10 board of spaces and obstacles for a robot\nto traverse via another file containing a list of commands"
		+ " where '_' is an empty space, 'X' is an obstacle, and\n'O' is the robot.\n"+q);
		boolean cont = true;
		while(cont)
		{
			System.out.println("Please enter the name of the file containing the board for the robot to traverse. Include file extension.\nExample: board.txt");
			String boardFName = keyboard.nextLine();
			readFile("./"+boardFName);
			System.out.println(q + "\nPlease enter the name of the file containing the list of commands for the robot to follow. Include file extension.");
			String cmmdFName = keyboard.nextLine();
			readCommands(cmmdFName);
			int iX;
			int iY;
			int constraint = cmmds.getSize();
			for(int i = 0; i < constraint; i++)
			{
				iX = currX;
				iY = currY;
				move(cmmds.dequeue());
				if(iX == currX && iY == currY)
				{
					System.out.println("CRASH");
					int clearQueue = cmmds.getSize();
					for(int j = 0; j < clearQueue; j++) //clears remaining moves contained in linked list after crash
					{
						cmmds.dequeue();
					}
					break;
				}
				printBoard();
				//System.out.println(cmmds.getSize());
			}
			System.out.println("Would you like to play again or quit? Input '1' to continue and '2' to quit.");
			int check = keyboard.nextInt();
			keyboard.nextLine();
			switch(check)
			{
			case 1:cont = true;
			break;
			case 2:cont = false;
			break;
			default: System.out.println("Error. Incorrect input. Program will now terminate.");
			cont = false;
			break;
			}
			System.out.println(q);
		}
		System.out.println("Have a nice day!");
	}
}
