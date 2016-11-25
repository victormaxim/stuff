import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.MenuBar;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.AbstractAction;

import java.awt.event.ActionEvent;

import javax.swing.Action;
import javax.swing.JToggleButton;
import javax.swing.JToolBar;

import java.awt.Component;

import javax.swing.Box;
import javax.swing.JMenuBar;

import java.awt.SystemColor;

import javax.swing.ImageIcon;
import javax.swing.JSlider;

import java.awt.Canvas;


public class Frama extends JFrame {
	private JMenuBar menuBar;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Frama frame = new Frama();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Frama() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
	}

}
