package my_socket_io;

import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

class SliderListener implements ChangeListener {
	  
	private CalController c;
	private CalorieSlider v;
		
	public SliderListener(CalController c, CalorieSlider v ){
	
		this.c = c;
		this.v = v;
		
	}
	
	public void stateChanged(ChangeEvent e) {
		JSlider source = (JSlider)e.getSource();
    	
        if (source.getValueIsAdjusting()) {
        	
        	System.out.println(v.getValue());
            
        }    
    }

}