package beans;

import java.util.Random;

import enums.Degats;

public class DefenseEsquive implements Defense {
	private static final int CHANCE_ESQUIVE = 25;
	private Random rand = new Random();
	
	@Override
	public int subitDegat(int pv, Degats degats) {
		if(rand.nextInt(100) <= CHANCE_ESQUIVE ) {
			return pv - degats.getDegats();
		} else {
			return pv;
		}
	}
}
