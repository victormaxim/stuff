import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;

public class Adauga extends JFrame{
    DefaultListModel<Angajat> model = new DefaultListModel<Angajat>();
    JList<Angajat> list = new JList<Angajat>(model);
    JScrollPane jsp = new JScrollPane(list);

    JPanel p1 = new JPanel(new BorderLayout());
    JPanel p2 = new JPanel(new FlowLayout(FlowLayout.LEFT));

    JLabel nume = new JLabel("Nume: ");
    JTextField t1 = new JTextField(10);

    JLabel prenume = new JLabel("Prenume: ");
    JTextField t2 = new JTextField(10);

    JLabel cnp = new JLabel("CNP: ");
    JTextField t3 = new JTextField(10);

    JButton b = new JButton("Adauga");



    ArrayList<Angajat> angajati = new ArrayList<Angajat>();

    public Adauga(){
        super("Adauga");
      
        add(p1);
        add(p2, BorderLayout.NORTH);

        p2.add(nume);
        p2.add(t1);
        p2.add(prenume);
        p2.add(t2);
        p2.add(cnp);
        p2.add(t3);
        p2.add(b);
        
                 
        
        
        
        b.addActionListener(
            new ActionListener(){
                public void actionPerformed(ActionEvent ev){
                    String nume = t1.getText();
                    String prenume = t2.getText();
                    String cnp = t3.getText();
                    Angajat anga = new Angajat(nume,prenume,cnp);
                    angajati.add(anga);
                    Fereastra.model.addElement(anga);
                    t1.setText("");
                    t2.setText("");
                    t3.setText("");
                  
                    dispose();
                    
                    
                    

                }
            });
        setSize(900,200);
        setVisible(true);

    }
   
    
    

}
