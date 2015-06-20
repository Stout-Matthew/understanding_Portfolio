package multiThreadExample;

public class SimpleThread extends Thread {

	private int sleepTime;
	private String message;
	
	
	
	// construct our thread class
	public SimpleThread(int seconds, String message){
		
		// set up a sleep time in miliseconds
		this.sleepTime = seconds * 1000;
		
		// properly create the string, simplicity does not excuse bad grammar :) 
		if(seconds == 1){
			this.message = message + ". it took " + seconds + " second to print this string";
		}
		else {
			this.message = message + ". it took " + seconds + " seconds to print this string";
		}
		
		this.start();
	}
	
	
	public void run(){
		
		try {
			Thread.sleep(sleepTime);
			
			System.out.println(message);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
