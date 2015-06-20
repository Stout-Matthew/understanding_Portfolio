package multithreading;

import java.io.IOException;
import java.net.Socket;
import org.quickconnectfamily.json.JSONException;
import org.quickconnectfamily.json.JSONInputStream;
import org.quickconnectfamily.json.JSONOutputStream;

/**
 *
 * @author Architect
 */
public class ThreadHandler extends Thread {
    
    private Socket socket = null;
    Integer portNumber = 0;
    
    public ThreadHandler(Socket socket, Integer portNumber) {
        
        this.socket = socket;
        this.portNumber = portNumber;
        
    }
    
    public void run() {
        
        try {
            
            JSONInputStream inFromClient = new JSONInputStream(socket.getInputStream());
            JSONOutputStream outToClient = new JSONOutputStream(socket.getOutputStream());
            
            Object in = inFromClient.readObject();
            String messageFromClient = (String)in;
            String messageToClient = "Hello " + messageFromClient;
            
            outToClient.writeObject(messageToClient);
            
            socket.close();
            
        }
        
        catch (IOException ioe) {
            
            System.err.println("Error trying to listen on port " + portNumber);
            
        }
        
        catch (JSONException je) {
            
            System.err.println("Error transmitting message to the client (check variable format?)");
            
        }
        
    }
    
}