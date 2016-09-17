package linkedListDatabase;

public class DatabaseTest 
{
	private static final int PASS = 1;
	
	private static final int FAIL = -1;
	
	public static void main(String[] args)
	{
		
	}
	
	private int testPopulation(PersonNode headPtr)
	{
		if (headPtr == null)
		{
			return FAIL;
		}
		
		PersonNode currentNode = headPtr;
		while (currentNode.next != null)
		{
			
		}
		return PASS;
	}
	
	private void printDetails(PersonNode currentNode)
	{
		System.out.println(currentNode.name + "    ");
	}
}
