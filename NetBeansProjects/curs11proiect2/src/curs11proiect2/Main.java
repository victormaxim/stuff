package curs11proiect2;

import gui.MainFrame;

public class Main {
    
    public static void main (String args[]){
    
    java.awt.EventQueue.invokeLater(new Runnable(){
    
public void run(){
    new MainFrame().setVisible(true);
}
    });
}
       
}
    
