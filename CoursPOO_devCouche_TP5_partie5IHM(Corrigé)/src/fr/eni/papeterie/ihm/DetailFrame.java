package fr.eni.papeterie.ihm;

import java.awt.Button;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import fr.eni.papeterie.bll.ArticleNotFoundException;
import fr.eni.papeterie.bll.BLLException;
import fr.eni.papeterie.bll.Catalogue;
import fr.eni.papeterie.bll.ParameterException;
import fr.eni.papeterie.bo.Article;
import fr.eni.papeterie.bo.Ramette;
import fr.eni.papeterie.bo.Stylo;
import fr.eni.papeterie.ihm.ButtonsPanel.ButtonsPanelListener;

public class DetailFrame extends JFrame implements ButtonsPanelListener {

	private JPanel panelForm;
	private JLabel lblReference;
	private JTextField txtReference;
	private JLabel lblDesignation;
	private JTextField txtDesignation;
	private JLabel lblMarque;
	private JTextField txtMarque;
	private JLabel lblStock;
	private JTextField txtStock;
	private JLabel lblPrix;
	private JTextField txtPrix;
	private JLabel lblType;
	private JRadioButton radioRamette;
	private JRadioButton radioStylo;
	private JLabel lblGrammage;
	private JCheckBox chk80;
	private JCheckBox chk100;
	private JLabel lblCouleur;
	private JComboBox<String> cmbCouleur;
	
	private ButtonsPanel panelButtons;
	
	
	private Catalogue catalogue;
	private Article articleCourant;
	
	public DetailFrame() {
		setSize(400, 450);
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		setContentPane(getPanelForm());
		
		try {
			catalogue = new Catalogue();
		} catch (BLLException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(this, "Erreur lors du chargement des données : " + e.getMessage());
		}
		
		try {
			setArticle(catalogue.getArticleCourant());
		} catch (ArticleNotFoundException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(this, "Le catalogue est vide");
		}
		
	}
	
	private void setArticle(Article article) {
		articleCourant = article;
		
		if(article != null) {
			getTxtDesignation().setText(article.getDesignation());
			getTxtMarque().setText(article.getMarque());
			getTxtPrix().setText(String.format("%.2f", article.getPrixUnitaire()).replace(',', '.'));
			getTxtReference().setText(article.getReference());
			getTxtStock().setText(String.valueOf(article.getQteStock()));
			
			if(article instanceof Ramette) {
				setTypeArticle(true);
				if(((Ramette)article).getGrammage() == 80) {
					getChk80().setSelected(true);
				} else {
					getChk100().setSelected(true);
				}
			} else {
				setTypeArticle(false);
				getCmbCouleur().setSelectedItem(((Stylo)article).getCouleur());
			}
			
		}
	}
	
	private Article getArticleFromFormulaire() throws BLLException {
		//on réutilise celle-là parceque cela aurait été la même mais avec un nom différent
		BLLException bllException = new BLLException();
		
		Article article = null;
		
		int qteStock = 0;
		try {
			qteStock = Integer.parseInt(getTxtStock().getText());
		} catch (Exception e) {
			bllException.ajouterException(new ParameterException("Stock", "Veuillez saisir un entier positif"));
		}
		
		float prixUnitaire = 0;
		try {
			prixUnitaire = Float.parseFloat(getTxtPrix().getText());
		} catch (Exception e) {
			bllException.ajouterException(new ParameterException("Prix Unitaire", "Veuillez saisir un nombre"));
		}
		
		if(bllException.hasExceptions()) {
			throw bllException;
		}
		
		String reference = getTxtReference().getText();
		String designation = getTxtDesignation().getText();
		String marque = getTxtMarque().getText();
		
		if(getRadioRamette().isSelected()) {
			int grammage = getChk100().isSelected() ? 100 : 80;
			article = new Ramette(marque, reference, designation, prixUnitaire, qteStock, grammage);
		} else {
			String couleur = (String) getCmbCouleur().getSelectedItem();
			article = new Stylo(marque, reference, designation, prixUnitaire, qteStock, couleur);
		}
		
		/*
		 * si on affichait déjà un article au moment où on a édité les valeurs,
		 * c'est qu'on est en train de modifier l'article,
		 * on récupère donc son identifiant
		 */		
		if(articleCourant != null) {
			article.setIdArticle(articleCourant.getIdArticle());
		}
		
		articleCourant = article;
		
		return article;
	}
	
	private void setTypeArticle(boolean isRamette) {
		//si c'est un stylo
		getCmbCouleur().setEnabled(!isRamette);
		getLblCouleur().setEnabled(!isRamette);
		getRadioStylo().setSelected(!isRamette);
		
		//si c'est une ramette
		getChk80().setEnabled(isRamette);
		getChk100().setEnabled(isRamette);
		getLblGrammage().setEnabled(isRamette);
		getChk80().setSelected(isRamette);
		getRadioRamette().setSelected(isRamette);
	}
	
	
	
	///////////////////////////////////
	// Interface graphique
	//////////////////////////////////
	
