package multiThreadExample;

import org.quickconnectfamily.json.JSONException;
import org.quickconnectfamily.json.JSONInputStream;

import views.ClientView;

public class ListenRun implements Runnable{

	public Object sObject;
	public JSONInputStream inpt;
	public ClientView clientView;
	
	public ListenRun(JSONInputStream inpt, ClientView clientView){
		
		this.inpt = inpt;
		this.clientView = clientView;
		
	}
	
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		try {
			
			readInputStream();
			addToClientView();
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
	
	// ADD THE INCOMING DATA TO THE CLIENT
	public void addToClientView(){
		 
		 clientView.setTextPane(clientView.getTextPane() + (String)sObject);
	 
	 }
	 
	//READ ANY INCOMING DATA
	 public void readInputStream() throws JSONException{ 
		 sObject = inpt.readObject();
	 }
	
}
