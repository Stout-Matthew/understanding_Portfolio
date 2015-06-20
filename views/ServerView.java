package views;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JTextPane;

public class ServerView {

	private JFrame frame;
	public JTextPane txtpnMain;
	public static String newline = System.getProperty("line.separator");
	
	
	public ServerView() {
		initialize();
		frame.setVisible(true);
	}
	
	public void setTxtpnMain(String value){	
		txtpnMain.setText(value + newline);
		
	}
	
	public String getTxtpnMain(){
		
		return txtpnMain.getText();
	}
	
	
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 554, 362);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		txtpnMain = new JTextPane();
		frame.getContentPane().add(txtpnMain, BorderLayout.CENTER);
	}
			
}

	
