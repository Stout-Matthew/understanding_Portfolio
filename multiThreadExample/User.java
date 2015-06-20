package multiThreadExample;

import java.io.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;

import exceptions.NotUserException;

public class User implements Serializable {

	String name;
	int age;
	int weight;
	int id;
	
	
	public User() {
		
	}

	public User(String name, String weight, String age) throws NotUserException{
		
		this.name = name;
		this.weight = Integer.valueOf(weight);
		this.age = Integer.valueOf(age);
		
		// if it does not then set it to 0
		this.id = 0;
	
	}
	public String userToString(){
		String stringVal = null;
		stringVal = "UserID = " + this.id + " " + this.name + " is " + this.age + " years old and weighs " + this.weight + " pounds.";
		return stringVal;
	}
	
	public User(Object obj) throws NotUserException {
		// create local variable
		Long asLong = null;
		// convert Object into a hashmap
		HashMap hashedObject = (HashMap)obj;
		
		// set the user name
		this.name = (String)hashedObject.get("name");

		//set the age
		asLong = (Long)hashedObject.get("age");
		this.age = asLong.intValue();
		
		// set the weight
		asLong = (Long)hashedObject.get("weight");
		this.weight = asLong.intValue();
		
		// evaluate if the id exists, if it does then set it
		if((Long)hashedObject.get("id") != null){
			asLong = (Long)hashedObject.get("id");
			this.id = asLong.intValue();
		}else{
			// if it does not then set it to 0
			this.id = (int)Math.round(Math.random()*10000);
		}
		
	}
	
	public User(String name, int age, int weight) {
		this.name = name;
		this.age = age;
		this.weight = weight;
	}
	
	public void setWeight(int weight){
		this.weight = weight;
	}
	public void setAge(int age){
		this.age = age;
	}

	public void setName(String name){
		this.name = name;
	}
	public void setId(int id){
		this.id = id;
	}
	

	public int getId(){
		return id;
	}

	public int getWeight(){
		return weight;
	}
	public int getAge(){
		return age;
	}

	public String getName(){
		return name;
	}
	
	
}
