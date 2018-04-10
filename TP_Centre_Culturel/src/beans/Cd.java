package beans;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Cd extends Produit {
	
	private int indexPiste = 0;
	private Map<Integer, Piste> pistes;
	
	public Cd() {}
	
	public Cd(String titre, Date dateSortie, float prixAchat, Auteur auteur) {
		super(titre, dateSortie, prixAchat, auteur);
		setPiste();
	}
	
	private void setPiste() {
		this.pistes = new HashMap<Integer, Piste>();
	}

	public int getIndexPiste() {
		return indexPiste;
	}
	
	public void setIndexPiste(int indexPiste) {
		this.indexPiste = indexPiste;
	}
	
	public void addPiste(int numero, String intitule, int duree) {
		pistes.add(new Piste(numero, intitule, duree));
	}
}
