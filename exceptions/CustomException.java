package exceptions;

public class CustomException extends Exception {

	
	public class sessionException extends CustomException{
		
		public void invalidSession(){
			
			System.err.println("This session creation attempt threw an error");
			this.printStackTrace();
			
		}
		
		
	}
	
	public void invalidObject() 
	{
		
		System.err.println("The object recovered for the socket stream is invalid");
		
	}
	
	public void notFood(){
		
	}
	
	public void invalidDBConnection(){
		
		System.err.println("The Connection to the database is invalid ");
		
		
	}
	
	
	
}

