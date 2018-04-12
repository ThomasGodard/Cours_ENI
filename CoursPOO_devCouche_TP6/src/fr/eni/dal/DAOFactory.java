package fr.eni.dal;

import fr.eni.dal.jdbc.EleveDAOJdbcImpl;

public abstract class DAOFactory {

	public static EleveDAO getEleveDAO() {
		return new EleveDAOJdbcImpl();
	}
}
