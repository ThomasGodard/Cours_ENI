package beans;

import java.util.Date;

public abstract class Produit {
	private static final float MARGE_CD = 1.20f;
	private static final float MARGE_LIVRE = 1.25f;
	private String titre;
	private Date dateSortie;
	private float prixAchat;
	private Auteur auteur;
	
	public Produit() {}
	
	public Produit(String titre, Date dateSortie, float prixAchat, Auteur auteur) {
		setTitre(titre);
		setDateSortie(dateSortie);
		setPrixAchat(prixAchat);
		setAuteur(auteur);
	}
	
	public Auteur getAuteur() {
		return auteur;
	}

	public void setAuteur(Auteur auteur) {
		if (auteur == null) {
			auteur = new Auteur();
		}
		this.auteur = auteur;
	}
	
	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public Date getDateSortie() {
		return dateSortie;
	}

	public void setDateSortie(Date dateSortie) {
		this.dateSortie = dateSortie;
	}

	public void setPrixAchat(float prixAchat) {
		this.prixAchat = prixAchat;
	}
	
	public float getPrixVente() {
		if ( this instanceof Cd) {
			return getPrixAchat() * MARGE_CD;
		} else {
			return getPrixAchat() * MARGE_LIVRE;
		}
	}

	public float getPrixDeVente(float pourcentageReduction) {
		return getPrixVente() * ((100-pourcentageReduction)/100);
	}
	
	protected final float getPrixAchat() {
		return this.prixAchat;
	}
}
