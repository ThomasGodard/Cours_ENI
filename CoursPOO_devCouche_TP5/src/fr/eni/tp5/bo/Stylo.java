package fr.eni.tp5.bo;

public class Stylo extends Article {

	private String couleur;
	
	public Stylo() { }
	
	public Stylo(int idArticle, String marque, String reference, String designation, float prixUnitaire, int qteStock, String couleur) {
		super(idArticle, marque, reference, designation, prixUnitaire, qteStock);
		this.couleur = couleur;
	}

	public Stylo(String marque, String reference, String designation, float prixUnitaire, int qteStock, String couleur) {
		super(marque, reference, designation, prixUnitaire, qteStock);
		this.couleur = couleur;
	}

	public String getCouleur() {
		return couleur;
	}

	public void setCouleur(String couleur) {
		this.couleur = couleur;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Stylo [couleur=");
		builder.append(couleur);
		builder.append("]");
		builder.append(System.lineSeparator());
		return super.toString() + builder.toString();
	}
}
