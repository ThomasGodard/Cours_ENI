package fr.eni.tp5.dal.serial;

public class DalException extends Exception {

	public DalException(String message) {
		super("DalException " + message);
	}
	
}
