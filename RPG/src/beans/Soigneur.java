package beans;
import java.util.ArrayList;
import java.util.List;

public class Soigneur extends Personnage {
	private static final int PV_TOTAL = 900;
	private static final int INDEX_SOIN_MOYEN = 0;
	private static final int INDEX_SOIN_FAIBLE = 1;
	private static final int INDEX_ATTAQUE_FAIBLE = 0;
	
	public Soigneur() {
		super(PV_TOTAL);
		//Liste des Soins
		this.capaciteSoins = new ArrayList<Soin>();
		capaciteSoins.add(new SoinMoyen());
		capaciteSoins.add(new SoinFaible());
		//Liste des Attaques
		this.capaciteAttaques = new ArrayList<Attaque>();
		capaciteAttaques.add(new AttaqueFaible());
		//Liste de Defense
	}
	
	public void attaqueCible(Personnage personnage) {
		capaciteAttaques.get(INDEX_ATTAQUE_FAIBLE).attaque(personnage);
	}
	
	public void soinCible(Personnage personnage) {
		capaciteSoins.get(INDEX_SOIN_MOYEN).soin(personnage);
	}
	
	public void soinZone(List<Personnage> personnages) {
		capaciteSoins.get(INDEX_SOIN_FAIBLE).soin(personnages);
	}
}