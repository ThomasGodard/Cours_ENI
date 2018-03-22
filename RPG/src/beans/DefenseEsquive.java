package beans;

import java.util.Random;

import enums.Degats;

public class DefenseEsquive implements Defense {
	private static final int CHANCE_ESQUIVE = 25;
	private Random rand = new Random();
	
	@Override
	public void subitDegat(Personnage personnage, Degats degats) {
		if(rand.nextInt(100) <= CHANCE_ESQUIVE ) {
			personnage.setPv(personnage.getPv() - degats.getDegats());
		}
	}
}
