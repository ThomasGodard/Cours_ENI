package fr.eni.tp5.ihm;

import fr.eni.tp5.bo.Ramette;
import fr.eni.tp5.bo.Stylo;
import fr.eni.tp5.dal.ArticleDao;
import fr.eni.tp5.dal.DaoFactory;

public class TestTP7 {

	public static void main(String[] args) {

		ArticleDao artDao = DaoFactory.getArticleDao();
		
		System.out.println(artDao.selectById(1));
		
		System.out.println(artDao.selectAll());
		
		artDao.update(3, new Stylo("Stypen", "Stypen", "Stylo plume Stypen", 5.5f, 25, "jaune"));
		artDao.update(3, new Ramette("Stypen", "Stypen", "Stylo plume Stypen", 5.5f, 25, 200));
		System.out.println("Mise à jour de l'article id 3");
		System.out.println(artDao.update(3, new Stylo("Stypen", "PlumeS", "Stylo plume Stypen", 5.5f, 19, "jaune"))+" lignes affectée(s).");
		System.out.println(artDao.selectById(3));
		//artDao.insert(new Stylo("Stypen", "Stypen", "Stylo plume Stypen", 5.5f, 25, "jaune"));
		System.out.println(artDao.selectAll());
		artDao.delete(8);
		System.out.println(artDao.selectAll());
		
	}

}
