package fr.eni.papeterie.test;

import java.util.List;

import fr.eni.papeterie.bo.Article;
import fr.eni.papeterie.bo.Stylo;
import fr.eni.papeterie.dal.ArticleDAO;
import fr.eni.papeterie.dal.DAOFactory;

public class AppliTestDAO {

	public static void main(String[] args) {
		try {
			ArticleDAO articleDAO = DAOFactory.getArticleDAO();
			Article articleId1 = articleDAO.selectById(1);
			Article articleId2 = articleDAO.selectById(2);
			Article articleId3 = articleDAO.selectById(22345);
	
			System.out.println(articleId1);
			System.out.println(articleId2);
			System.out.println(articleId3);
	
			/*Article articleAInserer = new Stylo("waterman", "w1", "le plus beau style", 150.0f, 2, "bleu");
			articleDAO.insert(articleAInserer);*/
			
			System.out.println("Liste après insertion:");
			for(Article a:articleDAO.selectAll())
			{
				System.out.println(a);
			}
			
			articleId1.setDesignation("coucou");
			articleId1.setQteStock(100);
			articleDAO.update(articleId1);
			
			System.out.println("Liste après modification:");
			for(Article a:articleDAO.selectAll())
			{
				System.out.println(a);
			}
			try
			{
				boolean deleteOK = articleDAO.delete(articleDAO.selectById(4));
				if(deleteOK)
				{
					System.out.println("Suppression réussie");
				}
				else
				{
					System.out.println("Echec suppression");
				}
			}
			catch(Exception e)
			{
				System.out.println(e.getMessage());
			}
	
			System.out.println("Liste après suppression:");
			for(Article a:articleDAO.selectAll())
			{
				System.out.println(a);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}










