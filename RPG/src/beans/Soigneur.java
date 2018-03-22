package beans;
import java.util.List;

import enums.Degats;
import interfaces.SoinDeZone;

public class Soigneur extends Personnage {
	private static final int PV_TOTAL = 900;
	
	private SoinDeZone soinsDeZone;
	private SoinDeZone soinsCible;
	
	public Soigneur() {
		super(PV_TOTAL);
		this.soinsDeZone = new SoinF();
		this.soinsCible = new SoinMoyen();
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