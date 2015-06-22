package multiThreadExample;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.net.*;
import java.util.concurrent.*;

import javax.swing.*;

import org.quickconnectfamily.*;
import org.quickconnectfamily.json.*;

import exceptions.NotUserException;
import views.*;


public class MultiThrClient {

	public String hostName = "localhost";
	public int portNumber;
	public User user;
	public Socket sSocket;
	public JSONInputStream inpt;
	public JSONOutputStream outpt;
	public ClientView clientView;
	public JButton btn;
	public String serverUpdate;
	public Object sObject;
	private ClientExec cliEx;
	
	public MultiThrClient(){
		
		System.out.println("MTC was created;");
		
	}
	public MultiThrClient(int portNumber, String hostName){
		
		this.hostName = hostName;
		this.portNumber = portNumber;
		cliEx = new ClientExec();
		// on opening get the socket connection
		
		clientView = new ClientView();
		btn = clientView.getSubmitUser();
		btn.addActionListener(
			new ActionListener(){
				public void actionPerformed(ActionEvent arg0) {	
					
					setUser( clientView.getUseNameField()
						   , clientView.getAgeField()
						   , clientView.getWeightField());
					
					getSSocketConnection();
					cliEx.execute(new SubRun(outpt, user));
					//writeToOutputStream(user);
					cliEx.execute(new ListenRun(inpt, clientView));
					clientView.clearFields();
				}
			}
		);
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
	
	 public void getSSocketConnection(){	
    	try {
			sSocket = new Socket(this.hostName, this.portNumber);
			setInpt(sSocket.getInputStream());
			setOutpt(sSocket.getOutputStream());
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
 	}
 /*****************************************************
  * @throws JSONException
  * 
  * this is no longer in use it will be handled by the runnable SubRun
  *****************************************************/
	 public void readInputStream() throws JSONException{ 
		 sObject = inpt.readObject();
	 }
	 
 /*****************************************************
  * not currently in use
  *****************************************************/
	 public void addToClientView(){
		 
		 clientView.setTextPane(clientView.getTextPane() + (String)sObject);
	 
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

	 /**************************************************************
	  * GENERAL GETTERS AND SETTERS SECTION FOR MY CLASS
	  * 
	  * @param inpt
	  * @throws IOException
	  **************************************************************/ 
	// have multiple overloads for polymorphism
	public void setSSocket(Socket sSocket){
		this.sSocket = sSocket;
	} 
	public void setInpt(InputStream inpt) throws IOException{
		this.inpt = new JSONInputStream(inpt);     
	}
	public void setOutpt(OutputStream outpt) throws IOException{
		this.outpt = new JSONOutputStream(outpt);
	}
	public void setInpt(Socket inpt) throws IOException{
		this.inpt = new JSONInputStream(inpt.getInputStream());     
	}
	public void setOutpt(Socket outpt) throws IOException{
		this.outpt = new JSONOutputStream(outpt.getOutputStream());
	}

	public static void main(String[] args){
		 
		int portNumber = 28889;
		String hostName = "localhost";
		MultiThrClient mtc = new MultiThrClient(portNumber, hostName);		 
		 
	 }
	
	
}
