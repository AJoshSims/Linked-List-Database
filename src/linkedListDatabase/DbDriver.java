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
		database.printList(MyDatabase.ADMIN_TABLE);
	}
}