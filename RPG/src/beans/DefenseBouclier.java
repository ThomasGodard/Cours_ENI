package beans;

import enums.Degats;
import interfaces.Defense;

public class DefenseBouclier implements Defense {
	private static final double REDUCTION_DEGAT = 0.95;
	
	@Override
	public void subitDegat(Personnage personnage, Degats degats) {
		personnage.setPv((int) (personnage.getPv() - degats.getDegats()*REDUCTION_DEGAT));
	}
}
