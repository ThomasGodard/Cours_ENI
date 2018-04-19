package fr.eni.papeterie.ihm;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class PanelBouttons extends JPanel {

	public interface PanelBouttonsListener {
		public void onClic(int noBtn);
	}
	
	private PanelBouttonsListener pListener;
	private static final int BTN_BACK = 1;
	private static final int BTN_NEW = 2;
	private static final int BTN_SAVE = 3;
	private static final int BTN_DEL = 4;
	private static final int BTN_FORW = 5;
	
	private JButton btnBack;
	private JButton btnDel;
	private JButton btnForw;
	private JButton btnNew;
	private JButton btnSave;
	
	public PanelBouttons(PanelBouttonsListener pListener) {
		this.pListener = pListener;
		add(getBtnBack());
		add(getBtnNew());
		add(getBtnSave());
		add(getBtnDel());
		add(getBtnForw());
	}

	private JButton getBtnBack() {
		if ( btnBack == null ) {
			btnBack = new JButton(new ImageIcon("Back24.gif"));
			btnBack.addActionListener((e) -> pListener.onClic(BTN_BACK));
		}
		return btnBack;
	}

	private JButton getBtnDel() {
		if ( btnDel == null ) {
			btnDel = new JButton(new ImageIcon("Delete24.gif")); 
			btnDel.addActionListener((e) -> pListener.onClic(BTN_DEL));
		}
		return btnDel;
	}

	private JButton getBtnForw() {
		if ( btnForw == null ) {
			btnForw = new JButton(new ImageIcon("Forward24.gif")); 
			btnForw.addActionListener((e) -> pListener.onClic(BTN_FORW));
		}
		return btnForw;
	}

	private JButton getBtnNew() {
		if ( btnNew == null ) {
			btnNew = new JButton(new ImageIcon("New24.gif")); 
			btnNew.addActionListener((e) -> pListener.onClic(BTN_NEW));
		}
		return btnNew;
	}

	private JButton getBtnSave() {
		if ( btnSave == null ) {
			btnSave = new JButton(new ImageIcon("Save24.gif")); 
			btnSave.addActionListener((e) -> pListener.onClic(BTN_SAVE));
		}
		return btnSave;
	}
}
