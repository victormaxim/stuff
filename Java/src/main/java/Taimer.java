import java.applet.Applet;
import java.awt.Button;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

@SuppressWarnings("serial")
public class Taimer extends Applet implements ActionListener, Runnable {
	
	//private static final long serialVersionUID = 1L;
	Thread t;
	public Button but = new Button("Buton 1");
	public int count = 0;
	public Panel p = new Panel();
	
	
	public void init(){
		add(p);
		
		t = new Thread(this);
		t.start();
		
		add(but);
		
		but.addActionListener(this);
		p.addMouseMotionListener(
				new MouseAdapter(){
					public void mouseMoved(MouseEvent ev){
						System.out.println(ev.getX());
					}
					
				}
				);
		
		
	}
	
	public void run() {
	
		while (count < 25) {
			
			try {
				Thread.sleep(200);
				count++;
				repaint();
				but.setLabel("----" + count);
				
				if(count >= 25){count=0;};
			}
			catch (InterruptedException e) {}
		}
		
	}

	public void paint(Graphics g) {

		but.setLabel("----" + count);
		 //g.drawRect(0,0,200,100);
	     /*switch(count)
	     {
	     case 1:g.setColor(Color.red);break;
	     case 2:g.setColor(Color.orange);break;
	     case 3:g.setColor(Color.yellow);break;
	     case 4:g.setColor(Color.blue);break;
	     }
	     */
		 int gren = (int) (count*count/2.5);
	     g.setColor(new Color(count * 10, gren,100 + count*5));
	     g.fillRect( count*3 ,count, 200, 100 );
	      
		
	}

	public void actionPerformed(ActionEvent ev) {
		but.setLabel("PRESSED");
		count=0;
		repaint();
	}

}