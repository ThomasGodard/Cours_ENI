package fr.eni.tp5.dal;

import fr.eni.tp5.configuration.Configuration;
import fr.eni.tp5.dal.jdbc.ArticleDaoJdbcImpl;
import fr.eni.tp5.dal.serial.ArticleDaoSerialImpl;

public abstract class DaoFactory {

	public static ArticleDao getArticleDao() {
		
		switch (Configuration.getValue("typeSauvegarde")) {
		case "jdbc":
			return new ArticleDaoJdbcImpl();
		case "serial":
			return new ArticleDaoSerialImpl();
		default:
			return new ArticleDaoSerialImpl();
		}
	}
}
