package fr.eni.ihm;

import java.util.Date;
import java.util.List;

import fr.eni.bo.Eleve;
import fr.eni.dal.DAOFactory;
import fr.eni.dal.EleveDAO;
import fr.eni.dal.jdbc.EleveDAOJdbcImpl;
import fr.eni.dal.xml.EleveDAOXmlImpl;

public class Test {

	public static void main(String[] args) {
			
//		EleveDAOJdbcImpl eleveDAO1 = new EleveDAOJdbcImpl();
//		EleveDAOXmlImpl eleveDAO2 = new EleveDAOXmlImpl();
		
//		EleveDAO eleveDAO = new EleveDAOJdbcImpl();
		
		EleveDAO eleveDAO = DAOFactory.getEleveDAO();
		
		List<Eleve> liste = eleveDAO.getListeEleves(true);
		System.out.println("Liste des élèves ascendant : ");
		for( Eleve e : liste) {
			System.out.println(e);
		}
		
		liste = eleveDAO.getListeEleves(false);
		System.out.println("Liste des élèves descendant : ");
		for( Eleve e : liste) {
			System.out.println(e);
		}
		
		Eleve eleve = new Eleve("HADDOCK", "Archibald", "MOULINSART", "15/02/1912", new Date());
		
		try {
			eleveDAO.ajouterEleve(eleve);
		} catch (Exception e) {
			e.printStackTrace();// TODO: handle exception
		}
		
		System.out.println("Nouvel élève : " +eleve);
//		rs.close();
//		stmt.close();
//		System.out.println(liste);
//
//		// Rechercher un eleve
//		System.out.println("RECHERCHER UN ELEVE");
//		sql = "SELECT nom, prenom, adresse, nele FROM dbo.eleves WHERE nom = ?;";
//		PreparedStatement pstmt = cnx.prepareStatement(sql);
//		pstmt.setString(1, "Durand");
//		rs = pstmt.executeQuery(sql);
//
//		if (rs.next()) {
//			System.out.println(new Eleve(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4)));
//		}
	}

}
