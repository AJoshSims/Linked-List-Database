package linkedListDatabase;

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

/**
 * TODO c
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
		adminHeadPtr = new PersonNode();
		adminTailPtr = null;
		facultyHeadPtr = new PersonNode();
		facultyTailPtr = null;
	}
	
	/**
	 * 
	 */
	void populateList(String pathname, PersonNode head)
	{
		Scanner fileInput = null;
		
		// TODO c
		try 
		{
			fileInput = new Scanner(new File(pathname));
		}
		
		// TODO c
		catch (NullPointerException e)
		{
			// TODO
		}
		
		// TODO c
		catch (FileNotFoundException e)
		{
			// TODO
		}
		
		// TODO optimize
		head = new PersonNode();
		PersonNode currentNode = head;
		while (fileInput.hasNext())
		{
			// TODO c
			currentNode.name = fileInput.next();
			currentNode.ID = fileInput.next();
			currentNode.phone = fileInput.next();
			currentNode.division = fileInput.next();
			currentNode.years = fileInput.next();
			
			// TODO c
			currentNode.next = new PersonNode();
			currentNode = currentNode.next;
		}
		
		if (currentNode.name == null)
		{
			currentNode = null;
		}
		
		fileInput.close();
		
		// TODO remove
		System.out.println(adminHeadPtr.name);
	}
	
/*	*//**
	 * 
	 * @param table
	 * @param id
	 * @param name
	 * @param phone
	 * @param division
	 * @param years
	 *//*
	public void insert(int table, String id, String name, String phone, 
		String division, String years)
	{
		
	}
	
	*//**
	 * 
	 * @param table
	 * @param attribute
	 * @param value
	 * @return
	 *//*
	public PersonNode[] select(int table, String attribute, String value)
	{
		
	}
	
	*//**
	 * 
	 * @param attribute
	 * @param value
	 * @return
	 *//*
	public PersonNode[] intersect(String attribute, String value)
	{
		
	}
	
	*//**
	 * 
	 * @param tableA
	 * @param tableB
	 * @return
	 *//*
	public PersonNode[] difference(int tableA, int tableB)
	{
		
	}
	
	*//**
	 * 
	 * @return
	 *//*
	public PersonNode[] union()
	{
		
	}
	
	*//**
	 * 
	 * @param table
	 * @param id
	 *//*
	public remove(int table, String id)
	{
		
	}
	
	*//**
	 * 
	 * @param table
	 * @return
	 *//*
	public PersonNode[] getVeteran(int table)
	{
		
	}
	
	*//**
	 * 
	 * @param table
	 * @return
	 *//*
	public PersonNode[] getRookie(int table)
	{
		
	}*/
	
	/**
	 * 
	 * @param table
	 */
	public void printList(int table)
	{	
		// TODO c
		PersonNode headPtr = null;
		switch (table)
		{
			case 1:
				headPtr = facultyHeadPtr;
			case 2:
				headPtr = adminHeadPtr;
			default:
				// TODO message about invalidity or something
		}
		
		if (headPtr != null)
		{
			System.out.println(headPtr.name + " " + headPtr.ID + " " + 
				headPtr.phone + " " + headPtr.division + " " + headPtr.years);
		}
		
		
		
		PersonNode currentNode = headPtr.next;
		
		
		
		while (currentNode != null)
		{
			System.out.println(headPtr.name + " " + headPtr.ID + " " + 
				headPtr.phone + " " + headPtr.division + " " + headPtr.years);
			
			currentNode = currentNode.next;
		}
	}
}
