 package understand_portfolio;


import java.io.Serializable;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import exceptions.*;


public class Food_item implements Serializable {

	
	private static final long serialVersionUID = 1L;
	// declare variables for submission to database
	public int    id;
	public String foodName;
	public String category;
	public int    calories;
	public Date   date_eaten;
	 
	public Food_item(){
		this.foodName  =  "Default";
		this.category   =  "no Category";
		this.calories   =  1000;
		this.date_eaten =  new Date();
	}
	public Food_item(HashMap input) throws CustomException{
		String tempDate = null;	
		this.foodName = (String)input.get("foodName");

		this.category = (String)input.get("category");
		
		tempDate = (String)input.get("date_eaten");
		
		DateFormat df = new SimpleDateFormat("dd-M-yyyy hh:mm:ss");
		try {
			this.date_eaten = df.parse(tempDate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		//numbers are stored as longs or doubles.
		Long asLong = (Long)input.get("calories");
		this.calories = asLong.intValue();
		
	}
	
	/*
	 * public String food_name;
	public String category;
	public int calories;
	 */
	
	
	public Food_item(String foodName, String category, int calories) throws CustomException{
		
		this.foodName = foodName;
		this.category = category;
		
		
		this.date_eaten = new Date();
		this.calories = calories;
		
	}
	

 //create getters and setters
	public int getId(){
		return this.id;
	}
	 
	public void setId(int value){
		this.id = value;
	}	 
	public String getFoodName(){
		return this.foodName;
	}
	 
	public void setFoodName(String value){
		this.foodName = value;
	}
	 
	public String getCategory(){
		return this.category;
	}
	public void setCategory(String value){
		this.category = value;
	}
	
	public int getCalories(){
		return this.calories;
	}
	public void setCalories(int calories){
		this.calories = calories;
	}
	
	public Date getDate_eaten(){
		return this.date_eaten;
	}
	public void setDate_eaten(Date date_eaten){
		this.date_eaten = date_eaten;
	}
	
	public void some_arbitrary_function(){
		
	}

}
