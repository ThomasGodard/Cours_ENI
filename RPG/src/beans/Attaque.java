package beans;

import java.util.List;

import enums.Degats;
import interfaces.AttaqueCible;
import interfaces.AttaqueDeZone;

public abstract class Attaque implements AttaqueCible, AttaqueDeZone{
	
	private Degats degats;
	
	public Attaque() {}
	
	public Attaque(Degats degats) {
		setDegats(degats);
	}

	private void setDegats(Degats degats) {
		this.degats = degats;
	}

	@Override
	public void attaque(Personnage perso, List<Personnage> personnages) {
		if (perso instanceof Monstre) {
			for (Personnage personnage : personnages) {
				if (!(personnage instanceof Monstre)) {
					personnage.subitDegats(degats);
				}
			}
		} else {
			for (Personnage personnage : personnages) {
				if (personnage instanceof Monstre) {
					personnage.subitDegats(degats);
				}
			}
		}
	}

	@Override
	public void attaque(Personnage personnage) {
		personnage.subitDegats(degats);
	}
}