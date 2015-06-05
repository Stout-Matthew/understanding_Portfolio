package understand_portfolio;


import java.util.Date;



public class Food_item {

// declare variables for submission to database
public int id;
public String food_name;
public String category;
public String calories;
public Date   date_eaten;
	 
 //create getters and setters
public int getId(){
	return this.id;
}
 
public void setId(int value){
	this.id = value;
}	 
	public String getFood_name(){
		return this.food_name;
	}
	 
	public void setFood_name(String value){
		this.food_name = value;
	}
	 
	public String getCategory(){
		return this.category;
	}
	public void setCategory(String value){
		this.category = value;
	}
	
	public String getCalories(){
		return this.calories;
	}
	public void setCalories(String calories){
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
