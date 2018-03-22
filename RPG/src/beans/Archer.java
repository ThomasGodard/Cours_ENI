package beans;

public class Archer extends Personnage{
	private static final int PV_TOTAL = 1200;
	
	public Archer() {
		super(PV_TOTAL);
		capaciteAttaquesCibles = new AttaqueMoyen();
		capaciteAttaquesDeZone = new AttaqueFaible();
		capaciteDefenses = new DefenseEsquive();
		
	}
}
