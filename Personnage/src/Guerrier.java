import com.sdz.comportement.*;
public class Guerrier extends Personnage {

	  public Guerrier(){
	    this.espritCombatif = new CombatCouteau();
	  }
	  public Guerrier(EspritCombatif esprit, Soin soin, Deplacement dep) {
	    super(esprit, soin, dep);
	  }
	
}	

