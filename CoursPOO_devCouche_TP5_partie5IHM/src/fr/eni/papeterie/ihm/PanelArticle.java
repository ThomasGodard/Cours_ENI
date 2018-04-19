package fr.eni.papeterie.ihm;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import fr.eni.papeterie.ihm.PanelBouttons.PanelBouttonsListener;

public class PanelArticle extends JPanel {

	PanelBouttonsListener btnListener;

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

	public PanelArticle(PanelBouttonsListener btnListener) {
		this.btnListener = btnListener;
		setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridy = 0;
		gbc.gridx = 0;
		add(getLblRef(), gbc);
		// équivaut à : addComponent(getLblRef(), this, 0, 0, 1, 1, 0.2);

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
		gbc.fill = GridBagConstraints.NONE;
		add(getZoneRbType(), gbc);

		gbc.gridy = 6;
		gbc.gridx = 0;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		add(getLblGram(), gbc);

		gbc.gridx = 1;
		gbc.fill = GridBagConstraints.NONE;
		add(getZoneCbGram(), gbc);

		gbc.gridy = 7;
		gbc.gridx = 0;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		add(getLblCouleur(), gbc);

		gbc.gridx = 1;
		add(getCmboCouleur(), gbc);
	}
	/*
	@SuppressWarnings("unused")
	private void addComponent(JComponent component, JPanel panel,
			  int x, int y, int width, int height,
			  double weightX) {
		addComponent(component, panel, x, y, width, height, weightX, true);
	}
	
	private void addComponent(JComponent component, JPanel panel,
							  int x, int y, int width, int height,
							  double weightX, boolean fillHorizontal) {
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridx = x;
		gbc.gridy = y;
		gbc.gridwidth = width;
		gbc.gridheight = height;
		gbc.weightx = weightX;
		if(fillHorizontal) {
			gbc.fill = GridBagConstraints.HORIZONTAL;
		}
		gbc.insets = new Insets(7, 10, 5, 10);
		panel.add(component, gbc);
	}
	*/

	private JLabel getLblRef() {
		if (lblRef == null) {
			lblRef = new JLabel("Référence");
		}
		return lblRef;
	}

	public JTextField getTxtRef() {
		if (txtRef == null) {
			txtRef = new JTextField(18);
		}
		return txtRef;
	}

	private JLabel getLblDes() {
		if (lblDes == null) {
			lblDes = new JLabel("Désignation");
		}
		return lblDes;
	}

	private JTextField getTxtDes() {
		if (txtDes == null) {
			txtDes = new JTextField(18);
		}
		return txtDes;
	}

	private JLabel getLblMarq() {
		if (lblMarq == null) {
			lblMarq = new JLabel("Marque");
		}
		return lblMarq;
	}

	private JTextField getTxtMarq() {
		if (txtMarq == null) {
			txtMarq = new JTextField(18);
		}
		return txtMarq;
	}

	private JLabel getLblStock() {
		if (lblStock == null) {
			lblStock = new JLabel("Stock");
		}
		return lblStock;
	}

	private JTextField getTxtStock() {
		if (txtStock == null) {
			txtStock = new JTextField(18);
		}
		return txtStock;
	}

	private JLabel getLblPrix() {
		if (lblPrix == null) {
			lblPrix = new JLabel("Prix");
		}
		return lblPrix;
	}

	private JTextField getTxtPrix() {
		if (txtPrix == null) {
			txtPrix = new JTextField(18);
		}
		return txtPrix;
	}

	private JLabel getLblType() {
		if (lblType == null) {
			lblType = new JLabel("Type");
		}
		return lblType;
	}

	private JPanel getZoneRbType() {
		if (zoneRbType == null) {
			zoneRbType = new JPanel();
			zoneRbType.setLayout(new BoxLayout(zoneRbType, BoxLayout.Y_AXIS));

			ButtonGroup groupeType = new ButtonGroup();
			groupeType.add(getRbRamette());
			groupeType.add(getRbStylo());

			zoneRbType.add(getRbRamette());
			zoneRbType.add(getRbStylo());
		}
		return zoneRbType;
	}
	
	private void setType(boolean isRamette) {
		getLblGram().setEnabled(isRamette);
		getCbGram80().setEnabled(isRamette);
		getCbGram100().setEnabled(isRamette);
		getCmboCouleur().setEnabled(isRamette);
		
		getLblCouleur().setEnabled(!isRamette);
		getCmboCouleur().setEnabled(!isRamette);
	}

	private JRadioButton getRbRamette() {
		if (rbRamette == null) {
			rbRamette = new JRadioButton("Ramette", true);
			rbRamette.addActionListener(e -> setType(true));
		}
		return rbRamette;
	}

	private JRadioButton getRbStylo() {
		if (rbStylo == null) {
			rbStylo = new JRadioButton("Stylo");
			rbStylo.addActionListener(e -> setType(false));
		}
		return rbStylo;
	}

	private JLabel getLblGram() {
		if (lblGram == null) {
			lblGram = new JLabel("Grammage");
		}
		return lblGram;
	}

	private JPanel getZoneCbGram() {
		if (zoneCbGram == null) {
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
		if (cbGram80 == null) {
			cbGram80 = new JCheckBox("80 grammes", true);
		}
		return cbGram80;
	}

	private JCheckBox getCbGram100() {
		if (cbGram100 == null) {
			cbGram100 = new JCheckBox("100 grammes");
		}
		return cbGram100;
	}

	private JLabel getLblCouleur() {
		if (lblCouleur == null) {
			lblCouleur = new JLabel("Couleur");
		}
		return lblCouleur;
	}

	private JComboBox<String> getCmboCouleur() {
		if (cmboCouleur == null) {
			String couleurs[] = { "jaune", "bleu", "vert", "rouge", "noir", "violet", "rose" };

			cmboCouleur = new JComboBox<>(couleurs);
			cmboCouleur.setEnabled(false);
		}
		return cmboCouleur;
	}

}
