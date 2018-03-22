package beans;

import enums.Degats;

public class Guerrier extends Personnage {
	private static final int PV_TOTAL = 1500;
	private static final double REDUCTION_DEGAT = 0.90;

	public Guerrier() {
		super(PV_TOTAL);
	}
	
	public void subitDegat(Degats degat) {
		this.setPv((int) (this.getPv() - degat.getDegats()*REDUCTION_DEGAT));
	}
	
	public void attaqueCible(Personnage personnage) {
		personnage.subitDegat(Degats.GROS);
	}
	
	public void attaqueCibleDST(Personnage personnage) {
		personnage.subitDegat(Degats.FAIBLE);
		personnage.setSaigne(true);
	}
}
