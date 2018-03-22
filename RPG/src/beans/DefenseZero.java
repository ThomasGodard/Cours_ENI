package beans;

import enums.Degats;

public class DefenseZero implements Defense {

	@Override
	public int subitDegat(int pv, Degats degats) {
		return pv - degats.getDegats();
	}

}
