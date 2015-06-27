package HttpUrl;

import java.net.*;
import java.io.*;

import org.quickconnectfamily.json.JSONInputStream;
import org.quickconnectfamily.json.JSONOutputStream;


public class HttpServer {

	
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		ServerSocket s = new ServerSocket(44752);	

		
		Socket clientSocket = s.accept();
		
		   clientSocket.getInputStream();
           clientSocket.getOutputStream();
           
           
           s.close();
		
		
	}

}
