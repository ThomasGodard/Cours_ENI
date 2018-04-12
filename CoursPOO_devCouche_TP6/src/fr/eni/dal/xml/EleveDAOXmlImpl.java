package fr.eni.dal.xml;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.eni.bo.Eleve;
import fr.eni.dal.ConnectionDAO;
import fr.eni.dal.EleveDAO;

public class EleveDAOXmlImpl implements EleveDAO {

	private static final String SELECT_ASC = "SELECT id, nom, prenom, adresse, nele, rentree FROM dbo.eleves ORDER BY nom ASC, prenom ASC";
	private static final String SELECT_DESC = "SELECT id, nom, prenom, adresse, nele, rentree FROM dbo.eleves ORDER BY nom DESC, prenom DESC";
	private static final String INSERT = "INSERT INTO dbo.eleves (nom, prenom, adresse, nele, rentree) VALUES (?, ?, ?, ?, ?)";
	private static final String INSERT_SP = "EXEC insererEleve @nom = ?, @prenom = ?, @adresse = ?, "
			+ "@nele = ?, @rentree = ?, @idEleve =?";

	/**
	 * 
	 * @param asc
	 * @return Liste des eleves. si pas d'eleve, la liste est vide.
	 */
	public List<Eleve> getListeEleves(boolean asc) {
		List<Eleve> liste = new ArrayList<>();

		try (Connection cnx = ConnectionDAO.getConnection()) {

			Statement stmt = cnx.createStatement();
			ResultSet rs;

			if (asc) {
				rs = stmt.executeQuery(SELECT_ASC);
			} else {
				rs = stmt.executeQuery(SELECT_DESC);
			}

			while (rs.next()) {
				liste.add(new Eleve(rs.getInt("id"), 
									rs.getString("nom"), 
									rs.getString("prenom"),
									rs.getString("adresse"), 
									rs.getString("nele"), 
									rs.getDate("rentree"))
						);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return liste;
	}

	public void ajouterEleve(Eleve eleve) throws Exception {

		try (Connection cnx = ConnectionDAO.getConnection()) {

			PreparedStatement pstmt = cnx.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS);
			pstmt.setString(1, eleve.getNom());
			pstmt.setString(2, eleve.getPrenom());
			pstmt.setString(3, eleve.getAdresse());
			pstmt.setString(4, eleve.getNele());
			pstmt.setDate(5, new java.sql.Date(eleve.getRentree().getTime()));

			int nbLignesAffectees = pstmt.executeUpdate();
			if (nbLignesAffectees != 1) {
				throw new Exception("L'enregistrement à échoué");
			}

			ResultSet rsId = pstmt.getGeneratedKeys();
			if (rsId != null && rsId.next()) {
				eleve.setId(rsId.getInt(1));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void ajouterEleveSP(Eleve eleve) throws Exception {

		try (Connection cnx = ConnectionDAO.getConnection()) {

			CallableStatement cstmt = cnx.prepareCall(INSERT_SP);
			cstmt.setString(1, eleve.getNom());
			cstmt.setString(2, eleve.getPrenom());
			cstmt.setString(3, eleve.getAdresse());
			cstmt.setString(4, eleve.getNele());
			cstmt.setDate(5, new java.sql.Date(eleve.getRentree().getTime()));

			cstmt.registerOutParameter(6, java.sql.Types.INTEGER);
			
			cstmt.execute();

			eleve.setId(cstmt.getInt(6));
			

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
