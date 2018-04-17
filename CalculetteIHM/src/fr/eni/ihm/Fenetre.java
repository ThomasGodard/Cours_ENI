package fr.eni.ihm;
import java.awt.BorderLayout;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import fr.eni.ihm.PanelButtons.PanelBouttonsListener;


public class Fenetre extends JFrame implements PanelBouttonsListener {

	private JPanel panelGlobal;
	private JLabel lblResult;
	private PanelButtons panelButtonsChiffres;
	private PanelButtons panelButtonsActions;
	
	
	private JPanel getPanelGlobal() {
		if ( this.panelGlobal == null) {
			panelGlobal = new JPanel(new BorderLayout());
			panelGlobal.add(getLblResult(), BorderLayout.NORTH);
			panelGlobal.add(getPanelButtonsChiffres(), BorderLayout.CENTER);
			panelGlobal.add(getPanelButtonsActions(), BorderLayout.EAST);
		}
		return panelGlobal;
	}


	private JLabel getLblResult() {
		if ( lblResult == null ) {
			lblResult = new JLabel("resultat", SwingConstants.RIGHT);
		}
		return lblResult;
	}


	private PanelButtons getPanelButtonsChiffres() {
		if ( panelButtonsChiffres == null ) {
			String chiffres[] = {"1","2","3","4","5","6","7","8","9","0"};
			panelButtonsChiffres = new PanelButtons(chiffres, this);
		}
		return panelButtonsChiffres;
	}


	private PanelButtons getPanelButtonsActions() {
		if( panelButtonsActions == null ) {
			String nomBtnActions[] = {"C", "/", "*", "-", "+", "="};
			panelButtonsActions = new PanelButtons(nomBtnActions, this, BoxLayout.X_AXIS);
		}
		return panelButtonsActions;
	}


	public Fenetre() {

		setBounds(200, 250, 200, 210);
		setTitle("Calculatrice");
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setContentPane(getPanelGlobal());
	}


	@Override
	public void onButonClicked(String msg) {
		System.out.println(msg);
	}
}
