package fr.eni.papeterie.bo;

public class Ligne {
	//Variables membres
	protected int qte;
	private Article article;
	
	//Getters/Setters
	public int getQte() {
		return qte;
	}
	public void setQte(int qte) {
		this.qte = qte;
	}
	public Article getArticle() {
		return article;
	}
	private void setArticle(Article article) {
		this.article = article;
	}
	public float getPrix()
	{
		return this.qte*this.article.getPrixUnitaire();
	}
	
	//Constructeurs
	public Ligne(Article article, int qte) {
		super();
		this.setArticle(article);
		this.setQte(qte);
	}
	@Override
	public String toString() {
		return "Ligne [qte=" + qte + ", prix=" + getPrix() + ", article=" + article +"]";
	}
	
	
	
}










