/*
 * Gavin Hewitt
 */
import java.util.Scanner;
import java.io.*;
public class PrizeManager {
	private Prize[] prizes;
	public PrizeManager(int size)
	{
		prizes = new Prize[size];
	}
	public static final int BODY_FIELD = 2;
	public static final String DELIM = "\t";
	public void readPrizeFile(String fileName)
	{
		try
		{
			
			Scanner fileReader = new Scanner(new File(fileName));
			while(fileReader.hasNextLine())
			{
				String line = fileReader.nextLine();
				String[] splitLine = line.split(DELIM); //splits line at delimiter
				if(splitLine.length != BODY_FIELD) //checks that line is properly formatted
					continue;
				String name = splitLine[0];
				double price = Double.parseDouble(splitLine[1]);
				this.addPrize(new Prize(name, price, false)); //adds prize to prize array with name and price from file
				fileReader.nextLine();
			}
			fileReader.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}
	public void addPrize(Prize aP)
	{
		if(aP == null)
			return;
		if(prizes[prizes.length - 1] != null) //prize array is full
			return;
		for(int i = 0; i < prizes.length; i++)
		{
			if(prizes[i] == null)
			{
				prizes[i] = aP;
				break;
			}
		}
	}
	public double selectPrize()
	{
		double sum = 0;
		System.out.println("The selected prizes are:");
		for(int i = 1; i<6;i++) //loop to pick 5 prizes
		{
			int index = (int)(Math.random() * prizes.length); //picks a random index between 0 and the length - 1 of the array
			if(prizes[index] == null)
			{
				i--;
				continue;
			}
			if(!prizes[index].hasOccurred()) //checks that prize hasn't been picked yet
			{
				System.out.println("Prize "+i+":"+prizes[index].getName());
				prizes[index].setHasOccurred(true);
				sum += prizes[index].getPrice(); //adds price of prize to protected variable sum
			} else
			{
				i--; //reduces loop if prize has occurred so five will still be picked
			}
		}
		return sum;
	}
	public void print()
	{
		for(Prize p : prizes)
		{
			if(p != null)
				System.out.println(p.print());
		}
	}
}
