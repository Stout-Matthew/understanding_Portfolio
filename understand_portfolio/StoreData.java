package understand_portfolio;

import org.hibernate.Session;  
import org.hibernate.SessionFactory;  
import org.hibernate.Transaction;  
import org.hibernate.cfg.Configuration;  
  /*****************************************
   * 
   * 
   * i AM NOT THE ORIGINAL AUTHOR OF STOREDATA OR EMPLOYEE
   * the code I wrote was Food_item and Hibernate_food_interface
   * 
   * @author http://www.javatpoint.com/steps-to-create-first-hibernate-application
   *
   *****************************************/
public class StoreData {  
public static void main(String[] args) {  
/****************
 *  Step 4 create a class to retrieve and store objects
 ****************/
    //creating configuration object  
	Configuration  cfg = new Configuration().configure("hibernate.cfg.xml");//populates the data of the configuration file  
      
    //creating session factory object  
    SessionFactory factory=cfg.buildSessionFactory();  
      
    //creating session object  
    Session session=factory.openSession();  
      
    //creating transaction object  
    Transaction t=session.beginTransaction();  
          
    Employee e1=new Employee();  
    e1.setId(400);  
    e1.setFirstName("Matthew");  
    e1.setLastName("Stout");  
      
    session.persist(e1);//persisting the object  
      
    t.commit();//transaction is commited  
    session.close();  
      
    System.out.println("successfully saved");  
      
}  
}  