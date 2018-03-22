package beans;

public class Monstre extends Personnage {
	private static final int PV_TOTAL = 5500;
	
	public Monstre() {
		super(PV_TOTAL);
		this.capaciteAttaquesDeZone = new AttaqueMoyen();
		this.capaciteAttaquesCibles = new AttaqueFort();
		this.capaciteDefenses = new DefenseResurection();
	}
}
