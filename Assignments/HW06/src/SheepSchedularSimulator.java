/*
 * Gavin Hewitt
 */
import java.util.Scanner;
import java.io.*;
public class SheepSchedularSimulator {
	private static final String q = "--------------------------";
	public static void main(String[] args)
	{
		Scanner keyboard = new Scanner(System.in);
		System.out.println("Welcome! Please enter the name of the file containing the list of sheep to be sheared.");
		String fileName = keyboard.nextLine();
		System.out.println(q + "Reading the file" + q);
		//System.out.println(lineCount("./"+fileName)); tester
		SheepScheduler schedule = new SheepScheduler();
		Sheep[] sheep = new Sheep[lineCount("./"+fileName)];
		readFile("./" + fileName, sheep);
		quickSort(sheep);
		/*
		for(Sheep s : sheep)
			System.out.println(s);
		*/
		System.out.println(q + "\nStarting Sheep Scheduler Simulation\n" + q);
		int count = 0;
		int currSheep = 0;
		Sheep printedSheep;
		while(true)
		{
			if(currSheep < sheep.length && count == sheep[currSheep].getArrivalTime())
			{
				while(currSheep != sheep.length && sheep[currSheep].getArrivalTime() == count)
				{
					schedule.addSheep(sheep[currSheep]);
					currSheep++;
				}
				
			}
			printedSheep = schedule.getCurrentSheep();
			if(schedule.isDone()) 
			{
				schedule.print();
				break;
			}
			schedule.advanceOneMinute();
			count++;
			if(schedule.getCurrentSheep() != null && schedule.getCurrentSheep().compareTo(printedSheep) != 0)
			{
				System.out.println(printedSheep);
				printedSheep = schedule.getCurrentSheep();
			}
			else if(schedule.isDone())
			{
				System.out.println(printedSheep);
			}
		}
		
	}
	private static void readFile(String fileName, Sheep[] array)
	{
		try
		{
			Scanner fileReader = new Scanner(new File(fileName));
			int count = 0;
			while(fileReader.hasNextLine()) 
			{
				String line = fileReader.nextLine();
				String[] splitLine = line.split("\t");
				if(splitLine.length != 3)
					continue;
				String name = splitLine[0];
				int shearingTime = Integer.parseInt(splitLine[1]);
				int arrivalTime = Integer.parseInt(splitLine[2]);
				array[count] = new Sheep(name, shearingTime, arrivalTime);
				count++;
			}
			fileReader.close();
		} catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	private static int lineCount(String fileName)
	{
		int count = 0;
		try
		{
			Scanner fileReader = new Scanner(new File(fileName));
			while(fileReader.hasNextLine())
			{
				String line = fileReader.nextLine();
				String[] splitLine = line.split("\t");
				if(splitLine.length != 3)
					continue;
				count++;
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return count;
	}
	public static void quickSort(Sheep[] a)
	{
		quickSort(a,0,a.length-1);
	}
	public static void quickSort(Sheep[] a, int start, int end)
	{
		if(start >= end)
			return;
		int pivotIndex = partition(a, start, end);
		quickSort(a, start, pivotIndex - 1);
		quickSort(a, pivotIndex + 1, end);
		
	}
	public static int partition(Sheep[] a, int start, int end)
	{
		Sheep pivot = a[end]; //pick last value as pivot
		int i = start;
		for(int j = start; j < end; j++)
		{
			if(a[j].getArrivalTime() < pivot.getArrivalTime())
			{
				//SWAP
				Sheep temp = a[i];
				a[i] = a[j];
				a[j] = temp;
				i++;
			}
		}
		//swap last values
		Sheep temp = a[i];
		a[i] = a[end];
		a[end] = temp;
		return i;
	}
}

