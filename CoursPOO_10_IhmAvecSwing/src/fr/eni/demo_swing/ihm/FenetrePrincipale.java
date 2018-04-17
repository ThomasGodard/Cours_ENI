package fr.eni.demo_swing.ihm;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.TextField;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

import fr.eni.demo_swing.ihm.PanelButtons.PanelButtonsListener;

public class FenetrePrincipale extends JFrame implements PanelButtonsListener {

	private JPanel panelGlobal;
	
	private PanelButtons panelButtons;
	
	private JLabel lblTitre;
	
	private JPanel panelFormulaire;
	private JLabel lblNumeroStagiaire;
	private JLabel lblNomStagiaire;
	private JLabel lblPrenomStagiaire;
	private TextField txtNomStagiaire;
	private TextField txtPrenomStagiaire;
	
	public FenetrePrincipale() {
		setSize(300, 300);
		setLocation(200, 200);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("Stagiaire");
		
		setContentPane(getPanelGlobal());
		
		applyLookAndFeel();
	}
	
	private void applyLookAndFeel() {
		String look = "com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel";
		//look = "javax.swing.plaf.metal.MetalLookAndFeel";
		
		try {
			UIManager.setLookAndFeel(look);
			SwingUtilities.updateComponentTreeUI(this.getContentPane());
		} catch (Exception e) {
			e.printStackTrace();
		}
	
	
	}

	public JPanel getPanelGlobal() {
		if(panelGlobal == null) {
			panelGlobal = new JPanel(new BorderLayout());
			
			panelGlobal.add(getLblTitre(), BorderLayout.NORTH);
			panelGlobal.add(getPanelFormulaire(), BorderLayout.CENTER);
			panelGlobal.add(getPanelButtons(), BorderLayout.SOUTH);
		}
		return panelGlobal;
	}

	private PanelButtons getPanelButtons() {
		if(panelButtons == null) {
			panelButtons = new PanelButtons(this);
		}
		return panelButtons;
	}

	private JPanel getPanelFormulaire() {
		if(panelFormulaire == null) {
			panelFormulaire = new JPanel(new GridBagLayout());
			
			GridBagConstraints gbc = new GridBagConstraints();
			gbc.gridx = 0;
			gbc.gridy = 0;
			panelFormulaire.add(getLblNumeroStagiaire(), gbc);
			
			gbc.gridy = 1;
			panelFormulaire.add(getLblNomStagiaire(), gbc);
			
			gbc.gridx = 1;
			panelFormulaire.add(getTxtNomStagiaire(), gbc);
			
			gbc.gridx = 0;
			gbc.gridy = 2;
			panelFormulaire.add(getLblPrenomStagiaire(), gbc);
			
			gbc.gridx = 1;
			panelFormulaire.add(getTxtPrenomStagiaire(), gbc);
		}
		return panelFormulaire;
	}

	private JLabel getLblNumeroStagiaire() {
		if(lblNumeroStagiaire == null) {
			lblNumeroStagiaire = new JLabel("Stagiaire n°");
		}
		return lblNumeroStagiaire;
	}

	private JLabel getLblNomStagiaire() {
		if(lblNomStagiaire == null) {
			lblNomStagiaire = new JLabel("Nom :");
		}
		return lblNomStagiaire;
	}

	private JLabel getLblPrenomStagiaire() {
		if(lblPrenomStagiaire == null) {
			lblPrenomStagiaire = new JLabel("Prénom :");
		}
		return lblPrenomStagiaire;
	}

	private TextField getTxtNomStagiaire() {
		if(txtNomStagiaire == null) {
			txtNomStagiaire = new TextField(30);
		}
		return txtNomStagiaire;
	}

	private TextField getTxtPrenomStagiaire() {
		if(txtPrenomStagiaire == null) {
			txtPrenomStagiaire = new TextField(30);
		}
		return txtPrenomStagiaire;
	}

	private JLabel getLblTitre() {
		if(lblTitre == null) {
			lblTitre = new JLabel("SUPER TITRE !!");
		}
		return lblTitre;
	}
	
	private void updateTitre(String titre) {
		getLblTitre().setText(titre);
	}

	@Override
	public void onButtonClicked(String msg) {
		updateTitre(msg);
		System.out.println(msg);
	}
	
}
