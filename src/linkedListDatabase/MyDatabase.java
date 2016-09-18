package linkedListDatabase;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

/**
 * 
 * @author Joshua Sims
 *
 */
public class MyDatabase 
{
	// TODO complete (can I use this?)
	/**
	 * 
	 */
	private HashMap<String, boolean[]> classificationsMap = 
		new HashMap<String, boolean[]>();
	
	/**
	 * 
	 */
	static final int NUM_OF_TABLES = 2;
		
	/**
	 * 
	 */
	static final int FACULTY_TABLE = 1;
	
	/**
	 * 
	 */
	static final int FACULTY_CLASSIFICATION = 0;
	
	/**
	 * 
	 */
	static final int ADMIN_TABLE = 2;
	
	/**
	 * 
	 */
	static final int ADMIN_CLASSIFICATION = 1;
	
	// TODO make sure these are private
	/**
	 * 
	 */
	static final int HEAD = 0;
	
	/**
	 * 
	 */
	static final int TAIL = 1;
	
	// TODO make sure these are private
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
		
		//
		if (fileInput.hasNext())
		{
			insert(table, fileInput.next(), fileInput.next(), fileInput.next(), 
				fileInput.next(), fileInput.next());
			
			//
			switch (table)
			{
				case FACULTY_TABLE:
					facultyTailPtr = facultyHeadPtr;
					break;
				case ADMIN_TABLE:
					adminTailPtr = adminHeadPtr;
					break;
			}
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
	 * @param name
	 * @param id
	 * @param phone
	 * @param division
	 * @param years
	 */
	private void insert(int table, String name, String id, String phone, 
		String division, String years)
	{
		//
		PersonNode newNode = new PersonNode(name, id, phone, division, years);
		boolean[] classifications = null;
		
		// TODO fortify?
		switch (table)
		{
			case FACULTY_TABLE:
				//
				if ((classifications = classificationsMap.get(id)) == null)
				{
					classifications = new boolean[] {false, false};
				}
				//
				else if (classifications[FACULTY_CLASSIFICATION] == true)
				{
					// TODO error message stating that no duplicates allowed
					return;
				}
				
				//
				classifications[FACULTY_CLASSIFICATION] = true;
				// TODO do I NEED to put back in?
				classificationsMap.put(id, classifications);
				newNode.next = facultyHeadPtr;
				facultyHeadPtr = newNode;
				break;
			case ADMIN_TABLE:
				//
				if ((classifications = classificationsMap.get(id)) == null)
				{
					classifications = new boolean[] {false, false};
				}
				//
				else if (classifications[ADMIN_CLASSIFICATION] == true)
				{
					// TODO error message stating that no duplicates allowed
					return;
				}
				
				//
				classifications[ADMIN_CLASSIFICATION] = true;
				// TODO do I NEED to put back in?
				classificationsMap.put(id, classifications);
				newNode.next = adminHeadPtr;
				adminHeadPtr = newNode;
				break;
		}
	}
	
	/**
	 * 
	 * @param table
	 * @param attribute
	 * @param value
	 * @return
	 */
	PersonNode[] select(int table, String attribute, String value)
	{
		//
		PersonNode[] selectedList = {null, null};
		
		//
		PersonNode head = null;
		switch (table)
		{
			case FACULTY_TABLE:
				head = facultyHeadPtr;
				break;
			case ADMIN_TABLE:
				head = adminHeadPtr;
				break;
		}
		
		//
		PersonNode currentNode = head;
		PersonNode currentSelectedListNode = null;
		// TODO include classification as attribute?
		// TODO optimize? (reflection)
		// TODO modularize
		// TODO fortify
		switch (attribute)
		{
			case "name":
				//
				if (currentNode.name.equals(value))
				{
					currentSelectedListNode = currentNode.clone();
					selectedList[HEAD] = currentSelectedListNode;
					currentSelectedListNode = currentSelectedListNode.next;
				}
				
				//
				while (currentNode.next != null)
				{
					if (currentNode.next.name.equals(value))
					{
						currentSelectedListNode = currentNode.next.clone();
						if (selectedList[HEAD] == null)
						{
							selectedList[HEAD] = currentSelectedListNode;
						}
						if (currentNode.next.next == null)
						{
							selectedList[TAIL] = currentSelectedListNode;
							return selectedList;
						}
						currentSelectedListNode = currentSelectedListNode.next;
					}
					
					//
					currentNode = currentNode.next;
				}
				break;
			case "id":
			case "ID":
				//
				if (currentNode.id.equals(value))
				{
					currentSelectedListNode = currentNode.clone();
					selectedList[HEAD] = currentSelectedListNode;
					currentSelectedListNode = currentSelectedListNode.next;
				}
				
				//
				while (currentNode.next != null)
				{
					if (currentNode.next.id.equals(value))
					{
						currentSelectedListNode = currentNode.next.clone();
						if (selectedList[HEAD] == null)
						{
							selectedList[HEAD] = currentSelectedListNode;
						}
						if (currentNode.next.next == null)
						{
							selectedList[TAIL] = currentSelectedListNode;
							return selectedList;
						}
						currentSelectedListNode = currentSelectedListNode.next;
					}
					
					//
					currentNode = currentNode.next;
				}
				break;
			case "phone":
				//
				if (currentNode.phone.equals(value))
				{
					currentSelectedListNode = currentNode.clone();
					selectedList[HEAD] = currentSelectedListNode;
					currentSelectedListNode = currentSelectedListNode.next;
				}
				
				//
				while (currentNode.next != null)
				{
					if (currentNode.next.phone.equals(value))
					{
						currentSelectedListNode = currentNode.next.clone();
						if (selectedList[HEAD] == null)
						{
							selectedList[HEAD] = currentSelectedListNode;
						}
						if (currentNode.next.next == null)
						{
							selectedList[TAIL] = currentSelectedListNode;
							return selectedList;
						}
						currentSelectedListNode = currentSelectedListNode.next;
					}
					
					//
					currentNode = currentNode.next;
				}
				break;
			case "division":
				//
				if (currentNode.division.equals(value))
				{
					currentSelectedListNode = currentNode.clone();
					selectedList[HEAD] = currentSelectedListNode;
					currentSelectedListNode = currentSelectedListNode.next;
				}
				
				//
				while (currentNode.next != null)
				{
					if (currentNode.next.division.equals(value))
					{
						currentSelectedListNode = currentNode.next.clone();
						if (selectedList[HEAD] == null)
						{
							selectedList[HEAD] = currentSelectedListNode;
						}
						if (currentNode.next.next == null)
						{
							selectedList[TAIL] = currentSelectedListNode;
							return selectedList;
						}
						currentSelectedListNode = currentSelectedListNode.next;
					}
					
					//
					currentNode = currentNode.next;
				}
				break;
			case "years":
				//
				if (currentNode.years.equals(value))
				{
					currentSelectedListNode = currentNode.clone();
					selectedList[HEAD] = currentSelectedListNode;
				}
				
				//
				while (currentNode.next != null)
				{
					if (currentNode.next.years.equals(value))
					{
						currentSelectedListNode.next = currentNode.next.clone();
						currentSelectedListNode = currentSelectedListNode.next;
						if (selectedList[HEAD] == null)
						{
							selectedList[HEAD] = currentSelectedListNode;
						}
						if (currentNode.next.next == null)
						{
							selectedList[TAIL] = currentSelectedListNode;
							return selectedList;
						}
					}
					
					//
					currentNode = currentNode.next;
				}
				break;
		}
		
		return selectedList;
	}
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
	/**
	 * 
	 * @param table
	 * @param id
	 */
	void remove(int table, String id)
	{
		//
		boolean[] classifications;
		
		if ((classifications = classificationsMap.get(id)) == null)
		{
			// TODO message stating does not exist
			return;
		}
		
		// TODO optimize?
		//
		PersonNode head = null;
		switch (table)
		{
			//
			case FACULTY_TABLE:
				//
				classifications[FACULTY_CLASSIFICATION] = false;
				// TODO do I NEED to put back in?
				classificationsMap.put(id, classifications);
				
				if (facultyHeadPtr.id.equals(id))
				{
					facultyHeadPtr = facultyHeadPtr.next;
					return;
				}
				//
				head = facultyHeadPtr;
				break;
			//
			case ADMIN_TABLE:
				//
				classifications[ADMIN_CLASSIFICATION] = false;
				// TODO do I NEED to put back in?
				classificationsMap.put(id, classifications);
				
				if (adminHeadPtr.id.equals(id))
				{
					adminHeadPtr = adminHeadPtr.next;
					return;
				}
		        //
				head = adminHeadPtr;
				break;
		}
		
		//
		PersonNode currentNode = head;
		while (currentNode.next != null)
		{
			if (currentNode.next.id.equals(id))	
			{
				//
				if (currentNode.next.next == null)
				{
					switch (table)
					{
						case FACULTY_TABLE:
							facultyTailPtr = currentNode;
							break;
						case ADMIN_TABLE:
							adminTailPtr = currentNode;
							break;
					}
				}
					
				currentNode.next = currentNode.next.next;
				return;
			}
			
			//
			currentNode = currentNode.next;
		}
	}
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
	void printList(int table)
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
				"    " + currentNode.years + "    " + 
				getClassifications(currentNode));
			
			currentNode = currentNode.next;
		}
	}
	
	// TODO make private
	/**
	 * 
	 * @param currentNode
	 * @return
	 */
	String getClassifications(PersonNode currentNode)
	{
		//
		boolean[] classifications = classificationsMap.get(currentNode.id);
		
		//
		String classificationString = "";
		if (classifications[ADMIN_CLASSIFICATION] == true)
		{
			classificationString += "ADM";
			if (classifications[FACULTY_CLASSIFICATION] == true)
			{
				classificationString += ", FAC";
			}
		}
		
		//
		else if (classifications[FACULTY_CLASSIFICATION] == true)
		{
			classificationString += "FAC";
		}
		
		//
		return classificationString;
	}
}