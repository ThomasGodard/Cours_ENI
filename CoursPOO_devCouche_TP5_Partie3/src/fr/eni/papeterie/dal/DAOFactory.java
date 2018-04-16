package fr.eni.papeterie.dal;

import fr.eni.papeterie.configuration.Parametres;
import fr.eni.papeterie.dal.jdbc.ArticleDAOJdbcImpl;
import fr.eni.papeterie.dal.serial.ArticleDAOSerialImpl;

public abstract class DAOFactory {
	
	public static ArticleDAO getArticleDAO()
	{
		switch (Parametres.getValue("typeSauvegarde")) {
		case "jdbc":
			return new ArticleDAOJdbcImpl();
		case "serial":
			return new ArticleDAOSerialImpl();
		default:
			return new ArticleDAOJdbcImpl();
		}
	}
}
