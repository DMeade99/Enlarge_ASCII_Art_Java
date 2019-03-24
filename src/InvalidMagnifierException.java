
public class InvalidMagnifierException extends Exception
{
	
	public InvalidMagnifierException()
	{
		System.out.println("Unable to magnify at that level.  "
				+ "Please select a level of magnification with a whole-number square root. (4, 9, 16, etc...");
	}

}
