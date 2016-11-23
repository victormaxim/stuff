import java.applet.Applet;
import java.awt.*;

public class Appletu extends Applet
{
    Button but = new Button("Click me");
    Panel p = new Panel();
    TextField tf = new TextField(10);

    public void init(){
        setLayout(new BorderLayout());
        add(p, BorderLayout.SOUTH);
        p.add(but);
        p.add(tf);

    }
    public void paint(Graphics g){
        g.setColor(new Color(250,50,50));
        g.drawOval(100,100,150,50);
    }

}
