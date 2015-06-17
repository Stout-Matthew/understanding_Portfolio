package my_socket_io;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

import javax.swing.*;
import javax.swing.event.ChangeListener;
import javax.swing.text.JTextComponent;

import net.miginfocom.swing.MigLayout;
import antlr.collections.List;


/*******************************************
 * breakdown of class
 * 
 * 
 * 
 * 
 *
 *******************************************/






public class CalController {
	
	private JFrame frame;
	private JTextPane  CaloriePane;
	private JTextField txtFoodName; 
	private JTextPane  dinner;
	private JTextPane  breakfast;
	private JTextPane  lunch;
	private JTextPane  snacks;
	private JScrollPane SPBreakfast;
	private JScrollPane SPLunch;
	private JScrollPane SPDinner;
	private JScrollPane SPSnack;
	private JComboBox<String> comboBox;
	private CalorieSlider slider;
	private SubmitClient submit;
	private JButton btnSubmit;
	private BtnListener btn;
	

	public CalController(JFrame frame){
	
		this.frame = frame;
		
	}
	
	public void setComboBox(JComboBox<String> comboBox){
		
	// set combo box details
		this.comboBox = comboBox;
		this.comboBox.addItem("Healthy");
		this.comboBox.addItem("Junk Food");
		this.comboBox.addItem("Fast Food");
		
	}
	
	public void setSlider(CalorieSlider slider){
	//	get control over the slider to make changes;
		this.slider = slider;
		this.slider.setC(this);
	}
	
	public void setCalories(int cals){
	// 
		
		this.CaloriePane.setText(String.valueOf(cals));
	}
		
	public void setScrollPanes(JScrollPane d,JScrollPane s,JScrollPane b,JScrollPane l){	
		
	}
	
	public void setSubmitButton(JButton btnSubmit){
		
	// set the button for object level variable
		this.btnSubmit = btnSubmit;
		this.btn = new BtnListener(this);
		this.btnSubmit.addActionListener(this.btn);
		
		
		
	}
	
	// 
	
	
	
	
/******************************************
 * 
 * sets the local instances of calorie pane, food name pane, snakes output pane
 * 
 * 
 * 
 ******************************************/
	public void setTextAreas(JTextPane CaloriePane , JTextField txtFoodName){
		
		// create a collection for items
		this.txtFoodName = txtFoodName; 
		
		// assign the text variables we will be controlling through the process
		this.CaloriePane = CaloriePane;
		this.CaloriePane.setEditable(false);
		this.CaloriePane.setFocusable(false);
		
	}
	
	public void submitFood(){
		
	// sets local variables for submission
		
		// casts string to integer for submission
		int cals = Integer.valueOf(CaloriePane.getText());
		String foodName = txtFoodName.getText();
		String category = (String)comboBox.getSelectedItem();
		
		
		if ((foodName.trim() == null) || (foodName.trim() == "")){
			
			
		}else
		{
			this.submit = new SubmitClient(foodName, category, cals, new Date());
			
		}
		
		
		}
		
	
	
	
}

