import java.awt.FlowLayout;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;


@SuppressWarnings("serial")
public class Gui extends JFrame{
	private JButton reg;
	
	public Gui(){
		super("Titlu");
		setLayout(new FlowLayout());
		
		
	Icon b = new ImageIcon(getClass().getResource("resources/images/rocket_landed.png"));
	Icon x = new ImageIcon(getClass().getResource("resources/images/rocket.png"));
	
	reg = new JButton("Butonu",b);
	reg.setRolloverIcon(x);
	add(reg);
	
	}

}
