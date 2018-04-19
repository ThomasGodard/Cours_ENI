package fr.eni.papeterie.bll;

import java.util.List;

import fr.eni.papeterie.bo.Article;

public class Catalogue {

	private CatalogueManager manager;
	private List<Article> listeArticle;
	int index;

	private Catalogue() throws BLLException {
		manager = CatalogueManager.getInstance();
		listeArticle = manager.getCatalogue();
		index = 0;
	}

	public static Catalogue getInstance() {
		if (instance == null) {
			instance = new Catalogue();
		}
		return instance;
	}
	
	public void addArticle(Article article) {
		try {

			cm.addArticle(article);
		} catch (BLLException e) {
			e.printStackTrace();
		}
	}
}