	private JPanel getPanelForm() {		
		if(panelForm == null) {
			panelForm = new JPanel(new GridBagLayout());
			
			addComponentTo(getLblReference(), panelForm, 0, 0, 1, 1, 0.2);
			addComponentTo(getTxtReference(), panelForm, 1, 0, 1, 1, 0.8);
			addComponentTo(getLblDesignation(), panelForm, 0, 1, 1, 1, 0.2);
			addComponentTo(getTxtDesignation(), panelForm, 1, 1, 1, 1, 0.8);
			addComponentTo(getLblMarque(), panelForm, 0, 2, 1, 1, 0.2);
			addComponentTo(getTxtMarque(), panelForm, 1, 2, 1, 1, 0.8);
			addComponentTo(getLblStock(), panelForm, 0, 3, 1, 1, 0.2);
			addComponentTo(getTxtStock(), panelForm, 1, 3, 1, 1, 0.8);
			addComponentTo(getLblPrix(), panelForm, 0, 4, 1, 1, 0.2);
			addComponentTo(getTxtPrix(), panelForm, 1, 4, 1, 1, 0.8);
			addComponentTo(getLblType(), panelForm, 0, 5, 1, 1, 0.2);
			
			/*
			 * Le ButtonGroup permet d'associer les radio boutons
			 * afin que lorsqu'un des boutons est sélectionné, l'autre se déselectionne.
			 */
			
			ButtonGroup typeGroup = new ButtonGroup();
			typeGroup.add(getRadioRamette());
			typeGroup.add(getRadioStylo());
			
			addComponentTo(getRadioRamette(), panelForm, 1, 5, 1, 1, 0.8);
			addComponentTo(getRadioStylo(), panelForm, 1, 6, 1, 1, 0.8);
			
			addComponentTo(getLblGrammage(), panelForm, 0, 7, 1, 1, 0.2);
			
			ButtonGroup grammageGroup = new ButtonGroup();
			grammageGroup.add(getChk80());
			grammageGroup.add(getChk100());
			
			addComponentTo(getChk80(), panelForm, 1, 7, 1, 1, 0.8);
			addComponentTo(getChk100(), panelForm, 1, 8, 1, 1, 0.8);
			
			addComponentTo(getLblCouleur(), panelForm, 0, 9, 1, 1, 0.2);
			addComponentTo(getCmbCouleur(), panelForm, 1, 9, 1, 1, 0.8);
			
			addComponentTo(getPanelButtons(), panelForm, 0, 10, 2, 1, 1);
		}
		
		return panelForm;
	}
	
	private void addComponentTo(JComponent component, JPanel panel,
			  int x, int y, int width, int height,
			  double weightX) {
		addComponentTo(component, panel, x, y, width, height, weightX, true);
	}
	
