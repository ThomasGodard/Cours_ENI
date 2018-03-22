package beans;
import java.util.ArrayList;
import java.util.List;

import enums.Degats;
import interfaces.SoinCible;
import interfaces.SoinDeZone;

public class Soigneur extends Personnage {
	private static final int PV_TOTAL = 900;
	
	private List<Soin> CapaciteSoins;
	
	public Soigneur() {
		super(PV_TOTAL);
		this.CapaciteSoins = new ArrayList<Soin>();
		CapaciteSoins.add(new SoinMoyen());
		CapaciteSoins.add(new SoinFaible());
	}
	
	public void attaqueCible(Personnage personnage) {
		personnage.subitDegat(Degats.FAIBLE);
	}
	
	public void soinCible(Personnage personnage) {
		
		CapaciteSoins.get(0).soin(personnage);
	}
	
	public void soinZone(List<Personnage> personnages) {
		CapaciteSoins.get(0).soin(personnages);
	}
}