package Socketio;

import java.io.IOException;
import java.net.Socket;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import org.quickconnectfamily.json.JSONException;
import org.quickconnectfamily.json.JSONInputStream;
import org.quickconnectfamily.json.JSONOutputStream;

/**
 *
 * @author Architect
 */
public class Client {
    
    public static void main(String[] args) {
        // create a client object
        Client client = new Client();
        
        // get the server parameters
        String hostName = "localhost";
        Integer portNumber = 31337;
        String name = "Jonathan";
        
        // needs try block, create server instance "toServer"
        // may throw unknow host exception or JSON exeption
        try (Socket toServer = new Socket(hostName, portNumber);) {
           // check to see if the name has any value other thna white space
            if (name.trim().isEmpty()) {
                throw new StringFormatException();
            }
            else {
	            // notify user of attempt to send info
	            System.out.println("Sending name " + name + " to server");
	          // make actual attempt to send data
	            client.sendData(toServer, name);
	            // call private method from client to get the data
	            System.out.println("Response from Server: " + client.retrieveData(toServer));
        }
            
        }
        
        catch (UnknownHostException uhe) {
            
            System.err.println("Unknown host: " + hostName);
            
        }
        
        catch (IOException ioe) {
            
            System.err.println("Couldn't establish a connection to host " + hostName + " on port " + portNumber);
            
        }
        
        catch (JSONException je) {
            
            System.err.println("Invalid data format.  Please ensure that the data is in the correct format (String) and try again.");
            
        }
        
        catch (StringFormatException sfe) {
            
            System.err.println("Name cannot be null");
            
        }
        
    }
    // pass in output stream and value for sending information
    private void sendData(Socket toServer, String name) throws IOException, JSONException {
        
            JSONOutputStream outToServer = new JSONOutputStream(toServer.getOutputStream());
            
            outToServer.writeObject(name);
            
        }
    
    private String retrieveData(Socket toServer) throws IOException, JSONException {
        
     JSONInputStream inFromServer = new JSONInputStream(toServer.getInputStream());
     
     Object in = inFromServer.readObject();
     
     String messageFromServer = (String)in;
     
     return messageFromServer;
        
    }
    
}