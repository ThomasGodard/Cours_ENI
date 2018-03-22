package enums;

public enum Degats {
	TRES_GROS(550),
	GROS(300),
	MOYEN(150),
	FAIBLE(50);
	
	private int degats;
	
	Degats(int degats) {
		setDegats(degats);
	}

	public int getDegats() {
		return degats;
	}
	
	private void setDegats(int degats) {
		this.degats = degats;
	}
}
