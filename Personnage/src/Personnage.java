import com.sdz.comportement.*;
public abstract class Personnage {
	
	//instance de comportement
	EspritCombatif espritCombatif = new Pacifiste();	
	Soin soin = new AucunSoin();
	Deplacement deplacement = new Marcher();

	//constructeur par defaut
	public Personnage(){} 
	
	//constructeur avec paramettre
	public Personnage(EspritCombatif espritCombatif, Soin soin, Deplacement deplacement) {
		this.espritCombatif = espritCombatif;
		this.soin = soin;
		this.deplacement = deplacement;
	}
	
	//methode deplacement de personnage
	public void seDeplacer() {
		deplacement.deplacer();
	}
	
	//methode combat personnage
	public void combattre() {
		espritCombatif.combat();
	}
	
	//methode soin personnage
	public void soigner() {
		soin.soigne();
	}
	//Mutateurs :
	//redefinit le comportement au combat
	public void setEspritCombatif(EspritCombatif espritCombatif) {
		this.espritCombatif = espritCombatif;
	}
	
	//redefinit le comportement soin
	public void setSoin (Soin soin) {
		this.soin = soin;
	}
	
	//redefinit le comportement deplacement
	public void setDeplacement (Deplacement deplacement) {
		this.deplacement = deplacement;
	}
}
