package fr.eni.tp5.dal.serial;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import fr.eni.tp5.bo.Article;
import fr.eni.tp5.dal.ArticleDao;

public class ArticleDaoSerialImpl implements ArticleDao, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final String filePath = "d:\\articles.dat";
	
	private static List<Article> articles = new ArrayList<>();
	
	// Chargée une seule fois à l'instanciation de la classe
	static {
		try {
			// permet d'écrire vers le flux
			ObjectInputStream ois = new ObjectInputStream(/*flux vers le fichier*/new FileInputStream(filePath));
			articles = (ArrayList<Article>) ois.readObject();
			ois.close();
		} catch (FileNotFoundException fnf) {
			System.err.println("Le fichier n'existe pas");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public Article selectById(int id) {
		return null;
	}

	@Override
	public List<Article> selectAll() {
		return articles;
	}

	@Override
	public int update(Article newArticle) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void insert(Article article) {
		articles.add(article);

		try {
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filePath));
			oos.writeObject(articles);
			oos.close();
		} catch (Exception e) {
			e.printStackTrace();
			throw new DalException("insert");
		}

	}

	@Override
	public boolean delete(Article article) {
		// TODO Auto-generated method stub
		return false;
	}

}
