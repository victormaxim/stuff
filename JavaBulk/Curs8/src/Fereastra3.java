import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class Fereastra3 extends JFrame{
	
	int[] v1 = {2,5,3,8,7};
	int[] v2 = {7,4,3,6,5};
	
	JButton[][] b = new JButton[5][5];
	JPanel p1 = new JPanel(new GridLayout(5,5));
	JPanel p2 = new JPanel(new FlowLayout(FlowLayout.LEFT));
	JLabel l1 = new JLabel("SUMA: 0");
	
	public Fereastra3(){
		super("Numere");
		
	}
	
	
}
