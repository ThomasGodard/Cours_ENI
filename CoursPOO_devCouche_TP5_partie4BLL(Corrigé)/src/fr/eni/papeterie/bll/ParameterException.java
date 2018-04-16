package fr.eni.papeterie.bll;

public class ParameterException extends Exception {
	
	public ParameterException(String attribut, String message) {
		super(attribut + " : " + message);
	}
}
