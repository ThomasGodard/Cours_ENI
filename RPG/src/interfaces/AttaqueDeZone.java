package interfaces;

import java.util.List;

import beans.Personnage;

public interface AttaqueDeZone {
	public void attaque(Personnage personnage, List<Personnage> personnages);
}
