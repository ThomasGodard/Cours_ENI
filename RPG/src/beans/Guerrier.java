package beans;

public class Guerrier extends Personnage {
	private static final int PV_TOTAL = 1500;

	public Guerrier() {
		super(PV_TOTAL);
		this.capaciteAttaquesCibles = new AttaqueFort();
		this.capaciteDefenses = new DefenseBouclier();
	}

	public void attaqueCibleDST(Personnage personnage) {
		capaciteAttaquesCibles.attaque(personnage);
		personnage.setSaigne(true);
	}
}
