package beans;

import enums.Degats;
import interfaces.Defense;

public class DefenseZero implements Defense {

	@Override
	public void subitDegat(Personnage personnage, Degats degats) {
		personnage.setPv(personnage.getPv() - degats.getDegats());
	}

}
