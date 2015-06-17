package my_socket_io;

import javax.swing.*;
import javax.swing.event.*;

public class CalorieSlider extends JSlider {
	
	private CalController c;
	
	static class SliderListener implements ChangeListener {	  
		private CalController c;
		
		public SliderListener(CalController c){	
			this.c = c;	
			
			
		}

		public void stateChanged(ChangeEvent e) {
			JSlider source = (JSlider)e.getSource();	    	
	        if (source.getValueIsAdjusting()) {
	        	
	        	c.setCalories(source.getValue());
	        }    
	    }

	}
	public CalorieSlider(int orientation, int min, int max, int value){
		
		this.setOrientation(orientation);
		this.setMaximum(max);
		this.setMinimum(min);
		this.setValue(value);	
		this.setMajorTickSpacing((int)(max/4));
		this.setMinorTickSpacing((int)(max/10));
		this.setPaintTicks(true);
		this.setPaintLabels(true);
	}
	public void setC(CalController c){
		
		this.c = c;
		this.addChangeListener(new SliderListener(c));
	
	}
	
	
	
	
	
}
