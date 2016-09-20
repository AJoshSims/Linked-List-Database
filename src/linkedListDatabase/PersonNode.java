package linkedListDatabase;

/**
 * A linked list node which contains data that describes a person -- 
 * specifically, a school faculty member or school administrator (or a 
 * combination of the two).
 * 
 * @author Joshua Sims
 * @version September 19, 2016
 */
public class PersonNode 
{
	/**
	 * The next person node in the linked list.
	 */
	PersonNode next = null;
	
    /**
     * Employee name having the form "Last name, First name" (no space after 
     * the comma).
     */
    String name;
	
	/**
	 * Unique, six digit employee ID number.
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
    
    /**
     * Creates a new person node according to the personal details passed as 
     * arguments.
     * 
     * @param name - employee name having the form "Last name, First name" 
     *     (no space after the comma)
     * @param id - unique, six digit employee ID number
     * @param phone - ten digit phone number
     * @param division - academic or administrative division
     * @param years - years of service
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
    
    /**
     * Creates and returns a new, non-linked person node whose personal 
     * information is identical to the calling person node's information. 
     * 
     * @return a new, non-linked person node whose personal 
     *     information is identical to the calling person node's information
     */
    @Override 
    public PersonNode clone()
    {
    	return new PersonNode(name, id, phone, division, years);
    }
}
