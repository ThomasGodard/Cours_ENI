package beans;

import enums.Degats;

public class DefenseResurection implements Defense {

	@Override
	public int subitDegat(int pv, Degats degats) {
		if (pv - degats.getDegats() > 0) {
			return pv - degats.getDegats();
		} else {
			return ;
		}
	}

}
