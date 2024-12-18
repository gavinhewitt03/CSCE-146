/*
 * Gavin Hewitt
 */
public class WordHelper {
	public static String[] sortByVowels(String[] w)
	{
		String[] res = new String[w.length]; //declares and instantiates copy array of w to be returned
		for(int i = 0; i < res.length; i++) //initializes copy array
		{
			res[i] = w[i];
		}
		boolean hasSwapped = true;
		while(hasSwapped)
		{
			hasSwapped = false;
			for(int i = 1;i < w.length; i++)
			{
				if(countVow(res[i - 1]) > countVow(res[i])) //check if number of vowels of previous string is higher than current
				{
					//Swaps
					String temp = res[i];
					res[i] = res[i - 1];
					res[i - 1] = temp;
					hasSwapped = true;
				}
			}
		}
		return res;
	}
	public static String[] sortByConsonants(String[] w)
	{
		String[] res = new String[w.length]; //declares and instantiates copy array of w to be returned
		for(int i = 0; i < res.length; i++) //initializes copy array
		{
			res[i] = w[i];
		}
		boolean hasSwapped = true;
		while(hasSwapped)
		{
			hasSwapped = false;
			for(int i = 1;i < w.length; i++)
			{
				if(countCon(res[i - 1]) > countCon(res[i])) //check if number of vowels of previous string is higher than current
				{
					//Swaps
					String temp = res[i];
					res[i] = res[i - 1];
					res[i - 1] = temp;
					hasSwapped = true;
				}
			}
		}
		return res;
	}
	public static String[] sortByLength(String[] w)
	{
		String[] res = new String[w.length]; //declares and instantiates copy array of w to be returned
		for(int i = 0; i < res.length; i++) //initializes copy array
		{
			res[i] = w[i];
		}
		boolean hasSwapped = true;
		while(hasSwapped)
		{
			hasSwapped = false;
			for(int i = 1; i < res.length; i++)
			{
				if(res[i].length() < res[i - 1].length())
				{
					String temp = res[i];
					res[i] = res[i - 1];
					res[i-1] = temp;
					hasSwapped = true;
				}
			}
		}
		return res;
	}
	private static int countVow(String s) //method to count number of variables
	{
		int numVow = 0;
		for(int i = 0; i < s.length(); i++) 
		{
			String check = s.substring(i, i+1);
			if(check.equalsIgnoreCase("A")
					|| check.equalsIgnoreCase("E")
					|| check.equalsIgnoreCase("I")
					|| check.equalsIgnoreCase("O")
					|| check.equalsIgnoreCase("U")
					|| check.equalsIgnoreCase("Y"))
			{
				numVow++;
			}
		}
		return numVow;
	}
	private static int countCon(String s) //method to count number of consonants
	{
		int numCon = 0;
		for(int i = 0; i < s.length(); i++) 
		{
			String check = s.substring(i, i+1);
			if(!check.equalsIgnoreCase("A")
					&& !check.equalsIgnoreCase("E")
					&& !check.equalsIgnoreCase("I")
					&& !check.equalsIgnoreCase("O")
					&& !check.equalsIgnoreCase("U")
					&& !check.equalsIgnoreCase("Y"))
			{
				numCon++;
			}
		}
		return numCon;
	}
}
