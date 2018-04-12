package fr.eni.bo;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Eleve {

	private int id;
	private String nom;
	private String prenom;
	private String adresse;
	private String nele;
	private Date rentree;
	
	public Eleve(int id, String nom, String prenom, String adresse, String nele, Date rentree) {
		this(nom, prenom, adresse, nele, rentree);
		this.id = id;
	}

	public Eleve(String nom, String prenom, String adresse, String nele, Date rentree) {
		this.rentree = rentree;
		this.nom = nom;
		this.prenom = prenom;
		this.adresse = adresse;
		this.nele = nele;
	}

	public int getId() {
		return id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getNele() {
		return nele;
	}

	public void setNele(String nele) {
		this.nele = nele;
	}

	public Date getRentree() {
		return rentree;
	}

	public void setRentree(Date rentree) {
		this.rentree = rentree;
	}

	@Override
	public String toString() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		StringBuilder builder = new StringBuilder();
		builder.append("Eleve [id=");
		builder.append(id);
		builder.append(", nom=");
		builder.append(nom);
		builder.append(", prenom=");
		builder.append(prenom);
		builder.append(", adresse=");
		builder.append(adresse);
		builder.append(", nele=");
		builder.append(nele);
		builder.append(", rentree=");
		builder.append(rentree == null ? "Non renseigné" : sdf.format(rentree));
		builder.append("]");
		return builder.toString();
	}

	public void setId(int id) {
		this.id = id;
	}


}
