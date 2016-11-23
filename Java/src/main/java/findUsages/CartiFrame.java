package findUsages;

import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class CartiFrame extends javax.swing.JFrame {
    

	JPanel p1 = new JPanel(new FlowLayout(FlowLayout.LEFT));
	JPanel p2 = new JPanel(new FlowLayout(FlowLayout.LEFT));
	JPanel p3 = new JPanel(new FlowLayout(FlowLayout.LEFT));

	JLabel jLabel1 = new JLabel("Nume: ");
	JLabel jLabel2 = new JLabel("Autor: ");
	
	JTextField jTextField1 = new JTextField(10);
	JTextField jTextField2 = new JTextField(10);

	JButton  jButton1 = new JButton("Adauga produs");
	
	
	
	public CartiFrame() {
		setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
		initComponents();

		

    }

    @SuppressWarnings("unchecked")
    private void initComponents() {
    	setLayout(new GridLayout(3, 1));
    	p1.add(jLabel1);
		p1.add(jTextField1);
		p2.add(jLabel1);
		p2.add(jTextField1);
		p3.add(jButton1);
		pack();
		setSize(200,200);
		setResizable(true);
		setVisible(true);

		
		
		jButton1.addActionListener(new java.awt.event.ActionListener() {
	            public void actionPerformed(java.awt.event.ActionEvent evt) {
	                jButton1ActionPerformed(evt);
	            }
	        });
    }
    	
        

       
       

        
        
                             

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        String nume = jTextField1.getText();
        String autor = jTextField2.getText();
        //Biblioteca.getInstance().addCarte(new Carte(nume, autor));
        jTextField1.setText("");
        jTextField2.setText("");
    }                                        


   
}
