import java.awt.Frame;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;


public class Frames extends Frame implements WindowListener{

	public Frames(){
		addWindowListener(this);
	}
	
	public void WindowClosing(WindowEvent ev){
		System.exit(0);
	}
	
	public void windowActivated(WindowEvent arg0) {}
	
	public void windowClosed(WindowEvent arg0) {}
	
	public void windowClosing(WindowEvent arg0) {}

	public void windowDeactivated(WindowEvent arg0) {}

	public void windowDeiconified(WindowEvent arg0) {}

	public void windowIconified(WindowEvent arg0) {}

	public void windowOpened(WindowEvent arg0) {}
	
}
