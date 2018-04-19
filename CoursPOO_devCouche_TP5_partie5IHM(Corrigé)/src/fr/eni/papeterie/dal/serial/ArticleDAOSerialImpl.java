package fr.eni.papeterie.dal.serial;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import fr.eni.papeterie.bo.Article;
import fr.eni.papeterie.dal.ArticleDAO;
import fr.eni.papeterie.dal.DalException;

public class ArticleDAOSerialImpl implements ArticleDAO {

	private static List<Article> articles = new ArrayList<>();
	
	@Override
	public Article selectById(int id) throws DalException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Article> selectAll() throws DalException {
		try {
			FileInputStream fis = new FileInputStream("articles.dat");
			ObjectInputStream ois = new ObjectInputStream(fis);
			articles = (List<Article>) ois.readObject();
			ois.close();
		} catch (Exception e) {
			e.printStackTrace();
			throw new DalException("selectAll");
		}
		
		return articles;
	}

	@Override
	public void insert(Article article) throws DalException {
		articles.add(article);
		
		saveFile();
	}

	@Override
	public void update(Article article) throws DalException {
		saveFile();
	}

	@Override
	public boolean delete(Article article) throws DalException {
		boolean result = articles.remove(article);
				
		saveFile();
		
		return result;
	}

	private void saveFile() throws DalException {
		try {
			FileOutputStream fos = new FileOutputStream("articles.dat");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(articles);
			oos.close();
		} catch(Exception e) {
			e.printStackTrace();
			throw new DalException("insert");
		}
	}
}
