package fr.eni.tp5.bo;

import java.util.ArrayList;
import java.util.List;

public class Panier {

	private float montant;
	private List<Ligne> lignesPanier;
	
	public Panier() {
		this.lignesPanier = new ArrayList<>();
		this.montant = 0;
	}

	public float getMontant() {
		return montant;
	}

	public List<Ligne> getLignesPanier() {
		return lignesPanier;
	}
	
	public Ligne getLigne(int index) {
		return this.lignesPanier.get(index);
	}
	
	public void addLigne(Article article, int qte) {
		Ligne l = new Ligne(article, qte);
		this.lignesPanier.add(l);
		this.montant += l.getPrix();
	}
	
	public void updateLigne(int index, int newQte) {
		this.montant -= this.getLigne(index).getPrix();
		this.lignesPanier.get(index).setQte(newQte);
		this.montant += this.lignesPanier.get(index).getPrix();
	}
	
	public void removeLigne(int index) {
		this.montant -= this.lignesPanier.get(index).getPrix();
		this.lignesPanier.remove(index);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Panier : ").append(System.lineSeparator()).append(System.lineSeparator());
		
		for(int i = 0; i < lignesPanier.size(); i++) {
			builder.append(this.getLigne(i));
			builder.append(System.lineSeparator());
		}
		
		builder.append(System.lineSeparator()).append(System.lineSeparator());
		builder.append("Valeur du panier : ").append(getMontant());
		
		return builder.toString();
	}
	
	
}
