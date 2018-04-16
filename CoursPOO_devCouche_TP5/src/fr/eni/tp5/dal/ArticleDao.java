package fr.eni.tp5.dal;

import java.util.List;

import fr.eni.tp5.bo.Article;

public interface ArticleDao {

	public Article selectById(int id);
	
	public List<Article> selectAll();
	
	public int update(Article newArticle);
	
	/**
	 * 
	 * @param article obligatoirement non null
	 */
	public void insert(Article article) ;
	
	public boolean delete(Article article);
}
