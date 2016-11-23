import java.awt.* ;
import java . applet .*;
import java . awt .*;
import java . awt. event .*;

public class FirstApplet extends Applet {
Image img;
public void init() {
img = getImage(getCodeBase(), "taz.gif");
Button play = new Button (" Play ");
Button loop = new Button (" Loop ");
add(play,10,10);
}

public void paint (Graphics g) {
	for (int n = 1; n < 10; ++n) {
		g.drawImage(img, 0, 0, this);
		
		
	}
	g.drawImage(img, 0, 0, this);
g.drawOval(100,0,150,50);


//g.drawString("Hello! My name is Taz!", 110, 25);

}
}