package beans;

import enums.Soins;
import interfaces.Soigne;

public class SoinCible implements Soigne {

	@Override
	public void soin(Personnage personnage) {
		if (personnage.getPv() + Soins.MOYEN.getSoin() < personnage.getPvTotal()) {
			personnage.setPv(personnage.getPv() + Soins.MOYEN.getSoin());
		} else {
			personnage.setPv(personnage.getPvTotal());
		}
	}

}
