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
    
    /**
     * 
     */
    @Override 
    public PersonNode clone()
    {
    	return new PersonNode(name, id, phone, division, years);
    }
}
