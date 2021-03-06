package fr.eni.papeterie.test;

import java.util.ArrayList;
import java.util.List;

import fr.eni.papeterie.bll.BLLException;
import fr.eni.papeterie.bll.CatalogueManager;
import fr.eni.papeterie.bo.Article;
import fr.eni.papeterie.bo.Ramette;
import fr.eni.papeterie.bo.Stylo;

public class AppliTestBLL {

	public static void main(String[] args) {
		// Instanciation du jeu d'essai
		List<Article> articles = new ArrayList<>();
		Stylo stylo = new Stylo("", "BBOrange", "Bic bille Orange", 1.2f, -20, "bleu");
		articles.add(stylo);
		articles.add(new Ramette("Clairef", "CRA4S", "Ramette A4 Sup", 9f, 20, 80));
		articles.add(new Stylo("Stypen", "PlumeS", "Stylo Plume Stypen", 5.5f, 20, "jaune"));
		articles.add(new Stylo("Waterman", "WOBGreen", "Waterman Orion Bille vert", 4.2f, 35, "vert"));
		articles.add(new Ramette("ProDesign", "ForLaser", "A4 Special laser", 5.5f, 55, 100));

		/*CatalogueManager mger = null;
		try {
			mger = new CatalogueManager();
		} catch (BLLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}*/

		// Ajout d'un article au catalogue
		try {
			for (Article art : articles) {
				CatalogueManager.getInstance().addArticle(art);
			}
			System.out.println(CatalogueManager.getInstance().getCatalogue());

		} catch (BLLException e) {
			//e.printStackTrace();
			System.out.println("Ajout d'articles\n");
			System.out.println(e.getMessage());
		}

		// Modification d'un article
		try {
			((Stylo) stylo).setCouleur("noir");
			((Stylo) stylo).setDesignation("Bic bille noir");
			((Stylo) stylo).setReference("BBNoir");
			CatalogueManager.getInstance().updateArticle(stylo);
			System.out.println("Article après modification  : " + stylo.toString());
		} catch (BLLException e) {
			System.out.println("Update article\n");
			System.out.println(e.getMessage());
		}

		// Suppression d'un article
		try {
			CatalogueManager.getInstance().removeArticle(stylo);
			System.out.println(CatalogueManager.getInstance().getCatalogue());
		} catch (BLLException e) {
			System.out.println("Suppression article");
			System.out.println(e.getMessage());
		}
	}

}
