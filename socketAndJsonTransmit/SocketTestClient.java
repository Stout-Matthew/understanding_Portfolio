package socketAndJsonTransmit;

import java.io.IOException;
import java.io.Serializable;
import java.net.*;
import java.util.Date;

import org.quickconnectfamily.json.JSONException;
import org.quickconnectfamily.json.JSONInputStream;
import org.quickconnectfamily.json.JSONOutputStream;

import understand_portfolio.Food_item;
import exceptions.CustomException;

public class SocketTestClient {

	private Food_item food;
	private String host_name = "localhost";
	private int portNumber = 38110;
	private Socket serverSocket;
	private JSONOutputStream jsonToServer;
	private JSONInputStream jsonFromServer;
	private Object gotObject;
	private Serializable sendObject;
	
public SocketTestClient(){
		
	food = new Food_item();
	
		if(this.connectToServer()){
			System.out.println("successful connection to server");
			
			if(setStreams()){
				System.out.println("successful creation of streams");	
				
				if(this.sendDataToServer(food)){
					System.out.println("food data sent successfully");	
					
					this.setGotObject();
					
				}
				
			}		
		}
		
	}

/*****************************************
 * constructor for submitting food item to the server
 * @param food
 *****************************************/
	public SocketTestClient(Food_item food){
		this.food = food;
		
		if(this.connectToServer()){
			System.out.println("successful connection to server");
			
			if(setStreams()){
				System.out.println("successful creation of streams");	
				
				if(this.sendDataToServer(this.food)){
					System.out.println("food data sent successfully");	
					this.setGotObject();	
				}
			}		
		}
	}
/****************
 * 
 * @param foodName
 * @param category
 * @param calories
 * @param inputDate
 * 
 */
	public SocketTestClient(String foodName, String category, int calories, Date inputDate){
		try {
			food = new Food_item(foodName, category, calories);
		
			if(this.connectToServer()){
				System.out.println("successful connection to server");
				
				if(setStreams()){
					System.out.println("successful creation of streams");	
					
					if(this.sendDataToServer(food)){
						System.out.println("food data sent successfully");	
						this.setGotObject();
						
					}
					
				}		
			}
		} catch (CustomException e) {
			// TODO Auto-generated catch block
			System.out.println("an error was thrown in the creation "
					+ "of a food object");			
		}		
	}
		
	/*********************************
	 * get the stream data from and to the server
	 *********************************/
	public boolean setStreams(){	
		try {
			this.setJsonFromServer();
			this.setJsonToServer();
			return true;
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	
	/***********************************
	 *  setters for the streams input and output
	 ***********************************/
	public void setJsonFromServer() throws IOException{
			jsonFromServer = new JSONInputStream(this.serverSocket.getInputStream());     
	}
	public void setJsonToServer() throws IOException{
			this.jsonToServer = new JSONOutputStream(this.serverSocket.getOutputStream());
	}
	

	/************************************
	 * SET THE GOT OBJECT AND IN THIS INSTANCE JUST SHOW US WHAT IT WAS
	 */
	public void setGotObject(){
		try {
	    	 gotObject = jsonFromServer.readObject();
	    	 System.out.println(gotObject);	 
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			System.out.println("get Data method failed");
		}	
	}
	
	/*****************************
	 * sending an object to the server
	 *****************************/
	private boolean sendDataToServer(Serializable sending_object) {
      
        // send the JSON object to the server  	
            try {
				this.jsonToServer.writeObject(sending_object);
				return true;
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return false;
			}
        }

	/******************************************
	 * make sure the server is listening and connect to the server
	 ******************************************/
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
    	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Food_item foody;
		try {
			foody = new Food_item("Cheetos","Junk Food", 100);
			new SocketTestClient(foody);
			
		} catch (CustomException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	
		

	}

}
