package beans;
import java.util.List;

import enums.Degats;

public class Monstre extends Personnage {
	private static final int PV_TOTAL = 5500;
	private boolean cptMort = false;
	
	public Monstre() {
		super(PV_TOTAL);
	}

	public void attaqueCible(Personnage personnage) {
		System.out.println("Attaque ciblée sur " + personnage.getClass().getSimpleName());
		personnage.subitDegat(Degats.GROS);
	}
	
	public void attaqueZone(List<Personnage> personnages) {
		System.out.println("Attaque de zone.");
		for(Personnage personnage : personnages) {
			if(personnage.getClass() != this.getClass()) {
				personnage.subitDegat(Degats.MOYEN);
			}
		}
	}
	
	@Override
	public void subitDegat(Degats degat) {
		super.subitDegat(degat);
		if (!this.getEstVivant() && !this.cptMort) {
			this.setPv(PV_TOTAL);
			cptMort = true;
		}
	}
}
