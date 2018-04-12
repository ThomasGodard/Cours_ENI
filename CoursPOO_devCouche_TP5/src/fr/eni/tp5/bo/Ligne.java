package fr.eni.tp5.bo;

public class Ligne {

	protected int qte;
	private Article article;
	
	public Ligne(Article article, int qte) {
		this.qte = qte;
		setArticle(article);
	}
	
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
	
	public float getPrix() {
		return this.getArticle().getPrixUnitaire()*this.getQte();
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Ligne [qte = ");
		builder.append(qte);
		builder.append(", article = ");
		builder.append(article);
		builder.append(", Prix = ");
		builder.append(getPrix());
		builder.append("]");
		builder.append(System.lineSeparator());
		return builder.toString();
	}
	
	

	
}
