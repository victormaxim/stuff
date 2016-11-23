package telacad;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;

public class Fereastra extends JFrame {

	// adauga meniurile
	JMenuBar mb = new JMenuBar();
	JMenu m1 = new JMenu("Optiuni");
	JMenuItem mi1 = new JMenuItem("Adauga produs");
	JMenuItem mi2 = new JMenuItem("Salveaza");
	JMenuItem mi3 = new JMenuItem("Deschide");

	// model pt a lucra cu obiecte si a le pune in liste
	DefaultListModel model = new DefaultListModel();
	JList<Produs> list = new JList<Produs>(model);
	JScrollPane jsp = new JScrollPane(list);

	JPanel p1 = new JPanel(new FlowLayout(FlowLayout.LEFT));
	JLabel nr = new JLabel("Nr produse: 0");

	public Fereastra() {
		super("Magazin");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setJMenuBar(mb);
		mb.add(m1);
		m1.add(mi1);
		m1.addSeparator();
		m1.add(mi2);
		m1.add(mi3);

		add(jsp);
		add(list);
		add(p1, BorderLayout.SOUTH);
		p1.add(nr);

		// actiune pe AdaugaProdus
		mi1.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent ev) {
				// adauga produsListener - obs
				new FereastraAd().addProdusListener(new ProdusListener() {
					public void produsAdaugat() {
						model.clear();
						ArrayList<Produs> produse = Magazin.getInstance()
								.getProduse();
						for (Produs p : produse)
							model.addElement(p);

					}
				});
			}
		}

		);

		mi2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ev) {
				try {
					JFileChooser chooser = new JFileChooser();
					int r = chooser.showSaveDialog(null);

					if (r == JFileChooser.APPROVE_OPTION) {
						File file = chooser.getSelectedFile();
						ObjectOutputStream oos = new ObjectOutputStream(
								new FileOutputStream(file));
						oos.writeObject(Magazin.getInstance());
						oos.close();
					}
				} catch (Exception e) {
				}
			}
		});

		mi3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ev) {
				try {
					JFileChooser chooser = new JFileChooser();
					int r = chooser.showOpenDialog(null);

					if (r == JFileChooser.APPROVE_OPTION) {
						File file = chooser.getSelectedFile();
						ObjectInputStream oos = new ObjectInputStream(
								new FileInputStream(file));

						Magazin m = (Magazin) oos.readObject();
						Magazin.setInstance(m);
						oos.close();
						model.clear();
						ArrayList<Produs> produse = Magazin.getInstance()
								.getProduse();
						for (Produs pr : produse)
							model.addElement(pr);

					}
				} catch (Exception e) {
				}
			}
		});

		// timer care sa refresheze nr produse
		new Thread() {
			public void run() {
				try {
					while (true) {
						Thread.sleep(1500);
						nr.setText("Nr. produse: "
								+ Magazin.getInstance().getProduse().size());
					}
				} catch (Exception e) {
				}
			}

		}.start();

		list.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent ev) {
				if(SwingUtilities.isRightMouseButton(ev))
				{System.out.println("uuu");}
				if (ev.getClickCount() == 2) {
					Produs p = (Produs) list.getSelectedValue();
					Magazin.getInstance().removeProdus(p);
					model.clear();
					ArrayList<Produs> produse = Magazin.getInstance()
							.getProduse();
					for (Produs pr : produse)
						model.addElement(pr);

				}
			}
		});

		setSize(700, 400);
		setVisible(true);
	}

}
