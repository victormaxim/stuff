import java.awt.BorderLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;

import telacad.Magazin;
import telacad.Produs;


public class JListe extends JPanel{

	
	JList list;
	DefaultListModel model;
	
	
	public JListe(){
		
		setLayout(new BorderLayout());
		model = new DefaultListModel();
		list = new JList(model);
		list.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		JScrollPane pane = new JScrollPane(list);
		
		for (int i = 0; i < 15; i++)
		      model.addElement("Element " + i);

	    add(pane, BorderLayout.NORTH);
	    
	    list.addMouseListener(
	    		new MouseAdapter(){
	    			public void mouseClicked(MouseEvent ev){
	    				
	    					System.out.println(list.getSelectedValues());
	    					   					
	    					
	    				
	    			}
	    		}
	    		);
	    
	    
	}
	
	
	public static void main(String[] args) {
		JFrame frame = new JFrame("");	
	frame.setContentPane(new JListe());
	frame.setSize(300, 300);
	frame.setVisible(true);
	
	}
}
