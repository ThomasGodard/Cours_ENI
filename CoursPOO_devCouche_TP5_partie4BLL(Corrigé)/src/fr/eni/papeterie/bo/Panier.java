package fr.eni.papeterie.bo;

import java.util.ArrayList;
import java.util.List;

public class Panier {
	private float montant;
	private List<Ligne> lignesPanier;
	
	public float getMontant() {
		return montant;
	}
	public List<Ligne> getLignesPanier()
	{
		return this.lignesPanier;
	}
	
	//Constructeurs
	public Panier() {
		this.lignesPanier=new ArrayList<>();
	}
	
	//Méthodes
	public Ligne getLigne(int index)
	{
		return this.lignesPanier.get(index);
	}
	
	public void addLigne(Article article, int qte)
	{
		Ligne ligne = new Ligne(article, qte);
		this.lignesPanier.add(ligne);
		this.montant+=ligne.getPrix();
	}
	public void updateLigne(int index, int newQte)
	{
		this.montant-=this.lignesPanier.get(index).getPrix();
		this.lignesPanier.get(index).setQte(newQte);
		this.montant+=this.lignesPanier.get(index).getPrix();
	}
	public void removeLigne(int index)
	{
		this.montant-=this.lignesPanier.get(index).getPrix();
		this.lignesPanier.remove(index);
		
	}
	//"Panier :"
	//"ligne 0 : Ligne [ qte=2, prix=1.2, article=Article [idArticle=1, reference=BBOrange, marque=Bic, designation=Bic bille Orange, prixUnitaire=1.2, qteStock=20] Stylo [Couleur=Bleu]]"
	//"Valeur du panier : 0.0"
	@Override
	public String toString() {
		StringBuilder sb=new StringBuilder();
		
		sb.append("Panier : ").append(System.lineSeparator()).append(System.lineSeparator());
		
		for(int index=0;index<this.lignesPanier.size();index++)
		{
			sb.append("ligne ").append(index).append(" : ");
			sb.append(this.lignesPanier.get(index).toString());
			sb.append(System.lineSeparator());
		}
		sb.append(System.lineSeparator()).append(System.lineSeparator());
		sb.append("Valeur du panier : ").append(this.montant);
		return sb.toString();
	}
	
	
	
	
}
