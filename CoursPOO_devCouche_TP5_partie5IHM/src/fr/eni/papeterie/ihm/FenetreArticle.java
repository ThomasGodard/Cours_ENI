package fr.eni.papeterie.ihm;

import java.awt.BorderLayout;
import java.awt.Component;
import java.util.List;
import java.util.ListIterator;

import javax.swing.JFrame;
import javax.swing.JPanel;

import fr.eni.papeterie.bll.BLLException;
import fr.eni.papeterie.bll.CatalogueManager;
import fr.eni.papeterie.bo.Article;
import fr.eni.papeterie.ihm.PanelBouttons.PanelBouttonsListener;

public class FenetreArticle extends JFrame implements PanelBouttonsListener {

	PanelBouttonsListener btnListener;
	
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
			panelArt = new PanelArticle(this);

		}
		return panelArt;
	}
	
	private Component getVueBtn() {
		if ( panelBtn == null ) {
			panelBtn = new PanelBouttons(this);
		}
		return panelBtn;
	}

	@Override
	public void onClic(int noBtn) {
		switch (noBtn) {
		case 1:
			previous();
			System.out.println(((PanelArticle) panelArt).getTxtRef().getText());
			break;

		default:
			break;
		};
	}
	
	public void save();
}

