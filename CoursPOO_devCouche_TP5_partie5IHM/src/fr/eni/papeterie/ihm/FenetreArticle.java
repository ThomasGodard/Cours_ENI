package fr.eni.papeterie.ihm;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class FenetreArticle extends JFrame {

	private JPanel cp;
	private JPanel panelArt;
	private JPanel panelBtn;
	JButton bouton;

	
	public FenetreArticle() {
		setLocationRelativeTo(null);
		setSize(300, 300);
		//setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setContentPane(getCp());
		setVisible(true);
	}
	
	public JPanel getCp() {
		if ( cp == null ) {
			cp = new JPanel(new BorderLayout());
			cp.add(getVueArt(), BorderLayout.NORTH);
			cp.add(getVueBtn(), BorderLayout.SOUTH);
		}
		return cp;
	}
	
	private Component getVueBtn() {
		if ( panelBtn == null ) {
			panelBtn = new JPanel();
			panelBtn.setBackground(Color.blue);
		}
		return panelBtn;
	}

	public JPanel getVueArt() {
		if ( panelArt == null ) {
			panelArt = new PanelArticle();
			panelArt.setBackground(Color.PINK);
		}
		return panelArt;
	}
}

