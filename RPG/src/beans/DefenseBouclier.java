package beans;

import enums.Degats;
import interfaces.Defense;

public class DefenseBouclier implements Defense {
	private static final double REDUCTION_DEGAT = 0.95;
	
	@Override
	public void subitDegat(Personnage personnage, Degats degats) {
		int pv = personnage.getPv();
		int degat = degats.getDegats();
		personnage.setPv((int) (pv - degat*REDUCTION_DEGAT));
	}
	;
}
