/*
 * Gavin Hewitt
 */
import java.util.Scanner;
import java.io.*;
public class FileIOSolutions {
	public static void pastTense(String iName, String oName)
	{
		try
		{
			Scanner fileReader = new Scanner(new File(iName));
			PrintWriter fileWriter = new PrintWriter(new FileOutputStream(oName));
			while(fileReader.hasNextLine())
			{
				String line = fileReader.nextLine(); //reads line
				line = line.replace(" is", " was"); //replaces any instance of is in the middle of a sentence with was
				line = line.replace("Is", "Was"); //replaces any instance of is at the beginning of a sentence with was
				fileWriter.println(line); //prints to new file
				String[] consoleOutput = line.split(" "); //splits the line by word
				for(int i = 0; i < consoleOutput.length; i++) //prints each word of line to console
					System.out.println(consoleOutput[i]);
			
			}
			fileReader.close();
			fileWriter.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	public static final String DELIM = "\t";
	public static final int BODY_FIELD = 3;
	public static double totalTubeVolume(String fName)
	{
		double result = 0.0; //value to be returned
		try
		{
			Scanner fileReader = new Scanner(new File(fName));
			while(fileReader.hasNextLine()) 
			{
				String line = fileReader.nextLine(); //reads line
				String[] splitLine = line.split(DELIM); //splits line by delimiter
				if(splitLine.length != BODY_FIELD) //checks to make sure line is properly formatted and if not moves on to next line
					continue;
				double radius = Double.parseDouble(splitLine[1]); //gets radius from file
				double height = Double.parseDouble(splitLine[2]); //gets height from file
				result += Math.pow(radius, 2) * Math.PI * height; //adds volume of tube to the total to be returned
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return result;
	}
}
