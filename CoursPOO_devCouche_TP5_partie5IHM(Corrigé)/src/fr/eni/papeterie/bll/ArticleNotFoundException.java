package fr.eni.papeterie.bll;

public class ArticleNotFoundException extends Exception {

	public ArticleNotFoundException() {
		super("L'article n'existe pas");
	}
}
