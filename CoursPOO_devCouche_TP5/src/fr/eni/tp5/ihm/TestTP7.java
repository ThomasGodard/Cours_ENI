package fr.eni.tp5.ihm;

import fr.eni.tp5.bo.Ramette;
import fr.eni.tp5.bo.Stylo;
import fr.eni.tp5.dal.ArticleDao;
import fr.eni.tp5.dal.DaoFactory;

public class TestTP7 {

	public static void main(String[] args) {

		ArticleDao artDao = DaoFactory.getArticleDao();
//		
		System.out.println(artDao.selectById(1));
		Ramette uneRamette = new Ramette(2, "Clairef", "CRA4S", "Ramette A4 Sup", 9f, 20, 80);
		artDao.insert(uneRamette);
		Stylo unBic = new Stylo(1, "Bic", "BBOrange","Bic bille Orange", 1.2f, 20, "Bleu");
		artDao.insert(unBic);
		System.out.println(artDao.selectAll());
//		
//		System.out.println("Mise à jour de l'article id 3");
//		System.out.println(artDao.update(new Stylo(3, "Stypen", "PlumeS", "Stylo plume Stypen", 5.5f, 19, "jaune"))+" lignes affectée(s).");
//		System.out.println(artDao.selectById(3));
//		//artDao.insert(new Stylo("Stypen", "Stypen", "Stylo plume Stypen", 5.5f, 25, "jaune"));
//		System.out.println(artDao.selectAll());
//		artDao.delete(artDao.selectById(6));
//		System.out.println(artDao.selectAll());
//		
	}

}