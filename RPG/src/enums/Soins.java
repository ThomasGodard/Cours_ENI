package enums;

public enum Soins {
	MOYEN(300),
	FAIBLE(100),
	ZERO(0);
	
	private int soin;
	
	Soins(int soin) {
		setSoin(soin);
	}

	public int getSoin() {
		return soin;
	}

	private void setSoin(int soin) {
		this.soin = soin;
	}
}
