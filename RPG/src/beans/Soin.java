package beans;

import java.util.List;

import enums.Soins;
import interfaces.SoinCible;
import interfaces.SoinDeZone;

public abstract class Soin implements SoinDeZone, SoinCible {
	
	private Soins soins;
	
	public Soin() {}
	
	public Soin(Soins soins) {
		setSoins(soins);
	}
	
	private void setSoins(Soins soins) {
		this.soins = soins ;
	}
	
	@Override
	public void soin(List<Personnage> personnages) {
		for(Personnage personnage : personnages) {
			if(!(personnage instanceof Monstre)) {
				this.soigne(personnage);
			}
		}
	}
	
	@Override
	public void soin(Personnage personnage) {
		this.soigne(personnage);
	}

	private void soigne(Personnage personnage) {
		if (personnage.getPv() + this.soins.getSoin() < personnage.getPvTotal()) {
			personnage.setPv(personnage.getPv() + this.soins.getSoin());
		} else {
			personnage.setPv(personnage.getPvTotal());
		}
	}
}
