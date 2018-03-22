package beans;

import enums.Soins;
import interfaces.Soigne;

public class SoinDeZone implements Soigne {

	@Override
	public void soin(Personnage personnage) {
		if (personnage.getPv() + Soins.FAIBLE.getSoin() < personnage.getPvTotal()) {
			personnage.setPv(personnage.getPv() + Soins.FAIBLE.getSoin());
		} else {
			personnage.setPv(personnage.getPvTotal());
		}
	}
}
