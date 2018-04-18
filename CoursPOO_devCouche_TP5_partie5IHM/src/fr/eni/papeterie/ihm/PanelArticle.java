package fr.eni.papeterie.ihm;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class PanelArticle extends JPanel{

	
	private JLabel lblRef;
	private JTextField txtRef;
	private JLabel lblDes;
	private JTextField txtDes;
	private JLabel lblMarq;
	private JTextField txtMarq;
	private JLabel lblStock;
	private JTextField txtStock;
	private JLabel lblPrix;
	private JTextField txtPrix;
	private JLabel lblType;
	private JPanel zoneRbType;
	private JRadioButton rbRamette;
	private JRadioButton rbStylo;
	private JLabel lblGram;
	private JPanel zoneCbGram;
	private JCheckBox cbGram80;
	private JCheckBox cbGram100;
	private JLabel lblCouleur;
	private JComboBox<String> cmboCouleur;
	
	public PanelArticle() {
		setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		//gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridy = 0;
		gbc.gridx = 0;
		add(getLblRef(), gbc);
		
		gbc.gridx = 1;
		add(getTxtRef(), gbc);
		
		gbc.gridy = 1;
		gbc.gridx = 0;
		add(getLblDes(), gbc);
		
		gbc.gridx = 1;
		add(getTxtDes(), gbc);
		
		gbc.gridy = 2;
		gbc.gridx = 0;
		add(getLblMarq(), gbc);
		
		gbc.gridx = 1;
		add(getTxtMarq(), gbc);
		
		gbc.gridy = 3;
		gbc.gridx = 0;
		add(getLblStock(), gbc);
		
		gbc.gridx = 1;
		add(getTxtStock(), gbc);
		
		gbc.gridy = 4;
		gbc.gridx = 0;
		add(getLblPrix(), gbc);
		
		gbc.gridx = 1;
		add(getTxtPrix(), gbc);
		
		gbc.gridy = 5;
		gbc.gridx = 0;
		add(getLblType(), gbc);
		
		gbc.gridx = 1;
		add(getZoneRbType(), gbc);
		
		gbc.gridy = 6;
		gbc.gridx = 0;
		add(getLblGram(), gbc);
		
		gbc.gridx = 1;
		add(getZoneCbGram(), gbc);
		
		gbc.gridy = 7;
		gbc.gridx = 0;
		add(getLblCouleur(), gbc);
		
		gbc.gridx = 1;
		add(getCmboCouleur(), gbc);
	}

	private JLabel getLblRef() {
		if ( lblRef == null ) {
			lblRef = new JLabel("Référence");
		}
		return lblRef;
	}

	private JTextField getTxtRef() {
		if ( txtRef == null ) {
			txtRef = new JTextField(18);
		}
		return txtRef;
	}

	private JLabel getLblDes() {
		if ( lblDes == null ) {
			lblDes = new JLabel("Désignation");
		}
		return lblDes;
	}

	private JTextField getTxtDes() {
		if ( txtDes == null ) {
			txtDes = new JTextField(18);
		}
		return txtDes;
	}

	private JLabel getLblMarq() {
		if ( lblMarq == null ) {
			lblMarq = new JLabel("Marque");
		}
		return lblMarq;
	}

	private JTextField getTxtMarq() {
		if ( txtMarq == null ) {
			txtMarq = new JTextField(18);
		}
		return txtMarq;
	}

	private JLabel getLblStock() {
		if ( lblStock == null ) {
			lblStock = new JLabel("Stock");
		}
		return lblStock;
	}

	private JTextField getTxtStock() {
		if ( txtStock == null ) {
			txtStock = new JTextField(18);
		}
		return txtStock;
	}

	private JLabel getLblPrix() {
		if ( lblPrix == null ) {
			lblPrix = new JLabel("Prix");
		}
		return lblPrix;
	}

	private JTextField getTxtPrix() {
		if ( txtPrix == null ) {
			txtPrix = new JTextField(18);
		}
		return txtPrix;
	}

	private JLabel getLblType() {
		if ( lblType == null ) {
			lblType = new JLabel("Type");
		}
		return lblType;
	}

	private JPanel getZoneRbType() {
		if ( zoneRbType == null ) {
			zoneRbType =  new JPanel();
			zoneRbType.setLayout(new BoxLayout(zoneRbType, BoxLayout.Y_AXIS));
			
			ButtonGroup groupeType = new ButtonGroup();
			groupeType.add(getRbRamette());
			groupeType.add(getRbStylo());
			
			zoneRbType.add(getRbRamette());
			zoneRbType.add(getRbStylo());
		}
		return zoneRbType;
	}

	private JRadioButton getRbRamette() {
		if ( rbRamette == null) {
			rbRamette = new JRadioButton("Ramette");
			rbRamette.addActionListener((e) -> {
				if(isEnabled()) {
					getCbGram80().setEnabled(true);
					getCbGram100().setEnabled(true);
					getCmboCouleur().setEnabled(false);
				}
			});
		}
		return rbRamette;
	}
	
	private JRadioButton getRbStylo() {
		if ( rbStylo == null ) {
			rbStylo = new JRadioButton("Stylo");
			rbStylo.addActionListener((e) -> {
				if (isEnabled()) {
					getCbGram80().setEnabled(false);
					getCbGram100().setEnabled(false);
					getCmboCouleur().setEnabled(true);
				}
			});
		}
		return rbStylo;
	}

	private JLabel getLblGram() {
		if ( lblGram == null ) {
			lblGram = new JLabel("Grammage");
		}
		return lblGram;
	}

	private JPanel getZoneCbGram() {
		if ( zoneCbGram == null ) {
			zoneCbGram = new JPanel();
			zoneCbGram.setLayout(new BoxLayout(zoneCbGram, BoxLayout.Y_AXIS));

			ButtonGroup groupeGram = new ButtonGroup();
			groupeGram.add(getCbGram80());
			groupeGram.add(getCbGram100());
			
			zoneCbGram.add(getCbGram80());
			zoneCbGram.add(getCbGram100());
		}
		return zoneCbGram;
	}

	private JCheckBox getCbGram80() {
		if ( cbGram80 == null ) {
			cbGram80 = new JCheckBox("80 grammes");
		}
		return cbGram80;
	}

	private JCheckBox getCbGram100() {
		if ( cbGram100 == null ) {
			cbGram100 = new JCheckBox("100 grammes");
		}
		return cbGram100;
	}

	private JLabel getLblCouleur() {
		if ( lblCouleur == null ) {
			lblCouleur = new JLabel("Couleur");
		}
		return lblCouleur;
	}

	private JComboBox<String> getCmboCouleur() {
		if ( cmboCouleur == null) {
			String couleurs[] = {"jaune", "bleu", "vert", "rouge", "noir", "violet", "rose"};
			
			cmboCouleur = new JComboBox<String>(couleurs);
		}
		return cmboCouleur;
	}
	
	
}
