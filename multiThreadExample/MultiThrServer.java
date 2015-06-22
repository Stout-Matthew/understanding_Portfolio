package multiThreadExample;

import java.io.*;
import java.net.*;
import java.util.*;

import views.*;

import org.quickconnectfamily.json.*;

import exceptions.*;


public class MultiThrServer {

	// object level variables 
	public User thisUser;
	public Socket cSocket;
	public ServerSocket sSocket;
	public int portNumber = 38110;
	private ServerView serverView;
	
	
	public MultiThrServer() throws IOException{
		
	}
	
	public MultiThrServer(int portNumber) throws IOException{
		// used to construct a Server  and a view port
		this.portNumber = portNumber;
		serverView = new ServerView();
	}
	
/*********************************
 * opens a listening port and 
 * executes a new Thread whenever
 * informaiton is received
 ********************************/
	public void openConnection(){
		try{
			sSocket = new ServerSocket(portNumber);
			
			while(true){
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
			new MultiThrServer(portNumber).openConnection();
		} catch (IOException e) {
			// TODO Auto-generated catch block
				e.printStackTrace();
		}	
	}
}














