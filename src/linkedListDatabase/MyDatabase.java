package linkedListDatabase;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * 
 * @author Joshua Sims
 *
 */
public class MyDatabase 
{
	/**
	 * 
	 */
	static final int FACULTY_TABLE = 1;
	
//	/**
//	 * 
//	 */
//	static final int FACULTY_CLASSIFICATION = 0;
	
	/**
	 * 
	 */
	static final int ADMIN_TABLE = 2;
	
//	/**
//	 * 
//	 */
//	static final int ADMIN_CLASSIFICATION = 1;

	/**
	 * Points to front of administrative list.
	 */
	private PersonNode adminHeadPtr;
	
	/**
	 * Points to end of administrative list.
	 */
	private PersonNode adminTailPtr;
	
	/**
	 * Points to front of faculty list.
	 */
	private PersonNode facultyHeadPtr;
	
	/**
	 * Points to end of faculty list.
	 */
	private PersonNode facultyTailPtr;
	
	/**
	 * 
	 */
	public MyDatabase()
	{
		buildTable(FACULTY_TABLE);
		buildTable(ADMIN_TABLE);
	}

	/**
	 * 
	 * @param textTable
	 */
	private void buildTable(int table)
	{
		//
		Scanner fileInput = null;
		try
		{
			switch (table)
			{
				case FACULTY_TABLE:
					fileInput = new Scanner(new File("faculty.txt"));
					break;
				case ADMIN_TABLE:
					fileInput = new Scanner(new File("admin.txt"));
					break;
			}
		}
		
		//
		catch (FileNotFoundException e)
		{
			
		}
		
		// TODO optimize?
		//
		while (fileInput.hasNext())
		{
			insert(table, fileInput.next(), fileInput.next(), fileInput.next(), 
				fileInput.next(), fileInput.next());
		}
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
	private void insert(int table, String id, String name, String phone, 
		String division, String years)
	{
		//
		PersonNode newNode = new PersonNode(id, name, phone, division, years);
		
//		//
//		final int offset = 1;
		
		//
		switch (table)
		{
			case FACULTY_TABLE:
//				newNode.classifications[table - offset] = "FAC";
				newNode.next = facultyHeadPtr;
				facultyHeadPtr = newNode;
				break;
			case ADMIN_TABLE:
//				newNode.classifications[table - offset] = "ADM";
				newNode.next = adminHeadPtr;
				adminHeadPtr = newNode;
				break;
		}
	}
	
//	/**
//	 * 
//	 * @param table
//	 * @param attribute
//	 * @param value
//	 * @return
//	 */
//	public PersonNode[] select(int table, String attribute, String value)
//	{
//		
//	}
//	
//	/**
//	 * 
//	 * @param attribute
//	 * @param value
//	 * @return
//	 */
//	public PersonNode[] intersect(String attribute, String value)
//	{
//		
//	}
//	
//	/**
//	 * 
//	 * @param tableA
//	 * @param tableB
//	 * @return
//	 */
//	public PersonNode[] difference(int tableA, int tableB)
//	{
//		
//	}
//	
//	/**
//	 * 
//	 * @return
//	 */
//	public PersonNode[] union()
//	{
//		
//	}
//	
//	/**
//	 * 
//	 * @param table
//	 * @param id
//	 */
//	public remove(int table, String id)
//	{
//		
//	}
//	
//	/**
//	 * 
//	 * @param table
//	 * @return
//	 */
//	public PersonNode[] getVeteran(int table)
//	{
//		
//	}
//	
//	/**
//	 * 
//	 * @param table
//	 * @return
//	 */
//	public PersonNode[] getRookie(int table)
//	{
//		
//	}
	
	/**
	 * 
	 * @param table
	 */
	public void printList(int table)
	{
		//
		PersonNode headPtr = null;
		switch (table)
		{
			case FACULTY_TABLE:
				headPtr = facultyHeadPtr;
				break;
			case ADMIN_TABLE:
				headPtr = adminHeadPtr;
				break;
		}
		
		// TODO align printed info?
		// TODO optimize?
		//
		PersonNode currentNode = headPtr;
		while (currentNode != null)
		{
			System.out.println(currentNode.name + "    " + currentNode.id + 
				"    " + currentNode.phone + "    " + currentNode.division + 
				"    " + currentNode.years + "    ");
			
			currentNode = currentNode.next;
		}
	}
}