import java.applet.Applet;
import java.awt.Button;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class ClockApplet extends Applet implements ActionListener, Runnable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Thread t, t1;
	public Button but = new Button("Buton 1");
	public int count = 0;
	
	public void init(){
		t = new Thread(this);
		t.start();
		add(but);
		but.addActionListener(this);
	}
	/*
	public void start() {
		add(but);
		// but.addActionListener(this);
	}
*/
	public void run() {
		t1 = Thread.currentThread();
		while (count < 10) {
			repaint();
			try {
				t1.sleep(1000);
				count++;
			} catch (InterruptedException e) {
			}
		}
	}

	public void paint(Graphics g) {

		Calendar cal = new GregorianCalendar();
		String hour = String.valueOf(cal.get(Calendar.HOUR));
		String minute = String.valueOf(cal.get(Calendar.MINUTE));
		String second = String.valueOf(cal.get(Calendar.SECOND));
		g.drawString(hour + ":" + minute + ":" + second, 20, 30);
		but.setLabel("----y" + second);
		
	}

	public void actionPerformed(ActionEvent ev) {
		but.setLabel("PRESSED");
	}

}