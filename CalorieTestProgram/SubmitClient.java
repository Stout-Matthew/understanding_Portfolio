package my_socket_io;

import understand_portfolio.*;

import java.io.*;
import java.net.*;
import java.util.Date;

import org.quickconnectfamily.json.*;

import exceptions.CustomException;
/****************************************************************
 * @author matthew
 * 
 * this is my client side submitor(name in progress)
 * it will take input given it, convert it to a JSON string and
 * submit it to the server VIA stream that it opens
 ***************************************************************/
public class SubmitClient {
	private Food_item food;
	private String host_name = "localhost";
	private int portNumber = 38110;
	private Socket serverSocket;
	private JSONOutputStream jsonToServer;
	private JSONInputStream jsonFromServer;
	private Object gotObject;
	private Serializable sendObject;
	
public SubmitClient(){
		
	food = new Food_item();
	
		if(this.connectToServer()){
			System.out.println("successful connection to server");
			
			if(get_streams()){
				System.out.println("successful creation of streams");	
				
				if(this.sendData(food)){
					System.out.println("food data sent successfully");	
					
					this.get_data();
					
				}
				
			}		
		}
		
	}
	public SubmitClient(Food_item food){
		
		if(this.connectToServer()){
			this.food = food;	
		
			get_streams();
			
		}
		
	}
	
public SubmitClient(String foodName, String category, int calories, Date inputDate){
			
	
	
	try {
		food = new Food_item(foodName, category, calories);
	
		if(this.connectToServer()){
			System.out.println("successful connection to server");
			
			if(get_streams()){
				System.out.println("successful creation of streams");	
				
				if(this.sendData(food)){
					System.out.println("food data sent successfully");	
					
					this.get_data();
					
				}
				
			}		
		}
	} catch (CustomException e) {
		// TODO Auto-generated catch block
		System.out.println("an error was thrown in the creation "
				+ "of a food object");			
	}		
}
	
	
	public boolean get_streams(){	
		try {
			this.input_stream();
			this.output_stream();
			return true;
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	
	public void input_stream() throws IOException{		
			jsonFromServer = new JSONInputStream(this.serverSocket.getInputStream());     
	}
	

	public void output_stream() throws IOException{
			this.jsonToServer = new JSONOutputStream(this.serverSocket.getOutputStream());
	}
	
	public void get_data(){
		try {
	    	 gotObject = jsonFromServer.readObject();
	    	 System.out.println((String)gotObject);	 
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			System.out.println("get Data method failed");
		}	
	}
	  // pass in output stream and value for sending information
    private boolean sendData(Serializable sendingObject) {
      
        // send the JSON object to the server  	
            try {
				this.jsonToServer.writeObject(sendingObject);
				return true;
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return false;
			}
        }

    public boolean connectToServer(){
    	
    	try {
			this.serverSocket = new Socket(this.host_name, this.portNumber);
			return true;
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
    }
    	
    	
}

    
 
  
		
