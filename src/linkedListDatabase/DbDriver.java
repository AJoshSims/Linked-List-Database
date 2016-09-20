package linkedListDatabase;

import java.util.Scanner;

/**
 * TODO c
 * 
 * @author Joshua Sims
 * @version September 19, 2016
 */
public class DbDriver 
{	
	/**
	 * The code for the select method.
	 */
	private static final String SELECT = "1";
	
	/**
	 * The code for the intersect method.
	 */
	private static final String INTERSECT = "2";
	
	/**
	 * The code for the difference method.
	 */
	private static final String DIFFERENCE = "3";
	
	/**
	 * The code for the union method.
	 */
	private static final String UNION = "4";
	
	/**
	 * The code for the remove method.
	 */
	private static final String REMOVE = "5";
	
	/**
	 * The code for the getVeteran method.
	 */
	private static final String GET_VETERAN = "6";
	
	/**
	 * The code for getRookie method.
	 */
	private static final String GET_ROOKIE = "7";
	
	/**
	 * the code for the printList method.
	 */
	private static final String PRINT = "8";
	
	/**
	 * Prompts the user to specify which database operation they would like
	 * performed and performs that operation accordingly.
	 * 
	 * @param args - does not take command line arguments
	 */
	public static void main(String[] args)
	{
		MyDatabase database = new MyDatabase();
		
		// Tools for gathering and recording user input.
		Scanner userInputScanner = new Scanner(System.in);
		String userInputString = null;
		
		System.out.println("Enter operation");
		
		// Parses the user's input for the sake of performing the specified
		Scanner userInputStringScanner = null; 
		while(!(userInputString = userInputScanner.nextLine().trim())
			.equals("0"))
		{
			//
			userInputStringScanner = new Scanner(userInputString);
			switch (userInputStringScanner.next())
			{
			    case SELECT:
			    	printResult(database, database
			    		.select(userInputStringScanner.nextInt(), 
			    		userInputStringScanner.next(), 
			    		userInputStringScanner.next()));
			    	break;
			    case INTERSECT:
			    	printResult(database, database
			    		.intersect(userInputStringScanner.next(), 
			    		userInputStringScanner.next()));
			    	break;
			    case DIFFERENCE:
			    	printResult(database, database
			    		.difference(userInputStringScanner.nextInt(), 
			    		userInputStringScanner.nextInt()));
			    	break;
			    case UNION:
			    	printResult(database, database.union());
			    	break;
			    case REMOVE:
			    	int table = userInputStringScanner.nextInt();
			    	database.remove(table, userInputStringScanner.next());
			    	database.printList(table);
			    	break;
			    case GET_VETERAN:
			    	printResult(database, database
			    		.getVeteran(userInputStringScanner.nextInt()));
			    	break;
			    case GET_ROOKIE:
			    	printResult(database, database
			    		.getRookie(userInputStringScanner.nextInt()));
			    	break;
			    case PRINT:
			    	database.printList(userInputStringScanner.nextInt());
			    	break;
			}
			
			System.out.println("\nEnter operation");
		}
		
		System.out.println("BYE!");
		userInputScanner.close();
	}
	
	/**
	 * 
	 */
	private static void printResult(MyDatabase database, PersonNode[] result)
	{
		//
		System.out.println("NAME        ID        PHONE        DIVISION" +
		"        YEARS        CLASSIFY");
		
		//
		PersonNode currentNode = result[MyDatabase.HEAD];
		while (currentNode != null)
		{
			System.out.println(currentNode.name + "    " + currentNode.id + 
				"    " + currentNode.phone + "    " + currentNode.division + 
				"    " + currentNode.years + "    " + 
				database.getClassificationString(currentNode));
			
			currentNode = currentNode.next;
		}
	}
}
