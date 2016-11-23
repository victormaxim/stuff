package jFrames;

import javax.swing.*;
import java.awt.*;


public class Fereastra2 extends JFrame{
Icon ico = new ImageIcon("m.jpg");

JButton b = new JButton();

public Fereastra2(){
setLayout(new FlowLayout());
add(b);
setVisible(true);
pack();
setLocation(300,300);

}

public static void main(String[]  args){
new Fereastra2();
}

}