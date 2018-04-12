package fr.eni.tp5.bo;

public class Ramette extends Article {

	private int grammage;
	
	
	
	public Ramette(int idArticle, String marque, String reference, String designation, float prixUnitaire, int qteStock,
			int grammage) {
		super(idArticle, marque, reference, designation, prixUnitaire, qteStock);
		this.grammage = grammage;
	}

	public Ramette(String marque, String reference, String designation, float prixUnitaire, int qteStock,
			int grammage) {
		super(marque, reference, designation, prixUnitaire, qteStock);
		this.grammage = grammage;
	}

	public int getGrammage() {
		return grammage;
	}

	public void setGrammage(int grammage) {
		this.grammage = grammage;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Rammette [grammage=");
		builder.append(this.grammage);
		builder.append("]");
		return super.toString() + builder.toString();
	}
	
	
}
