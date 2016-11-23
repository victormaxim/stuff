package telacad;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class FereastraAd extends JFrame implements SubiectProdus{


	private static final long serialVersionUID = 1L;
	JPanel p1 = new JPanel(new FlowLayout(FlowLayout.LEFT));
	JPanel p2 = new JPanel(new FlowLayout(FlowLayout.LEFT));
	JPanel p3 = new JPanel(new FlowLayout(FlowLayout.LEFT));

	JLabel l1 = new JLabel("Nume: ");
	JLabel l2 = new JLabel("Pret: ");

	JTextField t1 = new JTextField(10);
	JTextField t2 = new JTextField(10);

	JButton b = new JButton("Adauga produs");

	public FereastraAd() {
		super("FereastraAd");

		setLayout(new GridLayout(3, 1));
		add(p1);
		add(p2);
		add(p3);

		p1.add(l1);
		p1.add(t1);
		p2.add(l2);
		p2.add(t2);
		p3.add(b);

		b.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent ev) {
				
				Magazin m = Magazin.getInstance();

				String nume = t1.getText();
				double pret = Double.parseDouble(t2.getText());
				m.adaugaProdus(new Produs(nume, pret));
				notifica();
				dispose();
			}
		}

		);
		pack();
		setSize(200,200);
		setResizable(true);
		setVisible(true);
	}

	public void addProdusListener(ProdusListener o){

		obs.add(o);
			}
	
	public void notifica(){
		
		for(ProdusListener o: obs){
			o.produsAdaugat();
			System.out.println("notified");
		}
	}
	
}
