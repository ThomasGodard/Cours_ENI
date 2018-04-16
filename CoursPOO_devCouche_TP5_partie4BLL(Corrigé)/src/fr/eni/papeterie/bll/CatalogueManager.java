package fr.eni.papeterie.bll;

import java.util.List;

import fr.eni.papeterie.bo.Article;
import fr.eni.papeterie.bo.Ramette;
import fr.eni.papeterie.bo.Stylo;
import fr.eni.papeterie.dal.ArticleDAO;
import fr.eni.papeterie.dal.DAOFactory;
import fr.eni.papeterie.dal.DalException;

public class CatalogueManager {
	
	private static CatalogueManager instance;
	
	private ArticleDAO dao;
	
	private CatalogueManager() { 
		dao = DAOFactory.getArticleDAO();
	}
	
	public static CatalogueManager getInstance() {
		if(instance == null) {
			instance = new CatalogueManager();
		}
		return instance;
	}

	public void addArticle(Article art) throws BLLException {
		
		validerArticle(art);
		
		try {
			dao.insert(art);
		} catch (DalException e) {
			throw new BLLException("Erreur lors de l'insertion en BDD de l'article.");
		}
	}
	
	private void validerArticle(Article article) throws BLLException {
		BLLException bllException = new BLLException("Validation article");
		
		try {
			verificationReference(article);
		} catch (ParameterException e) {
			bllException.ajouterException(e);
		}
		
		try {
			verificationMarque(article);
		} catch (ParameterException e) {
			bllException.ajouterException(e);
		}
		
		try {
			verificationDesignation(article);
		} catch (ParameterException e) {
			bllException.ajouterException(e);
		}
		
		try {
			verificationPrixUnitaire(article);
		} catch (ParameterException e) {
			bllException.ajouterException(e);
		}
		
		try {
			verificationStock(article);
		} catch (ParameterException e) {
			bllException.ajouterException(e);
		}
		
		if(article instanceof Ramette) {
			try {
				verificationGrammage((Ramette) article);
			} catch (ParameterException e) {
				bllException.ajouterException(e);
			}
		} else if(article instanceof Stylo) {
			try {
				verificationCouleur((Stylo) article);
			} catch (ParameterException e) {
				bllException.ajouterException(e);
			}
		}
		
		if(bllException.hasExceptions()) {
			throw bllException;
		}
	}
	
	private void verificationReference(Article article) throws ParameterException {
		if(article.getReference() == null || 
		   article.getReference().trim().isEmpty()) {
			throw new ParameterException("Référence", "obligatoire");
		} else if(article.getReference().length() > 10) {
			throw new ParameterException("Référence", "10 caractères max.");
		}
	}
	
	private void verificationMarque(Article article) throws ParameterException {
		if(article.getMarque() == null || 
				article.getMarque().isEmpty()) {
			throw new ParameterException("Marque", "obligatoire");
		} else if(article.getMarque().length() > 200) {
			throw new ParameterException("Marque", "200 caractères max.");
		}
	}
	
	private void verificationDesignation(Article article) throws ParameterException {
		if(article.getDesignation() == null || 
				article.getDesignation().isEmpty()) {
			throw new ParameterException("Désignation" , "obligatoire");
		} else if(article.getDesignation().length() > 250) {
			throw new ParameterException("Désignation", "250 caractères max.");
		}
	}
	
	private void verificationPrixUnitaire(Article article) throws ParameterException {
		if(article.getPrixUnitaire() < 0) {
			throw new ParameterException("Prix", "Doit être un nombre positif");
		}
	}
	
	private void verificationStock(Article article) throws ParameterException {
		if(article.getQteStock() < 0) {
			throw new ParameterException("Stock", "Doit être un entier positif");
		}
	}
	
	private void verificationGrammage(Ramette ramette) throws ParameterException {
		if(ramette.getGrammage() < 1) {
			throw new ParameterException("Grammage", "Doit être un entier positif");
		}
	}
	
	private void verificationCouleur(Stylo stylo) throws ParameterException {
		if(stylo.getCouleur() == null || 
				stylo.getCouleur().isEmpty()) {
			throw new ParameterException("Couleur", "obligatoire");
		} else if(stylo.getCouleur().length() > 50) {
			throw new ParameterException("Couleur", "50 caractères max.");
		}
	}
 
	public List<Article> getCatalogue() throws BLLException {
		try {
			return dao.selectAll();
		} catch (DalException e) {
			throw new BLLException("Erreur accès données.");
		}
	}

	public void updateArticle(Article article) throws BLLException {
		validerArticle(article);
		
		try {
			dao.update(article);
		} catch (DalException e) {
			e.printStackTrace();
			throw new BLLException("Erreur interne mise à jour article");
		}
	}

	public void removeArticle(Article article) throws BLLException {
		
		if(article == null) {
			throw new BLLException("L'article est null");
		}
		
		try {
			dao.delete(article);
		} catch (DalException e) {
			e.printStackTrace();
			throw new BLLException("Erreur interne suppression article");
		}
	}
	
	public Article getArticle(int index) throws BLLException {
		try {
			return dao.selectById(index);
		} catch (DalException e) {
			throw new BLLException("Erreur accès données.");
		}
	}

}
