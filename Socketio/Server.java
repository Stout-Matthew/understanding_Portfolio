package Socketio;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import org.quickconnectfamily.json.JSONException;
import org.quickconnectfamily.json.JSONInputStream;
import org.quickconnectfamily.json.JSONOutputStream;

import socketAndJsonTransmit.FoodController;

/**
 *
 * @author Architect
 * 
 */
public class Server {
    
    public static void main(String[] args) {
        // get port number	
        Integer portNumber = 31337;
        
        System.out.println("Listening on port " + portNumber);
        
        // create a server socket on designated port number
        try (ServerSocket serverSocket = new ServerSocket(portNumber);
                Socket clientSocket = serverSocket.accept();) {
            
            JSONInputStream inFromClient = new JSONInputStream(clientSocket.getInputStream());
            JSONOutputStream outToClient = new JSONOutputStream(clientSocket.getOutputStream());
            
            Object in = inFromClient.readObject();
            String messageFromClient = (String)in;
            String messageToClient = "Hello " + messageFromClient;
            
            outToClient.writeObject(messageToClient);
            
            serverSocket.close();
            
        }
        
        catch (IOException ioe) {
            
            System.err.println("Error trying to listen on port " + portNumber);
            
        }
        
        catch (JSONException je) {
            
            System.err.println("Error transmitting message to the client (check variable format?)");
            
        }
        
    }
    
}