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

	
	public FenetreArticle() {
		setLocationRelativeTo(null);
		setSize(335, 315);
		setResizable(false);
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
	
	public JPanel getVueArt() {
		if ( panelArt == null ) {
			panelArt = new PanelArticle();

		}
		return panelArt;
	}
	
	private Component getVueBtn() {
		if ( panelBtn == null ) {
			panelBtn = new PanelBouttons();
		}
		return panelBtn;
	}
	
	
}

