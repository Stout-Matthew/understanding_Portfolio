package multiThreadExample;

public class MultiThreadTestProgram {

	public static void main(String[] args) {
		
		
		int seconds;
		String message;
		for (int i = 0; i <= 10; i++){
			
			seconds = (int)Math.ceil(Math.random()*5);
			message = "This output is string " + i;
			new SimpleThread(seconds, message);
			
		}
		
		
		
	}
}
