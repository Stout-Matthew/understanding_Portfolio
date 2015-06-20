package views;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import net.miginfocom.swing.MigLayout;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JButton;


public class ClientView {

	private JFrame frame;
	private JTextField txtfUseName;
	private JTextField txtAge;
	private JTextField txtWeight;
	private JTextPane textPane;
	private JButton btnSubmitUser;
	public static String newline = System.getProperty("line.separator");
	
	
	/**
	 * Create the application.
	 */
	public ClientView() {
		initialize();
	}
	
	public JButton getSubmitUser(){
		return btnSubmitUser;
	}
	
	public void setTextPane(String value){
		
		textPane.setText(value + newline);
		
	}
	
	public String getTextPane(){
		
		return textPane.getText();
		
	}
	
	public String getAgeField(){
		return txtAge.getText();
	}
	public String getWeightField(){
		return txtWeight.getText();
	}
	public String getUseNameField(){
		return txtfUseName.getText();
	}
	public void clearFields(){
		txtAge.setText("");
		txtWeight.setText("");
		txtfUseName.setText("");
	}
	
	

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 618, 436);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new MigLayout("", "[][][grow]", "[][][][][][][][][][][][][]"));
		
		textPane = new JTextPane();
		frame.getContentPane().add(textPane, "cell 2 2 1 11,grow");
		JLabel lblUserName = new JLabel("User Name");
		frame.getContentPane().add(lblUserName, "cell 0 2,alignx trailing");
		
		txtfUseName = new JTextField();
		frame.getContentPane().add(txtfUseName, "cell 1 2,growx");
		txtfUseName.setColumns(10);
		
		JLabel lblAge = new JLabel("Age");
		frame.getContentPane().add(lblAge, "cell 0 4,alignx trailing");
		
		txtAge = new JTextField();
		frame.getContentPane().add(txtAge, "cell 1 4,growx");
		txtAge.setColumns(10);
		
		JLabel lblWeight = new JLabel("Weight");
		frame.getContentPane().add(lblWeight, "cell 0 6,alignx trailing");
		
		txtWeight = new JTextField();
		frame.getContentPane().add(txtWeight, "cell 1 6,growx");
		txtWeight.setColumns(10);
		
		btnSubmitUser = new JButton("Submit User");		
		
		frame.getContentPane().add(btnSubmitUser, "cell 1 8");
		
		frame.setVisible(true);
	}

}
