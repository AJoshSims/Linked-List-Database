package linkedListDatabase;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

/**
 * A nonpersistent database structured by linked list tables containing person
 * nodes.
 * 
 * @author Joshua Sims
 * @version September 19, 2016
 */
public class MyDatabase 
{
	/**
	 * Stores records which describe the classification(s) (the containing 
	 * tables) of each person.
	 */
	private HashMap<String, boolean[]> classificationsMap = 
		new HashMap<String, boolean[]>();
		
	/**
	 * The code for the faculty table.
	 */
	static final int FACULTY_TABLE = 1;
	
	/**
	 * The index of the faculty table classification in a 
	 * {faculty classification, administrator classification} array.
	 */
	static final int FACULTY_CLASSIFICATION = 0;
	
	/**
	 * The code for the administrator table.
	 */
	static final int ADMIN_TABLE = 2;
	
	/**
	 * The index of the administrator table classification in a 
	 * {faculty classification, administrator classification} array.
	 */
	static final int ADMIN_CLASSIFICATION = 1;
	
	/**
	 * The index of the head node in a {head node, tail node} array.
	 */
	static final int HEAD = 0;
	
	/**
	 * The index of the tail node in a {head node, tail node} array.
	 */
	static final int TAIL = 1;
	
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
	 * Creates a nonpersistent database structured by linked list tables 
	 * containing person nodes.
	 */
	public MyDatabase()
	{
		buildTable(FACULTY_TABLE);
		buildTable(ADMIN_TABLE);
	}

	/**
	 * Builds a linked list table containing person nodes.
	 * 
	 * @param table - the linked list table to be built (faculty table or 
	 *     administrator table)
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
	 * Populates the linked list tables with person nodes.
	 * 
	 * @param table - the linked list table to be populated
     * @param name - employee name having the form "Last name, First name" 
     *     (no space after the comma)
     * @param id - unique, six digit employee ID number
     * @param phone - ten digit phone number
     * @param division - academic or administrative division
     * @param years - years of service
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
				classificationsMap.put(id, classifications);
				if (facultyHeadPtr == null)
				{
					facultyHeadPtr = newNode;
				}
				
				else
				{
				    facultyTailPtr.next = newNode;
				    facultyTailPtr = facultyTailPtr.next;
				}
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
				classificationsMap.put(id, classifications);
				if (adminHeadPtr == null)
				{
					adminHeadPtr = newNode;
				}
				else
				{
				    adminTailPtr.next = newNode;
				    adminTailPtr = adminTailPtr.next;
				}
				break;
		}
	}
	
	/**
	 * Returns a {head, tail} array of nodes selected from a 
	 * specified table according to a specified value of a specified 
	 * attribute.
	 * 
	 * @param table - the linked list table to select from
	 * @param attribute - the attribute related to the value
	 * @param value - the value to check for
	 * 
	 * @return selected - a {head, tail} array of nodes selected from a 
	 *     specified table according to a specified value of a specified 
	 *     attribute.
	 */
	PersonNode[] select(int table, String attribute, String value)
	{
		// 
		PersonNode[] selected = {null, null};
		
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
		PersonNode currentSelectedNode = null;
		// TODO include classification as attribute?
		// TODO optimize? (reflection)
		// TODO modularize
		// TODO fortify
		switch (attribute)
		{
			case "name":
				//
				while (currentNode != null)
				{
					if (currentNode.name.equals(value))
					{
						//
						if (selected[HEAD] == null)
						{
							selected[HEAD] = currentNode.clone();
							selected[TAIL] = selected[HEAD];
						}
						//
						else
						{
							selected[TAIL].next = currentNode.clone();
							selected[TAIL] = selected[TAIL].next;					
						}
					}
					
					currentNode = currentNode.next;
				}
				break;
			case "id":
			case "ID":
				//
				while (currentNode != null)
				{
					if (currentNode.id.equals(value))
					{
						//
						if (selected[HEAD] == null)
						{
							selected[HEAD] = currentNode.clone();
							selected[TAIL] = selected[HEAD];
						}
						//
						else
						{
							selected[TAIL].next = currentNode.clone();
							selected[TAIL] = selected[TAIL].next;					
						}
					}
					
					currentNode = currentNode.next;
				}
				break;
			case "phone":
				//
				while (currentNode != null)
				{
					if (currentNode.phone.equals(value))
					{
						//
						if (selected[HEAD] == null)
						{
							selected[HEAD] = currentNode.clone();
							selected[TAIL] = selected[HEAD];
						}
						//
						else
						{
							selected[TAIL].next = currentNode.clone();
							selected[TAIL] = selected[TAIL].next;					
						}
					}
					
					currentNode = currentNode.next;
				}
				break;
			case "division":
				//
				while (currentNode != null)
				{
					if (currentNode.division.equals(value))
					{
						//
						if (selected[HEAD] == null)
						{
							selected[HEAD] = currentNode.clone();
							selected[TAIL] = selected[HEAD];
						}
						//
						else
						{
							selected[TAIL].next = currentNode.clone();
							selected[TAIL] = selected[TAIL].next;					
						}
					}
					
					currentNode = currentNode.next;
				}
				break;
			case "years":
				//
				while (currentNode != null)
				{
					if (currentNode.years.equals(value))
					{
						//
						if (selected[HEAD] == null)
						{
							selected[HEAD] = currentNode.clone();
							selected[TAIL] = selected[HEAD];
						}
						//
						else
						{
							selected[TAIL].next = currentNode.clone();
							selected[TAIL] = selected[TAIL].next;					
						}
					}
					
					currentNode = currentNode.next;
				}
				break;
		}
		
		return selected;
	}

