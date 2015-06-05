/**
 * 
 */
package understand_portfolio;

import java.util.Date;

/*******************************************************
 * @author NOT Matthew
 * the following is a class and a collection of code
 * used in a hibernate tutrial I found online 
 * @ http://www.javatpoint.com/steps-to-create-first-hibernate-application
 * while I am sure My code will be simular, 
 * there will be differences in what it does and how.
 ******************************************************/
public class Employee {
/**********************************
 *  step one is create a Persistent class, this will have
 *	a no-args constructor
 *	identifier property(optional) it will map to the primary key column of the database
 *	getter and setter methods
 *	non-final class
 *********************************/	
	public int id;
	private String firstName,lastName;  
	  
	public String concat_first_last(){
		
	return this.firstName + " " + this.lastName;
	}
	
	public int getId() {  
	    return id;  
	}  
	public void setId(int id) { 
		
	    this.id = id;  
	}  
	public String getFirstName() {  
	    return firstName;  
	}  
	public void setFirstName(String firstName) {  
	    this.firstName = firstName;  
	}  
	public String getLastName() {  
	    return lastName;  
	}  
	public void setLastName(String lastName) {  
	    this.lastName = lastName;  
	}  
/*******************************
 *  Step two is create XML file employee.hbm.xml
 *  Hibernate-mapping is the root element
 *  class is the sub element of the hibernate mapping 
 *  that specifies the persistent class
 *  id is sub element of class to identify the primary key attribute
 *  generator is used to generate the primary key to new entries
 *  property gets the different properties of the class	  
 ********************************/
	  
/*********************************
 * Step three is create the configuration file, also in XML format
 * this will have info on the database and mapping file
 * it should be named hibernate.cfg.xml but you can change that probably
 */
	
	
	
}
