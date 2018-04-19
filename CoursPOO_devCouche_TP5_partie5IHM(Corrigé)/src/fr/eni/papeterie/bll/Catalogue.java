package fr.eni.papeterie.bll;

import java.util.List;

import fr.eni.papeterie.bo.Article;

public class Catalogue {

	private List<Article> mesArticles;
	
	private int indexArticleCourant;
	
	private CatalogueManager manager;
	
	public Catalogue() throws BLLException {
		manager = CatalogueManager.getInstance();
		
		mesArticles = manager.getCatalogue();
		indexArticleCourant = 0;
	}
	
	public Article getArticleCourant() throws ArticleNotFoundException {
		if(mesArticles.size() > 0) {
			return mesArticles.get(indexArticleCourant);
		}
		throw new ArticleNotFoundException();
	}
	
	public Article getArticleSuivant() throws ArticleNotFoundException {
		if(indexArticleCourant + 1 < mesArticles.size()) {
			//++indexArticleCourant;
			//return mesArticles.get(indexArticleCourant);
			return mesArticles.get(++indexArticleCourant);
		} else {
			throw new ArticleNotFoundException();
		}
	}
	
	public Article getArticlePrecedent() throws ArticleNotFoundException {
		if(indexArticleCourant - 1 >= 0) {
			//--indexArticleCourant;
			//return mesArticles.get(indexArticleCourant);
			return mesArticles.get(--indexArticleCourant);
		} else {
			throw new ArticleNotFoundException();
		}
	}
	
	public void createNouvelArticle(Article nouvelArticle) throws BLLException {
		manager.addArticle(nouvelArticle);
		mesArticles.add(nouvelArticle);
	}
	
	public void updateArticleCourant(Article articleAModifier) throws BLLException {
		manager.updateArticle(articleAModifier);
		mesArticles.set(indexArticleCourant, articleAModifier);
	}
	
	public Article supprimerArticleCourant() throws BLLException, ArticleNotFoundException {
		
		//récupère l'article à supprimer
		Article articleASupprimer = mesArticles.get(indexArticleCourant);
		
		//on supprime l'article de la BDD
		manager.removeArticle(articleASupprimer);
		
		//on enlève l'article de la liste (si ça été fait dans la BDD)
		mesArticles.remove(articleASupprimer);
		
		//on essaye de retourner l'article précédent
		try {
			return getArticlePrecedent();
		} catch (ArticleNotFoundException e) { //s'il n'existe pas, on essaye de retourner l'article suivant
			if(indexArticleCourant < mesArticles.size()) {
				return mesArticles.get(indexArticleCourant);
			}
		}
		
		throw new ArticleNotFoundException();
	}
	
	
}