	/**
	 * Place un composant (component) dans un panel (panel)
	 * @param component Le composant à placer
	 * @param panel Le panel où on place le composant
	 * @param x la colonne
	 * @param y la ligne
	 * @param width colspan (nb de colonnes occupées)
	 * @param height rowspan (nb de lignes occupées)
	 * @param weightX Proportion en X (par rapport à la largeur totale du panel)
	 * @param fillHorizontal true si on veut remplir la colonne, false sinon.
	 */
	private void addComponentTo(JComponent component, JPanel panel,
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
	
	private JLabel getLblReference() {
		if(lblReference == null) {
			lblReference = new JLabel("Référence");
			lblReference.setHorizontalAlignment(SwingConstants.RIGHT);
		}
		return lblReference;
	}
	private JTextField getTxtReference() {
		if(txtReference == null) {
			txtReference = new JTextField();
		}
		return txtReference;
	}
	private JLabel getLblDesignation() {
		if(lblDesignation == null) {
			lblDesignation = new JLabel("Designation");
			lblDesignation.setHorizontalAlignment(SwingConstants.RIGHT);
		}
		return lblDesignation;
	}
	private JTextField getTxtDesignation() {
		if(txtDesignation == null) {
			txtDesignation = new JTextField();
		}
		return txtDesignation;
	}
	private JLabel getLblMarque() {
		if(lblMarque == null) {
			lblMarque = new JLabel("Marque");
			lblMarque.setHorizontalAlignment(SwingConstants.RIGHT);
		}
		return lblMarque;
	}
	private JTextField getTxtMarque() {
		if(txtMarque == null) {
			txtMarque = new JTextField();
		}
		return txtMarque;
	}
	private JLabel getLblStock() {
		if(lblStock == null) {
			lblStock = new JLabel("Stock");
			lblStock.setHorizontalAlignment(SwingConstants.RIGHT);
		}
		return lblStock;
	}
	private JTextField getTxtStock() {
		if(txtStock == null) {
			txtStock = new JTextField();
		}
		return txtStock;
	}
	private JLabel getLblPrix() {
		if(lblPrix == null) {
			lblPrix = new JLabel("Prix");
			lblPrix.setHorizontalAlignment(SwingConstants.RIGHT);
		}
		return lblPrix;
	}
	private JTextField getTxtPrix() {
		if(txtPrix == null) {
			txtPrix = new JTextField();
		}
		return txtPrix;
	}
	private JLabel getLblType() {
		if(lblType == null) {
			lblType = new JLabel("Type");
			lblType.setHorizontalAlignment(SwingConstants.RIGHT);
		}
		return lblType;
	}
	private JRadioButton getRadioRamette() {
		if(radioRamette == null) {
			radioRamette = new JRadioButton("Ramette");
			radioRamette.setSelected(true);
			radioRamette.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					setTypeArticle(true);
				}
			});
		}
		return radioRamette;
	}
	private JRadioButton getRadioStylo() {
		if(radioStylo == null) {
			radioStylo = new JRadioButton("Stylo");
			radioStylo.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					setTypeArticle(false);
				}
			});
		}
		return radioStylo;
	}
		
	private JLabel getLblGrammage() {
		if(lblGrammage == null) {
			lblGrammage = new JLabel("Grammage");
			lblGrammage.setHorizontalAlignment(SwingConstants.RIGHT);
		}
		return lblGrammage;
	}
	private JCheckBox getChk80() {
		if(chk80 == null) {
			chk80 = new JCheckBox("80 grammes");
		}
		return chk80;
	}
	private JCheckBox getChk100() {
		if(chk100 == null) {
			chk100 = new JCheckBox("100 grammes");
		}
		return chk100;
	}
	private JLabel getLblCouleur() {
		if(lblCouleur == null) {
			lblCouleur = new JLabel("Couleur");
			lblCouleur.setHorizontalAlignment(SwingConstants.RIGHT);
		}
		return lblCouleur;
	}
	private JComboBox<String> getCmbCouleur() {
		if(cmbCouleur == null) {
			String[] couleurs = {"bleu", "vert", "rouge", "noir", "jaune"};
			cmbCouleur = new JComboBox<>(couleurs);
		}
		return cmbCouleur;
	}
	
	
	//////////////////////////
	// Boutons
	//////////////////////////
	private ButtonsPanel getPanelButtons() {
		if(panelButtons == null) {
			//panelButtons = new ButtonsPanel(this);
			panelButtons = new ButtonsPanel(new ButtonsPanelAdapter() {

				@Override
				public void onButtonPrevious() {
					previous();
				}

				@Override
				public void onButtonNext() {
					next();
				}
				
			});
		}
		
		return panelButtons;
	}
	
	
	private void next() {
		try {
			setArticle(catalogue.getArticleSuivant());
		} catch (ArticleNotFoundException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(this, "Vous êtes déjà à la fin de la liste");
		}
	}
	
	private void previous() {
		try {
			setArticle(catalogue.getArticlePrecedent());
		} catch (ArticleNotFoundException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(this, "Vous êtes déjà au début de la liste");
		}
	}
	
	private void create() {
		getTxtDesignation().setText("");
		getTxtMarque().setText("");
		getTxtStock().setText("");
		getTxtPrix().setText("");
		getTxtReference().setText("");
		
		setTypeArticle(true);
		
		articleCourant = null;
	}
	
	private void save() {
		if(articleCourant == null) { //on enregistre un nouvel article
			try { 
				catalogue.createNouvelArticle(getArticleFromFormulaire());
				JOptionPane.showMessageDialog(this, "Article ajouté");
			}  catch(BLLException e) {
				JOptionPane.showMessageDialog(this, "Erreur lors de l'ajout d'un article : " + e.getMessage());
			}				
		} else { //on enregistre les modifications de l'article que l'on affichait
			try { 
				catalogue.updateArticleCourant(getArticleFromFormulaire());
				JOptionPane.showMessageDialog(this, "Article mis à jour");
			}  catch(BLLException e) {
				JOptionPane.showMessageDialog(this, "Erreur lors de la mise à jour d'un article : " + e.getMessage());
			}
		}
	}
	
	private void delete() {
		//si on supprimer l'article courant (qui est donc affiché)
		if(articleCourant != null) {
			try {
				int result = JOptionPane.showConfirmDialog(this, "Voulez-vous vraiment supprimer cet article ?");
				if(result == JOptionPane.YES_OPTION) {
					Article articleAAfficher = catalogue.supprimerArticleCourant();
					setArticle(articleAAfficher);
				}
			} catch(BLLException e) {
				e.printStackTrace();
				JOptionPane.showMessageDialog(this, "Erreur lors de la suppression de l'article");
			} catch (ArticleNotFoundException e) {
				e.printStackTrace();
				create();
			}
		} else {
			create();
		}
	}

	//Méthodes utilisées si la classe est listener du panel de boutons
	@Override
	public void onButtonPrevious() {
		previous();
	}

	@Override
	public void onButtonNew() {
		create();
	}

	@Override
	public void onButtonSave() {
		save();
	}

	@Override
	public void onButtonDelete() {
		delete();
	}

	@Override
	public void onButtonNext() {
		next();
	}
}
