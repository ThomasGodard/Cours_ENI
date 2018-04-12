package fr.eni.tp5.ihm;

import fr.eni.tp5.dal.ArticleDao;
import fr.eni.tp5.dal.DaoFactory;

public class TestTP7 {

	public static void main(String[] args) {

		ArticleDao artDao = DaoFactory.getArticleDao();
		
		System.out.println(artDao.selectById(1));
	}

}
