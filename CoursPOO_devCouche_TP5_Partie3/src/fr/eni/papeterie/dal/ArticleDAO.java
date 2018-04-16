package fr.eni.papeterie.dal;

import java.util.List;

import fr.eni.papeterie.bo.Article;

public interface ArticleDAO {
	
	/**
	 * 
	 * @param id
	 * @return l'article correspondant à l'id ou null 
	 * si n'existe pas ou si problème à l'éxécution. 
	 * @throws DalException 
	 */
	public abstract Article selectById(int id) throws DalException;
	
	/**
	 * 
	 * @return une liste d'article jamais null
	 */
	public abstract List<Article> selectAll() throws DalException;
	
	/**
	 * 
	 * @param article obligatoirement non null
	 * @exception NullPointerException si l'article est null
	 */
	public abstract void insert(Article article) throws DalException;
	/**
	 * 
	 * @param article obligatoirement non null
	 * @exception NullPointerException si l'article est null
	 */
	public abstract void update(Article article) throws DalException;
	
	/**
	 * 
	 * @param article obligatoirement non null
	 * @exception NullPointerException si l'article est null
	 */
	public abstract boolean delete(Article article) throws DalException;
}










