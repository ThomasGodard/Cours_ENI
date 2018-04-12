package fr.eni.tp5.dal;

import java.util.List;

import fr.eni.tp5.bo.Article;

public interface ArticleDao {

	public Article selectById(int id);
	
	public List<Article> selectAll();
	
	public void update(Article article);
	
	public void insert(Article article);
	
	public void delete(Article article);
}
