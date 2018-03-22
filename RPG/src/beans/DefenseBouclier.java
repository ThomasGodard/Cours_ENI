package beans;

import enums.Degats;

public class DefenseBouclier implements Defense {
	private static final double REDUCTION_DEGAT = 0.95;
	
	@Override
	public int subitDegat(int pv, Degats degats) {
		return (int) (pv - degats.getDegats()*REDUCTION_DEGAT);
	}
}
