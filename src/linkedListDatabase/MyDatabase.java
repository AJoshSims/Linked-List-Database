package linkedListDatabase;

/**
 * 
 * @author Joshua Sims
 *
 */
public class MyDatabase 
{
	/**
	 * Points to front of administrative list.
	 */
	PersonNode adminHeadPtr;
	
	/**
	 * Points to end of administrative list.
	 */
	PersonNode adminTailPtr;
	
	/**
	 * Points to front of faculty list.
	 */
	PersonNode facultyHeadPtr;
	
	/**
	 * Points to end of faculty list.
	 */
	PersonNode facultyTailPtr;
	
	/**
	 * 
	 */
	public MyDatabase()
	{
		adminHeadPtr = null;
		adminTailPtr = null;
		facultyHeadPtr = null;
		facultyTailPtr = null;
	}
	
	/**
	 * 
	 * @param table
	 * @param id
	 * @param name
	 * @param phone
	 * @param division
	 * @param years
	 */
	public void insert(int table, String id, String name, String phone, String division, 
		String years)
	{
		
	}
	
	/**
	 * 
	 * @param table
	 * @param attribute
	 * @param value
	 * @return
	 */
	public PersonNode[] select(int table, String attribute, String value)
	{
		
	}
	
	/**
	 * 
	 * @param attribute
	 * @param value
	 * @return
	 */
	public PersonNode[] intersect(String attribute, String value)
	{
		
	}
	
	/**
	 * 
	 * @param tableA
	 * @param tableB
	 * @return
	 */
	public PersonNode[] difference(int tableA, int tableB)
	{
		
	}
	
	/**
	 * 
	 * @return
	 */
	public PersonNode[] union()
	{
		
	}
	
	/**
	 * 
	 * @param table
	 * @param id
	 */
	public remove(int table, String id)
	{
		
	}
	
	/**
	 * 
	 * @param table
	 * @return
	 */
	public PersonNode[] getVeteran(int table)
	{
		
	}
	
	/**
	 * 
	 * @param table
	 * @return
	 */
	public PersonNode[] getRookie(int table)
	{
		
	}
	
	/**
	 * 
	 * @param table
	 */
	public void printList(int table)
	{
		
	}
}
