package beans;
import java.util.List;
import java.util.Random;

import enums.Degats;

public class Archer extends Personnage{
	private static final int PV_TOTAL = 1200;
	private static final int CHANCE_ESQUIVE = 25;
	private Random rand = new Random();
	
	public Archer() {
		super(PV_TOTAL);
	}
	
	public void attaqueCible(Personnage personnage) {
		personnage.subitDegat(Degats.MOYEN);
	}
	
	public void attaqueZone(List<Personnage> personnages) {
		for(Personnage personnage : personnages) {
			if(personnage.getClass() != this.getClass()) {
				personnage.subitDegat(Degats.FAIBLE);
			}
		}
	}
	
	@Override
	public void subitDegat(Degats degats) {
		if(rand.nextInt(100) <= CHANCE_ESQUIVE ) {
			this.setPv(this.getPv() - degats.getDegats());
		}
	}
}
