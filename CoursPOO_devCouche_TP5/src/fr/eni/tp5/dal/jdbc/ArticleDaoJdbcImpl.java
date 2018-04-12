package fr.eni.tp5.dal.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import fr.eni.tp5.bo.Article;
import fr.eni.tp5.bo.Ramette;
import fr.eni.tp5.bo.Stylo;
import fr.eni.tp5.dal.ArticleDao;
import fr.eni.tp5.dal.ConnectionDao;

public class ArticleDaoJdbcImpl implements ArticleDao {

	private static final String SELECT_BY_ID = "SELECT idArticle, reference, marque, designation, prixUnitaire, qteStock, grammage, couleur, type "
			+ "FROM dbo.Articles WHERE idArticle = ?";

	@Override
	public Article selectById(int id) {
		Article art = null;
		try (Connection cnx = ConnectionDao.getConnection()) {
			PreparedStatement pstmt = cnx.prepareStatement(SELECT_BY_ID);
			pstmt.setInt(1, id);

			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				switch (rs.getString(9).toLowerCase()) {
				case "ramette":
					art = new Ramette(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getFloat(5),
							rs.getInt(6), rs.getInt(7));
					break;
				case "stylo":
					art = new Stylo(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getFloat(5),
							rs.getInt(6), rs.getString(8));
					break;
				}
				System.out.println("rs.next");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return art;
	}

	@Override
	public List<Article> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Article article) {
		// TODO Auto-generated method stub

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
