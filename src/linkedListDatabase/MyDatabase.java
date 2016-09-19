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
	
	// TODO Should nodes be inserted at end of list?
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
//	
	/**
	 * 
	 * @param attribute
	 * @param value
	 * @return
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
//	
	/**
	 * 
	 * @param tableA
	 * @param tableB
	 * @return
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
	 * 
	 * @return
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
	/**
	 * 
	 * @param table
	 * @return
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
	 * 
	 * @param table
	 * @return
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
				getClassificationString(currentNode));
			
			currentNode = currentNode.next;
		}
	}
	
	// TODO make private
	/**
	 * 
	 * @param currentNode
	 * @return
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