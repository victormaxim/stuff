import java.applet.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Butoane extends Applet implements ActionListener
{

public Button b1 = new Button("Buton 1");
public Button b2 = new Button("Buton 2");

public void init(){
    add(b1);
    add(b2);
    b1.addActionListener(this);
}

public void blink(){
for (int i=0;i<300;i++){

}

}


public void actionPerformed(ActionEvent ev){
b1.setLabel("PRESSED");
}

}
