package beans;

import java.util.List;

import enums.Degats;
import interfaces.AttaqueCible;
import interfaces.AttaqueDeZone;
import interfaces.Defense;
import interfaces.SoinCible;
import interfaces.SoinDeZone;

public abstract class Personnage {
	private int pv;
	private int pvTotal;
	private boolean saigne;
	
	private static final double SAIGNEMENT = 0.95;
	
	protected AttaqueCible capaciteAttaquesCibles = new AttaqueZero();
	protected AttaqueDeZone capaciteAttaquesDeZone = new AttaqueZero();
	protected SoinCible capaciteSoinsCible = new SoinZero();
	protected SoinDeZone capaciteSoinsDeZone = new SoinZero();
	protected Defense capaciteDefenses = new DefenseZero();
	
	public Personnage() {}
	
	public Personnage(int pv) {
		this.pvTotal = pv;
		this.setPv(pv);
		this.setSaigne(false);
	}

	public int getPv() {
		return pv;
	}

	protected void setPv(int pv) {
		this.pv = pv;
	}

	public boolean estVivant() {
		return this.getPv() > 0;
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
	
	public void attaqueCible(Personnage personnage) {
		capaciteAttaquesCibles.attaque(personnage);	
	}
	
	public void attaqueZone(List<Personnage> personnages) {
		capaciteAttaquesDeZone.attaque(this, personnages);
	}
	
	public void soigneCible(Personnage personnage) {
		capaciteSoinsCible.soin(personnage);
	}
	
	public void soigneZone(List<Personnage> personnages) {
		capaciteSoinsDeZone.soin(personnages);
	}
	
	public void subitDegats(Degats degats) {
		capaciteDefenses.subitDegat(this, degats);
	}
	
	public void saignement() {
		this.setPv((int) (this.getPv()*SAIGNEMENT));
	}
}


