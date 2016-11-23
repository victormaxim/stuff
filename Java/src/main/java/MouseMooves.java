import java.applet.Applet;
import java.awt.Button;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Calendar;
import java.util.GregorianCalendar;

@SuppressWarnings("serial")
public class MouseMooves extends Applet{
	
	
	public Panel p = new Panel();
	TextField tf = new TextField(10);
	
	public void init(){
		add(p);
		p.add(tf);
		
		p.addMouseMotionListener(
				new MouseAdapter(){
					public void mouseMoved(MouseEvent ev){
						System.out.println(ev.getX());
						String x = "" + ev.getX();
						tf.setText(x);
						System.out.println("X");
					}
					
				}
				);
		
		
System.out.println("X");
}
}
	
	