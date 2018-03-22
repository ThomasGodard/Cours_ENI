package interfaces;

import beans.Personnage;
import enums.Degats;

public interface Defense {
	public void subitDegat(Personnage personnage, Degats degats);
}
