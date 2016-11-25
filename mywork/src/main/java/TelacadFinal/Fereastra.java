import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;

public class Fereastra extends JFrame{
    static DefaultListModel<Angajat> model = new DefaultListModel<Angajat>();
    JList<Angajat> list = new JList<Angajat>(model);
    JScrollPane jsp = new JScrollPane(list);

    JPanel p1 = new JPanel(new BorderLayout());
    JPanel p2 = new JPanel(new FlowLayout(FlowLayout.LEFT));

    JMenuBar mb = new JMenuBar();
    JMenu m1 = new JMenu("Optiuni");
    JMenuItem mi1 = new JMenuItem("Adauga");

    ArrayList<Angajat> angajati = new ArrayList<Angajat>();

    public Fereastra(){
        super("Fereastra");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setJMenuBar(mb);
        mb.add(m1);
        m1.add(mi1);
        add(p1);
        add(p2, BorderLayout.SOUTH);
        p1.add(jsp);

        mi1.addActionListener(
            new ActionListener(){
                public void actionPerformed(ActionEvent ev){
                    new Adauga();    
                }
            });
        setSize(900,500);

        setVisible(true);

    }

    public static void main(String[] args){

        new Fereastra();

    }
    

}
