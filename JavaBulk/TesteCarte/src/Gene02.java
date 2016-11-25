

	import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JButton;
	@SuppressWarnings("serial")

	public class Gene02 extends JFrame {
	
	public void SimpleFrame() {
	setTitle("Don’t click the button!");
	setLayout(new FlowLayout());
	setDefaultCloseOperation(EXIT_ON_CLOSE);
	add(new JButton("Panic"));
	setSize(300, 100);
	setVisible(true);
	}
	}



	

