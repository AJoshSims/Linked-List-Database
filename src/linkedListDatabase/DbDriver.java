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
			database.getClassificationString(database.adminHeadPtr) + " table(s).");
		
		System.out.println("");
		//////////////////////////////////////////
		
		// getVeteran
		//////////////////////////////////////////
		System.out.println("TESTING GETVETERAN...");
		
		PersonNode[] veterans = database.getVeteran(MyDatabase.FACULTY_TABLE);
		
		System.out.println("head is " + veterans[MyDatabase.HEAD].name);
		System.out.println("tail is " + veterans[MyDatabase.TAIL].name);
		
		System.out.println("entire veteran list is...");
		PersonNode currentVeteranNode = veterans[MyDatabase.HEAD];
		while (currentVeteranNode != null)
		{
			System.out.println(currentVeteranNode.name + "    " + currentVeteranNode.id + 
				"    " + currentVeteranNode.phone + "    " + currentVeteranNode.division + 
				"    " + currentVeteranNode.years + "    " + 
				database.getClassificationString(currentVeteranNode));
			
			currentVeteranNode = currentVeteranNode.next;
		}
		
		System.out.println("");
		//////////////////////////////////////////
		
		// getRookie
		//////////////////////////////////////////
		System.out.println("TESTING GETROOKIE...");
		
		PersonNode[] rookies = database.getRookie(MyDatabase.ADMIN_TABLE);
		
		System.out.println("head is " + rookies[MyDatabase.HEAD].name);
		System.out.println("tail is " + rookies[MyDatabase.TAIL].name);
		
		System.out.println("entire rookie list is...");
		PersonNode currentRookieNode = rookies[MyDatabase.HEAD];
		while (currentRookieNode != null)
		{
			System.out.println(currentRookieNode.name + "    " + currentRookieNode.id + 
				"    " + currentRookieNode.phone + "    " + currentRookieNode.division + 
				"    " + currentRookieNode.years + "    " + 
				database.getClassificationString(currentRookieNode));
			
			currentRookieNode = currentRookieNode.next;
		}
		
		System.out.println("");
		//////////////////////////////////////////
		
		// select
		//////////////////////////////////////////
		System.out.println("TESTING SELECT...");
		
		PersonNode[] selected = database.select(MyDatabase.FACULTY_TABLE, "years", "23");
		
		System.out.println("head is " + selected[MyDatabase.HEAD].name);
		System.out.println("tail is " + selected[MyDatabase.TAIL].name);
		
		System.out.println("entire selected list is...");
		PersonNode currentSelectedNode = selected[MyDatabase.HEAD];
		while (currentSelectedNode != null)
		{
			System.out.println(currentSelectedNode.name + "    " + currentSelectedNode.id + 
				"    " + currentSelectedNode.phone + "    " + currentSelectedNode.division + 
				"    " + currentSelectedNode.years + "    " + 
				database.getClassificationString(currentSelectedNode));
			
			currentSelectedNode = currentSelectedNode.next;
		}
		
		System.out.println("");
		//////////////////////////////////////////

		// intersect
		//////////////////////////////////////////
		System.out.println("TESTING INTERSECT...");
		
		PersonNode[] intersection = database.intersect("years", "23");
		
		System.out.println("head is " + intersection[MyDatabase.HEAD].name);
		System.out.println("tail is " + intersection[MyDatabase.TAIL].name);
		
		System.out.println("entire Intersection list is...");
		PersonNode currentIntersectionNode = intersection[MyDatabase.HEAD];
		while (currentIntersectionNode != null)
		{
			System.out.println(currentIntersectionNode.name + "    " + currentIntersectionNode.id + 
				"    " + currentIntersectionNode.phone + "    " + currentIntersectionNode.division + 
				"    " + currentIntersectionNode.years + "    " + 
				database.getClassificationString(currentIntersectionNode));
			
			currentIntersectionNode = currentIntersectionNode.next;
		}
		
		System.out.println("");
		//////////////////////////////////////////
		
		// difference
		//////////////////////////////////////////
		System.out.println("TESTING DIFFERENCE...");
		
		PersonNode[] difference = database.difference(MyDatabase.FACULTY_TABLE, MyDatabase.ADMIN_TABLE);
		
		System.out.println("head is " + difference[MyDatabase.HEAD].name);
		System.out.println("tail is " + difference[MyDatabase.TAIL].name);
		
		System.out.println("entire difference list is...");
		PersonNode currentDifferenceNode = difference[MyDatabase.HEAD];
		while (currentDifferenceNode != null)
		{
			System.out.println(currentDifferenceNode.name + "    " + currentDifferenceNode.id + 
				"    " + currentDifferenceNode.phone + "    " + currentDifferenceNode.division + 
				"    " + currentDifferenceNode.years + "    " + 
				database.getClassificationString(currentDifferenceNode));
			
			currentDifferenceNode = currentDifferenceNode.next;
		}
		
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
			database.getClassificationString(database.facultyHeadPtr) + " table(s).");
		
		System.out.println("");
		//////////////////////////////////////////
	}
}
