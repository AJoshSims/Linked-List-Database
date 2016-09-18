package linkedListDatabase;

/**
 * TODO c
 * 
 * @author Joshua Sims
 *
 */
public class DbDriver 
{	
	/**
	 * 
	 */
	private static final int SELECT = 1;
	
	/**
	 *  
	 */
	private static final int INTERSECT = 2;
	
	/**
	 * 
	 */
	private static final int DIFFERENCE = 3;
	
	/**
	 * 
	 */
	private static final int UNION = 4;
	
	/**
	 * 
	 */
	private static final int REMOVE = 5;
	
	/**
	 * 
	 */
	private static final int GET_VETERAN = 6;
	
	/**
	 * 
	 */
	private static final int GET_ROOKIE = 7;
	
	/**
	 * 
	 */
	private static final int PRINT = 8;
	
	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args)
	{
		MyDatabase database = new MyDatabase();
		
		// TODO testing
		
		// insert
		//////////////////////////////////////////
		System.out.println("TESTING INSERT...");
		
		System.out.println("faculty table...");
		database.printList(MyDatabase.FACULTY_TABLE);
		System.out.println("admin table...");
		database.printList(MyDatabase.ADMIN_TABLE);
		
		System.out.println("");
		//////////////////////////////////////////
		
		// classification
		//////////////////////////////////////////
		System.out.println("TESTING CLASSIFICATION...");
		
		System.out.println(database.adminHeadPtr.name + " belongs to " + 
			database.getClassifications(database.adminHeadPtr) + " table(s).");
		
		System.out.println("");
		//////////////////////////////////////////
		
		// remove
		//////////////////////////////////////////
		System.out.println("TESTING REMOVE...");
		
		System.out.println("admin head is " + database.adminHeadPtr.name);
		System.out.println("admin tail is " + database.adminTailPtr.name);
		
		System.out.println("Removing...");
		database.remove(MyDatabase.ADMIN_TABLE, "482163");
		
		System.out.println("new admin head is " + database.adminHeadPtr.name);
		System.out.println("new admin tail is " + database.adminTailPtr.name);
		
		System.out.println("The admin table now looks like...");
		database.printList(MyDatabase.ADMIN_TABLE);
		
		System.out.println("");
		//////////////////////////////////////////
		
		// classification
		//////////////////////////////////////////
		System.out.println("TESTING CLASSIFICATION...");
		
		System.out.println(database.facultyHeadPtr.name + " belongs to " + 
			database.getClassifications(database.facultyHeadPtr) + " table(s).");
		
		System.out.println("");
		//////////////////////////////////////////
		
		// select
		//////////////////////////////////////////
		System.out.println("TESTING SELECT...");
		PersonNode[] selected = database.select(MyDatabase.FACULTY_TABLE, "years", "23");
		
		System.out.println("head is " + selected[MyDatabase.HEAD].name);
		System.out.println("tail is " + selected[MyDatabase.TAIL].name);
		
		System.out.println("entire selected list is...");
		PersonNode currentNode = selected[MyDatabase.HEAD];
		while (currentNode != null)
		{
			System.out.println(currentNode.name + "    " + currentNode.id + 
				"    " + currentNode.phone + "    " + currentNode.division + 
				"    " + currentNode.years + "    " + 
				database.getClassifications(currentNode));
			
			currentNode = currentNode.next;
		}
		//////////////////////////////////////////
	}
}
