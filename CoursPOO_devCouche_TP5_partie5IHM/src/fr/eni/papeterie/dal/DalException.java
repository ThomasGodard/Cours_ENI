package fr.eni.papeterie.dal;

public class DalException extends Exception {

	public DalException(String message) {
		super("DalException: " + message);
	}
}