	/**
	 * Examines all of the linked list tables and returns a {head, tail} array 
	 * of the nodes which have equivalent values of the specified attribute.
	 * 
	 * @param attribute - the attribute related to the value
	 * @param value - the value to check for
	 * 
	 * @return a {head, tail} array of nodes which have equivalent values of a 
	 * specified attribute.
	 */
	public PersonNode[] intersect(String attribute, String value)
	{
		//
		PersonNode[] intersection = {null, null};
		
		//
		PersonNode[] selectedFaculty = 
			select(FACULTY_TABLE, attribute, value);
		
		//
		PersonNode[] selectedAdmin = select(ADMIN_TABLE, attribute, value);
		
		//
		PersonNode currentSelectedFaculty = selectedFaculty[HEAD];
		PersonNode currentSelectedAdmin = selectedAdmin[HEAD];
		
		if (selectedFaculty[HEAD].id.equals(selectedAdmin[HEAD].id))
		{
			intersection[HEAD] = selectedFaculty[HEAD].clone();
			intersection[TAIL] = intersection[HEAD];
			
			selectedAdmin[HEAD] = selectedAdmin[HEAD].next;
		}
		
		while (currentSelectedFaculty.next != null)
		{
			while (currentSelectedAdmin.next != null)
			{
				if (currentSelectedFaculty.id.equals(currentSelectedAdmin.id))
				{
					if (intersection[HEAD] == null)
					{
						intersection[HEAD] = 
							currentSelectedFaculty.next.clone();
						intersection[TAIL] = intersection[HEAD];
					}
					else
					{
						intersection[TAIL].next = 
							currentSelectedFaculty.next.clone();
						intersection[TAIL] = intersection[TAIL].next;
					}
					
					//
					currentSelectedAdmin.next = currentSelectedAdmin.next.next;
					break;
				}
				
				//
				currentSelectedAdmin = currentSelectedAdmin.next;
			}
			
			//
			currentSelectedFaculty = currentSelectedFaculty.next;
			currentSelectedAdmin = selectedAdmin[HEAD];
		}
		
		return intersection;
	}
	
	/**
	 * Returns a {head, tail} array of nodes which exist in the linked list 
	 * table specified by tableA but do not exist in the linked list table 
	 * specified by tableB.
	 * 
	 * @param tableA - the code specifying the linked list table in which the 
	 *     nodes exist
	 * @param tableB - the code specifying the linked list table in which the 
	 *     nodes do not exist
	 * @return a {head, tail} array of nodes which exist in the linked list 
	 *     table specified by tableA but do not exist in the linked list table 
	 *     specified by tableB.
	 */
	public PersonNode[] difference(int tableA, int tableB)
	{
		//
		PersonNode[] difference = {null, null};
		
		//
		PersonNode tableANodeHead = null;
		PersonNode tableBNodeHead = null;
		switch (tableA)
		{
			case FACULTY_TABLE:
				tableANodeHead = facultyHeadPtr;
				tableBNodeHead = adminHeadPtr;
				break;
			case ADMIN_TABLE:
				tableANodeHead = adminHeadPtr;
				tableBNodeHead = facultyHeadPtr;
				break;
		}
		
		//TODO optimize
		//
		PersonNode currentTableANode = tableANodeHead;
		PersonNode currentTableBNode = tableBNodeHead;
		while (currentTableANode != null)
		{
			while (currentTableBNode != null)
			{
				//
				if (currentTableANode.id.equals(currentTableBNode.id))
				{
					//
					break;
				}
				//
				else if (currentTableBNode.next == null)
				{
					if (difference[HEAD] == null)
					{
						difference[HEAD] = currentTableANode.clone();
						difference[TAIL] = difference[HEAD];
					}
					else
					{
						difference[TAIL].next = currentTableANode.clone();
						difference[TAIL] = difference[TAIL].next;
					}
					
					//
					break;
				}
				//
				else
				{
					//
					currentTableBNode = currentTableBNode.next;
				}
			}
			
			//
			currentTableANode = currentTableANode.next;
			currentTableBNode = tableBNodeHead;
		}
		
		return difference;
	}
	
