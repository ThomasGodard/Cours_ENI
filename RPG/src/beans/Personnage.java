package beans;

import enums.Degats;

public abstract class Personnage {
	private int pv;
	private int pvTotal;
	private boolean saigne = false;
	private boolean estVivant= true;
	
	private static final double SAIGNEMENT = 0.95;
	
	public Personnage() {}
	
	public Personnage(int pv) {
		this.setPv(pv);
		this.setEstVivant(estVivant);
		this.setSaigne(saigne);
		this.pvTotal = pv;
	}
	
	public void subitDegat(Degats degats) {
		this.setPv(this.getPv() - degats.getDegats());
	}
	
	
	public void saignement() {
		this.setPv((int) (this.getPv()*SAIGNEMENT));
	}

	public int getPv() {
		return pv;
	}

	protected void setPv(int pv) {
		this.pv = pv;

	}

	public boolean getEstVivant() {
		estVivant = this.getPv() > 0;
		return estVivant;
	}
	
	public void setEstVivant(boolean estVivant) {
		this.estVivant = estVivant;
	}
	
	public boolean getSaigne() {
		return this.saigne;
	}
	
	public void setSaigne(boolean saigne) {
		this.saigne = saigne;
	}

	public static double getSaignement() {
		return SAIGNEMENT;
	}

	public int getPvTotal() {
		return pvTotal;
	}
}


