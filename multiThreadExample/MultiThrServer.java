package multiThreadExample;

import java.io.*;
import java.net.*;
import java.util.*;

import views.*;

import org.quickconnectfamily.json.*;

import exceptions.*;


public class MultiThrServer {

	
	public Collection<User> users;
	public User thisUser;
	public int maxCount;
	public Socket cSocket;
	public ServerSocket sSocket;
	public int portNumber = 38110;
	boolean isListening = true;
	private ServerView serverView;
	
	public MultiThrServer() throws IOException{
		
	}
	
	public MultiThrServer(int portNumber) throws IOException{
		
		this.portNumber = portNumber;
		serverView = new ServerView();

	}
	
	public void openConnection(){
		
		
		try{
			sSocket = new ServerSocket(portNumber);
			
			while(isListening){
				
				new ThreadController(sSocket.accept(), serverView).start();
				
			}
		}	        
		catch (IOException listen) {
			// throw exception is cannot be found
			listen.printStackTrace();
		}		
	}

	
	
	// call the main method
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int portNumber = 28889;
		
		try {
			
			MultiThrServer mts = new MultiThrServer(portNumber);
			
			mts.openConnection();
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}














