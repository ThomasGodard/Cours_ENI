package fr.eni.papeterie.test;

import java.util.ArrayList;
import java.util.List;

import fr.eni.papeterie.bo.Article;
import fr.eni.papeterie.bo.Ramette;
import fr.eni.papeterie.bo.Stylo;
import fr.eni.papeterie.dal.ArticleDAO;
import fr.eni.papeterie.dal.DAOFactory;
import fr.eni.papeterie.dal.DalException;

public class AppliTestSerial {

	public static void main(String[] args) {
		ArticleDAO dao = DAOFactory.getArticleDAO();
		
		//1ere étape : je récupère la liste d'articles
		List<Article> mesArticles = new ArrayList<>();
		try {
			mesArticles = dao.selectAll();
		} catch (DalException e) {
			e.printStackTrace();
			System.out.println("Erreur interne lors de la récupèration des données");
		}
		System.out.println("Début");
		System.out.println(mesArticles);
		
		//2eme étape : ajout d'articles
		Stylo unBic = new Stylo(1, "Bic", "BBOrange","Bic bille Orange", 1.2f, 20, "Bleu");
		Ramette uneRamette = new Ramette(2, "Clairef", "CRA4S", "Ramette A4 Sup", 9f, 20, 80);
		
		dao = DAOFactory.getArticleDAO();
		try {
			dao.insert(unBic);
		} catch (DalException e) {
			e.printStackTrace();
			System.out.println("Erreur interne lors de l'insertion");
		}
		
		try {
			dao.insert(uneRamette);
		} catch (DalException e) {
			e.printStackTrace();
			System.out.println("Erreur interne lors de l'insertion");
		}
		
		//3eme étape : récupère la liste d'articles
		try {
			mesArticles = dao.selectAll();
		} catch (DalException e) {
			e.printStackTrace();
			System.out.println("Erreur interne lors de la récupèration des données.");
		}
		System.out.println("Début");
		System.out.println(mesArticles);
	}

}
