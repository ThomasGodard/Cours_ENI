package fr.eni.papeterie.bo;

public class Stylo extends Article {

	//Variables membres
	private String couleur;
	
	//Getters/Setters
	public String getCouleur() {
		return couleur;
	}

	public void setCouleur(String couleur) {
		this.couleur = couleur;
	}
	
	//Constructeurs
	public Stylo(int idArticle, String marque, String reference, String designation, float prixUnitaire, int qteStock, String couleur) {
		super(idArticle, marque, reference, designation, prixUnitaire, qteStock);
		this.setCouleur(couleur);
	}

	public Stylo(String marque, String reference, String designation, float prixUnitaire, int qteStock, String couleur) {
		super(marque, reference, designation, prixUnitaire, qteStock);
		this.setCouleur(couleur);
	}
	public Stylo()
	{
		super(null,null,null,0f,0);
	}

	@Override
	public String toString() {
		return super.toString()+ " Stylo [couleur=" + couleur + "]";
	}

	
}










