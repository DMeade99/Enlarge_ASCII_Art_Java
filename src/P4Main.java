import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

public class P4Main {

	public static void main(String[] args)
	{
		try {
		
		Scanner userIn = new Scanner(System.in);
		FileOutputStream outputStream;
		PrintWriter outputToFile;
		String fileInput, fileOutput, modifiedOutput, line;
		StringBuilder newLine = new StringBuilder();
		char[] lineArray;
		int userMagnify = 0;
		int magnification = 0;
		
		// Prompt the user for a file name
		System.out.println("Welcome to the ASCII Art Magnifier!");
		System.out.println("Please enter an ASCII Art file name: ");
		fileInput = userIn.next();
		
		Scanner inputStream = openFile(fileInput);
		
		System.out.println("Now select your level of magnification.  "
				+ "Choose a magnifiction level with a whole number square root:");
		
		userMagnify = userIn.nextInt();
		magnification = checkMagnificationLevel(userMagnify);
		
		System.out.println("Finally, choose the name of your output file: ");
		fileOutput = userIn.next();
		outputStream = new FileOutputStream(fileOutput);
		outputToFile = outputFile(outputStream);
		
		while(inputStream.hasNextLine())
		{
			line = inputStream.nextLine();
			lineArray = line.toCharArray();
			
			for(int a = 0; a < lineArray.length; a++)  // Loop through every character in the array
			{
				for(int b = 0; b < magnification; b++) // Create multiple occurrences of each character and add to StringBuilder
				{
					newLine.append(lineArray[a]);
				}
			}
			modifiedOutput = newLine.toString();       // Save repeated characters as new line
			
			for(int a = 0; a < magnification; a++)     // Print multiple copies of modifiedOuput to complete magnification
			{
				outputToFile.println(modifiedOutput);
			}
			
			// need to reset StringBuilder
			newLine.setLength(0);
			
		}
		
		outputToFile.flush();
				
		}
		catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		}
		catch (InvalidMagnifierException e) {
			System.out.println(e.getMessage());
		}
		catch (FileAlreadyExists e) {
			System.out.println(e.getMessage());
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}
	
	public static Scanner openFile(String filename) throws FileNotFoundException
	{		
		FileInputStream fileIn = new FileInputStream(filename);
		Scanner inputStream = new Scanner(fileIn);
		
		return inputStream;
	}
	
	public static int checkMagnificationLevel(int number) throws InvalidMagnifierException
	{		
		int level = (int) Math.sqrt(number);
		if(Math.pow(level, 2) == number)
		{
			return level;
		}
		else
		{
			throw new InvalidMagnifierException();
		}		
	}
	
	public static PrintWriter outputFile(FileOutputStream fileOut) throws FileAlreadyExists
	{
		PrintWriter output = new PrintWriter(fileOut);
		return output;		
	}

}
