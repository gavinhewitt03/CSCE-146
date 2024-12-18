/*
 * Gavin Hewitt
 */
import java.util.Scanner;
public class SORTSort {

	public static void main(String[] args) 
	{
		Scanner keyboard = new Scanner(System.in);
		String s = "---------------------------------------------------------------------------------------------";
		boolean cont = true;
		while(cont)
		{
			System.out.println("Welcome! Please enter the number of Strings you would like to input.");
			int size = keyboard.nextInt();
			keyboard.nextLine();
			String[] strings = new String[size];
			System.out.println(s);
			System.out.println("Please begin entering strings:");
			for(int i = 0; i < size; i++)
			{
				strings[i] = keyboard.nextLine();
			}
			stringQuickSort(strings);
			System.out.println(s);
			System.out.println("Sorted list of strings:");
			for(int i = 0; i < size; i++)
			{
				System.out.println(strings[i]);
			}
			System.out.println(s);
			System.out.println("Would you like to enter more strings? Enter '1' for yes and '2' for no");
			int result = keyboard.nextInt();
			keyboard.nextLine();
			switch(result)
			{
			case 1: cont = true;
			break;
			case 2: cont = false;
			break;
			default: System.out.println("Error. Invalid input. Program will now terminate.");
			cont = false;
			break;
			}
		}
	}
	public static void stringQuickSort(String[] a)
	{
		stringQuickSort(a,0,a.length-1);
	}
	public static void stringQuickSort(String[] a, int start, int end)
	{
		if(start >= end)
			return;
		int pivotIndex = stringPartition(a, start, end);
		stringQuickSort(a, start, pivotIndex - 1);
		stringQuickSort(a, pivotIndex + 1, end);
		
	}
	public static int stringPartition(String[] a, int start, int end)
	{
		String pivot = a[end]; //pick last value as pivot
		int i = start;
		int count1 = 0;
		for(int k = 0; k < pivot.length() - 5; k++)
		{
			if(pivot.substring(k, k + 4).equalsIgnoreCase("sort"))
				count1++;
		}
		for(int j = start; j < end; j++)
		{
			int count2 = 0;
			for(int k = 0; k < a[j].length() - 4; k++)
			{
				if(a[j].substring(k, k + 4).equalsIgnoreCase("sort"))
					count2++;
			}
			if(count2 < count1)
			{
				//SWAP
				String temp = a[i];
				a[i] = a[j];
				a[j] = temp;
				i++;
			}
		}
		//swap last values
		String temp = a[i];
		a[i] = a[end];
		a[end] = temp;
		return i;
	}
}
