package fr.eni.dal;

import java.util.List;

import fr.eni.bo.Eleve;

public interface EleveDAO {

	/**
	 * 
	 * @param asc
	 * @return Liste des eleves. si pas d'eleve, la liste est vide.
	 */
	List<Eleve> getListeEleves(boolean asc);

	void ajouterEleve(Eleve eleve) throws Exception;

}