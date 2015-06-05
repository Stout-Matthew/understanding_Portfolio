package understand_portfolio;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JSplitPane;
import java.awt.BorderLayout;
import net.miginfocom.swing.MigLayout;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JFormattedTextField;
import javax.swing.JScrollBar;
import javax.swing.JSlider;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JTextArea;

public class calorie_counter_program {

	private JFrame frame;
	private JTextField txtfood_name;
	private JTextField txtCalories;
	private JTextField txtCategory;
	private JLabel lblFoodDatabase;
	private JTextArea display_food;
	private Hibernate_food_interface hbInt;
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					calorie_counter_program window = new calorie_counter_program();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public calorie_counter_program() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		// use the windows builder built into Eclipse for this part.
		//
		frame = new JFrame();
		frame.setBounds(100, 100, 776, 621);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.getContentPane().setLayout(new MigLayout("", "[grow 20][::40,grow 20][::40,grow 20][45:45:45,grow][::45][::45,grow 0][::45][grow 20][grow 20][grow][grow 20][grow 20][grow 20][grow 20][grow 20][grow 20][grow 20][grow 20][grow 20][grow 20][grow 20][grow 20]", "[grow][grow][grow][grow][grow][grow][grow][grow][grow][grow][grow][grow][grow][grow][][][][][][grow]"));
		
		lblFoodDatabase = new JLabel("Food Database");
		lblFoodDatabase.setFont(new Font("Papyrus", Font.BOLD, 22));
		frame.getContentPane().add(lblFoodDatabase, "cell 0 0 22 2,alignx center");
		
		JLabel lblFoodName = new JLabel("Food Name");
		frame.getContentPane().add(lblFoodName, "cell 1 5 2 1");
		
		txtfood_name = new JTextField();
		frame.getContentPane().add(txtfood_name, "cell 3 5 3 1,growx");
		txtfood_name.setColumns(10);
		
		display_food = new JTextArea();
		frame.getContentPane().add(display_food, "cell 9 5 12 13,grow");
		
		JLabel lblCalories = new JLabel("Calories");
		frame.getContentPane().add(lblCalories, "cell 1 6 2 1");
		
		txtCalories = new JTextField();
		frame.getContentPane().add(txtCalories, "cell 3 6,growx");
		txtCalories.setColumns(10);
		
		JLabel lblCategory = new JLabel("Category");
		frame.getContentPane().add(lblCategory, "cell 1 7 2 1");
		
		txtCategory = new JTextField();
		frame.getContentPane().add(txtCategory, "cell 3 7 3 1,growx");
		txtCategory.setColumns(10);
		
		JButton btnSubmit = new JButton("Submit");
		frame.getContentPane().add(btnSubmit, "cell 1 9 2 1");
		
//JTextField calories, JTextField category, JTextField food_name, JButton submit
		Hibernate_food_interface hbInt = new Hibernate_food_interface(txtCalories,txtCategory, txtfood_name,display_food, btnSubmit );	
		
		
	}

}
