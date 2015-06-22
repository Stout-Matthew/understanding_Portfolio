package multiThreadExample;

import java.io.Serializable;

import org.quickconnectfamily.json.JSONException;
import org.quickconnectfamily.json.JSONInputStream;
import org.quickconnectfamily.json.JSONOutputStream;

import exceptions.NotUserException;
import views.ClientView;

public class SubRun implements Runnable {

	
	public JSONOutputStream outpt;
	public User user;
	
	public SubRun(){
		
	}
	
	public SubRun(JSONOutputStream outpt, User user){
		this.outpt = outpt;
		this.user = user;
			
	}

	@Override
	public void run() {
	
		
		writeToOutputStream(user);
		
	}


	public void setUser(String name, String age, String weight){
		// attempt to put the input string into a user object
		try {
			this.user = new User(name, weight, age);
		} catch (NotUserException e) {
			// TODO Auto-generated catch block
			System.err.println("Some item is invalid");
			e.printStackTrace();
		}
	}
	
	
	 public void writeToOutputStream(Serializable sending_object) {
	      
	        // send the JSON object to the server  	
	            try {
					this.outpt.writeObject(sending_object);				
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	        }
	
}

