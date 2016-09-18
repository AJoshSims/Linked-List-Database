package linkedListDatabase;

/**
 * TODO c
 * 
 * @author Joshua Sims
 *
 */
public class PersonNode 
{
	/**
	 * The next person in the list.
	 */
	PersonNode next = null;
	
    /**
     * Employee name having the form "Last name, First name" (no space after 
     * the comma).
     */
    String name;
	
	/**
	 * Six digit employee ID number.
	 */
    String id;
    
    /**
     * Ten digit phone number.
     */
    String phone;
    
    /**
     * Academic or administrative division.
     */
    String division;
    
    /**
     * Years of service.
     */
    String years;
    
//    /**
//     * Classification(s). To be determined by the table(s) that this node
//     * occupies.
//     */
//    String[] classifications = {"", ""};
    
    /**
     * TODO c
     */
    PersonNode(String name, String id, String phone, String division, 
    	String years)
    {	
    	this.name = name;
    	this.id = id;
    	this.phone = phone;
    	this.division = division;
    	this.years = years;
    }
    
//    String getClassifications()
//    {
//    	//
//    	final int indexOfFirst = 0;
//    	//
//    	final int indexAfterFirst = 1;
//    	
//    	//
//    	String classificationsString = classifications[indexOfFirst];
//    	
//    	//
//    	if (classifications[indexAfterFirst] != "")
//    	{
//	    	for(int index = indexAfterFirst; index < classifications.length; 
//	    		index++)
//	    	{
//	    		classificationsString = ", " + classifications[index];
//	    	}
//    	}
//    	
//    	//
//    	return classificationsString;
//    }
}
