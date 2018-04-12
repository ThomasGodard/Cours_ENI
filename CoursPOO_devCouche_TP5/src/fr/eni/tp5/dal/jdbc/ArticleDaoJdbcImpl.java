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
	private static final String UPDATE_ON_ID = "UPDATE dbo.Articles SET reference = ?, marque = ?, designation = ?, prixUnitaire = ?, qteStock = ?, grammage = ?, couleur = ?, type = ? WHERE idArticle = ?;";

	@Override
	public Article selectById(int id) {
		Article art = null;
		try (Connection cnx = ConnectionDao.getConnection()) {
			PreparedStatement pstmt = cnx.prepareStatement(SELECT_BY_ID);
			pstmt.setInt(1, id);

			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				switch (rs.getString(9).trim().toLowerCase()) {
				case "ramette":
					art = new Ramette(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getFloat(5),
							rs.getInt(6), rs.getInt(7));
					break;
				case "stylo":
					art = new Stylo(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getFloat(5),
							rs.getInt(6), rs.getString(8));
					break;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
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
				switch (rs.getString(9).trim().toLowerCase()) {
				case "ramette":
					liste.add(new Ramette(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
							rs.getFloat(5), rs.getInt(6), rs.getInt(7)));
					break;
				case "stylo":
					liste.add(new Stylo(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getFloat(5),
							rs.getInt(6), rs.getString(8)));
					break;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return liste;
	}

	@Override
	public int update(int idArticle, Article newArticle) {
		int ligneAffectee = 0;
		try (Connection cnx = ConnectionDao.getConnection()) {
			
			PreparedStatement pstmt = cnx.prepareStatement(SELECT_BY_ID);
			
			
			pstmt = cnx.prepareStatement(UPDATE_ON_ID);
			pstmt.setString(1, newArticle.getReference());
			pstmt.setString(2, newArticle.getMarque());
			pstmt.setString(3, newArticle.getDesignation());
			pstmt.setFloat(4, newArticle.getPrixUnitaire());
			pstmt.setInt(5, newArticle.getQteStock());
			switch (newArticle.getClass().getSimpleName()) {
			case "Ramette":
				Ramette newRamette = (Ramette) newArticle;
				pstmt.setInt(6, newRamette.getGrammage());
				pstmt.setString(7, null);
				pstmt.setString(8, newRamette.getClass().getSimpleName());
				break;
			case "Stylo":
				Stylo newStylo = (Stylo) newArticle;
				pstmt.setInt(6, (Integer) null);
				pstmt.setString(7, newStylo.getCouleur());
				pstmt.setString(9, newStylo.getClass().getSimpleName());
				break;
			}
			pstmt.setInt(9, idArticle);
			

			ligneAffectee = pstmt.executeUpdate();

//			if (rs.next()) {
//				switch (newArticle.getClass().getSimpleName().toLowerCase()) {
//				case "ramette":
//					art = new Ramette(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getFloat(5),
//							rs.getInt(6), rs.getInt(7));
//					break;
//				case "stylo":
//					art = new Stylo(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getFloat(5),
//							rs.getInt(6), rs.getString(8));
//					break;
//				}
//			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ligneAffectee;
	}

	@Override
	public void insert(Article article) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Article article) {
		// TODO Auto-generated method stub

	}

}
