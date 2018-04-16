package fr.eni.papeterie.bo;

import java.io.Serializable;

public abstract class Article implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	//Variables membres
	private int idArticle;
	private String reference;
	private String marque;
	private String designation;
	private float prixUnitaire;
	private int qteStock;
	
	//Getters/setters
	public String getReference() {
		return reference;
	}
	public void setReference(String reference) {
		this.reference = reference;
	}
	public String getMarque() {
		return marque;
	}
	public void setMarque(String marque) {
		this.marque = marque;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public float getPrixUnitaire() {
		return prixUnitaire;
	}
	public void setPrixUnitaire(float prixUnitaire) {
		this.prixUnitaire = prixUnitaire;
	}
	public int getQteStock() {
		return qteStock;
	}
	public void setQteStock(int qteStock) {
		this.qteStock = qteStock;
	}
	public int getIdArticle() {
		return idArticle;
	}
	public void setIdArticle(int idArticle) {
		this.idArticle = idArticle;
	}
	
	//Constructeurs
	public Article(int idArticle, String marque, String reference, String designation, float prixUnitaire,
			int qteStock) {
		this(marque,reference,designation,prixUnitaire,qteStock);
		this.idArticle = idArticle;
	}
	public Article(String marque, String reference, String designation, float prixUnitaire, int qteStock) {
		super();
		this.setMarque(marque);
		this.setReference(reference);
		this.setDesignation(designation);
		this.setPrixUnitaire(prixUnitaire);
		this.setQteStock(qteStock);
	}
	@Override
	public String toString() {
		return "Article [idArticle=" + idArticle + ", reference=" + reference + ", marque=" + marque + ", designation="
				+ designation + ", prixUnitaire=" + prixUnitaire + ", qteStock=" + qteStock + "]";
	}
}
