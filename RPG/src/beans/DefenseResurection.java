package beans;

import enums.Degats;

public class DefenseResurection implements Defense {

	@Override
	public void subitDegat(Personnage personnage, Degats degats) {
		if (personnage.getPv() - degats.getDegats() > 0) {
			personnage.setPv(personnage.getPv() - degats.getDegats());
		} else {
			personnage.setPv(personnage.getPvTotal());
		}
	}

}
