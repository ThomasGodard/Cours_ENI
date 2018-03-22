package beans;
import java.util.ArrayList;
import java.util.List;

import enums.Degats;

public class Soigneur extends Personnage {
	private static final int PV_TOTAL = 900;
	private static final int INDEX_SOIN_MOYEN = 0;
	private static final int INDEX_SOIN_FAIBLE = 1;
	private static final int INDEX_ATTAQUE_FAIBLE = 0;
	
	
	
	private List<Soin> CapaciteSoins;
	private List<Attaque> CapaciteAttaques;
	
	public Soigneur() {
		super(PV_TOTAL);
		
		this.CapaciteSoins = new ArrayList<Soin>();
		CapaciteSoins.add(new SoinMoyen());
		CapaciteSoins.add(new SoinFaible());
		
		this.CapaciteAttaques = new ArrayList<Attaque>();
		CapaciteAttaques.add(new AttaqueFaible());
	}
	
	public void attaqueCible(Personnage personnage) {
		CapaciteAttaques.get(INDEX_ATTAQUE_FAIBLE).attaque(personnage);
	}
	
	public void soinCible(Personnage personnage) {
		CapaciteSoins.get(INDEX_SOIN_MOYEN).soin(personnage);
	}
	
	public void soinZone(List<Personnage> personnages) {
		CapaciteSoins.get(INDEX_SOIN_FAIBLE).soin(personnages);
	}
}