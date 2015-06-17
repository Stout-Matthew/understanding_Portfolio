package my_socket_io;

import java.awt.event.*;

public class BtnListener implements  ActionListener {
	private CalController c;
	
	public BtnListener(CalController c){
		
		// 
		
		this.c = c;
		
		
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		// TODO Auto-generated method stub
		
		c.submitFood();
		
		
		
	}

	
	
}
