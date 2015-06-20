package multithreading;

import java.io.IOException;
import java.net.ServerSocket;

/**
 *
 * @author Architect
 */
public class MultiThreadingServer {

    public static void main(String[] args) {
        
        int portNumber = 5555;
        
        boolean listening = true;
        
        try (ServerSocket serverSocket = new ServerSocket(portNumber)){
            
            while (listening) {
                
                new ThreadHandler(serverSocket.accept(), portNumber).start();
                
            }
            
        }
        
        catch (IOException ioe) {
            
            System.err.println("Error listening on port " + portNumber);
            
        }
        
    }
    
}