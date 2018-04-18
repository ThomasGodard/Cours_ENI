package fr.eni.papeterie.bo;

public class Ramette extends Article {

	//Variables membres
	private int grammage;
	
	//Getters/Setters
	public int getGrammage() {
		return grammage;
	}

	public void setGrammage(int grammage) {
		this.grammage = grammage;
	}
	
	//Constructeurs
	public Ramette(int idArticle, String marque, String reference, String designation, float prixUnitaire, int qteStock, int grammage) {
		super(idArticle, marque, reference, designation, prixUnitaire, qteStock);
		this.setGrammage(grammage);
	}

	public Ramette(String marque, String reference, String designation, float prixUnitaire, int qteStock, int grammage) {
		super(marque, reference, designation, prixUnitaire, qteStock);
		this.setGrammage(grammage);
	}
	public Ramette()
	{
		super(null,null,null,0f,0);
	}

	@Override
	public String toString() {
		return super.toString()+ " Ramette [grammage=" + grammage + "]";
	}

}
