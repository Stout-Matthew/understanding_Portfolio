package multiThreadExample;


import java.util.concurrent.*;

public class ClientExec implements Executor {


	public ClientExec(){
		
	}
	
	// this executes my runnable command
	@Override
	public void execute(Runnable command) {
		// TODO Auto-generated method stub
		
		command.run();
		
	}

	
}
