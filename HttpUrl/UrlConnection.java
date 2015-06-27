package HttpUrl;

import java.io.*;
import java.net.*;
import java.util.*;

import org.quickconnectfamily.json.*;

public class UrlConnection {

	public static JSONInputStream jsonFromServer;

	
	public void googleExample() throws IOException{
	
		URL url;
		try {
			url = new URL("http://ajax.googleapis.com/ajax/services/feed/load?v=1.0&q=http%3A%2F%2Fnews.google.com%2Fnews%3Foutput%3Drss%26num%3D8");
			
			jsonFromServer = new JSONInputStream(url.openStream());
			
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}

	public static void readThroughKeys(HashMap hash){

		getDetails("responseData", hash);
	}

	public static void getDetails(String value, HashMap hash){
		
		HashMap obj = (HashMap)hash.get(value);
		
		HashMap feed = (HashMap)obj.get("feed");
		
		GoogleFeedJson ggle = new GoogleFeedJson(feed);
		
		System.out.println(ggle.getTitle());	
	}
	
	public static void main(String args[]) throws IOException{
		
		URL url = new URL("http://ajax.googleapis.com/ajax/services/feed/load?v=1.0&q=http%3A%2F%2Fnews.google.com%2Fnews%3Foutput%3Drss%26num%3D8");
		
		url.openConnection();
    
		jsonFromServer = new JSONInputStream(url.openStream());
		
		try {
			
			Object obj = jsonFromServer.readObject();
			readThroughKeys((HashMap)obj);
		
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	
}
