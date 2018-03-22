package beans;
import java.util.List;

import enums.Degats;
import interfaces.Soigne;

public class Soigneur extends Personnage {
	private static final int PV_TOTAL = 900;
	
	private Soigne soinsDeZone;
	private Soigne soinsCible;
	
	public Soigneur() {
		super(PV_TOTAL);
		this.soinsDeZone = new SoinDeZone();
		this.soinsCible = new SoinCible();
	}
	
	public void attaqueCible(Personnage personnage) {
		personnage.subitDegat(Degats.FAIBLE);
	}
	
	public void soinCible(Personnage personnage) {
		this.soinsCible.soin(personnage);
	}
	
	public void soinZone(List<Personnage> personnages) {
		for(Personnage personnage : personnages) {
			if(!(personnage instanceof Monstre)) {
				this.soinsDeZone.soin(personnage);
			}
		}
	}
}