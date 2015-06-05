package understand_portfolio;

import java.awt.EventQueue;
import java.awt.List;

import org.hibernate.Query;
import org.hibernate.Session;  
import org.hibernate.SessionFactory;  
import org.hibernate.Transaction;  
import org.hibernate.cfg.Configuration;  

import javax.swing.*;

import java.awt.*;

import net.miginfocom.swing.MigLayout;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.Date;

public class Hibernate_food_interface {

	// create object level variables
// the JText fields will all be used to collect my input.
	private JTextField calories;
	private JTextField category;
	private JTextField food_name;
	private JTextArea display_food;
	private JButton submit;
	private Food_item new_item;
	public Configuration cfg;
	public SessionFactory factory;
	public Session session;
	public java.util.List results;
	public Transaction t;
	public Hibernate_food_interface(){
		
	}
	
	public Hibernate_food_interface(JTextField calories, 
									JTextField category, 
									JTextField food_name,
									JTextArea display_food,
									JButton submit ){
		
	// initialize the submit button so we can receive input from it.
		this.submit = submit;
	// use the action listener for the button input.
		submit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				submission_process();
				
			}
		});
	// initialize each of the text fields so we can receive their input in the controller
		this.calories = calories;
		this.category = category;
		this.food_name = food_name;
		
		
	// this will begin the submission process for the Hibernate function
		this.cfg = new Configuration().configure("food.hb.cfg.xml");//populates the data of the configuration file  
    // creating session factory object says it is deprecated but it still works. will
	// find new process later.
		this.factory = cfg.buildSessionFactory();    
    
	// creating session object  
	// this opens a session for me to send and receive data
	}
	private void query_process(){
/**********************************************************************
 *  this method is a work in progress to return data back from the 
 *  database and display it. I am not huge on lists so I have to 
 *  refresh my knowledge before I can commit to it working.
 *********************************************************************/
		this.session=factory.openSession();  
		Query query=session.createQuery("from Food_item"); 
		results=query.list();  
		t.commit();//transaction is commited  
	    session.close();  
	}
	
	
	private void submission_process(){
		
	// create the food object that we will be sending into the database
	// I could have probably built a contructor for this but oh well.
		Food_item new_item = new Food_item();
		new_item.setFood_name(food_name.getText());
		new_item.setCategory(category.getText());
		new_item.setCalories(calories.getText());
		new_item.setDate_eaten(new Date());

	/******************************************
	 * open a session for me to use in the transaction.
	 * this part was unclear about the seesion and how long it 
	 * should remain open so for my purposes I open and close it every time 
	 * I submit something to the database, however I'm sure you can open it
	 * and just keep it open.
	 ******************************************/
		this.session = factory.openSession();  
		
		//creating transaction object  
	    this.t = session.beginTransaction();  
		
				
		session.persist(new_item);//persisting the object  
	      
	    t.commit();//transaction is commited  
	    session.close();  
		
	}
	
	
	
	
	
	

}
