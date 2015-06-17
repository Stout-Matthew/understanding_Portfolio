package my_socket_io;

import net.miginfocom.swing.MigLayout;
import java.awt.Font;
import java.awt.*;
import javax.swing.*;

public class CalorieCount {

// my view controller
	private CalController control;

// actual frame of the window
	private JFrame frame;
	
// input objects
	private JTextField txtFoodName;
	private JTextPane CaloriePane;
	private JComboBox<String> comboBox;
	private CalorieSlider calorieSlider;
	private JButton btnSubmit;
	
// four scroll panes to output data
	private JScrollPane snacksScrollPane;
	private JScrollPane dinnerScrollPane;
	private JScrollPane lunchScrollPane;
	private JScrollPane breakfastScrollPane;
	
// text pane in scroll panes
	private JTextPane txtpnDinnerfood;
	private JTextPane txtpnBreakfastfood;
	private JTextPane txtpnLunchfood;
	private JTextPane txtpnSnackfood;
	
// all the boring labels
	private JLabel lblDinner;
	private JLabel lblSnacks;
	private JLabel lblCalorieOrganizer;
	private JLabel lblBreakfast;
	private JLabel lblLunch;
	private JLabel lblFoodName;
	private JLabel lblCategory;
	private JLabel lblCalories;
	private Font   smlLblFont = new Font("Rockwell Extra Bold", Font.PLAIN, 15);
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CalorieCount window = new CalorieCount();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public CalorieCount() {
		
		setOutputLabel();
		setInputs();
		setScrollPanes();
		initializeFrame();
		initializeController();

	}
	
	private void initializeFrame(){
		frame = new JFrame();
		frame.setBounds(100, 100, 639, 616);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new MigLayout("", "[grow][grow][grow][grow][grow][grow][grow][grow][grow][grow][grow][grow][grow][grow][grow][grow][grow][grow][grow][grow][grow]", "[grow][grow][grow][grow][grow][grow][grow][grow][grow][grow][grow][grow][grow][grow][grow][grow][grow][grow][grow][grow][grow]"));
		frame.getContentPane().add(lblFoodName, "cell 0 4 1 3,grow");
		frame.getContentPane().add(txtFoodName, "cell 1 5 6 1");
		frame.getContentPane().add(lunchScrollPane, "cell 15 4 6 4,grow");
		
		frame.getContentPane().add(lblCategory, "cell 0 7 1 3,grow");
		frame.getContentPane().add(comboBox, "cell 1 8 3 1,growx");
		frame.getContentPane().add(snacksScrollPane, "cell 15 8 6 4,grow");
		frame.getContentPane().add(lblCalorieOrganizer, "cell 0 0 15 3,grow");
		frame.getContentPane().add(breakfastScrollPane, "cell 15 0 6 4,grow");
		frame.getContentPane().add(lblCalories, "cell 0 10 1 3,alignx trailing");
		frame.getContentPane().add(dinnerScrollPane, "cell 15 12 6 4,grow");
		frame.getContentPane().add(calorieSlider, "cell 0 13 7 1,growx");
		frame.getContentPane().add(btnSubmit, "cell 1 15 4 2,grow");
		frame.getContentPane().add(CaloriePane, "cell 1 11,growx");
		
		
	}
	
	private void setJTextPanes(){
		txtpnSnackfood = new JTextPane();
		txtpnBreakfastfood = new JTextPane();
		txtpnLunchfood = new JTextPane();
		txtpnDinnerfood = new JTextPane();
		
	}
	
	private void setScrollPanes(){
		this.setJTextPanes();
		
		breakfastScrollPane = new JScrollPane();
		breakfastScrollPane.setViewportView(txtpnBreakfastfood);
		breakfastScrollPane.setColumnHeaderView(lblBreakfast);	
		
		lunchScrollPane = new JScrollPane();
		lunchScrollPane.setColumnHeaderView(lblLunch);
		lunchScrollPane.setViewportView(txtpnLunchfood);
		
		snacksScrollPane = new JScrollPane();
		snacksScrollPane.setColumnHeaderView(lblSnacks);	
		snacksScrollPane.setViewportView(txtpnSnackfood);
	
		dinnerScrollPane = new JScrollPane();
		dinnerScrollPane.setColumnHeaderView(lblDinner);
		dinnerScrollPane.setViewportView(txtpnDinnerfood);
		
	
	}
	
	private void setOutputLabel(){
		
		// create main header
		lblCalorieOrganizer = new JLabel("Calorie Organizer");
		lblCalorieOrganizer.setFont(new Font("Kristen ITC", Font.BOLD, 21));
		lblCalorieOrganizer.setHorizontalAlignment(SwingConstants.CENTER);
		
		// sub header labels
		lblBreakfast = new JLabel("Breakfast");
		lblLunch = new JLabel("Lunch");
		lblDinner = new JLabel("Dinner");
		lblSnacks = new JLabel("Snacks");
		
		// header labels format
		lblBreakfast.setHorizontalAlignment(SwingConstants.CENTER);
		lblBreakfast.setFont(smlLblFont);
		lblLunch.setHorizontalAlignment(SwingConstants.CENTER);
		lblLunch.setFont(smlLblFont);
		lblSnacks.setHorizontalAlignment(SwingConstants.CENTER);
		lblSnacks.setFont(smlLblFont);
		lblDinner.setHorizontalAlignment(SwingConstants.CENTER);
		lblDinner.setFont(smlLblFont);
	}

	private void setInputs(){
		// input Labels
		lblFoodName = new JLabel("Food Name");
		lblCalories = new JLabel("Calories");
		lblCategory = new JLabel("Category");
		
		// input
		calorieSlider = new CalorieSlider(CalorieSlider.HORIZONTAL,0,1500,100);
		CaloriePane = new JTextPane();
		CaloriePane.setName("calorieField");
		CaloriePane.setText("100");
		btnSubmit = new JButton("Submit");
		txtFoodName = new JTextField();
		txtFoodName.setName("foodName");
		comboBox = new JComboBox<String>();
		comboBox.setName("Category");
		
		// input labels
		btnSubmit.setFont(smlLblFont);
		lblFoodName.setHorizontalAlignment(SwingConstants.LEFT);
		lblFoodName.setFont(smlLblFont);
		lblCalories.setHorizontalAlignment(SwingConstants.LEFT);
		lblCalories.setFont(smlLblFont);
		lblCategory.setHorizontalAlignment(SwingConstants.LEFT);
		lblCategory.setFont(smlLblFont);
		
		txtFoodName.setColumns(10); 
	}
	private void initializeController(){
		control = new CalController(frame);
		control.setScrollPanes(dinnerScrollPane, snacksScrollPane,breakfastScrollPane ,lunchScrollPane);
		control.setTextAreas(CaloriePane, txtFoodName);
		control.setComboBox(comboBox);
		control.setSlider(calorieSlider);
		control.setSubmitButton(btnSubmit);
		
	}
	

}
