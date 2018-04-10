package beans;

public class Piste {
	
	private int numero;
	private String intitule;
	private int duree;
	
	public Piste(int numero, String intitule, int duree) {
		super();
		setNumero(numero);
		setIntitule(intitule);
		setDuree(duree);
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getIntitule() {
		return intitule;
	}

	public void setIntitule(String intitule) {
		this.intitule = intitule;
	}

	public int getDuree() {
		return duree;
	}

	public void setDuree(int duree) {
		this.duree = duree;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Piste [getNumero()=");
		builder.append(getNumero());
		builder.append(", getIntitule()=");
		builder.append(getIntitule());
		builder.append(", getDuree()=");
		builder.append(getDuree());
		builder.append("]");
		return builder.toString();
	}
	
	
}
