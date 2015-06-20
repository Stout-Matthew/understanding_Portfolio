package multiThreadExample;

import java.io.IOException;
import java.net.*;

import org.quickconnectfamily.json.*;

import views.ServerView;
import exceptions.NotUserException;


/***************************************
 * @author matthew
 * A class used to extend Thread and open
 * a server listening port
 ****************************************/

public class ThreadController extends Thread {

	public ServerView serverView;
	public User user;
	public ServerSocket sSocket;
	public Socket cSocket;
	public JSONInputStream inputStream;
	public JSONOutputStream outputStream;
	public Object inputObject;
	public String outputStringData;
	public int whichCase;
	
	/***********************************
	 *  default constructor
	 ***********************************/
	public ThreadController(Socket cSocket, ServerView serverView){
		// get the client socket
		this.cSocket = cSocket;
		// set up where we will send the data
		this.serverView = serverView;
		// establish which run instance we will perform
		this.whichCase = 1;
		
	}
	public ThreadController(Socket cSocket){
		this.cSocket = cSocket;
		this.whichCase = 2;
		this.start();
	}
	public ThreadController(ServerSocket sSocket){
		// constructor using incoming port number and server socket
		this.sSocket = sSocket;
		
	}
	
	// socket setter
	public void setCSocket(){
		try {
			this.cSocket = this.sSocket.accept();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
	}
	public void setInputStream(Socket cSocket)  throws IOException{
		this.inputStream = new JSONInputStream(cSocket.getInputStream());
	}
	public void setInputStream(JSONInputStream inputStream){
		this.inputStream = inputStream;
	}	
	public void setInputStream()  throws IOException{
		this.inputStream = new JSONInputStream(this.cSocket.getInputStream());
	}
	public void setOutputStream(Socket cSocket) throws IOException{
		this.outputStream = new JSONOutputStream(cSocket.getOutputStream());
	}
	public void setOutputStream(JSONOutputStream outputStream){
		this.outputStream = outputStream;
	}
	public void setOutputStream(){
		try {
			this.outputStream = new JSONOutputStream(this.cSocket.getOutputStream());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

/******************************************
 *  collect the input object from the stream
 * 
 ******************************************/
	public void setInputObject(){
		try {
			this.inputObject = this.inputStream.readObject();
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	   
	}
	
	
	
	public boolean setUser(){
		// attempt to put the input string into a user object
		try {
		
			this.user = new User(inputObject);
			return true;
		} catch (NotUserException e) {
			// TODO Auto-generated catch block
			System.err.println("The object passed is not a User");
			this.user = null;
			return false;
		}
		
	}
	
	public String toString(){
		
		this.outputStringData = (String)inputObject;
		return outputStringData;
	}
	public void addToPane(User user){
		
		String currentData = serverView.getTxtpnMain();
		this.outputStringData = user.userToString();
		currentData += outputStringData;
	    serverView.setTxtpnMain(currentData);   
	}
	
	public void sendReturnMessage(){
		String userName = user.getName() + " was added to the server list";
				
		try {
			outputStream.writeObject(userName);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	public void addToPane(){
		String currentData = serverView.getTxtpnMain();
		this.outputStringData = (String)inputObject;
		currentData += outputStringData;
	    serverView.setTxtpnMain(currentData);   
	}
	
	public void run(){
		
		try {
			switch(whichCase){
				case 1:
					this.setInputStream();
					this.setOutputStream();	
					this.setInputObject();
					
					if(this.setUser()){
						this.addToPane(this.user);
						this.sendReturnMessage();
					}else{
						this.addToPane();
					}
					
					
					
					this.cSocket.close();
					
				    break;
				
				case 2:
				// run a different instance of run
					this.setInputStream();
					this.setOutputStream();	
					this.setInputObject();
					System.out.println(outputStringData);
					this.cSocket.close();
					break;
				default:
					break;
			}
		} catch (IOException e1) {
			// catch any issues coming from these methods
			e1.printStackTrace();
		}  
	    
				
		
		
		
		
	}
}