	/**
	 * Returns a {head, tail} array of all of the unique nodes (as defined by 
	 * their id field) contained in the database tables.
	 * 
	 * @return a {head, tail} array of all of the unique nodes (as defined by 
	 * their id field) contained in the database tables.
	 */
	public PersonNode[] union()
	{
		PersonNode[] union = {null, null};
		
		PersonNode[] newFaculty = {null, null};
		
		newFaculty[HEAD] = facultyHeadPtr.clone();
		newFaculty[TAIL] = newFaculty[HEAD];
		
		PersonNode currentNode = facultyHeadPtr.next;
		while (currentNode != null)
		{
			newFaculty[TAIL].next = currentNode.clone();
			newFaculty[TAIL] = newFaculty[TAIL].next;
			
			currentNode = currentNode.next;
		}
		
		PersonNode[] newNotInFaculty = difference(ADMIN_TABLE, FACULTY_TABLE);
		
		union[HEAD] = newFaculty[HEAD];
		union[TAIL] = newFaculty[TAIL];
		union[TAIL].next = newNotInFaculty[HEAD];
		union[TAIL] = newNotInFaculty[TAIL];
		
		return union;
	}
	
	/**
	 * Removes a person node, defined by id, from the specified linked list 
	 * table.
	 * 
	 * @param table - the linked list table from which to remove the person
	 *     node
	 * @param id - the unique identifier of the person node to be removed
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

	/**
	 * Returns a {head, tail} array of the person nodes which have the largest 
	 * number of years and belong to the specified table.
	 * 
	 * @param table - the linked list table to select from
	 * @return a {head, tail} array of the person nodes which have the largest 
	 *     number of years and belong to the specified table.
	 */
	public PersonNode[] getVeteran(int table)
	{	
		//
		PersonNode[] veterans = {null, null};
		
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
		veterans[HEAD] = head.clone();
		veterans[TAIL] = veterans[HEAD];
		int mostYears = Integer.parseInt(veterans[HEAD].years);
		PersonNode currentNode = head.next;
		int years = 0;
		while (currentNode != null)
		{
			years = Integer.parseInt(currentNode.years);
			//
			if (years > mostYears)
			{
				veterans[HEAD] = currentNode.clone();
				veterans[TAIL] = veterans[HEAD];
				mostYears = years;
			}
			//
			else if(years == mostYears)
			{
				veterans[TAIL].next = currentNode.clone();
				veterans[TAIL] = currentNode.clone();
			}
			
			currentNode = currentNode.next;
		}
		
		//
		return veterans;
	}
	
	/**
	 * Returns a {head, tail} array of the person nodes which have the smallest 
	 * number of years and belong to the specified table.
	 * 
	 * @param table - the linked list table to select from
	 * @return a {head, tail} array of the person nodes which have the smallest 
	 *     number of years and belong to the specified table.
	 */
	public PersonNode[] getRookie(int table)
	{
		//
		PersonNode[] rookies = {null, null};
		
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
		rookies[HEAD] = head.clone();
		rookies[TAIL] = rookies[HEAD];
		int leastYears = Integer.parseInt(rookies[HEAD].years);
		PersonNode currentNode = head.next;
		int years = 0;
		while (currentNode != null)
		{
			years = Integer.parseInt(currentNode.years);
			//
			if (years < leastYears)
			{
				rookies[HEAD] = currentNode.clone();
				rookies[TAIL] = rookies[HEAD];
				leastYears = years;
			}
			//
			else if(years == leastYears)
			{
				rookies[TAIL].next = currentNode.clone();
				rookies[TAIL] = currentNode.clone();
			}
			
			currentNode = currentNode.next;
		}
		
		//
		return rookies;
	}
	
	/**
	 * Prints the person nodes from the specified linked list table to the 
	 * standard output.
	 * 
	 * @param table - the linked list table containing the person nodes whose
	 *     information is to be printed
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
				getClassificationString(currentNode));
			
			currentNode = currentNode.next;
		}
	}
	
	/**
	 * Returns a string describing which linked list tables contain the 
	 * specified person node.
	 * 
	 * @param currentNode - the specified person node
	 * @return a string describing which linked list tables contain the 
	 * specified person node
	 */
	String getClassificationString(PersonNode currentNode)
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