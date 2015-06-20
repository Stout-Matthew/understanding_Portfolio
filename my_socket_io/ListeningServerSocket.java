package my_socket_io;


import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;

import org.quickconnectfamily.json.JSONException;
import org.quickconnectfamily.json.JSONInputStream;
import org.quickconnectfamily.json.JSONOutputStream;

import exceptions.CustomException;
import socketAndJsonTransmit.FoodController;
import understand_portfolio.Food_item;

/************************************************
 * @author Matthew Stout
 * this is my listening server... THAT I CREATED!!!!!
 * thats right I created a simple server, boom (drops the mic)
 * this server will catch any input,
 * hopelfully a JSON string and convert it into
 * a food_item object then pass it to my database!
 *************************************************/


public class ListeningServerSocket {

	// server objects needed
	public int portNumber = 38110;
	public FoodController foodControl;
	public Food_item food;
	public ServerSocket serverSocket;
	public Socket clientSocket;
	public JSONInputStream from_client;
	public JSONOutputStream toClient;
	public Object inputObject;
	
	// constructor for default port
	public ListeningServerSocket(){

		// set up the connection to the socket
		this.establishSocketConn();
		this.setQcJson();
		this.getInputFromClient();
        this.closeSocket();    
	}
	
	// constructor to create specific port
	public ListeningServerSocket(int portNumber){

    // get port number	
		this.portNumber = portNumber;
		
	// set up the connection to the 
		this.establishSocketConn();

	// create a server socket on designated port number
		this.setQcJson();
		this.getInputFromClient();
        this.closeSocket();             	
	}
	
	public boolean setFoodHandler(){
		
		
		return false;
	}
	
	
	public void sendToClient(String value1){
		try {
			toClient.writeObject(value1);
		} catch (JSONException output) {
			
			// TODO Auto-generated catch block
			System.err.println("could not send message to client");
			output.printStackTrace();
		}
	}
	
	public void closeSocket(){
		
		try {
			serverSocket.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
		
	}
		
	public void getInputFromClient(){
		
		 try {
			 
			 this.inputObject = from_client.readObject();
			
			 try {
				inputObjectToString();
			} catch (CustomException invalidObject) {
				
			// TODO Auto-generated catch block
				invalidObject.invalidObject();
			
			}
			
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			System.err.println("message from client is invalid format.");
			e.printStackTrace();
		}
	}
	
	public int inputObjectToString() throws CustomException {

		HashMap newObj = (HashMap)this.inputObject;
		
		try{

			this.food = new Food_item(newObj);
			
				//this.send_message_to_client("food item collected");
			
			return 1; 
		}catch(CustomException notFood){
			
			
			System.out.println(newObj);
			
			return 0;
		}
		
		
		
		
		
	}
	
	public void setQcJson(){
		
		set_input_stream();
		set_output_stream();
	}
	
	public void set_input_stream(){
		 
		try {
			from_client = new JSONInputStream(clientSocket.getInputStream());
		} catch (IOException input) {
			// TODO Auto-generated catch block
			System.err.println("could not establish input stream");
		}
	}
	
	public void set_output_stream(){
		try {
			toClient = new JSONOutputStream(clientSocket.getOutputStream());
		} catch (IOException output) {
			// TODO Auto-generated catch block
			System.err.println("could not establish output stream");
		}
	}
	
	// create a server socket on designated port number
	public void establishSocketConn(){
		 try{
			 
			 this.serverSocket = new ServerSocket(portNumber);
             this.clientSocket = serverSocket.accept();
	        }	        
	        catch (IOException listen) {
	        // throw exception is cannot be found
	            System.err.println("could not listen to port " + portNumber);
	        }		
	}
	
	
	
	
	    public static void main(String[] args) {
	    	ListeningServerSocket srvr = new ListeningServerSocket();
	    	
	    }
	    
	}

