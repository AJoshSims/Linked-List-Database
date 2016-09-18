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
	PersonNode next;
	
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
    
    /**
     * TODO c
     */
    PersonNode(String name, String id, String phone, String division, 
    	String years)
    {
    	next = null;
    	
    	this.name = name;
    	this.id = id;
    	this.phone = phone;
    	this.division = division;
    	this.years = years;
    }
}
