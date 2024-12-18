/*
 * Written by Gavin Hewitt
 */
//Packages
import java.util.Scanner;
import java.util.Random;
public class BubbleSorter {
	public static final int ARRAY_SIZE = 10;
	public static void main(String[] args)
	{
		Scanner keyboard = new Scanner(System.in);
		System.out.println("Enter "+ARRAY_SIZE+" numbers and I'll sort them.");
		int[] array = new int[ARRAY_SIZE];
		for(int i = 0; i < array.length; i++)
		{
			System.out.println("Enter value "+i);
			array[i] = keyboard.nextInt();
		}
		//Bubble sort
		boolean hasSwapped = true;
		while(hasSwapped)
		{
			hasSwapped = false; //if there is nothing to swap, hasSwapped stays false and while loop exits because int array is already sorted
			for(int i = 0; i < array.length - 1; i++)
			{
				if(array[i] > array[i + 1])
				{
					//Swap
					int temp = array[i];
					array[i] = array[i + 1];
					array[i + 1] = temp;
					hasSwapped = true;
				}
			}
		}
		//Print the array
		for(int i = 0; i < array.length; i++)
		{
			System.out.println(array[i]);
		}
	}
}
