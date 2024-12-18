/*
 * Gavin Hewitt
 */
import java.util.Scanner;
import java.io.*;
public class VideoGameLL extends GenLL<VideoGame>{
	public VideoGameLL() //creates linked list of object type VideoGame
	{
		super();
	}
	public static final String DELIM = "\t";
	public static final int LINE_FIELD = 2;
	public void readFile(String fN)
	{
		try
		{
			Scanner fR = new Scanner(new File(fN));
			while(fR.hasNextLine())
			{
				String line = fR.nextLine();
				String[] splitLine = line.split(DELIM);
				if(splitLine.length != LINE_FIELD)
					continue;
				String name = splitLine[0];
				String console = splitLine[1];
				this.add(new VideoGame(name, console));
				if(fR.hasNextLine()) //seems counter intuitive to me but I was getting a no next line error without it?
					fR.nextLine();
			}
		} catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	public void search(String n, String c, VideoGameLL h)
	{
		ListNode temp = head;
		while(this.hasMore()) //loop to cycle through LL
		{
			if(temp == null)
				break;
			if(n.equals("*")) //checks to see if wild card value is entered for name
			{
				if(temp.data.getConsole().toUpperCase().contains(c.toUpperCase())) //checks to see if console matches the console input by user
				{
					temp.data.print(); //prints name and console of game if match
					h.add(temp.data); //adds game to a separate linked list to be printed to a new file if user wants
				}
			} else if(c.equals("*")) //checks for wild card value for console
			{
				if(temp.data.getName().toUpperCase().contains(n.toUpperCase())) //checks to see if name matches the name input by user
				{
					temp.data.print(); //prints name and console of game if match
					h.add(temp.data); //adds game to a separate linked list to be printed to a new file if user wants
				}
			} else
			{
				if(temp.data.getName().toUpperCase().contains(n.toUpperCase())
						&& temp.data.getConsole().toUpperCase().contains(c.toUpperCase())) //checks to see if name and console match the name and console input by the user
				{
					temp.data.print(); //prints name and console of game if match
					h.add(temp.data); //adds game to a separate linked list to be printed to a new file if user wants
				}
			}
			temp = temp.link; //advances through linked list
		}
		if(h.getSize() == 0) //prints message if user's search has no matches
			System.out.println("There were no matches related to your search."); 
	}
	public void writetoFile(String fN, boolean a)
	{
		try
		{
			FileWriter fW = new FileWriter(new File(fN), a); //creates a filewriter object with boolean to append or overwrite a file
			this.reset(); //starts at beginning of linked list
			while(this.hasMore()) //cycles through linked list
			{
				VideoGame curr = this.getCurrent();
				fW.write(curr.getName() + DELIM + curr.getConsole() + "\n"); //writes the video game object to the file
				this.gotoNext();
			}
			fW.close();
		} catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	public void clear() //method to clear linked list
	{
		this.reset();
		while(this.hasMore()) 
		{
			this.removeCurrent();
		}
	}
	public void print() //tester method to print values stored
	{
		ListNode temp = this.head;
		while(temp != null)
		{
			temp.data.print();
			temp = temp.link;
		}
	}
}
