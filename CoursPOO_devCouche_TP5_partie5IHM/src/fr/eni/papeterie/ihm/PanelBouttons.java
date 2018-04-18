package fr.eni.papeterie.ihm;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class PanelBouttons extends JPanel {

	private JButton btnBack;
	private JButton btnDel;
	private JButton btnForw;
	private JButton btnNew;
	private JButton btnSave;
	
	public PanelBouttons() {
		add(getBtnBack());
		add(getBtnNew());
		add(getBtnSave());
		add(getBtnDel());
		add(getBtnForw());
	}

	private JButton getBtnBack() {
		if ( btnBack == null ) {
			btnBack = new JButton(new ImageIcon("Back24.gif")); 
		}
		return btnBack;
	}

	private JButton getBtnDel() {
		if ( btnDel == null ) {
			btnDel = new JButton(new ImageIcon("Delete24.gif")); 
		}
		return btnDel;
	}

	private JButton getBtnForw() {
		if ( btnForw == null ) {
			btnForw = new JButton(new ImageIcon("Forward24.gif")); 
		}
		return btnForw;
	}

	private JButton getBtnNew() {
		if ( btnNew == null ) {
			btnNew = new JButton(new ImageIcon("New24.gif")); 
		}
		return btnNew;
	}

	private JButton getBtnSave() {
		if ( btnSave == null ) {
			btnSave = new JButton(new ImageIcon("Save24.gif")); 
		}
		return btnSave;
	}
}
