package socketAndJsonTransmit;


import org.hibernate.*;
import org.hibernate.boot.registry.*;
import org.hibernate.cfg.Configuration; 
import org.hibernate.service.*;

import exceptions.CustomException;

import javax.swing.*;

import java.awt.*;

import net.miginfocom.swing.MigLayout;

import java.awt.event.*;
import java.util.*;

import understand_portfolio.*;
/********************************************************************************
* this will gather the information from the server and submit it to the database
********************************************************************************/

public class FoodController {

// get all the needed variables and objects
	private Food_item food;
	private Session session;
	private java.util.List results;
	private Transaction t;
	private static SessionFactory sessionFactory;
	private static StandardServiceRegistry serviceRegistry;
	
	public FoodController(){	
		this.createSessionFactory();	
	}	
	
	public FoodController(Food_item food){
		this.createSessionFactory();
		this.submitFoodToDB(food);
	}	
	
	
	public boolean submitFoodToDB(Food_item food){
		this.food = food;
	    try{
	    // submit the item to the DB
	    	this.setTransactionAndSession();
			this.submitToDatabase();
		}catch(CustomException DBSession){
			DBSession.invalidDBConnection();
			DBSession.printStackTrace();
			session.close();
		    return false;
		}
	    
	    session.close();
	    return true;
		
	}
	
	private void setTransactionAndSession()throws SessionException {
		this.session = sessionFactory.openSession();  
		this.t = session.beginTransaction();
	}
	
	private void submitToDatabase() throws CustomException{
		 session.persist(this.food);
		 t.commit();
	}
	
	
	
	public void setFood(Food_item food){
		this.food = food;
	}
	
	private void createSessionFactory() {
	    Configuration configuration = new Configuration();
	    configuration.configure("food.hb.cfg.xml");
	    
	    serviceRegistry = new StandardServiceRegistryBuilder().applySettings(
	            configuration.getProperties()).build();
	    
	    sessionFactory = configuration.buildSessionFactory(serviceRegistry);
	    
	}
	
	
	
	
	
	
	
}
