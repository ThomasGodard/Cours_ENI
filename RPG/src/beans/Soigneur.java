package beans;

public class Soigneur extends Personnage {
	private static final int PV_TOTAL = 900;
	
	public Soigneur() {
		super(PV_TOTAL);
		this.capaciteSoinsCible = new SoinMoyen();
		this.capaciteSoinsDeZone = new SoinFaible();
		this.capaciteAttaquesCibles = new AttaqueFaible();
	}
}