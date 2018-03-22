package beans;

import java.util.ArrayList;

import enums.Degats;

public class Guerrier extends Personnage {
	private static final int PV_TOTAL = 1500;
	private static final double REDUCTION_DEGAT = 0.90;

	public Guerrier() {
		super(PV_TOTAL);
		this.capaciteAttaques = new ArrayList<>();
		capaciteAttaques.add(new AttaqueFort());
		capaciteAttaques.add(new AttaqueFaible());
	}
	
	public void subitDegat(Degats degat) {
		this.setPv((int) (this.getPv() - degat.getDegats()*REDUCTION_DEGAT));
	}
	
	public void attaqueCible(Personnage personnage) {
		capaciteAttaques.get(0).attaque(personnage);
	}
	
	public void attaqueCibleDST(Personnage personnage) {
		capaciteAttaques.get(1).attaque(personnage);
		personnage.setSaigne(true);
	}
}
