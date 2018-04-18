package fr.eni.papeterie.test;

import javax.swing.SwingUtilities;

import fr.eni.papeterie.ihm.FenetreArticle;

public class AppliTestIHM {

	public static void main(String[] args) {
		
		SwingUtilities.invokeLater(() -> new FenetreArticle());
	}
}
