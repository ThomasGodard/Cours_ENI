package fr.eni.papeterie.dal.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.eni.papeterie.bo.Article;
import fr.eni.papeterie.bo.Ramette;
import fr.eni.papeterie.bo.Stylo;
import fr.eni.papeterie.dal.ArticleDAO;
import fr.eni.papeterie.dal.DalException;

public class ArticleDAOJdbcImpl implements ArticleDAO {

	private static final String SELECT_BY_ID="select idArticle,reference,marque,"
											+ " designation,prixUnitaire,qteStock,"
											+ " grammage,couleur,type"
											+ " from articles"
											+ " where idArticle=?;";
	
	private static final String SELECT_ALL="select idArticle,reference,marque,"
											+ " designation,prixUnitaire,qteStock,"
											+ " grammage,couleur,type"
											+ " from articles";
	
	private static final String INSERT="INSERT INTO ARTICLES(reference,marque,"
											+ " designation,prixUnitaire,qteStock,"
											+ " grammage,couleur,type) "
											+ "VALUES(?,?,?,?,?,?,?,?)";
	private static final String UPDATE="UPDATE ARTICLES SET"
											+ " reference=?,"
											+ " marque=?,"
											+ " designation=?,"
											+ " prixUnitaire=?,"
											+ " qteStock=?,"
											+ " grammage=?,"
											+ " couleur=?,"
											+ " type=?"
											+ " where idArticle=?;";
	private static final String DELETE="DELETE FROM ARTICLES where idArticle=?";
	
	@Override
	public Article selectById(int id) throws DalException {
		Article article = null;
		
		try(Connection cnx = ConnectionDAO.getConnection())
		{
			//On considère qu'on a une connexion opérationnelle
			PreparedStatement pstmt = cnx.prepareStatement(SELECT_BY_ID);
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next())
			{
				article=this.itemBuilder(rs);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DalException("selectById");
		}
		
		return article;
	}

	@Override
	public List<Article> selectAll() throws DalException {
		List<Article> articles = new ArrayList<>();
		
		try(Connection cnx = ConnectionDAO.getConnection())
		{
			//On considère qu'on a une connexion opérationnelle
			Statement stmt = cnx.createStatement();
			ResultSet rs = stmt.executeQuery(SELECT_ALL);
			while(rs.next())
			{
				articles.add(this.itemBuilder(rs));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DalException("selectAll");
		}
		
		return articles;
	}
	
	/**
	 * 
	 * @param rs : déjà positionné sur un enregistrement existant
	 * @return
	 * @throws SQLException 
	 */
	private Article itemBuilder(ResultSet rs) throws SQLException
	{
		Article article=null;
		String type=rs.getString("type").trim();//trim à cause du nchar(10)
		//if(rs.getString("type").equals("Stylo"))
		//if("Stylo".equals(rs.getString("type")))
		if(Stylo.class.getSimpleName().equals(type))
		{
			Stylo nouveauStylo = new Stylo();
			nouveauStylo.setCouleur(rs.getString("couleur"));
			article=nouveauStylo;
		}
		else if(Ramette.class.getSimpleName().equals(type))
		{
			Ramette nouvelleRamette = new Ramette();
			nouvelleRamette.setGrammage(rs.getInt("grammage"));
			article=nouvelleRamette;
		}
		if(article!=null)
		{
			article.setIdArticle(rs.getInt("idArticle"));
			article.setReference(rs.getString("reference").trim());
			article.setMarque(rs.getString("marque"));
			article.setDesignation(rs.getString("designation"));
			article.setPrixUnitaire(rs.getFloat("prixUnitaire"));
			article.setQteStock(rs.getInt("qteStock"));
		}
		return article;
	}

	@Override
	public void insert(Article article) throws DalException {
		if(article==null)
		{
			throw new NullPointerException();
		}
		//ici, j'ai un article forcément non null
		try(Connection cnx = ConnectionDAO.getConnection())
		{
			//On considère qu'on a une connexion opérationnelle
			PreparedStatement pstmt = cnx.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS);
			//Ajout des paramètres à la requête
			preparerParametres(article, pstmt);
			//Exécution de la requête
			pstmt.executeUpdate();
			//Récupération de l'id généré
			ResultSet rsId = pstmt.getGeneratedKeys();
			if(rsId.next())
			{
				article.setIdArticle(rsId.getInt(1));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DalException("insert");
		}
	}

	private void preparerParametres(Article article, PreparedStatement pstmt) throws SQLException {
		pstmt.setString(1,article.getReference());
		pstmt.setString(2, article.getMarque());
		pstmt.setString(3, article.getDesignation());
		pstmt.setFloat(4, article.getPrixUnitaire());
		pstmt.setInt(5, article.getQteStock());
		if(article instanceof Stylo)
		{
			pstmt.setNull(6, java.sql.Types.INTEGER);
			pstmt.setString(7, ((Stylo) article).getCouleur());
		}
		else if(article instanceof Ramette)
		{
			pstmt.setInt(6, ((Ramette) article).getGrammage());
			pstmt.setString(7, null);
		}
		pstmt.setString(8, article.getClass().getSimpleName());
	}

	@Override
	public void update(Article article) throws DalException {
		if(article==null)
		{
			throw new NullPointerException();
		}
		//ici, j'ai un article forcément non null
		try(Connection cnx = ConnectionDAO.getConnection())
		{
			//On considère qu'on a une connexion opérationnelle
			PreparedStatement pstmt = cnx.prepareStatement(UPDATE);
			//Ajout des paramètres à modifier en base à la requête
			preparerParametres(article, pstmt);
			//Ajout du critère de restriction
			pstmt.setInt(9, article.getIdArticle());
			//Exécution de la requête
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DalException("update");
		}
	}

	@Override
	public boolean delete(Article article) throws DalException {
		boolean suppressionOK=false;
		if(article==null)
		{
			throw new NullPointerException();
		}
		//ici, j'ai un article forcément non null
		try(Connection cnx = ConnectionDAO.getConnection())
		{
			//On considère qu'on a une connexion opérationnelle
			PreparedStatement pstmt = cnx.prepareStatement(DELETE);
			//Ajout du critère de restriction
			pstmt.setInt(1, article.getIdArticle());
			//Exécution de la requête
			pstmt.executeUpdate();
			suppressionOK=true;
		} catch (SQLException e) {
			if(e.getMessage().contains("FK_LIGNES_ARTICLES"))
			{
				throw new DalException("Suppression impossible car l'article est dans un panier");
			}
			e.printStackTrace();
		}
		return suppressionOK;
	}

}





















