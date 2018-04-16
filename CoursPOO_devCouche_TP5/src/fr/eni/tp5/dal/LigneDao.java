package fr.eni.tp5.dal;

import fr.eni.tp5.bo.Ligne;

public interface LigneDao {

	public void ajouterLigne(Ligne ligne);
	
	public void supprimerLigne();
	
	public void modifierLigne();
}
