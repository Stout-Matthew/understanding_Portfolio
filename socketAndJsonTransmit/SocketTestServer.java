package socketAndJsonTransmit;


import java.io.IOException;
import java.net.*;
import java.util.HashMap;
import org.quickconnectfamily.json.JSONException;
import org.quickconnectfamily.json.JSONInputStream;
import org.quickconnectfamily.json.JSONOutputStream;
import exceptions.*;
import understand_portfolio.Food_item;
import my_socket_io.*;



public class SocketTestServer  {
	public int portNumber = 38110;
	public FoodController foodControl;
	public Food_item food;
	public ServerSocket serverSocket;
	public Socket clientSocket;
	public JSONInputStream fromClient;
	public JSONOutputStream toClient;
	public Object inputObject;
	
	public SocketTestServer(){
		
		// set up the connection to the socket
		this.establishSocketConn();
		this.setQcJson();
		this.getInputFromClient();
		try {
			toClient.writeObject(this.food);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//	this.submitToDB();
		
		
		this.closeSocket();
	}
	
	
	/**************************************
	* establishes a connection through the socket 
	*
	**************************************/
	public void establishSocketConn(){
		
		try{	
			this.serverSocket = new ServerSocket(portNumber);
			
			// the location from which data will be coming and accepted
			this.clientSocket = serverSocket.accept();
			
			
			System.out.println("Server set up to listen on port " + portNumber);
			 
		}	        
		catch (IOException listen) {
			// throw exception is cannot be found
			System.err.println("could not listen to port " + portNumber);
			 
		}		
	}
	
	public void setQcJson(){
		
		setInputStream();
		setOutputStream();
			 
	}
	
	
/***********************************************
 * 
 * get the input from our client and then send the data somewhere else
 * for conversion to an actual food item.
 * 
 ***********************************************/
	public void getInputFromClient(){
		
		 try {
			 // get the object that is incoming from a client
			 this.inputObject = fromClient.readObject();
				 
			// call object level method to convert the object to a string	 
				
			 
			 if (this.convertObjectToFoodItem() == 1){
				 toClient.writeObject("MESSAGE FROM SERVER: Food item received and submitted to database");
			 } else if(this.convertObjectToFoodItem() == 2){
				 toClient.writeObject("MESSAGE FROM SERVER: Json receveid but could not convert to food item");
			 } else if(this.convertObjectToFoodItem() == 3){
				 toClient.writeObject("MESSAGE FROM SERVER: Food item created but could not be submitted to the server");
			 }
				// catch the exception if thrown by input object method	
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			// can the standard Json exceptions
			System.err.println("message from client is invalid format."); 
		}
	}
	
	/*****************************
	 * 
	 * submits the item to a database using hibernate
	 * or rather it calls the class that will do that for it
	 * @throws JSONException 
	 * 
	 *****************************/
	public void submitToDB() throws DatabaseSubmissionException {

		this.foodControl = new FoodController();
		this.foodControl.submitFoodToDB(food);	
	}

	// close the socket so we dont get anything else
	public void closeSocket(){
		
		try {
			serverSocket.close();
			 
		} catch (IOException e) {
			// TODO Auto-generated catch block
			 
		}  
		
	}
	
	/**************************************
	 * 
	 * this method converts the JSON string to an actual item for use in the database
	 * 
	 **************************************/
	
	public int convertObjectToFoodItem()  {
		//create a hashmap of the item (I could probably just create a constructor on the receiving end to do this)
		HashMap newObj = (HashMap)this.inputObject;
		try{
			// this will create the food and if it doesn't work will throw an exception
			this.food = new Food_item(newObj);
			// then submit it to the database
			this.submitToDB();
			return 1;
		}catch(CustomException notFood){
			return 2;
		} catch (DatabaseSubmissionException e) {
			// TODO Auto-generated catch block
			return 3;
		} 
	}
	// gets the input stream
	public void setInputStream(){
		try {
			fromClient = new JSONInputStream(clientSocket.getInputStream());
			 
		} catch (IOException input) {
			// TODO Auto-generated catch block
			System.err.println("could not establish input stream");
			 
		}
	}
	
	// gets the output stream
	public void setOutputStream(){
		//
		try {
			toClient = new JSONOutputStream(clientSocket.getOutputStream());
			 
		} catch (IOException output) {
			// TODO Auto-generated catch block
			System.err.println("could not establish output stream");
			 
		}
	}
	
	// calls an instance of the socket server to collect item sent. then will close the listening port
	// after it collects an item
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new SocketTestServer();
		
	}

}
