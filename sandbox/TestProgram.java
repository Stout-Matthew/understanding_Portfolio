package sandbox;

import java.util.concurrent.*;
import multiThreadExample.*;


public class TestProgram {

	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ClientExec cE = new ClientExec();
	
		
		for(int i = 0; i < 100; i++){
			
			cE.execute(new SubRun());
		
		}
		
	}
		
}
