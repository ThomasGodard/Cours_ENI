package fr.eni.tp5.dal.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.eni.tp5.bo.Article;
import fr.eni.tp5.bo.Ramette;
import fr.eni.tp5.bo.Stylo;
import fr.eni.tp5.dal.ArticleDao;
import fr.eni.tp5.dal.ConnectionDao;

public class ArticleDaoJdbcImpl implements ArticleDao {

	private static final String SELECT_BY_ID = "SELECT idArticle, reference, marque, designation, prixUnitaire, qteStock, grammage, couleur, type FROM dbo.Articles WHERE idArticle = ?;";
	private static final String SELECT_ALL = "SELECT idArticle, reference, marque, designation, prixUnitaire, qteStock, grammage, couleur, type FROM dbo.Articles;";
	private static final String UPDATE = "UPDATE dbo.Articles SET reference = ?, marque = ?, designation = ?, prixUnitaire = ?, qteStock = ?, grammage = ?, couleur = ?, type = ? WHERE idArticle = ?;";
	private static final String INSERT = "INSERT INTO dbo.Articles (reference, marque, designation, prixUnitaire, qteStock, grammage, couleur, type) VALUES ( ?, ?, ?, ?, ?, ?, ?, ?);";
	private static final String DELETE = "DELETE FROM dbo.Articles WHERE idArticle = ?;";

	@Override
	public Article selectById(int id) {
		Article art = null;
		try (Connection cnx = ConnectionDao.getConnection()) {
			PreparedStatement pstmt = cnx.prepareStatement(SELECT_BY_ID);
			pstmt.setInt(1, id);

			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				art = itemBuilder(rs);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			art = null;
		}
		return art;
	}

	@Override
	public List<Article> selectAll() {
		List<Article> liste = new ArrayList<>();
		try (Connection cnx = ConnectionDao.getConnection()) {
			Statement stmt = cnx.createStatement();

			ResultSet rs = stmt.executeQuery(SELECT_ALL);

			while (rs.next()) {
				liste.add(this.itemBuilder(rs));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			liste.clear();
		}
		return liste;
	}

	@Override
	public int update(Article article) {
		int ligneAffectee = 0;
		try (Connection cnx = ConnectionDao.getConnection()) {
			PreparedStatement pstmt = cnx.prepareStatement(UPDATE);
			preparerParametres(article, pstmt);
			
			pstmt.setInt(9, article.getIdArticle());

			ligneAffectee = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ligneAffectee;
	}

	@Override
	public void insert(Article article) {
		if (article == null) {
			throw new NullPointerException();
		}

		try (Connection cnx = ConnectionDao.getConnection()) {
			PreparedStatement pstmt = cnx.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS);

			preparerParametres(article, pstmt);

			pstmt.executeUpdate();

			ResultSet rsId = pstmt.getGeneratedKeys();
			if (rsId.next()) {
				article.setIdArticle(rsId.getInt(1));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public boolean delete(Article Article) {
		boolean ok = true;
		try (Connection cnx = ConnectionDao.getConnection()) {
			PreparedStatement pstmt = cnx.prepareStatement(DELETE);
			pstmt.setInt(1, Article.getIdArticle());
			
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
			ok = false;
		}
		return ok;
	}
	
	private void preparerParametres(Article article, PreparedStatement pstmt) throws SQLException {
		pstmt.setString(1, article.getReference());
		pstmt.setString(2, article.getMarque());
		pstmt.setString(3, article.getDesignation());
		pstmt.setFloat(4, article.getPrixUnitaire());
		pstmt.setInt(5, article.getQteStock());
		if (article instanceof Ramette) {
			pstmt.setInt(6, ((Ramette) article).getGrammage());
		} else {
			pstmt.setNull(6, java.sql.Types.INTEGER);
		}

		if (article instanceof Stylo) {
			pstmt.setString(7, ((Stylo) article).getCouleur());
		} else {
			pstmt.setNull(7, java.sql.Types.VARCHAR);
		}
		pstmt.setString(8, article.getClass().getSimpleName());

	}

	/**
	 * 
	 * @param rs
	 *            : déjà positioné sur un enregistrement existant
	 * @return
	 * @throws SQLException
	 */
	private Article itemBuilder(ResultSet rs) throws SQLException {
		Article art = null;
		String type = rs.getString(9).trim();
		
		if (Ramette.class.getSimpleName().toLowerCase().equalsIgnoreCase(type)) {
			art = new Ramette();
			((Ramette) art).setGrammage(rs.getInt(7));
		} else if (Stylo.class.getSimpleName().equalsIgnoreCase(type)) {
			art = new Stylo();
			((Stylo) art).setCouleur(rs.getString(8));
		}

		if (art != null) {
			art.setIdArticle(rs.getInt(1));
			art.setReference(rs.getString(2).trim());
			art.setMarque(rs.getString(3));
			art.setDesignation(rs.getString(4));
			art.setPrixUnitaire(rs.getFloat(5));
			art.setQteStock(rs.getInt(6));
		}
		return art;
	}
}
