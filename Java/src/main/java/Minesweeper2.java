import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

@SuppressWarnings("serial")
public class Minesweeper2 extends JFrame implements ActionListener {

	Icon ico1 = new ImageIcon("mine.jpg");
	Icon ico2 = new ImageIcon("flag.png");
	Icon ico4 = new ImageIcon("mine.png");

	Icon ico3 = new ImageIcon("mine.jpg");
	int[][] m = new int[12][12];
	boolean bomb = true;
int ceas = 0;
	static int sec =0;
	JButton[][] b = new JButton[10][10];
	JPanel p1 = new JPanel();
	JButton newgame = new JButton(ico1);
	JButton r = new JButton(ico1);

int disc = 0;

	
	
	JPanel p2 = new JPanel(new GridLayout(10, 10));
	static JLabel timp = new JLabel();

	
	public Minesweeper2() {
		super("Mine");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		add(p1, BorderLayout.NORTH);
		add(p2);
		p1.add(timp);
		p1.add(newgame);
		p1.add(r);
		

		initializare();
		generare();
		count();

		//genereaza 10x10 butoane b[][] si le adauga pe panoul p2
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				//b[i][j] = new JButton(m[i+1][j+1]+"");
				b[i][j] = new JButton();
				b[i][j].addActionListener(this);
				
				
				
				// if(m[i+1][j+1]==-1)b[i][j].setBackground(Color.RED);
				p2.add(b[i][j]);
			}
		}

		newgame.addActionListener(new ActionListener() {public void actionPerformed(ActionEvent ev) {
				newGame();
			}
		});

		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
		b[i][j].addMouseListener
		(new MouseAdapter() {
				public void mouseClicked(MouseEvent ev) {
					 if (SwingUtilities.isRightMouseButton(ev)){
			                System.out.println("Right Worked");
			               
			         punesteagu(ev);       
					 }
					}
				}
		);
			}}
		
		
		
		
		r.addActionListener(

		new ActionListener() {
			public void actionPerformed(ActionEvent ev) {
				if (bomb) {
					r.setIcon(ico2);
				} else {
					r.setIcon(ico4);
				}

				bomb = !bomb;
				System.out.println(bomb);
			}

		}

		);

		setSize(500, 500);
		setResizable(false);
		setVisible(true);

	}

	// genereaza harta cu bordura (12 x 12)
	public void initializare() {

		for (int i = 0; i < 12; i++) {
			for (int j = 0; j < 12; j++) {
				m[i][j] = 0;
			}
		}
	}

	// genereaza 20 de bombe pozitionate intre 1x1 - 11x11 (in m=12x12)
	public void generare() {

		Random r = new Random();
		for (int i = 0; i < 20; i++) {
			int x = r.nextInt(10) + 1;
			int y = r.nextInt(10) + 1;
			// daca e deja pusa o bomba in zona x,y, da inapoi un pas si
			// genereaza o noua pozitie
			if (m[x][y] == -1)
				i--;
			else
				m[x][y] = -1;
		}

	}

	//numara minele din jur. parcurge m 1..11 si numara cate -1(bombe) are in jur
	public void count() {
		for (int i = 1; i < 11; i++) {
			for (int j = 1; j < 11; j++) {
				if (m[i][j] != -1) {
					if (m[i - 1][j - 1] == -1)	m[i][j]++;
					if (m[i - 1][j] == -1)		m[i][j]++;
					if (m[i - 1][j + 1] == -1)	m[i][j]++;
					if (m[i][j - 1] == -1)		m[i][j]++;

					if (m[i][j + 1] == -1)		m[i][j]++;
					if (m[i + 1][j - 1] == -1)	m[i][j]++;
					if (m[i + 1][j] == -1)		m[i][j]++;
					if (m[i + 1][j + 1] == -1)	m[i][j]++;

				}
			}
		}

	}

	// actiune pe butoanele din harta
	public void actionPerformed(ActionEvent ev) {
		JButton bx = (JButton) ev.getSource();
		if(ceas ==0){startceas();}
		ceas++;
				
		
		
		
		System.out.println(b[0][0].getIcon());
		if (bomb) {
			// bx.setBackground(null);
			bx.setIcon(null);
			for (int i = 0; i < 10; i++)
				for (int j = 0; j < 10; j++) {
					
					
					
					if (bx == b[i][j]) {
						
						
						
						//System.out.println(m[i + 1][j + 1]);
						//System.out.println(i + " " + j);

						if (m[i + 1][j + 1] == -1) {
							gameOver();
						}

						else {
							bx.setText(m[i + 1][j + 1] + "");
							bx.setEnabled(false);
							//System.out.println(i + " " + j);
							try {
								if (m[i + 1][j + 2] > -1){
									b[i][j + 1].setEnabled(false);
									b[i][j+1].setText(m[i+1][j+2]+"");}
									
								if (m[i + 1][j] > -1){
									b[i][j - 1].setEnabled(false);
									b[i][j-1].setText(m[i+1][j]+"");}
									
								if (m[i + 2][j + 2] > -1){
									b[i + 1][j + 1].setEnabled(false);
									b[i+1][j+1].setText(m[i+2][j+2]+"");} 
									
								if (m[i + 2][j] > -1){
									b[i + 1][j - 1].setEnabled(false);
									b[i+1][j-1].setText(m[i+2][j]+"");}

								if (m[i + 2][j + 1] >-1){
									b[i + 1][j].setEnabled(false);
									b[i+1][j].setText(m[i+2][j+1]+"");}
									
								if (m[i][j + 1] >-1){
									b[i - 1][j].setEnabled(false);
									b[i-1][j].setText(m[i][j+1]+"");}
									
								if (m[i][j + 2] >-1){
									b[i - 1][j + 1].setEnabled(false);
									b[i-1][j+1].setText(m[i][j+2]+"");}
									
								if (m[i + 2][j] >-1){
									b[i + 1][j - 1].setEnabled(false);
									b[i+1][j-1].setText(m[i+2][j]+"");}
									
								if (m[i][j] > -1){
									b[i - 1][j - 1].setEnabled(false);
									b[i-1][j-1].setText(m[i][j]+"");}
							} catch (Exception e) {
							}
							
							
							
							
						}
					}
				}
		} else {
			// bx.setBackground(Color.RED);
			String iconi = "";
			iconi = String.valueOf(bx.getIcon());
			
			if(iconi.equals("flag.png")){
				bx.setIcon(null);	
				
				for (int i = 0; i < 10; i++){
					for (int j = 0; j < 10; j++) {
						
												
						if (bx == b[i][j]) {
							
				if (m[i + 1][j + 1] == -1) {
					
					disc--;
					System.out.println("Mines to discover: " + (20-disc));}}}}
				
						}
			else{
				bx.setIcon(ico2);
				
				for (int i = 0; i < 10; i++){
					for (int j = 0; j < 10; j++) {
						
												
						if (bx == b[i][j]) {
							
				if (m[i + 1][j + 1] == -1) {
					
					disc++;
					System.out.println("Mines to discover: " + (20-disc));}}}}
				
				
			}
			
			
			
			//System.out.println("-" + iconi + "-");
			
			//if(iconi.equals("flag.png")){System.out.println("buum!");}
			
			
if((20-disc) ==1){
	JOptionPane.showMessageDialog(null, "MineSweeper", "1 more mine to go!",
			JOptionPane.INFORMATION_MESSAGE);
				}
				
				if((20-disc) ==0){
					JOptionPane.showMessageDialog(null, "MineSweeper", "You've won!!!",
							JOptionPane.INFORMATION_MESSAGE);
					
				}
			}
		}
				

	public void punesteagu(MouseEvent ev){
		 JButton bx = (JButton) ev.getSource();
		String iconi = "";
		iconi = String.valueOf(bx.getIcon());
		
		if(iconi.equals("flag.png")){
			bx.setIcon(null);	
			
			for (int i = 0; i < 10; i++){
				for (int j = 0; j < 10; j++) {
					
											
					if (bx == b[i][j]) {
						
			if (m[i + 1][j + 1] == -1) {
				
				disc--;
				System.out.println("Mines to discover: " + (20-disc));}}}}
			
					}
		else{
			bx.setIcon(ico2);
			
			for (int i = 0; i < 10; i++){
				for (int j = 0; j < 10; j++) {
					
											
					if (bx == b[i][j]) {
						
			if (m[i + 1][j + 1] == -1) {
				
				disc++;
				System.out.println("Mines to discover: " + (20-disc));}}}}
			
		
			if((20-disc) ==1){
				JOptionPane.showMessageDialog(null, "MineSweeper", "1 more mine to go!",
						JOptionPane.INFORMATION_MESSAGE);
							}
							
							if((20-disc) ==0){
								JOptionPane.showMessageDialog(null, "MineSweeper", "You've won!!!",
										JOptionPane.INFORMATION_MESSAGE);
								
							}
						}
		
		}
			
		
		
	
	
	
	public void dezactivareButoane() {
		for (int i = 0; i < 10; i++)
			for (int j = 0; j < 10; j++) {
				b[i][j].setEnabled(false);
			}
	}

	public void activareButoane() {
		for (int i = 0; i < 10; i++)
			for (int j = 0; j < 10; j++) {
				b[i][j].setEnabled(true);
			}
	}

	public void afisareMine() {
		for (int i = 0; i < 10; i++)
			for (int j = 0; j < 10; j++) {
				if (m[i + 1][j + 1] == -1)
					b[i][j].setIcon(ico3);
			}

	}

	public void gameOver() {
		ceas=0;
		dezactivareButoane();
		afisareMine();
		JOptionPane.showMessageDialog(null, "Game Over", "Game Over",
				JOptionPane.INFORMATION_MESSAGE);

	}

	public void restart() {
		ceas = 0;
		sec = 0;
		disc=0;
		timp.setText("0");
		for (int i = 0; i < 10; i++)
			for (int j = 0; j < 10; j++) {
				b[i][j].setText("");
				b[i][j].setIcon(null);

			}

	}

	public void newGame() {
		restart();
		activareButoane();
		initializare();
		generare();
		count();

	}

	
	
	public static void main(String[] args) {
		new Minesweeper();
			
	}
	
	
	public void startceas(){
		
		
			//ceas = false;
		new Thread(){
			public void run(){
			
				while(ceas>0)
		try{
		Thread.sleep(1000);
			sec++;
			timp.setText(sec+"");
			
		}
			
		catch(Exception e){}
			}
			
		}.start();
		

		
	}
	
}



		
	



