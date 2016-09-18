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
		database.printList(MyDatabase.FACULTY_TABLE);
		System.out.println("");
		database.printList(MyDatabase.ADMIN_TABLE);
		
		System.out.println("");
		
		System.out.println("head is " + database.adminHeadPtr.name);
		System.out.println("tail is " + database.adminTailPtr.name);
		
		database.remove(MyDatabase.ADMIN_TABLE, "482163");
		
		System.out.println("new head is " + database.adminHeadPtr.name);
		System.out.println("new tail is " + database.adminTailPtr.name);
		
		System.out.println("");
	
		database.printList(MyDatabase.ADMIN_TABLE);
	}
}
