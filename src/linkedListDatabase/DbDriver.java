package linkedListDatabase;

import java.util.Scanner;

/**
 * Creates a database containing school faculty and school administrator 
 * records, prompts the user to specify which database operation they would 
 * like performed, performs that operation accordingly, and prints the result.
 * 
 * <p>The database is a nonpersistent database structured by linked list tables.
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
	 * Creates the database, prompts the user to specify which database 
	 * operation they would like performed, performs that operation accordingly,
	 * and prints the result.
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
		// operation according to specified arguments.
		Scanner userInputStringScanner = null; 
		
		// Repeatedly prompts the user and performs specified operations until
		// user enters "0" instead of specifying an operation.
		while(!(userInputString = userInputScanner.nextLine().trim())
			.equals("0"))
		{
			// Parsing user's input and performing the operation accordingly.
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
	 * Prints the result of a database operation.
	 * 
	 * @param database - the database being manipulated
	 * @param result - the result of the database operation; a linked list table
	 */
	private static void printResult(MyDatabase database, PersonNode[] result)
	{
		// The headers for the records' data.
		System.out.println("NAME        ID        PHONE        DIVISION" +
		"        YEARS        CLASSIFY");
		
		// Prints each record's data.
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
